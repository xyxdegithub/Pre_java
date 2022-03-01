import aop2.UserService2;
import aop3.UserService3;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import aop1.UserService;

/**
 * @author :xyx
 * @date :2021/3/29 16:49
 * @description:aop测试
 * @
 */
public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext
                ("aplicationContext.xml");
        UserService service = context.getBean(UserService.class);
        service.add();
        System.out.println("***************************************************");
        ClassPathXmlApplicationContext context2 = new ClassPathXmlApplicationContext
                ("aplicationContext2.xml");
        UserService2 service2 = context2.getBean(UserService2.class);
        service2.delete();
        System.out.println("***************************************************");
        ClassPathXmlApplicationContext context3 = new ClassPathXmlApplicationContext
                ("aplicationContext3.xml");
        UserService3 service3 = context3.getBean(UserService3.class);
        service3.search();
    }
}
