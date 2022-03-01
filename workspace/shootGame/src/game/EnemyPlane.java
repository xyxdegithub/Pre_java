package game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

/**
 * 敌机类
 */
public class EnemyPlane extends FlyingObject{
	//本类私有成员
	private Image[] imgs;//敌机图片数组
	private int score; //该敌机被打掉后的分数
	
	/**
	 * 构造方法
	 */
	public EnemyPlane(){
		//初始化敌机图片数组
		imgs=new Image[6];
		for(int i=0; i<imgs.length; i++){
			try {
				imgs[i]=ImageIO.read(new File("images/enemy_plane"+(i+1)+".png"));
			} catch (IOException e) {
				System.out.println("敌机图片素材加载失败！");
			}
		}
		//初始化父类的相关属性及私有score属性
		Random r=new Random(); //定义一个随机类的对象r，用来生成随机数
		img=imgs[r.nextInt(imgs.length)]; //随机选取一张敌机图片
		x=r.nextInt(GamePanel.PANEL_WIDTH-img.getWidth(null));//敌机水平方向在面板可见范围内随机
		y=-img.getHeight(null); //敌机垂直方向最开始画在面板的上方
		if(img==imgs[0]){ //如果选取的是第一张图片，约定该敌机为自杀式敌机，速度最快，不发子弹，分数最高
			speed=12;
			score=300;
		}else if(img==imgs[imgs.length-1]){//如果选取的是最后一图片，约定该敌机为大敌机，速度适中，发射子弹，分数适中
			speed=7;
			score=200;
		}else{ //若选取其它图片，约定这些敌机为普通小敌机，速度最慢，发射子弹，分数最低
			speed=4;
			score=100;
		}
	}

	/**
	 * 敌机移动方法
	 */
	public void move() {
		this.y=this.y+this.speed;
	}
	
	/**
	 * 敌机越界判断方法，若越界，返回true; 否则，返回false
	 * @return
	 */

	public boolean outOfBound() {
		if(this.y>GamePanel.PANEL_HEIGHT){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 敌机发射子弹方法
	 */
	public EnemyBullet shoot() {
		if(this.img!=imgs[0]){ //若该敌机不是自杀式敌机，才发子弹
			Random r=new Random();
			int p=r.nextInt(1000);
			if(p>995){ //通过生成的 随机数>某个值 这个条件，降低发子弹的频率
				return new EnemyBullet(this); //this代表调用该shoot方法的敌机对象
			}else{
				return null;//返回空null，表示未发射
			}
		}else{
			return null; //返回空null，表示未发射
		}
	}

	/**
	 * 检测敌机是否与英雄机相撞，若相撞，返回true; 否则返回false
	 */
	public boolean isHittedByHeroPlane(HeroPlane hPlane) {
		//this代表调用该方法的敌机对象,hPlane代表英雄机
		if(this.x+this.img.getWidth(null)>=hPlane.x && 
		   this.x<=hPlane.x+hPlane.img.getWidth(null) &&
		   this.y+this.img.getHeight(null)>=hPlane.y &&
		   this.y<=hPlane.y+hPlane.img.getHeight(null)){
			return true;
		}else{
			return false;	
		}
	}
	/**
	 * 检测敌机是否与英雄机子弹相撞，若相撞，返回true; 否则返回false
	 */
	public boolean isHittedByHeroBullet(HeroBullet hBullet) {
		//this代表调用该方法的敌机对象,hBullet代表英雄机子弹
		if(this.x+this.img.getWidth(null)>=hBullet.x && 
		   this.x<=hBullet.x+hBullet.img.getWidth(null) &&
		   this.y+this.img.getHeight(null)>=hBullet.y &&
		   this.y<=hBullet.y+hBullet.img.getHeight(null)){
			return true;
		}else{
			return false;	
		}
	}

	/**
	 * 敌机爆炸时，产生爆炸效果
	 */
	public Boom boomed() {
		return new Boom(this.x,this.y,this.img.getWidth(null),this.img.getHeight(null),this.speed);
	}

	/**
	 * 获取敌机的分数
	 */
	public int getScore() {
		return this.score;
	}
}
