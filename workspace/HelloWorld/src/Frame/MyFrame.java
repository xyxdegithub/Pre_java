package Frame;

import java.awt.Color;

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	public static void main(String[] args) {
		JFrame frame = new JFrame("我的第一个Frame");
		frame.setSize(600,600);
		frame.getContentPane().setBackground(Color.RED);
		frame.setVisible(true);
	}
	
}