package views;
import javax.swing.*;

import dbutil.ExchangeData;
import dbutil.InitDatas;

import java.awt.Toolkit;
import java.awt.event.*;
public class ExamFrm  extends JFrame{		//���Խ���
	JDesktopPane jtp=new JDesktopPane();
    private void initMenus(){
	   JMenuBar bar=new JMenuBar();
	   JMenu m1=new JMenu("���Խ���");
	   JMenuItem m11=new JMenuItem("���Կ�ʼ");
	   JMenuItem m13=new JMenuItem("�˳����Խ���");
	   m1.add(m11);m1.addSeparator();  m1.add(m13);
	   bar.add(m1);
	   this.setJMenuBar(bar);
	   m11.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
			  newMenuItem_Clicked(); 
		   }
	   });
	   m13.addActionListener(new ActionListener(){
		   public void actionPerformed(ActionEvent e){
			  Return();
		   }
	   });
    }
    private void  newMenuItem_Clicked(){
    	StudentTestFrm frm=new StudentTestFrm();
    	frm.setSize(980, 560);
    	frm.setVisible(true);
    	jtp.getAllFrames();
    	jtp.add(frm);
    }
    public ExamFrm(){
    	initMenus();
    	this.getContentPane().add(jtp);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	this.setTitle("��ӭ����"+ExchangeData.sid+"ʹ�����߿���ϵͳ");
    	this.setSize(InitDatas.screenwidth-300,InitDatas.screenheight-200);
 	    setLocationRelativeTo(null);		//���ô�������Ļ����λ����ʾ
    	this.setVisible(true);
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		int width = Toolkit.getDefaultToolkit().getScreenSize().width;
		int height = Toolkit.getDefaultToolkit().getScreenSize().height;
		int windowsWedth = 1000;
		int windowsHeight = 620;
		ExamFrm frm = new ExamFrm();
		frm.setTitle("��ӭ"+ExchangeData.sid+"ʹ�����߿���ϵͳ");
		frm.setBounds((width - windowsWedth) / 2, (height - windowsHeight) / 2,
				windowsWedth, windowsHeight);
		frm.setVisible(true);
	}
	public void Return() {
		   this.setVisible(false);
	   }
}