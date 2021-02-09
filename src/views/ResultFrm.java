package views;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dbutil.ExchangeData;
import javax.swing.*;
public class ResultFrm extends JFrame{
		   private JLabel lbltxt=new JLabel("考试结束！",JLabel.CENTER);
		   private JLabel lblstuscore=new JLabel("您的总成绩是:"+ExchangeData.stuscore,JLabel.CENTER);
		   private JLabel lblscore=new JLabel("该试卷的总分为:"+ExchangeData.score,JLabel.CENTER);
		   private JLabel lblchoicescore=new JLabel("选择题得分:"+ExchangeData.corr1*ExchangeData.choicescore,JLabel.CENTER);
		   private JLabel lblTFscore=new JLabel("判断题得分:"+ExchangeData.corr2*ExchangeData.TFscore,JLabel.CENTER);
		   private JButton btnOK=new JButton("确认并返回");
		   public ResultFrm() {
			   JPanel jp=(JPanel)this.getContentPane();
			   jp.setLayout(new GridLayout(6,1));
			   jp.add(lbltxt);
			   jp.add(lblstuscore);
			   jp.add(lblscore);
			   jp.add(lblchoicescore);
			   jp.add(lblTFscore);
			   jp.add(btnOK);
			   this.setTitle("查看考试结果");
			   this.setSize(400,200);
			   setLocationRelativeTo(null);		//设置窗体在屏幕居中位置显示
			   this.setVisible(true);
				btnOK.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						btnOKClicked();
					}
				});
		   }
		   	public void btnOKClicked() {
	   			new LoginFrm();
	   			this.dispose();
	   	}
}
