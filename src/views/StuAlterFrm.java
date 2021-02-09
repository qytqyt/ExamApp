package views;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import dbutil.SQLHelper;
public class StuAlterFrm extends JFrame implements ActionListener {		//学生信息修改界面

	JTextField txtId,txtPwd,txtName,txtEmail,txtFindPwd;
	JButton btnAlter,btnCancel;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String uid;
	public StuAlterFrm(String number)
	{
		init();
		setVisible(true);
		setBounds(550, 200, 550, 280);
		setLocationRelativeTo(null);		//设置窗体在屏幕居中位置显示
		setTitle("用户信息修改界面");
		this.uid = number;
		setText();
	}
	
	void init()
	{
		JLabel lblId = new JLabel("用户名");
		JLabel lblPwd = new JLabel("密   码");
		JLabel lblName = new JLabel("姓   名");
		JLabel lblEmail = new JLabel("邮   箱");
		JLabel lblFindPwd = new JLabel("是否需要找回密码");
	
		
		txtId = new JTextField();
		txtPwd = new JTextField();
		txtName = new JTextField();
		txtEmail = new JTextField();
		txtFindPwd = new JTextField();
		
		btnAlter = new JButton("修   改");
		btnAlter.addActionListener(this);
		btnCancel = new JButton("取   消");
		btnCancel.addActionListener(this);
		
		JPanel jp=(JPanel)this.getContentPane();
		jp.setLayout(new GridLayout(6,2));
		jp.add(lblId);jp.add(txtId);
		jp.add(lblPwd);jp.add(txtPwd);
		jp.add(lblName);jp.add(txtName);
		jp.add(lblEmail);jp.add(txtEmail);
		jp.add(lblFindPwd);jp.add(txtFindPwd);
		jp.add(btnAlter);jp.add(btnCancel);
		
	}
	
	public void connDB() { // 连接数据库
		try {
			Class.forName("com.mysql.jdbc.Driver");//注册驱动
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {//创建连接
			con = DriverManager.getConnection(SQLHelper.url,SQLHelper.dbuser,SQLHelper.dbpwd);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

	public void closeDB() // 关闭连接
	{
		try {
			stmt.close();
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setText()//此函数功能是 把数据库 需要修改的信息 都打印到界面的文本框中
	{
		String id =null;
		String pwd=null;
		String name=null;
		String email=null;
		String needfindpwd=null;
		txtId.setText(uid);
		txtId.setEnabled(false);
		
		this.connDB();
		try {
			stmt = con.createStatement();
			String sql = "select * from students where uid = '"+uid+"';";
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				  id = rs.getString("uid");
				  pwd = rs.getString("upwd");
				  name = rs.getString("name");
				  email = rs.getString("email");
				  needfindpwd = rs.getString("needfindpwd");
			}else{
				JOptionPane.showMessageDialog(null, "不存在该编号！");
				this.dispose();
				new StuTableFrm();
			}
			this.closeDB();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		txtId.setText(id);
		txtPwd.setText(pwd);
		txtName.setText(name);
		txtEmail.setText(email);
		txtFindPwd.setText(needfindpwd);
	}

	public void actionPerformed(ActionEvent e) {
		String id =null;
		String pwd=null;
		String name=null;
		String email=null;
		String needfindpwd=null;	 
		Object source = e.getSource();
		
		this.connDB();

		 id = txtId.getText() ;
		 pwd = txtPwd.getText() ;
		 name = txtName.getText();
		 email = txtEmail.getText();
		 needfindpwd = txtFindPwd.getText();

		if(source == btnAlter)//点击确定按钮
		{
			if(id.equals("")||pwd.equals("")||name.equals("")||email.equals("")||needfindpwd.equals(""))
			{
				JOptionPane.showMessageDialog(null, "请填写完整！");
			}
			else
			{
				
				int n = JOptionPane.showConfirmDialog(this, "确定修改此用户信息？","确认对话框",JOptionPane.YES_NO_OPTION);//确认文本框
				if(n == JOptionPane.YES_OPTION)
				{
					this.connDB();
					try {
						
						stmt = con.createStatement();
						String str =  "update students set uid='"+id+"',upwd='"+pwd+"',name='"+name+"',email='"+email+"',needfindpwd='"+needfindpwd+"' where uid = '"+uid+"';";
						stmt.executeUpdate(str);
						JOptionPane.showMessageDialog(null, "修改成功！");
						this.closeDB();
						this.dispose();
						new StuTableFrm();
						
					} catch (SQLException e1) {
					e1.printStackTrace();
	
					}
				}
			}
		}
		else if(source == btnCancel)
		{
			this.dispose();
			new StuTableFrm();
		}
	}
}