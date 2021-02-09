package views;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import dbutil.SQLHelper;
public class StuAlterFrm extends JFrame implements ActionListener {		//ѧ����Ϣ�޸Ľ���

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
		setLocationRelativeTo(null);		//���ô�������Ļ����λ����ʾ
		setTitle("�û���Ϣ�޸Ľ���");
		this.uid = number;
		setText();
	}
	
	void init()
	{
		JLabel lblId = new JLabel("�û���");
		JLabel lblPwd = new JLabel("��   ��");
		JLabel lblName = new JLabel("��   ��");
		JLabel lblEmail = new JLabel("��   ��");
		JLabel lblFindPwd = new JLabel("�Ƿ���Ҫ�һ�����");
	
		
		txtId = new JTextField();
		txtPwd = new JTextField();
		txtName = new JTextField();
		txtEmail = new JTextField();
		txtFindPwd = new JTextField();
		
		btnAlter = new JButton("��   ��");
		btnAlter.addActionListener(this);
		btnCancel = new JButton("ȡ   ��");
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
	
	public void connDB() { // �������ݿ�
		try {
			Class.forName("com.mysql.jdbc.Driver");//ע������
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {//��������
			con = DriverManager.getConnection(SQLHelper.url,SQLHelper.dbuser,SQLHelper.dbpwd);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
		
	}

	public void closeDB() // �ر�����
	{
		try {
			stmt.close();
			con.close();
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void setText()//�˺��������� �����ݿ� ��Ҫ�޸ĵ���Ϣ ����ӡ��������ı�����
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
				JOptionPane.showMessageDialog(null, "�����ڸñ�ţ�");
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

		if(source == btnAlter)//���ȷ����ť
		{
			if(id.equals("")||pwd.equals("")||name.equals("")||email.equals("")||needfindpwd.equals(""))
			{
				JOptionPane.showMessageDialog(null, "����д������");
			}
			else
			{
				
				int n = JOptionPane.showConfirmDialog(this, "ȷ���޸Ĵ��û���Ϣ��","ȷ�϶Ի���",JOptionPane.YES_NO_OPTION);//ȷ���ı���
				if(n == JOptionPane.YES_OPTION)
				{
					this.connDB();
					try {
						
						stmt = con.createStatement();
						String str =  "update students set uid='"+id+"',upwd='"+pwd+"',name='"+name+"',email='"+email+"',needfindpwd='"+needfindpwd+"' where uid = '"+uid+"';";
						stmt.executeUpdate(str);
						JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
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