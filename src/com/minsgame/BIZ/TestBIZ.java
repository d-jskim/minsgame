package com.minsgame.BIZ;

import com.minsgame.DAO.TestDAO;
import com.minsgame.VO.Test;

import java.sql.Connection;
import static common.JDBCTemplate.*;

public class TestBIZ {
	
	public Test insertMember(Test test) {
		System.out.println("BIZ_insertMember\n");
		Connection conn = getConnection();		
		Test test_res = new TestDAO(conn).insertMember(test);
		return test_res;
	}

}
