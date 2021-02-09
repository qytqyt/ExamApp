package views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import dao.*;
import views.StuTableFrm;
import views.StudentFrm;
import views.TeacherFrm;
import dbutil.ExchangeData;
public class LoginFrm extends JFrame{		//��¼����
   private JLabel lblId=new JLabel("�û���");
   private JLabel lblPwd=new JLabel("��   ��");
   private JTextField txtId=new JTextField();
   private JPasswordField txtPwd=new JPasswordField();
   private JButton btnOk=new JButton("��¼");
   private JButton btnCancel=new JButton("ȡ��");
   private JButton btnFindPwd = new JButton("�һ�����");
   private JRadioButton radioOne = new JRadioButton();//ѧ��ѡ��
   private JRadioButton radioTwo = new JRadioButton();//����Աѡ��
   private JRadioButton radioThree = new JRadioButton();//��ʦѡ��
   
   ButtonGroup group=new ButtonGroup();
   
   private StuDao stuDao=new StuDao();
   private TeacherDao teacherDao=new TeacherDao();
   private ManagerDao managerDao=new ManagerDao();
   
   String idStr;
   public LoginFrm() {
	   JPanel jp=(JPanel)this.getContentPane();
	   jp.add(lblId);jp.add(txtId);
	   jp.add(lblPwd);jp.add(txtPwd);
	   jp.add(btnOk);jp.add(btnCancel);jp.add(btnFindPwd);
   	   jp.add(radioOne);jp.add(radioTwo);jp.add(radioThree);
	   group.add(radioOne);group.add(radioTwo);group.add(radioThree);
	   txtPwd.setEchoChar('*');					//������������е�������*��ʾ����
	   this.setTitle("�û���¼");
	   this.setSize(340,270);
	   this.setLocationRelativeTo(null);		//���ô�������Ļ����λ����ʾ
	   this.setVisible(true);
	   radioOne.setText("ѧ����½");
	   radioOne.setSelected(false);
	   radioTwo.setText("����Ա��½");
	   radioTwo.setSelected(false);
	   radioThree.setText("��ʦ��½");
	   radioThree.setSelected(false);
		jp.setLayout(null);
		lblId.setBounds(30,40,50,18);
		lblPwd.setBounds(30,80,50,18);
		txtId.setBounds(80,40,200,18);
		txtPwd.setBounds(80,80,200,18);
		btnOk.setBounds(30,180,90,30);
		btnCancel.setBounds(110,180,90,30);
		btnFindPwd.setBounds(190,180,90,30);
		radioOne.setBounds(20,120,80,30);
		radioTwo.setBounds(110,120,110,30);
		radioThree.setBounds(220,120,110,30);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		btnOk.addActionListener(new ActionListener() {		//���ȷ�������е�¼��֤
			@Override
			public void actionPerformed(ActionEvent e) {
				btnOKClicked();
			}
		});
		btnCancel.addActionListener(new ActionListener() {	//���ȡ�����رյ�ǰ��¼����
    	   	@Override
    	   	public void actionPerformed(ActionEvent e) {
    	   		btnCancelClicked();
    	   	}
       	});
		btnFindPwd.addActionListener(new ActionListener() {	//����һ����밴ť�����������޸�
			@Override
			public void actionPerformed(ActionEvent e) {
				btnFindPwdClicked();
			}
		});
   }
   private void btnOKClicked() {
	   String uid=this.txtId.getText();
	   String upwd=this.txtPwd.getText();
	   if(radioOne.isSelected()) {
		   idStr="ѧ��";
		   ExchangeData.sid=uid;
		   if(stuDao.validateStu(uid, upwd)) {
			   JOptionPane.showMessageDialog(this,"��ӭ����"+uid+idStr+"��½");
			   new StudentFrm();
			   this.setVisible(false);
		   }else {
			   JOptionPane.showMessageDialog(this, "�û����������������!");
		   }
	   }
	   if(radioTwo.isSelected()) {
		   idStr="����Ա";
		   ExchangeData.mid=uid;
		   if(managerDao.validateManage(uid, upwd)) {
			   JOptionPane.showMessageDialog(this,"��ӭ����"+uid+idStr+"��½");
			   new ManagerFrm();
			   this.setVisible(false);
		   }else {
			   JOptionPane.showMessageDialog(this, "�û����������������!");
		   }
	   }
	   if(radioThree.isSelected()) {
		   idStr="��ʦ";
		   ExchangeData.tid=uid;
		   if(teacherDao.validateTeach(uid, upwd)) {
			   JOptionPane.showMessageDialog(this,"��ӭ����"+uid+idStr+"��½");
			   new TeacherFrm();
			   this.setVisible(false);
		   }else {
			   JOptionPane.showMessageDialog(this, "�û����������������!");
		   }
	   }
   }
   	public void btnCancelClicked() {
   			if(JOptionPane.showConfirmDialog(this, "ȷ�Ϲرյ�ǰ������",
   					"�رմ���",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) {
   				this.dispose();
   				}
   	}
   	public void btnFindPwdClicked() {
   				String uid=this.txtId.getText();
   				String upwd=this.txtPwd.getText();
   				if(radioOne.isSelected()&&stuDao.validateStu(uid, upwd)) {			//ѧ�����ύ�޸�������Ϣ����ѧ����Ϣ�������
   				   ExchangeData.sid=uid;
   					if(stuDao.changePwd(ExchangeData.sid)>0) {
   					  JOptionPane.showMessageDialog(this, "��Ϣ���ύ!");
   				  }else {
   					  JOptionPane.showMessageDialog(this, "��Ϣ�ύʧ��!");
   				  }
   				}
   				if(radioTwo.isSelected()&&managerDao.validateManage(uid, upwd)) {	//����Ա��ֱ�ӽ������Ա��Ϣϵͳ�����޸�
   		   			if(JOptionPane.showConfirmDialog(this, "�����н������Ա��Ϣϵͳ�޸�",
   		   					"�رմ���",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) {
   		   				new ManagerTableFrm();
   		   				Return();
   		   			}
   				}
   				if(radioThree.isSelected()&&teacherDao.validateTeach(uid, upwd)) {	//��ʦ��ֱ�ӽ����ʦ��Ϣϵͳ�����޸�
   		   			if(JOptionPane.showConfirmDialog(this, "�����н����ʦ��Ϣϵͳ�޸�",
   		   					"�رմ���",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) {
   		   				new TeacherTableFrm();
   		   				Return();
   		   			}
   				}
   				this.dispose();
   	}
   	public static void main(String[] args) {
   		new LoginFrm();
   	}
	public void Return() {
		   this.setVisible(false);
	   }
}