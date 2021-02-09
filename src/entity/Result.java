package entity;
public class Result {
	private int stuscore,score,corr,allnum;
	private String stuid;
	public Result(int stuscore,int score,int corr,int allnum,String stuid) {
		super();
		this.stuid=stuid;
		this.stuscore=stuscore;
		this.score=score;
		this.corr=corr;
		this.allnum=allnum;
	}
	
	public int getStuscore() {
		return stuscore;
	}
	
	public void setStuscore(int stuscore) {
		this.stuscore = stuscore;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public int getCorr() {
		return corr;
	}
	
	public void setCorr(int corr) {
		this.corr = corr;
	}
	
	public int getAllnum() {
		return allnum;
	}
	
	public void setAllnum(int allnum) {
		this.allnum = allnum;
	}
	
	public String getStuid() {
		return stuid;
	}
	
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	
}