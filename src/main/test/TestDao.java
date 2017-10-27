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


public class TestDao {


    public static void main(String[] args) {

        System.out.println("================测试开始================");


        String username = "";
        String password = "";

        if(username.equals("123456") && password .equals("456789")){
            System.out.println("登录成功");
        }

        System.out.println("================测试结束================");

    }

}
