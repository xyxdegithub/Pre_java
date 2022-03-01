package game;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 * 游戏面板类
 * @author gongdewen
 *
 */
public class GamePanel extends JPanel implements KeyListener, ActionListener{
	private Image img; //背景图成员
	private int screen_width; //屏幕宽度
	private int screen_height; //屏幕高度
	private JLabel lblTitle; //抽奖标题
	private JLabel[] lblLuckyNames; //中奖幸运者名单标签数组
	private JLabel lblRandText; //随机文本标签（抽奖时显示随机姓名或抽奖状态）
	private ArrayList<String> namesList; //参与抽奖的人员名单列表
	private Timer timer; //定时器，用于自动执行某些代码（此处用于抽奖时在下方随机滚动显示参与抽奖者的名字）
	private boolean isTiming ; //定时器是否处于正在计时工作状态（值为false，表示未工作；为true，表示工作）
	private boolean isOver; //抽将是否完毕（值为false，表示未抽奖完毕；为true，表示抽将完毕） 
	private int count; //用来存放已抽出中奖的人员名单数(还用于中奖幸运者名单标签数组的下标）
	private AudioClip audio; //背景音乐播放对象
	private int awardNum;  //用来存放本轮抽奖设定的数量
	private PrintWriter pw; //用来写文件的输出流
	/**
	 * 构造方法
	 */
	public GamePanel(){
		img=Toolkit.getDefaultToolkit().getImage("bg.jpg"); //图片初始化
		screen_width=Toolkit.getDefaultToolkit().getScreenSize().width;
		screen_height=Toolkit.getDefaultToolkit().getScreenSize().height;
		namesList=readData(); //读入参与抽奖的人员名单
		//初始化用来写文件的输出流
		try {
			FileOutputStream fos=new FileOutputStream("中奖结果.txt"); //按字节写
			OutputStreamWriter osw=new OutputStreamWriter(fos); //按字符写
			pw=new PrintWriter(osw,true); //第二个参数，表示自动行刷新，即每写一行，文件保存一次
		} catch (FileNotFoundException e) {
			System.out.println("中奖结果文件操作失败");
			e.printStackTrace();
		}
		initComponent();  //初始化标签组件
		this.addKeyListener(this); //面板上添加键盘监听器对象
		this.setFocusable(true); //面板得到焦点
		//初始化定时器，当定时器开始工作时（初始时并没有工作），
		//则每隔50毫秒（即1秒为1000毫秒），就自动执行ActionListener接口中的actionPerformed方法1次
		timer=new Timer(50,this);
		isTiming=false; //初时定时器未处于工作状态
		count=0;	//初始化已抽出中奖的人员名单数
		isOver=false; //初始时抽将未完成
		try {
			audio=Applet.newAudioClip(new File("drum.wav").toURI().toURL());
		} catch (MalformedURLException e) {
			System.out.println("背景音效文件加载失败！");
			e.printStackTrace();
		}
		
	}
	/**
	 * 读入参与抽奖的人员名单列表
	 * @return 名单列表
	 */
	private ArrayList<String> readData() {
		ArrayList<String> namesList=new ArrayList<String>();
		try {
			FileInputStream fis=new FileInputStream("data.txt"); //按字节读
			InputStreamReader isr=new InputStreamReader(fis);//按字符读
			BufferedReader br=new BufferedReader(isr); //按行读
			String name=null;
			while( (name=br.readLine()) !=null ){ //读取一行数据，存入name，当未读到文件尾时
				namesList.add(name); //添到加列表
			}
			br.close(); //关闭文件
		} catch (IOException e) {
			System.out.println("抽奖人员数据文件打开或读入错误！");
			e.printStackTrace();
		}
		
		return namesList;
	}


	/**
	 * 初始化标签组件
	 */
	private void initComponent() {
		this.removeAll(); //移除面板上所有已有的组件（本例中为所有标签组件）
		//初始化本轮抽奖的标题
		String awardTitle=JOptionPane.showInputDialog(this, "请设定本轮抽奖的奖项名称：");
		while(awardTitle==null||awardTitle.equals("")){
			JOptionPane.showMessageDialog(this, "本轮抽奖的奖项名称不能为空！","出错",JOptionPane.ERROR_MESSAGE);
			awardTitle=JOptionPane.showInputDialog(this, "请设定本轮抽奖的奖项名称：");
		}
		//初始化本轮抽奖设定的数量
		String strNum=null;
		while(true){
			strNum=JOptionPane.showInputDialog(this, "参予本轮抽奖人数为:"+namesList.size()+"，请设定本轮抽奖的次数：");
			try{
				awardNum=Integer.parseInt(strNum);
				if(awardNum>namesList.size()){ //若设定的抽奖次数大于参予抽奖的人数
					throw new Exception(); //抛一个异常
				}
				break; //若不报错，则退出循环
			}catch(NumberFormatException e){
				JOptionPane.showMessageDialog(this, "抽奖次数请输入一个数字！","出错",JOptionPane.ERROR_MESSAGE);
			}catch (Exception e) {
				JOptionPane.showMessageDialog(this, "抽奖次数应该小于等于参予抽奖的人数！","出错",JOptionPane.ERROR_MESSAGE);
			}
		}
		pw.println(awardTitle+" 中奖人员名单（共"+awardNum+"名）：");
		this.setLayout(null); //面板不采用系统布局，采用手工布局方式
		//1.初始化抽奖标题
		lblTitle=new JLabel(awardTitle+"（共"+awardNum+"名）");
		lblTitle.setFont(new Font("微软雅黑",Font.BOLD,40)); //设置字体
		lblTitle.setForeground(Color.RED); //设置标签文字颜色
		lblTitle.setSize((awardTitle.length()+6)*40,40); //设置标签大小
		lblTitle.setLocation(screen_width/2-lblTitle.getWidth()/2,100);
		this.add(lblTitle);
		//2.初始化中奖幸运者名单标签数组
		lblLuckyNames=new JLabel[awardNum];
		for(int i=0; i<lblLuckyNames.length; i++){
			lblLuckyNames[i]=new JLabel();
			lblLuckyNames[i].setFont(new Font("微软雅黑",Font.PLAIN,30)); //设置字体
			lblLuckyNames[i].setForeground(Color.RED); //设置标签文字颜色
			lblLuckyNames[i].setSize(120,30); //设置标签大小
			lblLuckyNames[i].setLocation(screen_width/2-lblLuckyNames[i].getWidth()/2,200+i*60);
			this.add(lblLuckyNames[i]);
		}
		//3.初始化随机文本标签
		lblRandText=new JLabel();
		lblRandText.setFont(new Font("微软雅黑",Font.PLAIN,30)); //设置字体
		lblRandText.setSize(120,30); //设置标签大小
		lblRandText.setLocation(screen_width/2-lblRandText.getWidth()/2,screen_height-lblRandText.getHeight()-100);
		this.add(lblRandText);
		
		this.updateUI(); //刷新面板上的所有组件（本例中为所有标签组件）
		
	}
	protected void paintComponent(Graphics g) { //代表画笔
		super.paintComponent(g);
		g.drawImage(img,0,0,screen_width,screen_height,this);//在屏幕的左上角画一个全屏宽度和高度的图片
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//实现按空格键随机抽取，按ESC退出
		if(e.getKeyCode()==KeyEvent.VK_SPACE){ //若按下空格键
			if(isOver){ //若抽奖完毕，则提示返回
				return;
			}
			//实现定时器开始工作和停止工作的切换
			if(!isTiming){
				timer.start(); //定时器开始工作
				audio.loop();	//循环播放背景音效 
				isTiming=true;
			}else{
				timer.stop();	//定时器停止工作
				audio.stop();	//停止播放背景音效 
				isTiming=false;
				//将停止时下方显示的名字，放在中间中奖区显示
				lblLuckyNames[count++].setText(lblRandText.getText());
				pw.println(lblRandText.getText()); //写入中奖名单.txt文件
				//从参与抽奖者名单列表中删除该中奖者名字
				namesList.remove(lblRandText.getText());
				//抽奖是否已全部完成的判断
				if(count==awardNum){
					lblRandText.setText("抽奖完毕");
					pw.println(); //本轮抽奖结束，中奖名单.txt文件空一行
					isOver=true; //抽奖（状态）完毕
				}
			}
		}else if(e.getKeyCode()==KeyEvent.VK_ESCAPE){ //若按下ESC键
			if(!isOver){
				int ans=JOptionPane.showConfirmDialog
						(this, "本轮抽奖尚未结束，确认要退出抽奖吗？","提示",JOptionPane.OK_CANCEL_OPTION);
				if(ans==JOptionPane.CANCEL_OPTION){ //若点取消 
					return;
				}else{
					pw.println("抽奖中断...");
				}
			}
			pw.close(); //关闭文件（中奖名单.txt）
			System.exit(0); //退出程序
		}else if(e.getKeyCode()==KeyEvent.VK_F5 && isOver ){ //某轮抽奖结束时按F5键，重新初始化新的一轮抽奖
			initComponent(); //初始化组件
			count=0;	//初始化本轮已抽出中奖的人员名单数
			isOver=false; //初始时抽将未完成
		}
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		int n=(int)(Math.random()*namesList.size()); //获取一个抽奖名单列表中随机的下标
		lblRandText.setText(namesList.get(n)); //下面标签显示随机的名字
	}
}
