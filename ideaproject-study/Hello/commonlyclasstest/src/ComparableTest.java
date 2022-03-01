import java.util.Arrays;
import java.util.Comparator;

/**
 * @author :xyx
 * @date :2021/2/2 21:21
 * @description:商品排序,重写compareto方法，实现自然排序
 * @
 */
class Goods implements Comparable {
    private String name;
    private double price;

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    //首先以商品价格进行排序，价格相同再以名称排序
    @Override
    public int compareTo(Object o) {
        if (o instanceof Goods) {
            Goods goods = (Goods) o;
            if (this.price > goods.price) {
                return 1;
            } else if (this.price < goods.price) {
                return -1;
            } else {
                //return 0;
                return this.name.compareTo(goods.name);
            }
            // return Double.compare(this.price,goods.price);
        }
        throw new RuntimeException("传入数据错误!");

    }


}

public class ComparableTest {
    public static void main(String[] args) {
        Goods[] goods = new Goods[6];
        goods[0] = new Goods("苹果笔记本电脑", 20000);
        goods[1] = new Goods("华为笔记本电脑", 12000);
        goods[2] = new Goods("联想笔记本电脑", 7000);
        goods[3] = new Goods("惠普笔记本电脑", 6999);
        goods[4] = new Goods("小米笔记本电脑", 3999.9);
        goods[5] = new Goods("戴尔笔记本电脑", 7000);
        {
            System.out.println("***************自然排序***************");
            System.out.println(Arrays.toString(goods));
            Arrays.sort(goods);//自然排序
            System.out.println(Arrays.toString(goods));
        }
        {
            //定制排序,临时写怎么排
            System.out.println("***************定制排序***************");
            System.out.println(Arrays.toString(goods));
            Arrays.sort(goods, new Comparator<Goods>() {
                @Override
                public int compare(Goods o1, Goods o2) {
                    if (o1 instanceof Goods && o2 instanceof Goods) {
                        Goods g1 = o1;
                        Goods g2 = o2;
                        return -g1.compareTo(g2);//从大到小排序
                    }
                    throw new RuntimeException("输入数据不对!");
                }
            });
            System.out.println(Arrays.toString(goods));
        }
    }

}
