package views;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dao.QuestionDao;
public class QuestionAddFrm extends JFrame{		//��Ŀ��Ϣ���ӽ���
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
   
   private JButton btnAdd=new JButton("��   ��");
   private JButton btnCancel=new JButton("ȡ   ��");
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
	   this.setTitle("������Ŀ");
	   this.setSize(800,400);
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
		  JOptionPane.showMessageDialog(this, "���ӳɹ�!");
		  this.dispose();
		  questiontablefrm.updateTable();
	  }else {
		  JOptionPane.showMessageDialog(this, "�����û�ʧ��!");
	  }
   }
public static void main(String[] args) {
	   new QuestionAddFrm();
   }
}