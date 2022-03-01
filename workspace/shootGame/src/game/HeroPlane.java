package game;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 英雄机类
 */
public class HeroPlane extends FlyingObject{
	//私有属性
	public static final int WORKING=1; //英雄机处于工作状态（在面板上能看见、可移动、可发子弹）
	public static final int RESTING=0; //英雄机处于休息状态（在面板上看不见、不能移动、不能发子弹）
	private int status; //用来存放英雄机当前的状态
	private int rest_count; //用于休息倒计时的计数
	private int life; //英雄机的命数
	private int speed; //英雄机的速度
	private boolean down,up,left,right;
	/**
	 * 构造方法
	 */
	public HeroPlane(){
		//对私有成员初始化
		speed=5;
		status=WORKING;
		life=3; 
		//对父类成员初始化
		try {
			img=ImageIO.read(new File("images/hero.png"));
		} catch (IOException e) {
			System.out.println("加载英雄机图片失败！");
		}
		x=GamePanel.PANEL_WIDTH/2-this.img.getWidth(null)/2;
		y=GamePanel.PANEL_HEIGHT-this.img.getHeight(null)-50;//50为英雄机距面板底部的微调距离
		//speed速度属性对于英雄机类无意义，无需初始化
	}

	/**
	 * 英雄机移动方法
	 * 参数x0横坐标,y0纵坐标：是鼠标当前所在的位置
	 * 英雄机参考鼠标当前位置移动，同时确保鼠标形状在英雄机图片的中心位置
	 */
	public void move(int x0, int y0) {
		this.x=x0-this.img.getWidth(null)/2;
		this.y=y0-this.img.getHeight(null)/2;
	}

	/**
	 * 英雄机发射子弹方法
	 */
	public HeroBullet shoot() {
		return new HeroBullet(this); //返回一个子弹对象
	}
	
	/**
	 * 检测英雄机是否与敌机子弹相撞，若相撞，返回true; 否则返回false
	 */
	public boolean isHittedByEnemyBullet(EnemyBullet eBullet) {
		//this代表调用该方法的英雄机对象,eBullet代表敌机子弹
		if(this.x+this.img.getWidth(null)>=eBullet.x && 
		   this.x<=eBullet.x+eBullet.img.getWidth(null) &&
		   this.y+this.img.getHeight(null)>=eBullet.y &&
		   this.y<=eBullet.y+eBullet.img.getHeight(null)){
			return true;
		}else{
			return false;	
		}
	}

	/**
	 * 英雄机爆炸，产生爆炸效果
	 */
	public Boom boomed() {
		return new Boom(this.x, this.y, this.img.getWidth(null), this.img.getHeight(null), 0);
	}

	/**
	 * 改变英雄机的状态，状态有2种：WORKING和RESTING
	 */
	public void changeStatus(int newStatus) {
		this.status=newStatus; //更新状态
		if(status==RESTING){ //若更新后的状态为休息状态
			rest_count=40; //设置休息倒计时的计数
			this.x=-this.img.getWidth(null)-10;//将英雄机移到左边看不见的地方（10为微调距离）
		}else if(status==WORKING){//若更新后的状态为工作状态
			//将英雄机移到面板的正下方使其可看到
			this.x=GamePanel.PANEL_WIDTH/2-this.img.getWidth(null)/2;
			this.y=GamePanel.PANEL_HEIGHT-this.img.getHeight(null)-50;//50为英雄机距面板底部的微调距离
		}
		
	}

	/**
	 * 返回英雄机的当前状态
	 */
	public int getStatus() {
		return this.status;
	}

	/**
	 * 英雄机是否休息完成；若完成，返回true；否则，返回false
	 */
	public boolean isRestComplete() {
		rest_count--; //休息到计时计数减1
		if(rest_count==0){//若休息到计时为0
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 返回英雄机当前的命数值
	 */
	public int getLife() {
		return this.life;
	}
	
	/**
	 * 英雄机减去一条命，
	 * 若减完后，没有命了，返回false；否则，返回true
	 */

	public boolean subtractLife() {
		this.life--;
		if(this.life==0){ //减完后，没有命了
			return false; 
		}else{
			return true;
		}
	}

	/**
	 * 英雄机恢复原始的生命数
	 */
	public void restoreLife() {
		this.life=3;
	}

	public void add(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			up = true;
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			left = true;
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			right = true;
			break;
		
		
		
		
		
		}
		
		
	}

	public void mine(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_W:
		case KeyEvent.VK_UP:
			up = false;
			break;
		case KeyEvent.VK_S:
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		case KeyEvent.VK_A:
		case KeyEvent.VK_LEFT:
			left = false;
			break;
		case KeyEvent.VK_D:
		case KeyEvent.VK_RIGHT:
			right = false;
			break;
		}
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public void moveDown() {
		this.y+=speed;
	}

	public void moveUP() {
		this.y-=speed;
	}

	public void moveLeft() {
		this.x-=speed;
	}

	public void moveRight() {
		this.x+=speed;
	}
	
	
	
	
}
