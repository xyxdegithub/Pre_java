package BuilderPattern;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Parlour {
	private String wall;
	private String sofa;
	private String TV;

	public String getWall() {
		return wall;
	}

	public void setWall(String wall) {
		this.wall = wall;
	}

	public String getSofa() {
		return sofa;
	}

	public void setSofa(String sofa) {
		this.sofa = sofa;
	}

	public String getTV() {
		return TV;
	}

	public void setTV(String tV) {
		TV = tV;
	}
	 public void show()
	    {
	        JFrame jf=new JFrame("建造者模式测试");
	        Container contentPane=jf.getContentPane();
	        JPanel p=new JPanel();   
	        JScrollPane sp=new JScrollPane(p);  
	        String parlour=wall+TV+sofa;
	        
	        JLabel l=new JLabel(new ImageIcon("src/parlour.jpg"));
	        
	        p.setLayout(new GridLayout(1,1));
	        p.setBorder(BorderFactory.createTitledBorder("客厅"));
	        p.add(l);
	        contentPane.add(sp,BorderLayout.CENTER);       
	        jf.pack();  
	        jf.setVisible(true);
	        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }   

}
