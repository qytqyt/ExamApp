package views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import dao.ManagerDao;;
public class ManagerAddFrm extends JFrame{		//����Ա�û���Ϣ��ӽ���
   private JLabel lblId=new JLabel("�û���");
   private JLabel lblPwd=new JLabel("��   ��");
   private JLabel lblName=new JLabel("��   ��");
   private JLabel lblEmail=new JLabel("��   ��");
   private JLabel lblFindPwd=new JLabel("�Ƿ���Ҫ�һ�����");
   private JTextField txtId=new JTextField();
   private JPasswordField txtPwd=new JPasswordField();
   private JTextField txtName=new JTextField();
   private JTextField txtEmail=new JTextField();
   private JTextField txtFindPwd=new JTextField();
   private JButton btnAdd=new JButton("��   ��");
   private JButton btnCancel=new JButton("ȡ   ��");
   private ManagerDao managerDao=new ManagerDao();
   private ManagerTableFrm managertablefrm=new ManagerTableFrm();
   public ManagerAddFrm() {
	   JPanel jp=(JPanel)this.getContentPane();
	   jp.setLayout(new GridLayout(6,2));
	   jp.add(lblId);jp.add(txtId);
	   jp.add(lblPwd);jp.add(txtPwd);
	   jp.add(lblName);jp.add(txtName);
	   jp.add(lblEmail);jp.add(txtEmail);
	   jp.add(lblFindPwd);jp.add(txtFindPwd);
	   jp.add(btnAdd);jp.add(btnCancel);
	   this.setTitle("�����û�");
	   this.setSize(400,350);
	   setLocationRelativeTo(null);		//���ô�������Ļ����λ����ʾ
	   this.setVisible(true);
	   btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				btnAddClicked();
			}
		});
	}
   private void btnAddClicked() {
	  String uid=this.txtId.getText();
	  String upwd=this.txtPwd.getText();
	  String name=this.txtName.getText();
	  String email=this.txtEmail.getText();
	  String needfindpwd=this.txtFindPwd.getText();
	  if(managerDao.addUser(uid,upwd,name,email,needfindpwd)>0) {
		  JOptionPane.showMessageDialog(this, "���ӳɹ�!");
		  managertablefrm.updateTable();
	  }else {
		  JOptionPane.showMessageDialog(this, "�����û�ʧ��!");
	  }
   }
public static void main(String[] args) {
	   new ManagerAddFrm();
   }
}