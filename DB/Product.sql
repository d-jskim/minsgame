--������ ���� 
DROP SEQUENCE prod_seq;

--������ ����
CREATE SEQUENCE prod_seq
	increment by 1
	start with 1;

--���̺� ����
DROP TABLE product;

--���̺� ����
CREATE TABLE product(
	prodNo number PRIMARY KEY,
	prodName varchar2(20),
	emptyDate date,
	memo varchar2(200),
	imgSrc varchar2(200)
);

--���� ������ ����
INSERT INTO product VALUES(prod_seq.nextval, 'cactus', sysdate, 'cactus_memo', './images/cactus.jpg');
INSERT INTO product VALUES(prod_seq.nextval, 'coffee', sysdate, 'coffee_memo', './images/coffee.jpg');
INSERT INTO product VALUES(prod_seq.nextval, 'flower', sysdate, 'flower_memo', './images/flower.jpg');
INSERT INTO product VALUES(prod_seq.nextval, 'pen', sysdate, 'pen_memo', './images/pen.jpg');
INSERT INTO product VALUES(prod_seq.nextval, 'whitepaper', sysdate, 'whitepaper_memo', './images/whitepaper.jpg');


/*PROCEDURE*/
CREATE OR REPLACE PROCEDURE getAllProduct(res out SYS_REFCURSOR)
IS
BEGIN
	OPEN res FOR SELECT * FROM product;
END;
/

