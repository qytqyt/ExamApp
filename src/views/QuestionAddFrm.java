package views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.QuestionDao;
public class QuestionAddFrm extends JFrame{		//题目信息增加界面
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
	
   private JTextField txtQID=new JTextField();
   private JTextField txtQuestion=new JTextField();
   private JTextField txtOptionA=new JTextField();
   private JTextField txtOptionB=new JTextField();
   private JTextField txtOptionC=new JTextField();
   private JTextField txtOptionD=new JTextField();
   private JTextField txtOptionT=new JTextField();
   private JTextField txtOptionF=new JTextField();
   private JTextField txtanswer=new JTextField();
   private JTextField txtPaperID=new JTextField();
   
   private JButton btnAdd=new JButton("增   加");
   private JButton btnCancel=new JButton("取   消");
   private QuestionDao questionDao=new QuestionDao();
   private QuestionTableFrm questiontablefrm=new QuestionTableFrm();
   public QuestionAddFrm() {
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
	   jp.add(btnAdd);jp.add(btnCancel);
	   this.setTitle("增加题目");
	   this.setSize(800,400);
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
	  String id=this.txtQID.getText();
	  String question=this.txtQuestion.getText();
	  String oa=this.txtOptionA.getText();
	  String ob=this.txtOptionB.getText();
	  String oc=this.txtOptionC.getText();
	  String od=this.txtOptionD.getText();
	  String ot=this.txtOptionT.getText();
	  String of=this.txtOptionF.getText();
	  String answer=this.txtanswer.getText();
	  String pid=this.txtPaperID.getText();
	  if(questionDao.addQ(id,question,oa,ob,oc,od,ot,of,answer,pid)>0) {
		  JOptionPane.showMessageDialog(this, "增加成功!");
		  this.dispose();
		  questiontablefrm.updateTable();
	  }else {
		  JOptionPane.showMessageDialog(this, "增加用户失败!");
	  }
   }
public static void main(String[] args) {
	   new QuestionAddFrm();
   }
}