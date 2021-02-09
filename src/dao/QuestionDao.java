package dao;
import java.sql.*;
import dbutil.SQLHelper;
import entity.Question;
public class QuestionDao {
	  private String driver = "com.mysql.jdbc.Driver";
	  private String url = "jdbc:mysql://127.0.0.1:3306/examappdb";
	  private String dbuser = "root", dbpwd = "heiheihei1234";
	   public int addQ(String QID,String Question,String OptionA,String OptionB,String OptionC,String OptionD,String OptionT,String OptionF,String answer,String PaperID) {
		   int r=0;
		   String sql="insert into question values('"+QID+"','"+Question+"','"+OptionA+"','"+OptionB+"','"+OptionC+"','"+OptionD+"','"+OptionT+"','"+OptionF+"','"+answer+"','"+PaperID+"')";
		   r=SQLHelper.executeUpdate(sql);
		   return r;
	   }
	   public int addQ(Question question) {
		   int r=0;
		   String sql="insert into question values('+question.getId()','"+question.getQuestion()+"','"+question.getOptionA()+"','"+question.getOptionB()+"'),'"+question.getOptionC()+"'),'"+question.getOptionD()+"'),'"+question.getOptionT()+"'),'"+question.getOptionF()+"'),'"+question.getAnswer()+"'),'"+question.getPaperID()+"')";
		   r=SQLHelper.executeUpdate(sql);
		   return r;
	   }
	   public int alterQuestion(String QID,String Question,String OptionA,String OptionB,String OptionC,String OptionD,String OptionT,String OptionF,String answer,String PaperID) {
		   int r=0;
		   String sql="update question set Question='"+Question+"',OptionA='"+OptionA+"',OptionB='"+OptionB+"',OptionC='"+OptionC+"',OptionD='"+OptionD+"',OptionT='"+OptionT+"',OptionF='"+OptionF+"',answer='"+answer+"',PaperID='"+PaperID+"' where QID='"+QID+"'";
		   r=SQLHelper.executeUpdate(sql);
		   return r;
	   }
	   public int alterQuestion(Question question) {
		   int r=0;
		   String sql="update question set Question='"+question.getQuestion()+"','"+question.getOptionA()+"','"+question.getOptionB()+"','"+question.getOptionC()+"','"+question.getOptionD()+"','"+question.getOptionT()+"','"+question.getOptionF()+"','"+question.getAnswer()+"','"+question.getPaperID()+"'";
		   r=SQLHelper.executeUpdate(sql);
		   return r;
	   }
       private int queryCustomerCount() {
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
     public String[][] queryAllCustomers() {
       String[][] rows = new String[queryCustomerCount()][10];
       try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
         Statement cmd = conn.createStatement();
         String sql = "select * from question";
         ResultSet rs = cmd.executeQuery(sql);
         int count = 0;
         while (rs.next()) {
           String id = rs.getString(1);// 当前行第1列
           String question = rs.getString(2);
           String oa = rs.getString(3);
           String ob = rs.getString(4);
           String oc = rs.getString(5);
           String od = rs.getString(6);
           String ot = rs.getString(7);
           String of = rs.getString(8);
           String answer = rs.getString(9);
           String pid = rs.getString(10);
           rows[count][0] = id;
           rows[count][1] = question;
           rows[count][2] = oa;
           rows[count][3] = ob;
           rows[count][4] = oc;
           rows[count][5] = od;
           rows[count][6] = ot;
           rows[count][7] = of;
           rows[count][8] = answer;
           rows[count][9] = pid;
           count++;
         }
         conn.close();
       } catch (Exception ex) {
               ex.printStackTrace();
       }
       return rows;
     }
       public int deleteQuestionById(String id) {
         int r=0;
         try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
         Statement cmd = conn.createStatement();
         String sql="delete from question where QID='"+id+"'";
         r=cmd.executeUpdate(sql);
         conn.close();
       } catch (Exception ex) {
               ex.printStackTrace();
       }
         return r;
       }
}
