package game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 背景图类
 */
public class Background extends FlyingObject{
	//该类的私有成员
	private Image img_start; //启动游戏时的图
	private Image img_suspend; //一轮游戏中断结束时的图
	private Image img_running; //游戏运行时背景图
	private int last_running_y; //游戏运行时画“运行图”最后那一刻的y坐标
	
	/**
	 * 构造方法
	 */
	public Background(){
		//1.对本类私有成员初始化
		try {
			img_start=ImageIO.read(new File("images/background_start.png"));
			img_suspend=ImageIO.read(new File("images/background_suspend.png"));
			img_running=ImageIO.read(new File("images/background_1.png"));
		} catch (IOException e) {
			System.out.println("读取背景图失败！");
		}
		//初始化游戏运行时画“运行图”最后那一刻的y坐标
		//运行背景图的高度为6000,面板的高度为600，
		//为了最开始显示背景图底部的600，所以在-5400处开始画
		last_running_y=-5400;
		//2.对父类成员初始化
		img=img_start;
		x=0;
		y=0;
		speed=0;
	}

	/**
	 * 根据游戏的状态改变背景图
	 */
	public void changeImage(int status) {
		//若一个类要引用其它类的常量成员，则引用格式应为：
		//其它类的类名.常量名
		if(status==GamePanel.GAME_RUNNING){
			this.img=img_running; //改变图片为运行背景图
			this.y=last_running_y; //恢复画“运行图”最后那一刻的y坐标
			this.speed=2; //改变背景图的移动速度
		}else if(status==GamePanel.GAME_SUSPEND){
			this.last_running_y=y; //保存“运行图”最后那一刻的y坐标
			this.img=img_suspend;//改变图片为运行中断结束图
			this.y=0;	//改变画图的起始y坐标
			this.speed=0;	//改变背景图的移动速度
		}
		
	}

	/**
	 * 背景图移动
	 */
	public void move() {
		this.y=this.y+this.speed;
		if(this.y>0){ //背景图全部画完，每次在（0,0）处重画，就相当于“不动了”
			this.y=0; 
		}
	}
	
	
}
