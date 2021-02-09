package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class TeacherFrm extends JFrame{			//��ʦ��ʼ����
	private JButton btnSelect=new JButton("������г�ȡ����");
	private JButton btnScore=new JButton("�鿴���Գɼ�");
	private JButton btninform=new JButton("��Ϣ�����̨");
	private JButton btnadd=new JButton("�������ϵͳ");
	public TeacherFrm(){
		JPanel jp=(JPanel)this.getContentPane();
		jp.setLayout(new GridLayout(4,2));
	    jp.add(btnSelect);
	    jp.add(btnScore);
	    jp.add(btninform);
	    jp.add(btnadd);
		this.setSize(400,350);
		this.setTitle("��ʦ��̨����ϵͳ");
		setLocationRelativeTo(null);		//���ô�������Ļ����λ����ʾ
		this.setVisible(true);
	    btnSelect.addActionListener(new ActionListener() {	//������г�ȡ����
	        public void actionPerformed(ActionEvent e) {
	        	new SelectFrm();
	        }
	      });
	    btnScore.addActionListener(new ActionListener() {	//�鿴���Գɼ�
	        public void actionPerformed(ActionEvent e) {
	        	new TeacherResult();
	        }
	      });
	    btninform.addActionListener(new ActionListener() {	//��Ϣ�����̨
	        public void actionPerformed(ActionEvent e) {
	        	new ManagerFrm();
	        }
	      });
	    btnadd.addActionListener(new ActionListener() {	//�������ϵͳ
	        public void actionPerformed(ActionEvent e) {
	        	new QuestionTableFrm();
	        }
	      });
	}
	
}