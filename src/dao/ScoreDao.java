package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import dbutil.ExchangeData;
import dbutil.SQLHelper;
import entity.Result;
public class ScoreDao {
	  private String driver = "com.mysql.jdbc.Driver";
	  private String url = "jdbc:mysql://127.0.0.1:3306/examappdb";
	  private String dbuser = "root", dbpwd = "heiheihei1234";
	   public int addResult(int stuscore,int score,int corr,int allnum,String stuid) {
		   int r=0;
		   String sql="insert into aspaper values('"+stuscore+"','"+score+"','"+corr+"','"+allnum+"','"+stuid+"')";
		   r=SQLHelper.executeUpdate(sql);
		   return r;
	   }
	   public int addResult(Result result) {
		   int r=0;
		   String sql="insert into aspaper values('"+result.getStuscore()+"','"+result.getScore()+"','"+result.getCorr()+"','"+result.getAllnum()+"'),'"+result.getStuid()+"')";
		   r=SQLHelper.executeUpdate(sql);
		   return r;
	   }
     private int queryCustomerCount() {
       int r=0;
       try {
       Class.forName(driver);
       Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
       Statement cmd = conn.createStatement();
       String sql = "select count(*) from aspaper";
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
     private int queryStuScoreCount() {
         int r=0;
         try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
         Statement cmd = conn.createStatement();
         String sql = "select count(*) from aspaper where stuid IN ('"+ExchangeData.sid+"');";
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
     private int queryStuScoreCount1() {
         int r=0;
         try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
         Statement cmd = conn.createStatement();
         String sql = "select count(*) from aspaper;";
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
     String[][] rows = new String[queryCustomerCount()][5];
     try {
       Class.forName(driver);
       Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
       Statement cmd = conn.createStatement();
       String sql = "select * from aspaper where stuid IN ('"+ExchangeData.sid+"');";
       ResultSet rs = cmd.executeQuery(sql);
       int count = 0;
       while (rs.next()) {
         String stuscore = rs.getString(1);// 当前行第1列
         String score = rs.getString(2);
         String corr = rs.getString(3);
         String allnum = rs.getString(4);
         String stuid = rs.getString(5);
         rows[count][0] = stuscore;
         rows[count][1] = score;
         rows[count][2] = corr;
         rows[count][3] = allnum;
         rows[count][4] = stuid;
         count++;
       }
       conn.close();
     } catch (Exception ex) {
             ex.printStackTrace();
     }
     return rows;
   }   public String[][] queryAllCustomers1() {
	     String[][] rows = new String[queryCustomerCount()][5];
	     try {
	       Class.forName(driver);
	       Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
	       Statement cmd = conn.createStatement();
	       String sql = "select * from aspaper;";
	       ResultSet rs = cmd.executeQuery(sql);
	       int count = 0;
	       while (rs.next()) {
	         String stuscore = rs.getString(1);// 当前行第1列
	         String score = rs.getString(2);
	         String corr = rs.getString(3);
	         String allnum = rs.getString(4);
	         String stuid = rs.getString(5);
	         rows[count][0] = stuscore;
	         rows[count][1] = score;
	         rows[count][2] = corr;
	         rows[count][3] = allnum;
	         rows[count][4] = stuid;
	         count++;
	       }
	       conn.close();
	     } catch (Exception ex) {
	             ex.printStackTrace();
	     }
	     return rows;
	   }
   public String[][] queryAllStuScore() {
	     String[][] rows = new String[queryCustomerCount()][5];
	     try {
	       Class.forName(driver);
	       Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
	       Statement cmd = conn.createStatement();
	       String sql = "select * from aspaper";
	       ResultSet rs = cmd.executeQuery(sql);
	       int count = 0;
	       while (rs.next()) {
	         String stuscore = rs.getString(1);// 当前行第1列
	         String score = rs.getString(2);
	         String corr = rs.getString(3);
	         String allnum = rs.getString(4);
	         String stuid = rs.getString(5);
	         rows[count][0] = stuscore;
	         rows[count][1] = score;
	         rows[count][2] = corr;
	         rows[count][3] = allnum;
	         rows[count][4] = stuid;
	         count++;
	       }
	       conn.close();
	     } catch (Exception ex) {
	             ex.printStackTrace();
	     }
	     return rows;
	   }
}
