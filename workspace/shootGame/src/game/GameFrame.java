package game;

import javax.swing.JFrame;

/**
 * 游戏主窗体类
 */
public class GameFrame extends JFrame{
	private GamePanel panel; //面板成员
	
	/**
	 * 构造方法
	 */
	public GameFrame(){
		this.setTitle("飞机大战");//窗体的标题
		this.setSize(407, 630); //窗体的宽度和高度
		this.setLocationRelativeTo(null);//窗体屏幕居中
		this.setResizable(false); //窗体不可改变大小
		this.setAlwaysOnTop(true);//窗体总是在最前面显示
		//窗体关闭时退出程序
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel=new GamePanel(); //初始化面板成员
		this.add(panel);	//窗体上添加面板
		this.setVisible(true); //窗体运行时可见 
		panel.action(); //调用panel的action方法执行
	}
	public static void main(String[] args) {
		new GameFrame();
	}
}
