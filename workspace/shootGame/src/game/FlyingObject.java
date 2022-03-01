package game;

import java.awt.Graphics;
import java.awt.Image;

/**
 * 飞行物类
 * 是所有飞行物（包括背景图、英雄机、英雄机子弹、敌机、敌机子弹
 * 、爆炸效果）的父类
 *
 */
public class FlyingObject {
	public Image img;	//飞行物的图片成员
	public int x;	//画飞行物的x坐标
	public int y;	//画飞行物的y坐标
	public int speed; //飞行物移动时的速度
	
	/**
	 * 自定义绘画方法draw，用于在面板上画飞行物
	 */
	public void draw(Graphics g){ //g代表画笔，调用该方法需要传入画笔
		//this代表调用该方法的对象（谁调用draw方法，就代表谁）
		//画图时，若省略画的宽高，则与图片本身的宽高保持一致
		g.drawImage(this.img, this.x, this.y, null);
	}
}
