package views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import dao.*;
import views.StuTableFrm;
import views.StudentFrm;
import views.TeacherFrm;
import dbutil.ExchangeData;
public class LoginFrm extends JFrame{		//登录界面
   private JLabel lblId=new JLabel("用户名");
   private JLabel lblPwd=new JLabel("密   码");
   private JTextField txtId=new JTextField();
   private JPasswordField txtPwd=new JPasswordField();
   private JButton btnOk=new JButton("登录");
   private JButton btnCancel=new JButton("取消");
   private JButton btnFindPwd = new JButton("找回密码");
   private JRadioButton radioOne = new JRadioButton();//学生选项
   private JRadioButton radioTwo = new JRadioButton();//管理员选项
   private JRadioButton radioThree = new JRadioButton();//教师选项
   
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
	   txtPwd.setEchoChar('*');					//将输入密码框中的密码以*显示出来
	   this.setTitle("用户登录");
	   this.setSize(340,270);
	   this.setLocationRelativeTo(null);		//设置窗体在屏幕居中位置显示
	   this.setVisible(true);
	   radioOne.setText("学生登陆");
	   radioOne.setSelected(false);
	   radioTwo.setText("管理员登陆");
	   radioTwo.setSelected(false);
	   radioThree.setText("教师登陆");
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
		btnOk.addActionListener(new ActionListener() {		//点击确定，进行登录验证
			@Override
			public void actionPerformed(ActionEvent e) {
				btnOKClicked();
			}
		});
		btnCancel.addActionListener(new ActionListener() {	//点击取消，关闭当前登录窗口
    	   	@Override
    	   	public void actionPerformed(ActionEvent e) {
    	   		btnCancelClicked();
    	   	}
       	});
		btnFindPwd.addActionListener(new ActionListener() {	//点击找回密码按钮，进行密码修改
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
		   idStr="学生";
		   ExchangeData.sid=uid;
		   if(stuDao.validateStu(uid, upwd)) {
			   JOptionPane.showMessageDialog(this,"欢迎您，"+uid+idStr+"登陆");
			   new StudentFrm();
			   this.setVisible(false);
		   }else {
			   JOptionPane.showMessageDialog(this, "用户名或密码输入错误!");
		   }
	   }
	   if(radioTwo.isSelected()) {
		   idStr="管理员";
		   ExchangeData.mid=uid;
		   if(managerDao.validateManage(uid, upwd)) {
			   JOptionPane.showMessageDialog(this,"欢迎您，"+uid+idStr+"登陆");
			   new ManagerFrm();
			   this.setVisible(false);
		   }else {
			   JOptionPane.showMessageDialog(this, "用户名或密码输入错误!");
		   }
	   }
	   if(radioThree.isSelected()) {
		   idStr="教师";
		   ExchangeData.tid=uid;
		   if(teacherDao.validateTeach(uid, upwd)) {
			   JOptionPane.showMessageDialog(this,"欢迎您，"+uid+idStr+"登陆");
			   new TeacherFrm();
			   this.setVisible(false);
		   }else {
			   JOptionPane.showMessageDialog(this, "用户名或密码输入错误!");
		   }
	   }
   }
   	public void btnCancelClicked() {
   			if(JOptionPane.showConfirmDialog(this, "确认关闭当前窗口吗？",
   					"关闭窗口",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) {
   				this.dispose();
   				}
   	}
   	public void btnFindPwdClicked() {
   				String uid=this.txtId.getText();
   				String upwd=this.txtPwd.getText();
   				if(radioOne.isSelected()&&stuDao.validateStu(uid, upwd)) {			//学生，提交修改密码信息传到学生信息管理表中
   				   ExchangeData.sid=uid;
   					if(stuDao.changePwd(ExchangeData.sid)>0) {
   					  JOptionPane.showMessageDialog(this, "信息已提交!");
   				  }else {
   					  JOptionPane.showMessageDialog(this, "信息提交失败!");
   				  }
   				}
   				if(radioTwo.isSelected()&&managerDao.validateManage(uid, upwd)) {	//管理员，直接进入管理员信息系统进行修改
   		   			if(JOptionPane.showConfirmDialog(this, "请自行进入管理员信息系统修改",
   		   					"关闭窗口",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) {
   		   				new ManagerTableFrm();
   		   				Return();
   		   			}
   				}
   				if(radioThree.isSelected()&&teacherDao.validateTeach(uid, upwd)) {	//教师，直接进入教师信息系统进行修改
   		   			if(JOptionPane.showConfirmDialog(this, "请自行进入教师信息系统修改",
   		   					"关闭窗口",JOptionPane.OK_CANCEL_OPTION)==JOptionPane.OK_OPTION) {
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