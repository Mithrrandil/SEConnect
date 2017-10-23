import com.TravisChenn.j2ee.Seconnect.dao.Impl.ManagerDaoImpl;

import com.TravisChenn.j2ee.Seconnect.dao.ManagerDao;
import com.TravisChenn.j2ee.Seconnect.dao.OperatorDao;
import com.TravisChenn.j2ee.Seconnect.dao.StationDao;
import com.TravisChenn.j2ee.Seconnect.dao.TaskQueueDao;
import com.TravisChenn.j2ee.Seconnect.entity.base.BaseMember;
import com.TravisChenn.j2ee.Seconnect.entity.common.Message;
import com.TravisChenn.j2ee.Seconnect.entity.common.TaskQueue;
import com.TravisChenn.j2ee.Seconnect.entity.member.Operator;
import com.TravisChenn.j2ee.Seconnect.service.MemberService;
import com.TravisChenn.j2ee.Seconnect.service.TaskQueueService;
import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


//指定单元测试的主要功能模块
@RunWith(SpringJUnit4ClassRunner.class)

//指定Spring配置文件的位置
@ContextConfiguration(locations = {"/config/spring/spring-context.xml", "/config/spring/spring-mvc.xml"})

public class TestDao {

    @Resource
    private MemberService memberService;

    @Resource
    private OperatorDao operatorDao;

    @Resource
    private StationDao stationDao;

    @Resource
    private TaskQueueService taskQueueService;

    @Resource
    private MemberService memberService;

    @Resource
    private ManagerDao managerDao;

    @Test
    public void MybatisDaoTest() {
        System.out.println("================测试开始================");

        System.out.println(managerDao.selectLockNumByManagerID(1));

        System.out.println("================测试结束================");
    }

}
