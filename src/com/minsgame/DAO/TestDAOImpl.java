package com.minsgame.DAO;

public interface TestDAOImpl {
	String minsert = "insert into testTab values(?, ?)";
	String mlogin = "select * from testTab where userid = ? and password =?";
}
