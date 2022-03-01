package game;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
/**
 * 游戏主窗体类
 * @author gongdewen
 *
 */
public class GameFrame extends JFrame{
	private GamePanel panel;
	public GameFrame(){
		this.setSize(Toolkit.getDefaultToolkit().getScreenSize());//设置窗体大小为屏幕大小
		this.setUndecorated(true); //设置窗体没有标题栏修饰
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//设置关闭窗体时退出程序
		panel=new GamePanel(); //初始化面板
		this.add(panel);
		this.setVisible(true); //setVisible一方面使窗体显示，另一方面会自动调用面板的paintComponent方法执行
	}
	
	public static void main(String[] args) {
		new GameFrame();
	}
}
