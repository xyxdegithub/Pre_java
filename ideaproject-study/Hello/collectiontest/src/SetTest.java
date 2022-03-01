import java.util.HashSet;
import java.util.Iterator;

/**
 * @author :xyx
 * @date :2021/2/10 15:44
 * @description:
 * @
 */
public class SetTest {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(123);
        hashSet.add(123);//加两个一样的
        hashSet.add(1);
        hashSet.add("2");
        hashSet.add(new Person("set",10));
        hashSet.add(new Person("set",10));//重写了hashcode方法和equals方法
        hashSet.add(true);
        Iterator iterator = hashSet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"\t");
        }

    }

}
