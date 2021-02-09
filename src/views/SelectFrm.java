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
	   private JLabel lblSelect=new JLabel("请输入需要抽取的试卷名");
	   private JTextField txtSelect=new JTextField();
	   private JLabel lblChoiceScore=new JLabel("请输入选择题分值");
	   private JTextField txtChoiceScore=new JTextField();
	   private JLabel lblTFScore=new JLabel("请输入判断题分值");
	   private JTextField txtTFScore=new JTextField();
	   private JLabel lblChoiceNum=new JLabel("请输入选择题个数");
	   private JTextField txtChoiceNum=new JTextField();
	   private JLabel lblTFNum=new JLabel("请输入判断题个数");
	   private JTextField txtTFNum=new JTextField();
	   private JButton btnOK=new JButton("出   卷");
	   private JButton btnCancel=new JButton("取   消");
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
		   this.setTitle("组卷系统");
		   this.setSize(400,200);
		   setLocationRelativeTo(null);		//设置窗体在屏幕居中位置显示
		   
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
					 JOptionPane.showMessageDialog(null, "输入需要抽取的试题号！");
				}
				else
				{
					paperDao.deletePaper();
					paperDao.selectPaper(txtSelect.getText());
					new PaperTableFrm();
				}
				if(txtChoiceScore.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null, "输入选择题分值！");
				}
				else
				{
					ExchangeData.choicescore=Integer.parseInt(txtChoiceScore.getText());
				}
				if(txtTFScore.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null, "输入判断题分值！");
				}
				else
				{
					ExchangeData.TFscore=Integer.parseInt(txtTFScore.getText());
				}
				if(txtChoiceNum.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null, "输入选择题个数！");
				}
				else
				{
					ExchangeData.choicenum=Integer.parseInt(txtChoiceNum.getText());
				}
				if(txtTFNum.getText().equals(""))
				{
					 JOptionPane.showMessageDialog(null, "输入判断题个数！");
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
