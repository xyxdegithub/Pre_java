import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author :xyx
 * @date :2021/2/16 20:23
 * @description:只能添加相同类的对象
 * @
 */
public class SetTest3 {

    public static void main(String[] args) {
        TreeSet treeSet = new TreeSet();
        treeSet.add(new Person("李四",19));
        treeSet.add(new Person("王飒",18));


//        treeSet.add(123);
//        treeSet.add(1);
        Iterator iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"\t");
        }
    }
}
