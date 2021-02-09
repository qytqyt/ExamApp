package views;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import entity.Question;
import dao.PaperDao;
import dao.ScoreDao;
import dbutil.ExchangeData;
public class StudentTestFrm extends JInternalFrame implements ActionListener{
	private PaperDao paperDao=new PaperDao();
	private ScoreDao scoreDao=new ScoreDao();
	private Question[] ques=paperDao.queryAllQuestions();
	private String[] answers=new String[ques.length];
	private JButton[] btnQues=null;
	private JButton btnNext=new JButton("��һ��");
	private JButton btnSubmit=new JButton("�ύ");
	private JRadioButton radioQa =new JRadioButton("A");
	private JRadioButton radioQb =new JRadioButton("B");
	private JRadioButton radioQc =new JRadioButton("C");
	private JRadioButton radioQd =new JRadioButton("D");
	private JRadioButton radioQt =new JRadioButton("T");
	private JRadioButton radioQf =new JRadioButton("F");
	private JTextArea txtQuestion=new JTextArea(8,20);
	private int curQuestionId=0;
	ButtonGroup bg=new ButtonGroup();
    private void setQuestion(int qid){
    	txtQuestion.setText("��"+(qid+1)+"��: "+ques[qid].getQuestion()+"\r\n\r\n"+
                             "  A."+ques[qid].getOptionA()+"\r\n"+
                             "  B."+ques[qid].getOptionB()+"\r\n"+
                             "  C."+ques[qid].getOptionC()+"\r\n"+
                             "  D."+ques[qid].getOptionD()+"\r\n"+
                             "  T.�ж���ȷ\r\n"+
                             "  F.�жϴ���");
    }
    private void  btnNext_Clicked(){
    	bg.clearSelection();
    	curQuestionId++;
    	if(curQuestionId>=ques.length-1){
    		JOptionPane.showMessageDialog(this, "�Ѿ������һ����!");
    		curQuestionId=ques.length-1;
    	}
    	
    	setQuestion(curQuestionId);
    }
    private void btnSubmit_Clicked() {
    	for(int i=0;i<answers.length;i++) {
    		paperDao.correctPaper(i+1);
    		if(ExchangeData.aws.equals(answers[i])&&(answers[i]=="A"||answers[i]=="B"||answers[i]=="C"||answers[i]=="D")){
    			ExchangeData.corr1++;
    		}
    		if(ExchangeData.aws.equals(answers[i])&&(answers[i]=="T"||answers[i]=="F")) {
    			ExchangeData.corr2++;
    		}
    	}
    	ExchangeData.allnum=ExchangeData.choicenum+ExchangeData.TFnum;		//�Ծ�������
    	ExchangeData.corr=ExchangeData.corr1+ExchangeData.corr2;			//�Ծ���ȷ����
    	ExchangeData.stuscore=ExchangeData.choicescore*ExchangeData.corr1+ExchangeData.TFscore*ExchangeData.corr2; //��ǰ���ķ���
    	ExchangeData.score=ExchangeData.choicescore*ExchangeData.choicenum+ExchangeData.TFscore*ExchangeData.TFnum;//�Ծ��ܷ�
    	if(scoreDao.addResult(ExchangeData.stuscore, ExchangeData.score, ExchangeData.corr, ExchangeData.allnum, ExchangeData.sid)>0) {
			  JOptionPane.showMessageDialog(this, "�ɼ����ϴ�!");
		  }else {
			  JOptionPane.showMessageDialog(this, "�ɼ��ϴ�ʧ��!");
		  }
    	new ResultFrm();
    }
    private void  btnQues_Clicked(ActionEvent e){
    	JButton btn=(JButton)e.getSource();
    	bg.clearSelection();
    	int qid=new Integer(btn.getText().trim());
    	curQuestionId=qid-1;
    	setQuestion(curQuestionId);
    }
	public StudentTestFrm() {
		super("2018-2019�ڶ�ѧ����ĩ����",true,true,true,true);
		JPanel jp = (JPanel) this.getContentPane();
		
		/*radio����*/
		
		bg.add(radioQa);bg.add(radioQb);bg.add(radioQc);bg.add(radioQd);bg.add(radioQt);bg.add(radioQf);
		radioQa.addActionListener(this);
		radioQb.addActionListener(this);
		radioQc.addActionListener(this);
		radioQd.addActionListener(this);
		radioQt.addActionListener(this);
		radioQf.addActionListener(this);
		txtQuestion.setFont(new Font("΢���ź�",Font.BOLD,17));
		
		JPanel jpRight_1=new JPanel();//������Ŀ��ѡ��
		jpRight_1.setLayout(new BorderLayout());
		jpRight_1.add(txtQuestion);
		JPanel jpRight_1Bottom=new JPanel();
		jpRight_1Bottom.add(radioQa);jpRight_1Bottom.add(radioQb);
		jpRight_1Bottom.add(radioQc);jpRight_1Bottom.add(radioQd);
		jpRight_1Bottom.add(radioQt);jpRight_1Bottom.add(radioQf);
		jpRight_1.add(jpRight_1Bottom,BorderLayout.SOUTH);
		
		JPanel jpRight_2=new JPanel();
		jpRight_2.setLayout(new BorderLayout());
		JPanel jpQuestion=new JPanel();
		jpQuestion.setLayout(new GridLayout(ques.length%5==0?ques.length/5:ques.length/5+1,5));
		
		btnQues=new JButton[ques.length];
		for(int i=0;i<ques.length;i++){
			btnQues[i]=new JButton((i+1)+"");
			jpQuestion.add(btnQues[i]);
			btnQues[i].addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					btnQues_Clicked(e);
				}
			});
		}
		btnNext.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				btnNext_Clicked();
			}
		});
		btnSubmit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				btnSubmit_Clicked();
			}
		});
		jpRight_2.add(jpQuestion);
		
		JPanel jpRightBottom=new JPanel();
		jpRightBottom.add(btnNext);jpRightBottom.add(btnSubmit);
		jpRight_2.add(jpRightBottom,BorderLayout.SOUTH);
		
		JSplitPane splitPane=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,jpRight_1,jpRight_2);
		splitPane.setDividerLocation(500);
		splitPane.setDividerSize(1);
		
		jp.add(splitPane);
		
    }

	
	public void actionPerformed(ActionEvent e) {
		/*��RadioButton���ʱ�����¼��������*/
		
		if(e.getSource()==radioQa){
			if(radioQa.isSelected()){
				answers[curQuestionId]="A";
			}
		}else if(e.getSource()==radioQb){
			if(radioQb.isSelected()){
				answers[curQuestionId]="B";
			}
		}else if(e.getSource()==radioQc){
			if(radioQc.isSelected()){
				answers[curQuestionId]="C";
			}
		}else if(e.getSource()==radioQd){
			if(radioQd.isSelected()){
				answers[curQuestionId]="D";
			}
		}else if(e.getSource()==radioQt){
			if(radioQt.isSelected()){
				answers[curQuestionId]="T";
			}
		}else if(e.getSource()==radioQf){
			if(radioQf.isSelected()){
				answers[curQuestionId]="F";
			}
		}
		btnQues[curQuestionId].setBackground(Color.GRAY);
	}
	
}