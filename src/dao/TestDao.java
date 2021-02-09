package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import entity.Question;
public class TestDao {
	  private String driver = "com.mysql.jdbc.Driver";
	  private String url = "jdbc:mysql://127.0.0.1:3306/examappdb";
	  private String dbuser = "root", dbpwd = "heiheihei1234";
	    private int queryQuestionCount() {
	      int r=0;
	      try {
	      Class.forName(driver);
	      Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
	      Statement cmd = conn.createStatement();
	      String sql = "select count(*) from question";
	      ResultSet rs = cmd.executeQuery(sql);
	      if (rs.next()) {
	        r=rs.getInt(1);
	      }
	      conn.close();
	    } catch (Exception ex) {
	            ex.printStackTrace();
	    }
	      return r;
	    }
	  public Question[] queryAllQuestions() {
	    Question[] ques = new Question[queryQuestionCount()];
	    try {
	      Class.forName(driver);
	      Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
	      Statement cmd = conn.createStatement();
	      String sql = "select * from question";
	      ResultSet rs = cmd.executeQuery(sql);
	      int i=0;
	      while (rs.next()) {
	           String id = rs.getString(1);// 当前行第1列
	           String question = rs.getString(2);
	           String oa = rs.getString(3);
	           String ob = rs.getString(4);
	           String oc = rs.getString(5);
	           String od = rs.getString(6);
	           String ot = rs.getString(7);
	           String of = rs.getString(8);
			   Question q=new  Question();
			   q.setId(i+1);
			   q.setQuestion(question);
			   //q.setTitle("第"+(i+1)+"题目内容");
			   q.setOptionA(oa);
			   q.setOptionB(ob);
			   q.setOptionC(oc);
			   q.setOptionD(od);
			   q.setOptionT(ot);
			   q.setOptionF(of);
			   ques[i]=q;
			   i++;
	      }	      conn.close();
	    } catch (Exception ex) {
	            ex.printStackTrace();
	    }
	    return ques;
	  }
	  
}
