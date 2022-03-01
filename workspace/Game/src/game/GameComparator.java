package game;
/*
 * 定义用于手势比较的接口
 * 
 * 如果playerValue胜computerValue返回1,相同返回0,否则返回-1
 *int compare(int playerValue,int computerValue)
 *自定义子类实现接口 GameComparatorImpl
 */
public interface GameComparator {
	/*
	 * value1 玩家输入的手势值
	 * value2 电脑输入的手势值
	 */
    int compare(int value1,int value2);
    
}


   class GameComparatorImpl implements GameComparator{

	@Override
	public int compare(int value1, int value2) {
		if(value1==value2){
			return 0;
		}else{
			if(value1==Constant.STONE){
			    if(value2==Constant.SCISSORS){
			    	return 1;
			    }else{
			    	return -1;
			    }		
		}else if(value1==Constant.SCISSORS){
			if(value2==Constant.STONE){
				return -1;
			}else{
				return 1;
			}
		}else{
			if(value2==Constant.STONE){
				return 1;
			}else{
				return -1;
			}
		}
		
	}
	   
   }
   }

