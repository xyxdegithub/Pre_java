package demo;

import java.awt.Color;

import javax.swing.JFrame;

public class JFrameDemo {
public static void main(String[] args) {
	JFrame jf=new JFrame();
	jf.setSize(400, 400);
	jf.setTitle("This my first frame");
	jf.setBackground(Color.red);//该句无效在JFrame中，该方法是继承Frame
	jf.getContentPane().setBackground(Color.red);//该句有效
	jf.setVisible(true);
}
}
