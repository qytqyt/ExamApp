package views;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.PaperDao;
import dbutil.ExchangeData;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SelectFrm extends JFrame{
	   private JLabel lblSelect=new JLabel("��������Ҫ��ȡ���Ծ���");
	   private JTextField txtSelect=new JTextField();
	   private JLabel lblChoiceScore=new JLabel("������ѡ�����ֵ");
	   private JTextField txtChoiceScore=new JTextField();
	   private JLabel lblTFScore=new JLabel("�������ж����ֵ");
	   private JTextField txtTFScore=new JTextField();
	   private JLabel lblChoiceNum=new JLabel("������ѡ�������");
	   private JTextField txtChoiceNum=new JTextField();
	   private JLabel lblTFNum=new JLabel("�������ж������");
	   private JTextField txtTFNum=new JTextField();
	   private JButton btnOK=new JButton("��   ��");
	   private JButton btnCancel=new JButton("ȡ   ��");
	   private PaperDao paperDao=new PaperDao();
	   public SelectFrm() {
		   JPanel jp=(JPanel)this.getContentPane();
		   jp.setLayout(new GridLayout(6,2));
		   jp.add(lblSelect);jp.add(txtSelect);
		   jp.add(lblChoiceScore);jp.add(txtChoiceScore);
		   jp.add(lblTFScore);jp.add(txtTFScore);
		   jp.add(lblChoiceNum);jp.add(txtChoiceNum);
		   jp.add(lblTFNum);jp.add(txtTFNum);
		   jp.add(btnOK);jp.add(btnCancel);
		   this.setTitle("���ϵͳ");
		   this.setSize(400,200);
		   setLocationRelativeTo(null);		//���ô�������Ļ����λ����ʾ
		   
		   lblSelect.setBounds(30,40,50,18);
		   txtSelect.setBounds(80,40,200,18);
		   
		   lblChoiceScore.setBounds(30,80,50,18);
		   txtChoiceScore.setBounds(80,80,200,18);
		   
		   lblTFScore.setBounds(30,120,50,18);
		   txtTFScore.setBounds(80,120,200,18);
		   
		   lblChoiceNum.setBounds(30,160,50,18);
		   txtChoiceNum.setBounds(80,160,200,18);
		   
		   lblTFNum.setBounds(30,200,50,18);
		   txtTFNum.setBounds(80,200,200,18);
		   
		   btnOK.setBounds(30,240,90,30);
		   btnCancel.setBounds(110,240,90,30);
		   
		   this.setVisible(true);
		    btnCancel.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent e) {
		        	Return();
		        }
		      });
		   btnOK.addActionListener(new ActionListener() {
	       public void actionPerformed(ActionEvent e) {
				if(txtSelect.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null, "������Ҫ��ȡ������ţ�");
				}
				else
				{
					paperDao.deletePaper();
					paperDao.selectPaper(txtSelect.getText());
					new PaperTableFrm();
				}
				if(txtChoiceScore.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null, "����ѡ�����ֵ��");
				}
				else
				{
					ExchangeData.choicescore=Integer.parseInt(txtChoiceScore.getText());
				}
				if(txtTFScore.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null, "�����ж����ֵ��");
				}
				else
				{
					ExchangeData.TFscore=Integer.parseInt(txtTFScore.getText());
				}
				if(txtChoiceNum.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null, "����ѡ���������");
				}
				else
				{
					ExchangeData.choicenum=Integer.parseInt(txtChoiceNum.getText());
				}
				if(txtTFNum.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null, "�����ж��������");
				}
				else
				{
					ExchangeData.TFnum=Integer.parseInt(txtTFNum.getText());
				}
	        }
	      });
	   }
	   public void Return() {
		   this.setVisible(false);
	   }
}
