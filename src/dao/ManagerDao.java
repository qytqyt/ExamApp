package dao;
import java.sql.*;
import dbutil.SQLHelper;
import entity.User;
public class ManagerDao {
	  private String driver = "com.mysql.jdbc.Driver";
	  private String url = "jdbc:mysql://127.0.0.1:3306/examappdb";
	  private String dbuser = "root", dbpwd = "heiheihei1234";
	  public boolean validateManage(String id,String pwd) {			//管理员表登录验证
		   boolean flag=false;
		   String sql="select upwd from managers where uid='"+id+"'";
		   ResultSet rs= SQLHelper.executeQuery(sql);
		   try {
			   if(rs!=null && rs.next()) {
				   String dbpwd=rs.getString(1);
				   if(dbpwd.equals(pwd)) {
					   flag=true;
				   }
			   }
			   SQLHelper.closeConnection();
		    } catch (Exception ex) {
				ex.printStackTrace();
			}
		   return flag;
	   }
	   public int addUser(String uid,String upwd,String name,String email,String needfindpwd) {
		   int r=0;
		   String sql="insert into managers values('"+uid+"','"+upwd+"','"+name+"','"+email+"','"+needfindpwd+"')";
		   r=SQLHelper.executeUpdate(sql);
		   return r;
	   }
	   public int addUser(User user) {
		   int r=0;
		   String sql="insert into managers values('"+user.getId()+"','"+user.getPwd()+"','"+user.getName()+"','"+user.getEmail()+"'),'"+user.getNeedfindpwd()+"')";
		   r=SQLHelper.executeUpdate(sql);
		   return r;
	   }
	   public int alterUser(String uid,String upwd,String name,String email,String needfindpwd) {
		   int r=0;
		   String sql="update managers set upwd='"+upwd+"',name='"+name+"',email='"+email+"',needfindpwd='"+needfindpwd+"'where uid='"+uid+"'";
		   r=SQLHelper.executeUpdate(sql);
		   return r;
	   }
	   public int alterUser(User user) {
		   int r=0;
		   String sql="update managers set upwd='"+user.getPwd()+"','"+user.getName()+"','"+user.getEmail()+"','"+user.getNeedfindpwd()+"'";
		   r=SQLHelper.executeUpdate(sql);
		   return r;
	   }
       private int queryCustomerCount() {
         int r=0;
         try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
         Statement cmd = conn.createStatement();
         String sql = "select count(*) from managers";
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
         String sql = "select * from managers";
         ResultSet rs = cmd.executeQuery(sql);
         int count = 0;
         while (rs.next()) {
           String id = rs.getString(1);// 当前行第1列
           String password = rs.getString(2);
           String name = rs.getString(3);
           String email = rs.getString(4);
           String needfindpwd = rs.getString(5);
           rows[count][0] = id;
           rows[count][1] = password;
           rows[count][2] = name;
           rows[count][3] = email;
           rows[count][4] = needfindpwd;
           count++;
         }
         conn.close();
       } catch (Exception ex) {
               ex.printStackTrace();
       }
       return rows;
     }
       public int deleteCustomerById(String id) {
         int r=0;
         try {
         Class.forName(driver);
         Connection conn = DriverManager.getConnection(url, dbuser, dbpwd);
         Statement cmd = conn.createStatement();
         String sql="delete from managers where uid='"+id+"'";
         r=cmd.executeUpdate(sql);
         conn.close();
       } catch (Exception ex) {
               ex.printStackTrace();
       }
         return r;
       }
}
