package entity;
public class Question {
	private int id;
	private String Question,OptionA,OptionB,OptionC,OptionD,OptionT,OptionF,answer,PaperID;
	public Question() {
		
	}
	public Question(int id,String Question,String OptionA,String OptionB,String OptionC,String OptionD,String OptionT,String OptionF,String answer,String PaperID) {
		super();
		this.id = id;
		this.Question = Question;
		this.OptionA = OptionA;
		this.OptionB = OptionB;
		this.OptionC = OptionC;
		this.OptionD = OptionD;
		this.OptionT = OptionT;
		this.OptionF = OptionF;
		this.answer=answer;
		this.PaperID=PaperID;
	}
	
	public String getPaperID() {
		return PaperID;
	}
	
	public void setPaperID(String paperID) {
		PaperID = paperID;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getQuestion() {
		return Question;
	}
	
	public void setQuestion(String question) {
		Question = question;
	}
	
	public String getOptionA() {
		return OptionA;
	}
	
	public void setOptionA(String optionA) {
		OptionA = optionA;
	}
	
	public String getOptionB() {
		return OptionB;
	}
	
	public void setOptionB(String optionB) {
		OptionB = optionB;
	}
	
	public String getOptionC() {
		return OptionC;
	}
	
	public void setOptionC(String optionC) {
		OptionC = optionC;
	}
	
	public String getOptionD() {
		return OptionD;
	}
	
	public void setOptionD(String optionD) {
		OptionD = optionD;
	}
	
	public String getOptionT() {
		return OptionT;
	}
	
	public void setOptionT(String optionT) {
		OptionT = optionT;
	}
	
	public String getOptionF() {
		return OptionF;
	}
	
	public void setOptionF(String optionF) {
		OptionF = optionF;
	}

}
