package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StudentFrm extends JFrame{			//学生初始界面
	private JButton btnStart=new JButton("开始考试");
	private JButton btnScore=new JButton("查看考试成绩");
	public StudentFrm(){
		JPanel jp=(JPanel)this.getContentPane();
		jp.setLayout(new GridLayout(2,2));
	    jp.add(btnStart);
	    jp.add(btnScore);
		this.setSize(400,350);
		this.setTitle("学生考试系统");
		setLocationRelativeTo(null);		//设置窗体在屏幕居中位置显示
		this.setVisible(true);
	    btnStart.addActionListener(new ActionListener() {	//开始考试
	        public void actionPerformed(ActionEvent e) {
	        	new ExamFrm();
	        }
	      });
	    btnScore.addActionListener(new ActionListener() {	//查看考试成绩
	        public void actionPerformed(ActionEvent e) {
	        	new StudentSelfResultFrm();
	        }
	      });
	}
}
