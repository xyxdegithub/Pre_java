package game;
/*常量类
 * 保存游戏中所有的常量
 * 使用0-2代表 石头 剪刀 布
 * 定义字符串数组保存 石头 剪刀 布
 * 最大的胜利的场数 3
 */
public class Constant {
   public static int STONE=0;
   public static int SCISSORS=1;
   public static int PAPER=2;
   
   public static final int MAX_WIN_COUNT=3;
   
   public static final String[] NAMES={"石头","剪刀","布"};
}
