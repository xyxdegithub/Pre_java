import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author :xyx
 * @date :2021/2/7 16:15
 * @description:collection接口常用方法
 * @
 */
public class CollectionTest4 {
    public static void main(String[] args) {
        Collection collection=new ArrayList();//有序
        collection.add(1);
        collection.add(2);
        collection.add("1");
        collection.add(new Person("子涵",23));

        Iterator iterator = collection.iterator();
        while(iterator.hasNext()){

            Object obj=iterator.next();
            if ("1".equals(obj)){
                iterator.remove();//调用remove之前需先调用next
            }
        }
        iterator=collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
