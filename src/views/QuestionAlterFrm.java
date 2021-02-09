package views;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import dbutil.SQLHelper;
public class QuestionAlterFrm extends JFrame implements ActionListener {	//题目信息修改界面

	JTextField txtQID,txtQuestion,txtOptionA,txtOptionB,txtOptionC,txtOptionD,txtOptionT,txtOptionF,txtanswer,txtPaperID;
	JButton btnAlter,btnCancel;
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String uid;
	public QuestionAlterFrm(String number)
	{
		init();
		setVisible(true);
		setBounds(550, 200, 550, 280);
		setLocationRelativeTo(null);		//设置窗体在屏幕居中位置显示
		setTitle("题库信息修改界面");
		this.uid = number;
		setText();
	}
	
	void init()
	{
		JLabel lblQID = new JLabel("题   号");
		JLabel lblQuestion = new JLabel("题   目");
		JLabel lblOptionA = new JLabel("A选项");
		JLabel lblOptionB = new JLabel("B选项");
		JLabel lblOptionC = new JLabel("C选项");
		JLabel lblOptionD = new JLabel("D选项");
		JLabel lblOptionT = new JLabel("T选项");
		JLabel lblOptionF = new JLabel("F选项");
		JLabel lblanswer = new JLabel("答   案");
		JLabel lblPaperID = new JLabel("试卷名");
	
		txtQID = new JTextField();
		txtQuestion = new JTextField();
		txtOptionA = new JTextField();
		txtOptionB = new JTextField();
		txtOptionC = new JTextField();
		txtOptionD = new JTextField();
		txtOptionT = new JTextField();
		txtOptionF = new JTextField();
		txtanswer = new JTextField();
		txtPaperID = new JTextField();
		
		btnAlter = new JButton("修   改");
		btnAlter.addActionListener(this);
		btnCancel = new JButton("取   消");
		btnCancel.addActionListener(this);
		
		JPanel jp=(JPanel)this.getContentPane();
		jp.setLayout(new GridLayout(11,2));
		jp.add(lblQID);jp.add(txtQID);
		jp.add(lblQuestion);jp.add(txtQuestion);
		jp.add(lblOptionA);jp.add(txtOptionA);
		jp.add(lblOptionB);jp.add(txtOptionB);
		jp.add(lblOptionC);jp.add(txtOptionC);
		jp.add(lblOptionD);jp.add(txtOptionD);
		jp.add(lblOptionT);jp.add(txtOptionT);
		jp.add(lblOptionF);jp.add(txtOptionF);
		jp.add(lblanswer);jp.add(txtanswer);
		jp.add(lblPaperID);jp.add(txtPaperID);
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
		String id=null;
		String question=null;
		String oa=null;
		String ob=null;
		String oc=null;
		String od=null;
		String ot=null;
		String of=null;
		String answer=null;
		String pid=null;
		txtQID.setText(uid);
		txtQID.setEnabled(false);
		
		this.connDB();
		try {
			stmt = con.createStatement();
			String sql = "select * from question where QID = '"+uid+"';";
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				  id = rs.getString("QID");
				  question = rs.getString("Question");
				  oa = rs.getString("OptionA");
				  ob = rs.getString("OptionB");
				  oc = rs.getString("OptionC");
				  od = rs.getString("OptionD");
				  ot = rs.getString("OptionT");
				  of = rs.getString("OptionF");
				  answer = rs.getString("answer");
				  pid = rs.getString("PaperID");
			}else{
				JOptionPane.showMessageDialog(null, "不存在该编号！");
				this.dispose();
				new QuestionTableFrm();
			}
			this.closeDB();
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		
		txtQID.setText(id);
		txtQuestion.setText(question);
		txtOptionA.setText(oa);
		txtOptionB.setText(ob);
		txtOptionC.setText(oc);
		txtOptionD.setText(od);
		txtOptionT.setText(ot);
		txtOptionF.setText(of);
		txtanswer.setText(answer);
		txtPaperID.setText(pid);
	}

	public void actionPerformed(ActionEvent e) {
		String id =null;
		String question=null;
		String oa=null;
		String ob=null;
		String oc=null;	 
		String od=null;
		String ot=null;
		String of=null;	 
		String answer=null;
		String pid=null;
		Object source = e.getSource();
		
		this.connDB();

		 id = txtQID.getText() ;
		 question = txtQuestion.getText() ;
		 oa = txtOptionA.getText();
		 ob = txtOptionB.getText();
		 oc = txtOptionC.getText();
		 od = txtOptionD.getText();
		 ot = txtOptionT.getText();
		 of = txtOptionF.getText();
		 answer = txtanswer.getText();
		 pid = txtPaperID.getText();
		 
		if(source == btnAlter)//点击确定按钮
		{
			if(id.equals("")||question.equals(""))
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
						String str =  "update question set QID='"+id+"',Question='"+question+"',OptionA='"+oa+"',OptionB='"+ob+"',OptionC='"+oc+"',OptionD='"+od+"',OptionT='"+ot+"',OptionF='"+of+"',answer='"+answer+"',PaperID='"+pid+"' where QID='"+uid+"';";
						stmt.executeUpdate(str);
						JOptionPane.showMessageDialog(null, "修改成功！");
						this.closeDB();
						this.dispose();
						new QuestionTableFrm();
						
					} catch (SQLException e1) {
					e1.printStackTrace();
	
					}
				}
			}
		}
		else if(source == btnCancel)
		{
			this.dispose();
			new QuestionTableFrm();
		}
	}
}