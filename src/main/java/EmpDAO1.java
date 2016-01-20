
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
    
	
public class EmpDAO1 {
	Connection conn=null;
	Statement state=null;
	ResultSet rs=null;
	
		public static void main(String[] args){
		  EmpDAO1 dao=new EmpDAO1();
		  dao.findAll();
		}
	   public void findAll(){
	     
		 try {
			 String url = "jdbc:oracle:thin:@(DESCRIPTION=(LOAD_BALANCE=YES)(FAILOVER=ON)(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST="
					+ "10.150.51.33"
					+ ")(PORT="
					+ "1526"
					+ ")))(CONNECT_DATA=(SERVER=DEDICATED)(SERVICE_NAME="
					+ "hisdb"
					+ ")))";
			 
		    Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@10.150.51.33:1526:hisdb","gdyc","gdyc");
//			conn = DriverManager.getConnection(url, "gdyc","gdyc");
			state = conn.createStatement();
			rs = state.executeQuery("SELECT B.TIMESTAMP,B.VALUE FROM FD B WHERE B.KEY_NUM = (SELECT A.KEY_NUM FROM REGISTAB A WHERE A.ID_SUBSTN = '电话报数' AND A.EXTID = '茂名厂GPW') AND TO_CHAR(B.TIMESTAMP,'YYYY-MM-DD') = TO_CHAR(SYSDATE,'YYYY-MM-DD') ");
			while (rs.next()){
			   System.out.println(rs.getString("value"));
			   
			   
			}
		 }catch(ClassNotFoundException e){
		    System.out.println("驱动类无法找到");
			throw new RuntimeException(e);
		 }catch (SQLException e){
		    System.out.println("数据库访问异常");
			throw new RuntimeException(e);
		 }finally{
		    try{
			  if(rs !=null){
			    rs.close();
			  }
			  if(state !=null){
			    state.close();
			  }
			  if(conn !=null){
			    conn.close();
			  }
			}catch(SQLException e){
			  System.out.println("关闭连接时发生异常");
			}
		 }
	   }
	}
