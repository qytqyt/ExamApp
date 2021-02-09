package views;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dbutil.ExchangeData;
import javax.swing.*;
public class ResultFrm extends JFrame{
		   private JLabel lbltxt=new JLabel("���Խ�����",JLabel.CENTER);
		   private JLabel lblstuscore=new JLabel("�����ܳɼ���:"+ExchangeData.stuscore,JLabel.CENTER);
		   private JLabel lblscore=new JLabel("���Ծ���ܷ�Ϊ:"+ExchangeData.score,JLabel.CENTER);
		   private JLabel lblchoicescore=new JLabel("ѡ����÷�:"+ExchangeData.corr1*ExchangeData.choicescore,JLabel.CENTER);
		   private JLabel lblTFscore=new JLabel("�ж���÷�:"+ExchangeData.corr2*ExchangeData.TFscore,JLabel.CENTER);
		   private JButton btnOK=new JButton("ȷ�ϲ�����");
		   public ResultFrm() {
			   JPanel jp=(JPanel)this.getContentPane();
			   jp.setLayout(new GridLayout(6,1));
			   jp.add(lbltxt);
			   jp.add(lblstuscore);
			   jp.add(lblscore);
			   jp.add(lblchoicescore);
			   jp.add(lblTFscore);
			   jp.add(btnOK);
			   this.setTitle("�鿴���Խ��");
			   this.setSize(400,200);
			   setLocationRelativeTo(null);		//���ô�������Ļ����λ����ʾ
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
