DROP TABLE TRANSACTIONS;
DROP TABLE PROPERTIES;
DROP TABLE CUSTOMERS;
DROP TABLE BROKERS;
DROP TABLE SECURITIES;

CREATE TABLE BROKERS (
	BROKER_ID VARCHAR(6),
	BROKER_PWD VARCHAR(20),
	BROKER_FN VARCHAR(30),
	BROKER_LN VARCHAR(30),
	CONSTRAINT BROKER_PK PRIMARY KEY (BROKER_ID)
	);

CREATE TABLE CUSTOMERS (
	CUSTOMER_ID VARCHAR(6),
	BROKER_ID VARCHAR(6),
	CUSTOMER_PWD VARCHAR(20),
	CUSTOMER_NAME VARCHAR(30),
	BALANCE DECIMAL(8,2),
	CONSTRAINT CUSTOMER_PK PRIMARY KEY (CUSTOMER_ID),
	CONSTRAINT CUSTOMER_FK FOREIGN KEY (BROKER_ID) REFERENCES BROKERS(BROKER_ID)
	);

CREATE TABLE SECURITIES(
	SECURITY_ID VARCHAR(6),
	SYMBOL VARCHAR(6),
	SECURITY_NAME VARCHAR(30),
	TYPE VARCHAR(20),
	PRICE DECIMAL(9,2),
	DIVIDEND BOOLEAN,
	RATING VARCHAR(10),
	HIGH DECIMAL(9,2),
	LOW DECIMAL(9,2),
	CONSTRAINT SECURITIES_PK PRIMARY KEY (SECURITY_ID, SECURITY_NAME, PRICE)
);


CREATE TABLE PROPERTIES(
	PROPERTY_ID VARCHAR(6),
	CUSTOMER_ID VARCHAR(6),
  SECURITY_ID VARCHAR(6),
	SECURITY_NAME VARCHAR(30),
	QUANTITY INTEGER,
  COST DECIMAL(9,2),
	CONSTRAINT PROPERTIES_PK PRIMARY KEY (PROPERTY_ID),
	CONSTRAINT PROPERTIES_FK FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID),
	CONSTRAINT PROPERTIES_FK2 FOREIGN KEY (SECURITY_ID, SECURITY_NAME, COST) REFERENCES SECURITIES(SECURITY_ID, SECURITY_NAME, PRICE)
	);


CREATE TABLE TRANSACTIONS(
	TRANSACTION_ID  INT NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
	SECURITY_ID VARCHAR(6),
  SECURITY_NAME VARCHAR(30),
	CUSTOMER_ID VARCHAR(6),
	BROKER_ID VARCHAR(6),
  TRANS_TYPE VARCHAR(4),
	TIMEDATE TIMESTAMP,
	AMOUNT INT,
	PASS_FAIL BOOLEAN,
	PURCHASE_PRICE DECIMAL(9,2),
	TOTAL_PRICE DECIMAL(9,2),
	CONSTRAINT TRANSACTIONS_PK PRIMARY KEY (TRANSACTION_ID),
	CONSTRAINT TRANSACTIONS_FK1 FOREIGN KEY (SECURITY_ID, SECURITY_NAME, PURCHASE_PRICE) REFERENCES SECURITIES(SECURITY_ID, SECURITY_NAME, PRICE),
	CONSTRAINT TRANSACTIONS_FK2 FOREIGN KEY (CUSTOMER_ID) REFERENCES CUSTOMERS(CUSTOMER_ID),
	CONSTRAINT TRANSACTIONS_FK3 FOREIGN KEY (BROKER_ID) REFERENCES BROKERS(BROKER_ID)
);


INSERT INTO SECURITIES VALUES('S11110', 'AAPL', 'Apple Inc', 'Stock', 243.43, true, 'Buy', 249.74, 142.0);
INSERT INTO SECURITIES VALUES('S11111', 'MSFT', 'Microsoft Corp.', 'Stock', 143.36, true, 'Buy', 145.67, 93.96);
INSERT INTO SECURITIES VALUES('S11112', 'GOOG', 'Alphabet Inc [Google] Class C', 'Stock', 1265.1, false, 'Buy', 1299.31, 970.11);
INSERT INTO SECURITIES VALUES('S11113', 'GOOGL', 'Alphabet Inc [Google] Class A', 'Stock', 1260.95, false, 'Buy', 1299.24, 977.66);
INSERT INTO SECURITIES VALUES('S11114', 'AMZN', 'Amazon Com Inc.', 'Stock', 1758.08, false, 'Sell', 2035.08, 1307.00);
INSERT INTO SECURITIES VALUES('S11115', 'FB', 'Facebook Inc.', 'Stock', 188.90, false, 'Strong Buy', 208.66, 125.02);
INSERT INTO SECURITIES VALUES('S11116', 'JPM', 'JPMorgan Chase & Co.', 'Stock', 126.91, true, 'Buy', 127.42, 91.11);
INSERT INTO SECURITIES VALUES('S11117', 'J&J', 'Johnsons & Johnson', 'Stock', 129.81, true, 'Sell', 148.99, 121.0);
INSERT INTO SECURITIES VALUES('S11118', 'V', 'Visa Inc.', 'Stock', 179.12, true, 'Buy', 187.05, 121.60);
INSERT INTO SECURITIES VALUES('S11119', 'WMT', 'Walmart Inc', 'Stock', 117.94, true, 'Sell', 120.71, 85.78);

INSERT INTO BROKERS VALUES('B12345', 'abcd', 'Bee', 'Mayes');
INSERT INTO BROKERS VALUES('B12346', 'efgh', 'Molly', 'Vonada');
INSERT INTO BROKERS VALUES('B12347', 'ijkl', 'Shaughn', 'Seepaul');
INSERT INTO BROKERS VALUES('B12348', 'mnop', 'Dre', 'Williams');

INSERT INTO CUSTOMERS VALUES('C12345', 'B12345', 'c12345', 'Patrick Henry', 1000.00);
INSERT INTO CUSTOMERS VALUES('C12346', 'B12346', 'c12346', 'Leonardo DiCaprio', 100000.00);
INSERT INTO CUSTOMERS VALUES('C12347', 'B12345', 'c12347', 'Derek Perkins', 50.00);
INSERT INTO CUSTOMERS VALUES('C12348', 'B12347', 'c12348', 'John Mullins', 9800.00);

INSERT INTO PROPERTIES VALUES('P00001', 'C12346', 'S11110', 'Apple Inc', 5, 243.43);
INSERT INTO PROPERTIES VALUES('P00002', 'C12348', 'S11115', 'Facebook Inc.', 3, 188.90);
INSERT INTO PROPERTIES VALUES('P00003', 'C12345', 'S11111', 'Microsoft Corp.', 2, 143.36);
INSERT INTO PROPERTIES VALUES('P00004', 'C12345', 'S11118', 'Visa Inc.', 1, 179.12);
INSERT INTO PROPERTIES VALUES('P00005', 'C12346', 'S11111', 'Microsoft Corp.', 4, 143.36);
INSERT INTO PROPERTIES VALUES('P00006', 'C12345', 'S11113', 'Alphabet Inc [Google] Class A', 3, 1260.95);
INSERT INTO PROPERTIES VALUES('P00007', 'C12345', 'S11119', 'Walmart Inc', 6, 117.94);
INSERT INTO PROPERTIES VALUES('P00008', 'C12346', 'S11117', 'Johnsons & Johnson', 4, 129.81);
INSERT INTO PROPERTIES VALUES('P00009', 'C12347', 'S11111', 'Microsoft Corp.', 1, 143.36);
INSERT INTO PROPERTIES VALUES('P00010', 'C12347', 'S11114', 'Amazon Com Inc.', 6, 1758.08);
INSERT INTO PROPERTIES VALUES('P00011', 'C12347', 'S11116', 'JPMorgan Chase & Co.', 4, 126.91);
INSERT INTO PROPERTIES VALUES('P00012', 'C12348', 'S11112', 'Alphabet Inc [Google] Class C', 6, 1265.1);
INSERT INTO PROPERTIES VALUES('P00013', 'C12348', 'S11112', 'Alphabet Inc [Google] Class C', 7, 1265.1);

INSERT INTO TRANSACTIONS(SECURITY_ID, CUSTOMER_ID, BROKER_ID, TRANS_TYPE, TIMEDATE, AMOUNT, PASS_FAIL, PURCHASE_PRICE, TOTAL_PRICE) VALUES('S11111', 'C12345', 'B12345', 'Sell', CURRENT_TIMESTAMP, 1, true, 141.21, 154.87);

COMMIT;
