package com.minsgame.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static common.JDBCTemplate.*;

import com.minsgame.VO.Test;

public class TestDAO implements TestDAOImpl {
	
	Connection conn = null;

	public TestDAO(Connection con) {
		this.conn = con;
	}

	public Test insertMember(Test test) {
		System.out.println("DAO_insertMember");
		PreparedStatement pstmt = null;
		Test test_res = null;
		int res = 0;
		
		try {
			pstmt = conn.prepareStatement(minsert);
			System.out.println("hey1");
			pstmt.setString(1, test.getUserid());
			System.out.println("hey2");
			pstmt.setString(2, test.getPassword());
			System.out.println("hey3");
			res = pstmt.executeUpdate();
			System.out.println("hey4");
		} catch (Exception e) {
			Rollback(conn);
			e.printStackTrace();
		} finally {
			Commit(conn);
			System.out.println("commit check!");
		}
		
		if(res > 0) {
			System.out.println("res출력: " + res);
			test_res = loginMember(test.getUserid(), test.getPassword());
		}else {
			System.out.println("가입 X");
		}
		
		return test_res;
	}
	
	//insertMember에서 호출하고 Member 객체 리턴
	public Test loginMember(String userId, String password) {
		System.out.println("DAO_loginMember");
		 
		
		ResultSet rs = null;	
		Test test_res = null;
		
		try {
			pstmt = conn.prepareStatement(mlogin);
			System.out.println("hey5");
			pstmt.setString(1, userId);
			System.out.println("hey6");
			pstmt.setString(2, password);
			System.out.println("hey7");
			rs = pstmt.executeQuery();
			System.out.println("hey8");
			
			while(rs.next()) {
				test_res = new Test(rs.getString(1), rs.getString(2));				
			}
		} catch (Exception e) {
			System.out.println("DAO_loginMember err: " + e);
		}		
		System.out.println("Test obj from DB: " + test_res.toString());
		return test_res;
	}

}
