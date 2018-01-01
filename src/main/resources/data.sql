--users
insert into user_bean values(10001, sysdate-1, 'Jack');
insert into user_bean values(10002, sysdate-10, 'Jill');
insert into user_bean values(10003, sysdate-100, 'Adam');
insert into user_bean values(10004, sysdate-1000, 'Eve');
insert into user_bean values(10005, sysdate-10000, 'John');
--posts
insert into user_posts_bean values(11001,'My first post', '10001');
insert into user_posts_bean values(11002,'My second post', '10001');
insert into user_posts_bean values(11003,'My first post', '10005');

CREATE TABLE CN_PRODUCT_BEAN (PRODUCT_KEY INTEGER NOT NULL, COST_CURRENCY VARCHAR2(32 BYTE[*]) NOT NULL, CREATED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL, CREATED_USER_ID VARCHAR2(64 BYTE) NOT NULL, HAS_INFINITE_INVENTORY CHAR(1 BYTE) NOT NULL, IS_HAZMAT CHAR(1 BYTE) NOT NULL, IS_PERISHABLE CHAR(1 BYTE) NOT NULL, IS_RETURNABLE CHAR(1 BYTE) NOT NULL, IS_TAXABLE CHAR(1 BYTE) NOT NULL, MODIFIED_DATE TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL, MODIFIED_USER_ID VARCHAR2(64 BYTE) NOT NULL, ORGANIZATION_CODE VARCHAR2(32 BYTE) NOT NULL, PRODUCT_DESCRIPTION VARCHAR2(512 BYTE) NOT NULL, PRODUCT_ID CHAR(64 BYTE) NOT NULL, PRODUCT_NAME VARCHAR2(128 BYTE) NOT NULL, PRODUCT_STATUS CHAR(16 BYTE) NOT NULL, RETURN_PERIOD NUMBER(5,0) NOT NULL, TAX_PRODUCT_CODE VARCHAR2(64 BYTE) NOT NULL, UNIT_COST DECIMAL(7,2) NOT NULL, UNIT_OF_MEASURE VARCHAR2(32 BYTE) NOT NULL, PRIMARY KEY (PRODUCT_KEY)) "; expected "K, M, G, CHAR, )"; SQL statement:
create table cn_product_bean (product_key integer not null, cost_currency VARCHAR2(32 BYTE) not null, created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null, created_user_id VARCHAR2(64 BYTE) not null, has_infinite_inventory CHAR(1 BYTE) not null, is_hazmat CHAR(1 BYTE) not null, is_perishable CHAR(1 BYTE) not null, is_returnable CHAR(1 BYTE) not null, is_taxable CHAR(1 BYTE) not null, modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP not null, modified_user_id VARCHAR2(64 BYTE) not null, organization_code VARCHAR2(32 BYTE) not null, product_description VARCHAR2(512 BYTE) not null, product_id CHAR(64 BYTE) not null, product_name VARCHAR2(128 BYTE) not null, product_status CHAR(16 BYTE) not null, return_period NUMBER(5,0) not null, tax_product_code VARCHAR2(64 BYTE) not null, unit_cost DECIMAL(7,2) not null, unit_of_measure VARCHAR2(32 BYTE) not null, primary key (product_key)) [42001-196]
	