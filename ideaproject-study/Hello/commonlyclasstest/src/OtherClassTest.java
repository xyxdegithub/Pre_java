/**
 * @author :xyx
 * @date :2021/2/4 16:57
 * @description:system,math,biginteger,bigdecimal
 * @
 */
public class OtherClassTest {
    public static void main(String[] args) {
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的版本是" + javaVersion);//java的版本是1.8.0_231
        String javaHome = System.getProperty("java.home");
        System.out.println("java的home是" + javaHome);//java的home是E:\Java\jdk1.8.0_231\jre
        String userDir = System.getProperty("user.dir");
        System.out.println("用户路径在" + userDir);//用户路径在E:\JavaCode\workspace_idea\Hello
        String osName = System.getProperty("os.name");
        System.out.println("系统的名字是" + osName);//系统的名字是Windows 10
        String osVersion = System.getProperty("os.version");
        System.out.println("系统的版本是" + osVersion);//系统的版本是10.0
        String userName = System.getProperty("user.name");
        System.out.println("用户的名字是" + userName);//用户的名字是Sunshine

    }

}
