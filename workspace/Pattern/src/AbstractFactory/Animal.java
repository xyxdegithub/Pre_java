package AbstractFactory;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//抽象产品：动物类
interface Animal
{
    public void show();
}
//具体产品：马类
class Horse implements Animal
{
  JScrollPane sp;
  JFrame jf=new JFrame("抽象工厂模式测试");
  public Horse()
  {
      Container contentPane=jf.getContentPane();
      JPanel p1=new JPanel();
      p1.setLayout(new GridLayout(1,1));
      p1.setBorder(BorderFactory.createTitledBorder("动物：马"));
      sp=new JScrollPane(p1);
      contentPane.add(sp, BorderLayout.CENTER);
      JLabel l1=new JLabel(new ImageIcon("src/A_Horse.jpg"));
      p1.add(l1);       
      jf.pack();       
      jf.setVisible(false);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭 
  }
  public void show()
  {
      jf.setVisible(true);
  }
}
//具体产品：牛类
class Cattle implements Animal
{
  JScrollPane sp;
  JFrame jf=new JFrame("抽象工厂模式测试");
  public Cattle() {
      Container contentPane=jf.getContentPane();
      JPanel p1=new JPanel();
      p1.setLayout(new GridLayout(1,1));
      p1.setBorder(BorderFactory.createTitledBorder("动物：牛"));
      sp=new JScrollPane(p1);
      contentPane.add(sp, BorderLayout.CENTER);
      JLabel l1=new JLabel(new ImageIcon("src/A_Cattle.jpg"));
      p1.add(l1);       
      jf.pack();       
      jf.setVisible(false);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//用户点击窗口关闭 
  }
  public void show()
  {
      jf.setVisible(true);
  }
}


