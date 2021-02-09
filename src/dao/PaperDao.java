package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import dbutil.ExchangeData;
import dbutil.SQLHelper;
import entity.Question;
public class PaperDao {
	  private String driver = "com.mysql.jdbc.Driver";
	  private String url = "jdbc:mysql://127.0.0.1:3306/examappdb";
	  private String dbuser = "root", dbpwd = "heiheihei1234";
	   public void correctPaper(int i) {
		   try {
	       Class.forName(driver);
	       Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);//�������ݿ����ӣ�������Ӷ���conn
	       Statement cmd = conn.createStatement();//����һ��Statement����
		   String sql="select answer from paper where PID='"+i+"';";
	       ResultSet rs = cmd.executeQuery(sql);//ִ�в�ѯ���Ѳ�ѯ�����ֵ�����������
	       while(rs.next()) {	//���������
	    	   ExchangeData.aws=rs.getString(1);
	       }
	       conn.close();
	       }catch (Exception ex) {
	        	 ex.printStackTrace();
	   }
}
	   public int deletePaper() {
		   int r=0;
		   String sql="delete from paper";
		   r=SQLHelper.executeUpdate(sql);
		   return r;
	   }
	   public int selectPaper(String i) {
		   int r=0;
		   String sql="insert into paper(PID,Question,OptionA,OptionB,OptionC,OptionD,OptionT,OptionF,answer) SELECT QID,Question,OptionA,OptionB,OptionC,OptionD,OptionT,OptionF,answer from question where PaperID IN ('"+i+"')";
		   r=SQLHelper.executeUpdate(sql);
		   return r;
	   }
       private int queryCustomerCount() {
         int r=0;
         try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
         Statement cmd = conn.createStatement();
         String sql = "select count(*) from paper";
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
       String[][] rows = new String[queryCustomerCount()][9];
       try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
         Statement cmd = conn.createStatement();
         String sql = "select * from paper";
         ResultSet rs = cmd.executeQuery(sql);
         int count = 0;
         while (rs.next()) {
           String id = rs.getString(1);// ��ǰ�е�1��
           String question = rs.getString(2);
           String oa = rs.getString(3);
           String ob = rs.getString(4);
           String oc = rs.getString(5);
           String od = rs.getString(6);
           String ot = rs.getString(7);
           String of = rs.getString(8);
           String answer = rs.getString(9);
           
           rows[count][0] = id;
           rows[count][1] = question;
           rows[count][2] = oa;
           rows[count][3] = ob;
           rows[count][4] = oc;
           rows[count][5] = od;
           rows[count][6] = ot;
           rows[count][7] = of;
           rows[count][8] = answer;
           count++;
         }
         conn.close();
       } catch (Exception ex) {
               ex.printStackTrace();
       }
       return rows;
     }
	    private int queryQuestionCount() {
	      int r=0;
	      try {
	      Class.forName(driver);
	      Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
	      Statement cmd = conn.createStatement();
	      String sql = "select count(*) from paper";
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
	      String sql = "select * from paper";
	      ResultSet rs = cmd.executeQuery(sql);
	      int i=0;
	      while (rs.next()) {
	           String id = rs.getString(1);// ��ǰ�е�1��
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
			   //q.setTitle("��"+(i+1)+"��Ŀ����");
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