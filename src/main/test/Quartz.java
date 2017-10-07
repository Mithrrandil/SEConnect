import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//指定单元测试的主要功能模块
@RunWith(SpringJUnit4ClassRunner.class)

//指定Spring配置文件的位置
@ContextConfiguration(locations = {"/config/spring/spring-context.xml", "/config/spring/spring-mvc.xml"})

public class Quartz {

    @Test
    public void MybatisDaoTest() {
        System.out.println("================测试开始================");

        System.out.println("Hello Quartz");

        System.out.println("================测试结束================");
    }
}
