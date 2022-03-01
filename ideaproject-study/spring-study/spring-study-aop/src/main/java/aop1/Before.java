package aop1;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * @author :xyx
 * @date :2021/3/29 16:45
 * @description:TODO
 * @
 */
public class Before implements MethodBeforeAdvice{


        //method : 要执行的目标对象的方法
        //objects : 被调用的方法的参数
        //Object : 目标对象
        @Override
        public void before(Method method, Object[] objects, Object o) throws Throwable {
            System.out.println( o.getClass().getName() + "的" + method.getName() + "方法被执行了");
        }
    }

