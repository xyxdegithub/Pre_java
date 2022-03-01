package game;
/*
 * 游戏核心类
 */
public class MyGame implements GameInterface{
private GamePlayer player;
private GamePlayer computer;

private GameComparator comparator;
	private int count;
	
	public void initGame() {
	    player=new Player("小柯");
	    computer =new Computer("阿拉法狗");
	    
		comparator=new GameComparatorImpl() ;
		count=1;
	}
			
		
	public void startGame() {
		System.out.println("*********************第"+count+"局开始*********************");
		while(true){
//			玩家选择一个手势
			player.getInputValue();
//	                   电脑随机一个手势		
			computer.getInputValue();
			
			player.show();
			computer.show();
			
//			比较两个数值
			int compare=comparator.compare(player.getValue(),computer.getValue());
//			根据裁判判决结果，修改对应玩家数值，并打印本局结果，输出一下当前比分
			compareModify(compare);
			
			showGameInfo(compare);
			
			System.out.println("*********************第"+count+"局结束*********************");
			count++;
//			判断游戏是否可以结束,是否有玩家达到三次胜利
			if(player.isWin() || computer.isWin()){
				break;
			}
		}
		
	}
//根据比较结果修改玩家的值
	private void compareModify(int compare){
		if(compare==1){
			player.setWinCount(player.getWinCount()+1);
		}else if(compare==-1){
			computer.setWinCount(computer.getWinCount()+1);
		}
	}
	
	private void showGameInfo(int compare){
		switch(compare){
	
		case 1://玩家胜利
			System.out.println("本局:"+player.getName()+"胜利了");
			break;
		case 0:
			System.out.println("本局:平局");
			break;
		case -1:
			System.out.println("本局:"+computer.getName()+"胜利了");
			break;
		}
		System.out.println("当前游戏总比分:"+player.getName()+" VS "
		+computer.getName()+"\t"+player.getWinCount()+" VS "+computer.getWinCount());
	}
	
	
	public void endGame() {
		System.out.println("游戏结果");
		if(player.isWin()){
			System.out.println(player.getName()+"胜利了!");
		}else{
			System.out.println(computer.getName()+"胜利了!");
		}
		
		System.out.println("最终游戏总比分:"+player.getName()+" VS "
				+computer.getName()+"\t"+player.getWinCount()+" VS "+computer.getWinCount());
	}

}
