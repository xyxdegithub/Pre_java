import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author :xyx
 * @date :2021/2/5 10:56
 * @description:collection接口常用方法
 * @
 */
public class CollectionTest {
    public static void main(String[] args) {
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add("123");
        coll.add(new Person("张三", 19));
        Person p=new Person("老王",28);
        coll.add(p);
        System.out.println("contains方法....");
        System.out.println(coll.contains(123));//true
        System.out.println(coll.contains(456));//false
        System.out.println(coll.contains("123"));//true
        System.out.println(coll.contains(new String("123")));//true,判断的是内容

        //一般必须重写equals方法,让其调用obj类对象的equals方法,从false变成true
        System.out.println(coll.contains(new Person("张三",19)));//false,判断地址
        System.out.println(coll.contains(p));//true
        System.out.println("containsAll方法....");
        Collection coll2= Arrays.asList(123,"123");
        System.out.println(coll.containsAll(coll2));//true

    }

}

