package game;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 英雄机子弹类
 */
public class HeroBullet extends FlyingObject{
	
	/**
	 * 构造方法
	 */
	public HeroBullet(HeroPlane hPlane){
		//对父类成员初始化
		try {
			img=ImageIO.read(new File("images/hero_bullet_2.png"));
		} catch (IOException e) {
			System.out.println("英雄机子弹图片加载失败");
		}
		x=hPlane.x+hPlane.img.getWidth(null)/2-this.img.getWidth(null)/2;
		y=hPlane.y-this.img.getHeight(null)-10;//10为英雄机与子弹之间的微调距离
		speed=10;
	}
	/**
	 * 英雄机子弹移动
	 */
	public void move() {
		this.y=this.y-this.speed;
		
	}
	/**
	 * 英雄机子弹越界处理：若越界，则返回true；否则返回false
	 */
	public boolean outOfBound() {
		if(this.y<=-this.img.getHeight(null)){
			return true;
		}else{
			return false;
		}
	}
}
