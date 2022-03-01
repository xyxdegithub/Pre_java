import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author :xyx
 * @date :2021/2/6 23:46
 * @description:collection接口常用方法
 * @
 */
public class CollectionTest3 {
    public static void main(String[] args) {
        Collection collection=new ArrayList();//有序
        collection.add(1);
        collection.add(2);
        collection.add("1");
        collection.add(new Person("子涵",23));
        System.out.println(collection);
        System.out.println("哈希码是:"+collection.hashCode());

        //集合元素的遍历
        Iterator iterator=collection.iterator() ;
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"\t");
        }
        System.out.println();
        Object[] objects=collection.toArray();
        for (int i = 0; i < objects.length; i++) {
            System.out.print(objects[i]+"\t");
        }

    }

}
