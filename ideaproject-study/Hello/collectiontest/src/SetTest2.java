import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @author :xyx
 * @date :2021/2/16 20:18
 * @description:linkedhashset
 * @
 */
public class SetTest2 {
    public static void main(String[] args) {
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(123);
        linkedHashSet.add(123);//加两个一样的
        linkedHashSet.add(1);
        linkedHashSet.add("2");
        linkedHashSet.add(new Person("set",10));
        linkedHashSet.add(new Person("set",10));//重写了hashcode方法和equals方法
        linkedHashSet.add(true);
        Iterator<Object> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"\t");
        }
    }

}
