/**
 * 
 */
package polymorphism;

/**
 * @author xyx
 * 2021年1月12日 下午3:08:21
 */
public class Man extends Person{
         boolean isSmoke=false;
         public int id=1;
         public void eat() {
        	 System.out.println("男吃的多!");
         }
         public void walk() {
        	 System.out.println("男走的快!");
         }
         
}
