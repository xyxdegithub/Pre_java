package game;
/*
 * 抽取的父类 GamePlayer 抽象的
 * 参与者的名字
 * 实例成员变量 value
 * 记录游戏参与者胜利的场数
 * 功能:抽象的 获取数值的方法 getInputValue()
 */
public  abstract class GamePlayer {
   private String name;
   
   private int value;
   
   private int winCount;
   
   /*
    * 获取游戏参与者选择的手势的值得方法.子类需要实现
    */
   public abstract int getInputValue();

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getValue() {
	return value;
}

public void setValue(int value) {
	this.value = value;
}

public int getWinCount() {
	return winCount;
}

public void setWinCount(int winCount) {
	this.winCount = winCount;
}


public void show(){
	System.out.println(name+"\t选择的手势是:"+Constant.NAMES[value]);
}
//判断玩家是否胜利
public boolean isWin(){
	return winCount==Constant.MAX_WIN_COUNT;
}
   
   
}
