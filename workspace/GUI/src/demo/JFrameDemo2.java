package demo;

import java.awt.Color;
import java.awt.Frame;

import javax.swing.JFrame;

public class JFrameDemo2 extends JFrame{
    private void initFrame() {
    	
    	this.setSize(400, 400);
    	this.setTitle("不可改变大小");
    	this.setResizable(false);//不能改变大小
    	this.getContentPane().setBackground(Color.red);
    	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	this.setVisible(true);
    	
    }
    public static void main(String[] args) {
		JFrameDemo2 jf=new JFrameDemo2();
		jf.initFrame();
	}
	
}
