package game;

public class MyUtil {
   private MyUtil(){
	   
   }
   public static int getRandomNumber(int min,int max){
	   return (int)(Math.random()*(max-min)+min);
   }
}
