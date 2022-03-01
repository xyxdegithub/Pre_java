package game;

import java.util.Scanner;

public class Player extends GamePlayer{

	public Player(String name) {
		setName(name);
	}

	
	public int getInputValue() {
		Scanner scanner=new Scanner(System.in);
		System.out.println("请选择你的手势:(0-石头),"
				+ "(1-剪刀),(2-布)");
		int value=scanner.nextInt();
		setValue(value);
		return 0;
	}

}
