package entity;
/**
 * 实体类，与表game_user相对应
 * @author gongdewen
 *
 */
public class GameUser {
	private String name; //玩家名
	private int score;	//玩家得分
	
	public GameUser(){
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	@Override
	public String toString() {
		return "GameUser [name=" + name + ", score=" + score + "]";
	}
	
	
}
