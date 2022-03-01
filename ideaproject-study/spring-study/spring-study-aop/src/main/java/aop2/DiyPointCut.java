package aop2;

import javax.swing.plaf.PanelUI;

/**
 * @author :xyx
 * @date :2021/3/29 17:02
 * @description:TODO
 * @
 */
public class DiyPointCut {
    public void before() {
        System.out.println("方法执行前!");
    }

    public void after() {
        System.out.println("方法执行后!");
    }

}
