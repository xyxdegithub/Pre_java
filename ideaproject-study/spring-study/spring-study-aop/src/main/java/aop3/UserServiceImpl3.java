package aop3;

/**
 * @author :xyx
 * @date :2021/3/29 16:44
 * @description:TODO
 * @
 */
public class UserServiceImpl3 implements UserService3 {


    @Override
    public void add() {
        System.out.println("增加用户");
    }

    @Override
    public void delete() {
        System.out.println("删除用户");
    }

    @Override
    public void update() {
        System.out.println("更新用户");
    }

    @Override
    public void search() {
        System.out.println("查询用户");
    }
}
