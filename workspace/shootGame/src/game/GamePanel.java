package game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

import dao.GameUserDao;
import entity.GameUser;

/**
 * 游戏面板类
 */
public class GamePanel extends JPanel implements MouseMotionListener,MouseListener, ActionListener{
	//用public static final修饰的，为定义常量（常量一旦赋值，则不能再更改）
	public static final int PANEL_WIDTH=400; //常量，代表面板的宽
	public static final int PANEL_HEIGHT=600; //常量，代表面板的高
	public static final int GAME_READY=0;	//常量，表示游戏处于准备状态
	public static final int GAME_RUNNING=1;  //常量，表示游戏处于运行状态
	public static final int GAME_SUSPEND=2;  //常量，表示游戏处于暂时中断状态，可继续也可结束
	public static final int GAME_OVER=3; //常量，表示游戏处于结束状态
	public static final int MAX_ENEMY_NUMBER=3; //常量，面板上同时出现的最大敌机数量
	private int status;  //用来存放游戏当前的状态（其值只能是GAME_READY、GAME_RUNNING、GAME_SUSPEND、GAME_OVER这四种状态之一）
	private Background background; //游戏背景对象
	private ArrayList<EnemyPlane> ePlanes ;//敌机列表
	private ArrayList<EnemyBullet> eBullets ; //敌机子弹列表
	private HeroPlane hPlane;	//英雄机
	private ArrayList<HeroBullet> hBullets; //英雄机子弹列表
	private ArrayList<Boom> booms; //爆炸效果列表
	private int score; //游戏总得分
	private JLabel lblScore; //显示游戏分数的标签
	private JLabel lblLife;  //显示英雄机命数的标签
	private Timer timer; //用于游戏暂时中断结束时，倒计时的定时器
	private int countdown_times; //用于存放中断结束时，倒计时还剩余的时间
	private Image img_countdown_sw;//用于存放中断结束时，倒计时的十位(sw)上的图片
	private Image img_countdown_gw;//用于存放中断结束时，倒计时的个位(gw)上的图片
	private AudioClip all_bomb;//全屏爆炸音效
	private AudioClip bg;//背景音效
	private AudioClip enemy_bomb;//敌机爆炸音效
	private AudioClip hero_bomb;//英雄机爆炸音效
	private AudioClip hero_bullet;//英雄机发子弹音效
	/**
	 * 构造方法
	 */
	public GamePanel(){
		//初始化游戏当前的状态
		status=GAME_READY;
		//初始化游戏背景对象
		background=new Background();
		//初始化敌机列表
		ePlanes=new ArrayList<EnemyPlane>();
		for(int i=0; i<MAX_ENEMY_NUMBER; i++){
			ePlanes.add(new EnemyPlane());
		}
		//初始化敌机子弹列表
		eBullets=new ArrayList<EnemyBullet>();
		//初始化英雄机
		hPlane=new HeroPlane();
		//初始化英雄机子弹列表
		hBullets=new ArrayList<HeroBullet>();
		//初始化爆炸效果列表
		booms=new ArrayList<Boom>();
		//添加鼠标移动监听器
		this.addMouseMotionListener(this);
		//添加鼠标监听器
		this.addMouseListener(this);
		
		//初始化游戏总得分
		score=0;
		this.setLayout(null);//为了各个标签在面板上显示好看，采用手工布局
		//初始化显示游戏分数的标签
		lblScore=new JLabel();
		lblScore.setText("分数 : "+score);
		lblScore.setForeground(Color.WHITE);//设置前景颜色为白色
		lblScore.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblScore.setSize(140, 20);
		lblScore.setLocation(10, 10);
		this.add(lblScore);
		lblScore.setVisible(false); //设置不可见
		//初始化显示英雄机命数的标签
		lblLife=new JLabel();
		lblLife.setText("命数 : "+hPlane.getLife());
		lblLife.setForeground(Color.WHITE);//设置前景颜色为白色
		lblLife.setFont(new Font("微软雅黑", Font.BOLD, 14));
		lblLife.setSize(140, 20);
		lblLife.setLocation(10, 30);
		this.add(lblLife);
		lblLife.setVisible(false); //设置不可见
		//初始化游戏暂时中断结束时，倒计时的定时器
		//以下语句定义了一个定时器，当定时器开始开始工作时，
		//每隔1000毫秒（即1秒）自动执行actionPerformed方法一次
		//注意：第2个参数若填this，则要求当前类实现ActionListener接口
		timer=new Timer(1000,this);
		
		//初始化游戏音效
		try {
			all_bomb=Applet.newAudioClip(new File("music/all_bomb.wav").toURI().toURL());
			bg=Applet.newAudioClip(new File("music/bg.wav").toURI().toURL());
			enemy_bomb=Applet.newAudioClip(new File("music/enemy_bomb.wav").toURI().toURL());
			hero_bomb=Applet.newAudioClip(new File("music/hero_bomb.wav").toURI().toURL());
			hero_bullet=Applet.newAudioClip(new File("music/hero_bullet.wav").toURI().toURL());
		} catch (MalformedURLException e) {
			System.out.println("添加游戏声音失败");
			e.printStackTrace();
		}
	}
	
	@Override//重写父类的绘制组件paintComponet方法，用于在面板上绘制图片
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(status!=GAME_OVER){ //若游戏未处于游戏结束状态
			//绘制背景图
			background.draw(g); 
			if(status==GAME_RUNNING){ //若游戏状态处于运行状态
				//绘制敌机列表中的各个敌机
				for(int i=0; i<ePlanes.size(); i++){
					EnemyPlane ePlane=ePlanes.get(i); //获取每一架敌机
					ePlane.draw(g); //绘制敌机
				}
				//绘制敌机子弹列表中的各个敌机子弹
				for(int i=0; i<eBullets.size(); i++){
					EnemyBullet eBullet= eBullets.get(i);
					eBullet.draw(g);
				}
				//绘制英雄机
				hPlane.draw(g);
				//绘制英雄机子弹列表中各个子弹
				for(int i=0; i<hBullets.size(); i++){
					HeroBullet hBullet=hBullets.get(i);
					hBullet.draw(g);
				}
				//绘制爆炸效果列表中各个爆炸效果
				for(int i=0; i<booms.size(); i++){
					Boom boom=booms.get(i);
					//注意：不同对象爆炸，爆炸大小不同，因此要同时指定画爆炸效果的宽度和高度
					g.drawImage(boom.img, boom.x, boom.y, boom.getW(),boom.getH(),this);
				}
			}else if(status==GAME_SUSPEND){//若游戏处于暂停中断状态时
				//画倒计时的图片
				g.drawImage(img_countdown_gw, PANEL_WIDTH-img_countdown_gw.getWidth(null)-11, 10, this);//11为微调距离，下同
				g.drawImage(img_countdown_sw, PANEL_WIDTH-img_countdown_gw.getWidth(null)-11-img_countdown_sw.getWidth(null)-11, 10, this);
			}
		}
	}
	/**
	 * action方法：行动，面板上的所有对象要行动起来
	 */
	public void action(){
		while(true){//永真循环
			if(status==GAME_RUNNING){ //若游戏处于运行状态
				//1.背景图移动
				background.move();
				//2.对敌机列表进行处理
				//System.out.println(ePlanes.size());
				for(int i=0; i<ePlanes.size();i++){
					EnemyPlane ePlane=ePlanes.get(i);
					//2.1敌机移动
					ePlane.move();
					//2.2越界处理及发射子弹处理
					if(ePlane.outOfBound()==true){//若越界，则从列表中删除
						ePlanes.remove(i);
						i--;
					}else{ //若未越界，则发射子弹
						EnemyBullet eBullet=ePlane.shoot();
						if(eBullet!=null){
							eBullets.add(eBullet);
						}
					}
				}
				
				//3.对敌机子弹列表进行处理
				//System.out.println(eBullets.size());
				for(int i=0; i<eBullets.size();i++){
					EnemyBullet eBullet=eBullets.get(i);
					//3.1 敌机子弹移动
					eBullet.move(); 
					//3.2 敌机子弹切换图片（形成子动画效果）
					eBullet.changeImage();
					//3.3 对子弹越界进行处理
					if(eBullet.outOfBound()==true){
						eBullets.remove(i);
						i--;
					}
				}
				
				//4.对英雄机子弹列表进行处理
				//System.out.println("英雄机子弹数："+hBullets.size());
				for(int i=0; i<hBullets.size(); i++){
					HeroBullet hBullet=hBullets.get(i);
					//4.1 英雄机子弹移动
					hBullet.move();
					//4.2 越界处理
					if(hBullet.outOfBound()==true){
						hBullets.remove(i);
						i--;
					}
				}
				
				//5.碰撞检测
				//5.1检测敌机被碰撞情况
				boolean hPlane_isHitted=false;//该变量存放英雄机是否被撞，初始为false，表示没有被撞
				for(int i=0; i<ePlanes.size();i++){
					EnemyPlane ePlane=ePlanes.get(i);
					boolean ePlane_isHitted=false; //该变量存放敌机是否被撞，初始为false，表示没有被撞
					//5.1.1 检测敌机是否与英雄机相撞
					if(ePlane.isHittedByHeroPlane(hPlane)==true ){
						ePlane_isHitted=true;//表示敌机被撞了
						hPlane_isHitted=true;//英雄机被撞了
					}
					//5.1.2 检测敌机是否与英雄机子弹相撞
					for(int j=0; j<hBullets.size(); j++){
						HeroBullet hBullet=hBullets.get(j);
						if(ePlane.isHittedByHeroBullet(hBullet)==true){
							ePlane_isHitted=true;//表示敌机被撞了
							hBullets.remove(j); //移除该英雄机子弹
						}
					}
					if(ePlane_isHitted==true){ //经过上面2处检测，若敌机被撞
						enemy_bomb.play();//播放敌机爆炸音效
						Boom boom=ePlane.boomed();//敌机爆了，产生一个爆炸效果
						booms.add(boom); //添加到爆炸效果列表
						score=score+ePlane.getScore();
						ePlanes.remove(i); //移除该敌机
					}
				}
				//5.2 检测英雄机被碰撞情况
				//5.2.1 检测英雄机是否与敌机相撞（这个在上面检测敌机是否被撞中已处理，此处无需再作处理）
				//5.2.2 检测英雄机是否与敌机子弹相撞
				for(int i=0; i<eBullets.size(); i++){
					EnemyBullet eBullet=eBullets.get(i);
					if(hPlane.isHittedByEnemyBullet(eBullet)==true){
						hPlane_isHitted=true; //表示英雄机被撞了
						eBullets.remove(i); //移除该敌机子弹
						i--;
					}
				}
				if(hPlane_isHitted==true){ //经过上面的碰撞检测，如果英雄机被撞了
					hero_bomb.play();//播放英雄级爆炸音效
					Boom boom=hPlane.boomed(); //英雄机被爆了，产生一个爆炸效果
					booms.add(boom); //添加到爆炸效果列表
					hPlane.changeStatus(HeroPlane.RESTING);//将英雄机切换到休息状态
					boolean b=hPlane.subtractLife(); //英雄机减命
					if(b==false){ //没有命了
						bg.stop();//结束背景音乐
						//做一些倒计时的准备工作
						countdown_times=5;//倒计时初始为5秒
						int sw=countdown_times/10;//倒计时十位上的数
						int gw=countdown_times%10;//倒计时个位上的数
						try {
							img_countdown_sw=ImageIO.read(new File("images/d"+sw+".jpg"));//初始化倒计时十位上的图片
							img_countdown_gw=ImageIO.read(new File("images/d"+gw+".jpg"));//初始化倒计时个位上的图片
						} catch (IOException e) {
							System.out.println("加载显示时间的图片失败！");
						}
						timer.start();//开始倒计时（定时器开始工作）
						status=GAME_SUSPEND; //切换游戏状态为暂时中断结束状态
						background.changeImage(status); //改变背景图
					}
				}
				
				//6.对爆炸效果列表中各个“爆炸”对象进行处理
				for(int i=0; i<booms.size(); i++){
					Boom boom=booms.get(i);
					//6.1 爆炸效果移动
					boom.move();
					//6.2 爆炸效果切换图片
					boolean b=boom.changeImage();
					if(b==false){ //若切换图片失败（说明爆炸效果已完成）
						booms.remove(i); //移除该爆炸效果
						i--;
					}
				}
				
				//7.若敌机未达到约定的最大数量，则补充敌机
				if(ePlanes.size()<MAX_ENEMY_NUMBER){
					ePlanes.add(new EnemyPlane());
				}
				
				//8.若英雄机处于休息状态，则试图唤醒它切换到工作状态
				if(hPlane.getStatus()==HeroPlane.RESTING){
					boolean b=hPlane.isRestComplete();
					if(b==true){ //若休息完成
						hPlane.changeStatus(HeroPlane.WORKING);//切换到工作状态
						allBomb();//全屏爆炸
					}
				}
				
				//9.刷新游戏信息（分数及英雄机命数）
				lblScore.setText("分数 : "+score);
				lblLife.setText("命数 : "+hPlane.getLife());
				
			}
			
			repaint(); //重画（即调用paintComponent方法执行）
			try {
				Thread.sleep(50);//程序暂停50毫秒
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		}
	}
	
	/**
	 * 全屏爆炸：
	 * 一方面为了英雄机再次出场造势，
	 * 另一方面是为了防止英雄机一出场就被打死了
	 */
	private void allBomb() {
		all_bomb.play();//播放全屏爆炸音效
		Boom boom=new Boom(0, 0, PANEL_WIDTH, PANEL_HEIGHT, 0);//产生爆炸效果
		booms.add(boom);//添加到爆炸效果列表
		//将面板上所有敌机的分数累加到totalScore
		for(int i=0; i<ePlanes.size(); i++){
			EnemyPlane ePlane=ePlanes.get(i);
			score=score+ePlane.getScore();
		}
		ePlanes.clear(); //清空敌机列表所有元素
		eBullets.clear(); //清空敌机子弹列表所有元素
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {//鼠标拖动
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) { //鼠标移动
		//getX()和getY()：返回鼠标所处的位置（即x横坐标和y纵坐标）
		//System.out.println("("+e.getX()+","+e.getY()+")");
		if(status==GAME_READY && e.getX()>=130 && e.getX()<=260 
				&& e.getY()>=390 && e.getY()<=430){//若游戏处于准备状态且鼠标移到“开始游戏”上
			//设置鼠标形状为“手势形状”
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}else if(status==GAME_RUNNING && hPlane.getStatus()==HeroPlane.WORKING){//若游戏处于运行状态且英雄机处于工作状态
			//设置鼠标形状为“手势形状”
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
			//英雄机随着鼠标移动
			hPlane.move(e.getX(),e.getY());
			//移动时自动发子弹
			//HeroBullet hBullet=hPlane.shoot();
			//hBullets.add(hBullet);
		}else if(status==GAME_SUSPEND && e.getX()>=110 && e.getX()<=300 
				&& e.getY()>=310 && e.getY()<=370){ //若游戏处于暂时中断状态且鼠标移到“继续游戏”上
			//设置鼠标形状为“手势形状”
			this.setCursor(new Cursor(Cursor.HAND_CURSOR));
		}else{
			//设置鼠标形状为“默认形状”（此处为箭头）
			this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) { //鼠标按下
		if(status==GAME_READY && e.getX()>=130 && e.getX()<=260 
				&& e.getY()>=390 && e.getY()<=430){ //若游戏处于准备状态且在"开始游戏"上点击
			status=GAME_RUNNING; //游戏切换到运行状态
			bg.loop();//播放背景音乐
			background.changeImage(status); //改变背景图
			lblScore.setVisible(true);//显示游戏分数的标签可见
			lblLife.setVisible(true);//显示英雄机命数的标签可见
		}else if(status==GAME_RUNNING && hPlane.getStatus()==HeroPlane.WORKING){ //若游戏处于运行状态且英雄机处于工作状态，则按下鼠标，发射子弹
			hero_bullet.play();//播放英雄机发子弹音效
			HeroBullet hBullet=hPlane.shoot();
			hBullets.add(hBullet);
		}else if(status==GAME_SUSPEND && e.getX()>=110 && e.getX()<=300 
				&& e.getY()>=310 && e.getY()<=370){ //若游戏处于暂时中断状态且鼠标在“继续游戏”上点击
			status=GAME_RUNNING;//游戏切换到运行状态
			bg.loop();//播放背景音乐
			background.changeImage(status); //改变背景图
			hPlane.restoreLife(); //英雄机恢复命数
			timer.stop(); //倒计时定时器停止工作
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {//行为处理方法
		countdown_times--;//倒计时减1
		int sw=countdown_times/10;//倒计时十位上的数
		int gw=countdown_times%10;//倒计时个位上的数
		try {
			img_countdown_sw=ImageIO.read(new File("images/d"+sw+".jpg"));//初始化倒计时十位上的图片
			img_countdown_gw=ImageIO.read(new File("images/d"+gw+".jpg"));//初始化倒计时个位上的图片
		} catch (IOException e) {
			System.out.println("加载显示时间的图片失败！");
		}
		if(countdown_times==0){ //倒计时完毕
			timer.stop(); //定时器计止工作
			status=GAME_OVER; //切换游戏状态
			gameover(); //调用gameover方法，保存用户分数并显示游戏分数排行榜
		}
		
	}

	/**
	 * gameover方法：处理本次玩家数据并显示游戏分数排行榜
	 */
	private void gameover() {
		this.remove(lblScore); //移除分数显示标签
		this.remove(lblLife);	//移除英雄机命数显示标签
		this.setBackground(Color.WHITE); //设置面板背景颜色为白色
		//弹出对话框，接受用户输入的玩家姓名
		String name=JOptionPane.showInputDialog(this,"请输入尊姓大名");
		if(name==null || name.equals("")){ //若用户未输入姓名
			name="未命名";
		}
		//一、处理本次玩家数据，思路如下：
		/*
		 * 	先根据玩家的name在数据库shootgame_db的game_user表中
		 * 	查询是否有此玩家，并做以下处理：
		 * 	1）若没有此玩家，则往game_user表中增加一条记录（包括玩家名name和本次游戏总分score）
		 * 	2）若有此玩家（以前有记录），则比较本次游戏得分与以前记录在表中得分的大小，
		 * 	若本次游戏得分高于以前得分，则将表中得分更新为本次游戏得分，否则不更新。
		 */
		GameUserDao dao=new GameUserDao();
		GameUser user=dao.findByName(name);
		if(user==null){ //若未找到
			GameUser newUser=new GameUser();
			newUser.setName(name);
			newUser.setScore(score);
			dao.insert(newUser);
		}else{ //若找到
			if(score>user.getScore()){
				user.setScore(score);
				dao.updateByName(user);
			}
		}
		//二、显示游戏排行榜（最高总分前5名）
		JLabel lblTitle=new JLabel();
		lblTitle.setText("玩家排行榜");
		lblTitle.setFont(new Font("微软雅黑",Font.BOLD,40));
		lblTitle.setSize(200, 40);
		lblTitle.setLocation(PANEL_WIDTH/2-lblTitle.getWidth()/2, 100);
		this.add(lblTitle);
		//思路如下：查询分数最高的n条记录，并利用标签将结果信息显示在面板上
		ArrayList<GameUser> userList=dao.findMaxScoreTopN(5);
		JLabel[] lblNames=new JLabel[userList.size()]; //显示玩家姓名的标签数组
		JLabel[] lblScores=new JLabel[userList.size()];
		for(int i=0; i<userList.size(); i++){
			GameUser u=userList.get(i);
			lblNames[i]=new JLabel(u.getName());
			lblNames[i].setFont(new Font("微软雅黑",Font.PLAIN,30));
			lblNames[i].setSize(120, 30);
			lblNames[i].setLocation(60, 200+i*60);
			this.add(lblNames[i]);
			lblScores[i]=new JLabel(u.getScore()+"");
			lblScores[i].setFont(new Font("微软雅黑",Font.PLAIN,30));
			lblScores[i].setSize(120, 30);
			lblScores[i].setLocation(250, 200+i*60);
			this.add(lblScores[i]);
		}
		//设置第1个玩家的显示颜色为红色
		lblNames[0].setForeground(Color.RED);
		lblScores[0].setForeground(Color.RED);
		
		if(userList.size()>=2){
			//设置第2个玩家的显示颜色为蓝色
			lblNames[1].setForeground(Color.BLUE);
			lblScores[1].setForeground(Color.BLUE);
		}
		
		if(userList.size()>=3){
			//设置第3个玩家的显示颜色为蓝色
			lblNames[2].setForeground(Color.PINK);
			lblScores[2].setForeground(Color.PINK);
		}
	}



}
