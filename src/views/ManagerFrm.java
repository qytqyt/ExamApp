package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ManagerFrm extends JFrame{			//����Ա��ʼ����
		private JButton btnStudent=new JButton("ѧ����Ϣ��̨");
		private JButton btnTeacher=new JButton("��ʦ��Ϣ��̨");
		private JButton btnManager=new JButton("����Ա��Ϣ��̨");
		public ManagerFrm(){
			JPanel jp=(JPanel)this.getContentPane();
			jp.setLayout(new GridLayout(3,2));
		    jp.add(btnStudent);
		    jp.add(btnTeacher);
		    jp.add(btnManager);
			this.setSize(400,350);
			this.setTitle("��Ϣ����ϵͳ");
			setLocationRelativeTo(null);		//���ô�������Ļ����λ����ʾ
			this.setVisible(true);
		    btnStudent.addActionListener(new ActionListener() {	//ѧ����Ϣ��̨
		        public void actionPerformed(ActionEvent e) {
		        	new StuTableFrm();
		        }
		      });
		    btnTeacher.addActionListener(new ActionListener() {	//��ʦ��Ϣ��̨
		        public void actionPerformed(ActionEvent e) {
		        	new TeacherTableFrm();
		        }
		      });
		    btnManager.addActionListener(new ActionListener() {	//����Ա��Ϣ��̨
		        public void actionPerformed(ActionEvent e) {
		        	new ManagerTableFrm();
		        }
		      });
		}
}
