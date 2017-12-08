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