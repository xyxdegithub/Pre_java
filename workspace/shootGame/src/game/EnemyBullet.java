package game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 敌机子弹类
 */
public class EnemyBullet extends FlyingObject{
	//本类私有成员
	private Image[] imgs; //子弹图片数组
	private int img_change_count ; //用于改变子弹图片时计数
	/**
	 * 构造方法（有参构造）
	 */
	public EnemyBullet(EnemyPlane ePlane){
		//初始化私有成员
		imgs=new Image[2];
		for(int i=0; i<imgs.length; i++){
			try {
				imgs[i]=ImageIO.read(new File("images/enemy_bullet_"+(i+1)+".gif"));
			} catch (IOException e) {
				System.out.println("敌机子弹图片读取失败！");
			}
		}
		//初始化用于改变子弹图片时的计数
		img_change_count=0;
		//初始化父类成员
		img=imgs[0];
		x=ePlane.x+ePlane.img.getWidth(null)/2-this.img.getWidth(null)/2;
		y=ePlane.y+ePlane.img.getHeight(null)+5; //5为敌机与子弹之间的空隙
		speed=ePlane.speed+1; //子弹的速度比敌机的速度加1
		
		
	}

	/**
	 * 子弹移动方法
	 */
	public void move() {
		this.y=this.y+this.speed;
	}
	
	
	/**
	 * 判断子弹是否越界，若越界，返回true；否则，返回false.
	 */
	public boolean outOfBound() {
		if(this.y>GamePanel.PANEL_HEIGHT){
			return true;
		}else{
			return false;
		}
	}

	/**
	 * 敌机子弹切换图片方法（形成子弹动画效果）
	 */
	public void changeImage() {
		img_change_count++; //用于改变子弹图片时的计数加1
		if(img_change_count%4==0){ //计数到4的倍数换一次（以减慢换图片的频率）
			//下面的if...else切换图片
			if(this.img==imgs[0]){
				this.img=imgs[1];
			}else{
				this.img=imgs[0];
			}
			
		}
		
	}
}
