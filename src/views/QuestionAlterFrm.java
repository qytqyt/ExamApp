package views;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

import dbutil.SQLHelper;
public class QuestionAlterFrm extends JFrame implements ActionListener {	//��Ŀ��Ϣ�޸Ľ���

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
		setLocationRelativeTo(null);		//���ô�������Ļ����λ����ʾ
		setTitle("�����Ϣ�޸Ľ���");
		this.uid = number;
		setText();
	}
	
	void init()
	{
		JLabel lblQID = new JLabel("��   ��");
		JLabel lblQuestion = new JLabel("��   Ŀ");
		JLabel lblOptionA = new JLabel("Aѡ��");
		JLabel lblOptionB = new JLabel("Bѡ��");
		JLabel lblOptionC = new JLabel("Cѡ��");
		JLabel lblOptionD = new JLabel("Dѡ��");
		JLabel lblOptionT = new JLabel("Tѡ��");
		JLabel lblOptionF = new JLabel("Fѡ��");
		JLabel lblanswer = new JLabel("��   ��");
		JLabel lblPaperID = new JLabel("�Ծ���");
	
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
		
		btnAlter = new JButton("��   ��");
		btnAlter.addActionListener(this);
		btnCancel = new JButton("ȡ   ��");
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
				JOptionPane.showMessageDialog(null, "�����ڸñ�ţ�");
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
		 
		if(source == btnAlter)//���ȷ����ť
		{
			if(id.equals("")||question.equals(""))
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
						String str =  "update question set QID='"+id+"',Question='"+question+"',OptionA='"+oa+"',OptionB='"+ob+"',OptionC='"+oc+"',OptionD='"+od+"',OptionT='"+ot+"',OptionF='"+of+"',answer='"+answer+"',PaperID='"+pid+"' where QID='"+uid+"';";
						stmt.executeUpdate(str);
						JOptionPane.showMessageDialog(null, "�޸ĳɹ���");
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