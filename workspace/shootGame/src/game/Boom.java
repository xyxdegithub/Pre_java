package game;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 爆炸效果类
 */
public class Boom extends FlyingObject{
	//本类私有成员
	private Image[] imgs;//爆炸效果图片数组
	private int w; //画爆炸效果的宽度
	private int h; //画爆炸效果的高度
	private int n; //用来存放正在画的那张图片的下标
	private int img_change_count ; //用于改变爆炸效果图片时计数
	
	/**
	 * 构造方法
	 */
	public Boom(int x0,int y0,int w0,int h0,int speed0){
		//初始化爆炸效果图片数组
		imgs=new Image[6];
		for(int i=0; i<imgs.length; i++){
			try {
				imgs[i]=ImageIO.read(new File("images/blast_"+(i+1)+".png"));
			} catch (IOException e) {
				System.out.println("爆炸效果图片素材加载失败！");
			}
		}
		//初始化用来存放正在画的那张图片的下标
		n=0;
		//初始化父类属性及私用w和h属性
		img=imgs[0];
		x=x0; 
		y=y0; 
		w=w0;
		h=h0;
		speed=speed0; 
		//初始化用于改变爆炸效果图片时的计数
		img_change_count=0;
	}
	
	/**
	 * 返回爆炸效果画的宽度
	 */
	public int getW(){
		return this.w;
	}
	
	/**
	 * 返回爆炸效果画的高度
	 */
	public int getH(){
		return this.h;
	}

	/**
	 * 爆炸效果移动
	 */
	public void move() {
		this.y=this.y+this.speed;
	}

	/**
	 * 爆炸效果切换图片，形成动画效果
	 * 约定:
	 * 若切换图片成功，返回true; 
	 * 若切换失败（即所有图片已全部切换完,没有图片切换了），则返回false
	 */
	public boolean changeImage() {
		img_change_count++;//用于改变爆炸效果图片时的计数加1
		
		if(img_change_count%4==0){ //每次计数到4的倍数，下标才加1
			n++; //正在画的那张图片的下标加1
		}
		
		if(n>imgs.length-1){ //若下标已超过最后一个有效下标
			return false;
		}else{
			img=imgs[n];
			return true;
		}
		
	}
	
}
