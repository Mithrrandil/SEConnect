package com.TravisChenn.j2ee.Seconnect.controller;

import com.TravisChenn.j2ee.Seconnect.dao.ManagerDao;
import com.TravisChenn.j2ee.Seconnect.dao.OperatorDao;
import com.TravisChenn.j2ee.Seconnect.entity.base.BaseMember;
import com.TravisChenn.j2ee.Seconnect.entity.common.Message;
import com.TravisChenn.j2ee.Seconnect.entity.example.ManagerExample;
import com.TravisChenn.j2ee.Seconnect.entity.example.OperatorExample;
import com.TravisChenn.j2ee.Seconnect.entity.member.Manager;
import com.TravisChenn.j2ee.Seconnect.entity.member.Operator;
import com.TravisChenn.j2ee.Seconnect.service.MemberService;
import com.TravisChenn.j2ee.Seconnect.utils.MessageUtil;
import com.TravisChenn.j2ee.Seconnect.utils.WebUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/login")

/*IDEA Spring配置文件识别异常*/
@SuppressWarnings("unused")
public class LoginController {

    @Resource
    private MemberService memberService;

    @Resource
    private ManagerDao managerDao;

    /**
     * 用户登录
     *
     * @param response      请求返回对象
     * @param loginUsername 登录用户名
     * @param loginPassword 登录密码
     * @param channel       登录类型
     * @param memberType    用户类型
     * @return 登录结果
     */
    @RequestMapping(value = "/submit", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String submit(HttpServletResponse response, @RequestParam(name = "loginUsername") String loginUsername, @RequestParam(name = "loginPassword") String loginPassword, @RequestParam(name = "channel") String channel, @RequestParam(name = "memberType") String memberType) {


        //当用户类型为 操作员 并且登录类型为 后台时拒绝登录
        if (channel.equals(BaseMember.Channel.ADMIN.name()) && memberType.equals(BaseMember.MemberType.OPERATOR.name())) {
            return MessageUtil.commonMessage(Message.Type.ERROR, BaseMember.LoginResultIndex.DENIED_AUTHORITY_BY_CHANNEL.getZN());
        }

        //从服务中取出登录结果
        BaseMember.LoginResultIndex loginResultIndex = memberService.memberCheck(loginUsername, loginPassword, memberType);

        //添加登录成功的Cookie
        if (loginResultIndex == BaseMember.LoginResultIndex.SUCCESS) {
            //获取当前用户的信息

            ManagerExample managerExample = new ManagerExample();
            managerExample.or().andLoginUsernameEqualTo(loginUsername);

            Manager manager = managerDao.selectByExample(managerExample).get(0);
            WebUtil.addCookie(response, "SECONNECT_ID", String.valueOf(manager.getId()));
            WebUtil.addCookie(response, "SECONNECT_REALNAME", String.valueOf(manager.getRealName()));
            WebUtil.addCookie(response, "SECONNECT_LOGIN_USERNAME", String.valueOf(manager.getLoginUsername()));
            return MessageUtil.commonSuccess();
        } else {
            return MessageUtil.commonMessage(Message.Type.ERROR, loginResultIndex.getZN());
        }

    }

    @RequestMapping(value = "/loginOut", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
    public @ResponseBody
    String submit(HttpServletRequest request, HttpServletResponse response) {
        WebUtil.removeCookie(request, response, "SECONNECT_ID");
        WebUtil.removeCookie(request, response, "SECONNECT_REALNAME");
        WebUtil.removeCookie(request, response, "SECONNECT_LOGIN_USERNAME");
        return MessageUtil.commonSuccess();
    }


}