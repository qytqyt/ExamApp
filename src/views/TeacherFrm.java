package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TeacherFrm extends JFrame{			//教师初始界面
	private JButton btnSelect=new JButton("从题库中抽取试题");
	private JButton btnScore=new JButton("查看考试成绩");
	private JButton btninform=new JButton("信息管理后台");
	private JButton btnadd=new JButton("进入题库系统");
	public TeacherFrm(){
		JPanel jp=(JPanel)this.getContentPane();
		jp.setLayout(new GridLayout(4,2));
	    jp.add(btnSelect);
	    jp.add(btnScore);
	    jp.add(btninform);
	    jp.add(btnadd);
		this.setSize(400,350);
		this.setTitle("教师后台管理系统");
		setLocationRelativeTo(null);		//设置窗体在屏幕居中位置显示
		this.setVisible(true);
	    btnSelect.addActionListener(new ActionListener() {	//从题库中抽取试题
	        public void actionPerformed(ActionEvent e) {
	        	new SelectFrm();
	        }
	      });
	    btnScore.addActionListener(new ActionListener() {	//查看考试成绩
	        public void actionPerformed(ActionEvent e) {
	        	new TeacherResult();
	        }
	      });
	    btninform.addActionListener(new ActionListener() {	//信息管理后台
	        public void actionPerformed(ActionEvent e) {
	        	new ManagerFrm();
	        }
	      });
	    btnadd.addActionListener(new ActionListener() {	//进入题库系统
	        public void actionPerformed(ActionEvent e) {
	        	new QuestionTableFrm();
	        }
	      });
	}
	
}