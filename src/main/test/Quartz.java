import com.TravisChenn.j2ee.Seconnect.dao.TaskQueueDao;
import com.TravisChenn.j2ee.Seconnect.entity.common.TaskQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;


//指定单元测试的主要功能模块
@RunWith(SpringJUnit4ClassRunner.class)

//指定Spring配置文件的位置
@ContextConfiguration(locations = {"/config/spring/spring-context.xml", "/config/spring/spring-mvc.xml"})

public class Quartz {

    @Resource
    private TaskQueueDao taskQueueDao;

    @Test
    public void MybatisDaoTest() {
        System.out.println("================测试开始================");

//        List<TaskQueue> list = taskQueueDao.selectTaskInDays(TaskQueue.TaskType.MANDATORY_UNLOCK_AUTHORITY.getZN(), "王雨森", 7);
//        list.forEach((x) -> System.out.println(x.toString()));

        System.out.println("================测试结束================");
    }
}
