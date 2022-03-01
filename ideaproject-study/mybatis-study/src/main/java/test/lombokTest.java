package test;

import entity.User;

/**
 * @author :xyx
 * @date :2021/3/25 19:30
 * @description:lombok测试
 * @
 */
public class lombokTest {

    public static void main(String[] args) {
        System.out.println(new User());
        User user = new User(1, "1", "1");
        System.out.println(user);
    }
}
