--시퀀스 삭제
DROP SEQUENCE member_seq;

--시퀀스 생성
CREATE SEQUENCE member_seq
	increment by 1
	start with 1;

--테이블 삭제
DROP TABLE member;

--테이블 생성
CREATE TABLE member(
	userId number PRIMARY KEY,
	email varchar2(30) UNIQUE NOT NULL,
	username varchar2(20) NOT NULL,
	password varchar2(20) NOT NULL,
	regDate date
);

INSERT INTO member VALUES(member_seq.nextVal, 'min@minsgame.com', 'min', 'min', sysdate);

Select * from member;