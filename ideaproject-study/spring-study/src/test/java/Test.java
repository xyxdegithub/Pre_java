import bean.Person;
import bean.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import aop1.UserServiceImpl;

/**
 * @author :xyx
 * @date :2021/3/28 16:51
 * @description:TODO
 * @
 */
public class Test {

    public static void main(String[] args) {
       /* UserServiceImpl userService = new UserServiceImpl();
        userService.setUserDao(new UserDaoImpl2());
        userService.service();*/

        ApplicationContext context = new
                ClassPathXmlApplicationContext("applicationContext.xml");

        UserServiceImpl service = (UserServiceImpl) context.getBean("service");
        service.service();
        System.out.println("****************************************************");

        Student student = (Student) context.getBean("student");
        System.out.println(student.toString());
        System.out.println("****************************************************");
        Person person = context.getBean(Person.class);
        person.getCat().shout();
        person.getDog().shout();
    }
}
