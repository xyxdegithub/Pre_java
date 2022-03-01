package aop1;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

/**
 * @author :xyx
 * @date :2021/3/29 16:46
 * @description:TODO
 * @
 */
public class After implements AfterReturningAdvice {


    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了" + target.getClass().getName()
                + "的" + method.getName() + "方法,"
                + "返回值：" + returnValue);
    }
}

