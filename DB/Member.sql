--������ ����
DROP SEQUENCE member_seq;

--������ ����
CREATE SEQUENCE member_seq
	increment by 1
	start with 1;

--���̺� ����
DROP TABLE member;

--���̺� ����
CREATE TABLE member(
	userId number PRIMARY KEY,
	email varchar2(30) UNIQUE NOT NULL,
	username varchar2(20) NOT NULL,
	password varchar2(20) NOT NULL,
	regDate date
);

INSERT INTO member VALUES(member_seq.nextVal, 'min@minsgame.com', 'min', 'min', sysdate);

Select * from member;