package common;

import java.sql.*;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class JDBCTemplate {

	public static Connection getConnection() {

		Connection con = null;
		Context initContext = null;
	
		try {
			//1. 환경설정을 초기화한다.
			initContext = new InitialContext();
			
			//2. 이름으로 맵핑된 was의 가상 디렉토리를 찾는다.
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			
			//3. 가상디렉토리 하위에 선언된 추가된 디렉토리를 찾는다.
			DataSource ds = (DataSource)envContext.lookup("jdbc/minsgame");
			
			//4. 연결한다.
		    con = ds.getConnection();
		    con.setAutoCommit(false);
		    
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	//연결한 상태를 close()하겠다.
	public static void Close(Connection con) {
		try {
			if(!con.isClosed() && con != null) {
				con.close();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Close(Statement stmt) {
		try {
			if(stmt != null) {
				stmt.close();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Close(ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void Commit(Connection con) {
		try {
			if(con != null && con.isClosed()) {
				con.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Rollback(Connection con) {
		try {
			if(con != null && !con.isClosed()) {
				con.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
