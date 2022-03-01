import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author :xyx
 * @date :2021/2/16 20:39
 * @description:treeset定制排序
 * @
 */
public class SetTest4 {
    public static void main(String[] args) {
        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add(new Person("李四", 19));
        treeSet.add(new Person("王思", 20));
        treeSet.add(new Person("第四", 20));
        Comparator<Person> comparator = new Comparator<Person>() {
            //先比较年龄
            @Override
            public int compare(Person o1, Person o2) {
                if (o1 instanceof Person && o2 instanceof Person) {
                    Person p1 = (Person) o1;
                    Person p2 = (Person) o2;
                    return Integer.compare(o1.getAge(), o2.getAge());
                }
                throw  new RuntimeException("传入数据不对!");
            }
        };
        Iterator<Object> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
