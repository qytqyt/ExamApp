package views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import dao.TeacherDao;
public class TeacherAddFrm extends JFrame{		//教师用户信息添加界面
   private JLabel lblId=new JLabel("用户名");
   private JLabel lblPwd=new JLabel("密   码");
   private JLabel lblName=new JLabel("姓   名");
   private JLabel lblEmail=new JLabel("邮   箱");
   private JLabel lblFindPwd=new JLabel("是否需要找回密码");
   private JTextField txtId=new JTextField();
   private JPasswordField txtPwd=new JPasswordField();
   private JTextField txtName=new JTextField();
   private JTextField txtEmail=new JTextField();
   private JTextField txtFindPwd=new JTextField();
   private JButton btnAdd=new JButton("增   加");
   private JButton btnCancel=new JButton("取   消");
   private TeacherDao teacherDao=new TeacherDao();
   private TeacherTableFrm teachertablefrm=new TeacherTableFrm();
   public TeacherAddFrm() {
	   JPanel jp=(JPanel)this.getContentPane();
	   jp.setLayout(new GridLayout(6,2));
	   jp.add(lblId);jp.add(txtId);
	   jp.add(lblPwd);jp.add(txtPwd);
	   jp.add(lblName);jp.add(txtName);
	   jp.add(lblEmail);jp.add(txtEmail);
	   jp.add(lblFindPwd);jp.add(txtFindPwd);
	   jp.add(btnAdd);jp.add(btnCancel);
	   this.setTitle("增加用户");
	   this.setSize(400,350);
	   setLocationRelativeTo(null);		//设置窗体在屏幕居中位置显示
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
	  if(teacherDao.addUser(uid,upwd,name,email,needfindpwd)>0) {
		  JOptionPane.showMessageDialog(this, "增加成功!");
		  teachertablefrm.updateTable();
	  }else {
		  JOptionPane.showMessageDialog(this, "增加用户失败!");
	  }
   }
public static void main(String[] args) {
	   new TeacherAddFrm();
   }
}