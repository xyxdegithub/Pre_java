import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * @author :xyx
 * @date :2021/2/5 11:17
 * @description:collection接口常用方法
 * @remove和removeall,retainall交集
 */
public class CollectionTest2 {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add("123");
        collection.add(456);
        collection.add(false);
        collection.add(new Person("张三", 19));
        System.out.println("remove方法");
        collection.remove(123);
        collection.remove("123");
        System.out.println(collection);//[456, false, Person{name='张三', age=19}]
        collection.remove(new Person("张三", 19));
        System.out.println(collection);//[456, false]

        Collection collection1= Arrays.asList(456);//相当从数组到集合
        collection.retainAll(collection1);
        System.out.println(collection);//[456]

        collection.removeAll(collection1);
        System.out.println(collection);//[]


    }

}
