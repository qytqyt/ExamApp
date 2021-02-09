package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ManagerFrm extends JFrame{			//管理员初始界面
		private JButton btnStudent=new JButton("学生信息后台");
		private JButton btnTeacher=new JButton("教师信息后台");
		private JButton btnManager=new JButton("管理员信息后台");
		public ManagerFrm(){
			JPanel jp=(JPanel)this.getContentPane();
			jp.setLayout(new GridLayout(3,2));
		    jp.add(btnStudent);
		    jp.add(btnTeacher);
		    jp.add(btnManager);
			this.setSize(400,350);
			this.setTitle("信息管理系统");
			setLocationRelativeTo(null);		//设置窗体在屏幕居中位置显示
			this.setVisible(true);
		    btnStudent.addActionListener(new ActionListener() {	//学生信息后台
		        public void actionPerformed(ActionEvent e) {
		        	new StuTableFrm();
		        }
		      });
		    btnTeacher.addActionListener(new ActionListener() {	//教师信息后台
		        public void actionPerformed(ActionEvent e) {
		        	new TeacherTableFrm();
		        }
		      });
		    btnManager.addActionListener(new ActionListener() {	//管理员信息后台
		        public void actionPerformed(ActionEvent e) {
		        	new ManagerTableFrm();
		        }
		      });
		}
}
