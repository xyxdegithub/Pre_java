package aop3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * @author :xyx
 * @date :2021/3/29 19:10
 * @description:注解实现aop
 * @
 */
@Aspect
public class AnnotationPointcut {
    @Before("execution(* aop3.UserServiceImpl3.*(..))")
    public void before() {
        System.out.println("方法执行前!");
    }

    @After("execution(* aop3.UserServiceImpl3.*(..))")
    public void after() {
        System.out.println("方法执行后!");
    }
    @Around("execution(* aop3.UserServiceImpl3.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        System.out.println("签名:"+jp.getSignature());
        //执行目标方法proceed
        Object proceed = jp.proceed();
        System.out.println("环绕后");
        System.out.println(proceed);
    }

}
