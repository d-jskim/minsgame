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
			//1. ȯ�漳���� �ʱ�ȭ�Ѵ�.
			initContext = new InitialContext();
			
			//2. �̸����� ���ε� was�� ���� ���丮�� ã�´�.
			Context envContext  = (Context)initContext.lookup("java:/comp/env");
			
			//3. ������丮 ������ ����� �߰��� ���丮�� ã�´�.
			DataSource ds = (DataSource)envContext.lookup("jdbc/minsgame");
			
			//4. �����Ѵ�.
		    con = ds.getConnection();
		    con.setAutoCommit(false);
		    
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	//������ ���¸� close()�ϰڴ�.
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
