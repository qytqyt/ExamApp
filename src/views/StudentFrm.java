package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StudentFrm extends JFrame{			//ѧ����ʼ����
	private JButton btnStart=new JButton("��ʼ����");
	private JButton btnScore=new JButton("�鿴���Գɼ�");
	public StudentFrm(){
		JPanel jp=(JPanel)this.getContentPane();
		jp.setLayout(new GridLayout(2,2));
	    jp.add(btnStart);
	    jp.add(btnScore);
		this.setSize(400,350);
		this.setTitle("ѧ������ϵͳ");
		setLocationRelativeTo(null);		//���ô�������Ļ����λ����ʾ
		this.setVisible(true);
	    btnStart.addActionListener(new ActionListener() {	//��ʼ����
	        public void actionPerformed(ActionEvent e) {
	        	new ExamFrm();
	        }
	      });
	    btnScore.addActionListener(new ActionListener() {	//�鿴���Գɼ�
	        public void actionPerformed(ActionEvent e) {
	        	new StudentSelfResultFrm();
	        }
	      });
	}
}
