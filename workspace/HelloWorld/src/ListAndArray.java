import java.util.ArrayList;
import java.util.List;

public class ListAndArray {
 public static void main(String[] args) {
	List<Integer> list=new ArrayList<>();
	list.add(new Integer(4));
	list.add(new Integer(3));
	
	Integer[] intArray = list.toArray(new Integer[list.size()]);
	System.out.println(intArray.length);
}
}
