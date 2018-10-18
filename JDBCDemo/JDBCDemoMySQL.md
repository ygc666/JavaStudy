### JDBCDemoMySQL

```sql
create database jdbc_demo_mysql;

use jdbc_demo_mysql;

create table user(
	id int primary key auto_increment,
    name varchar(20),
    age int
);

insert into user value(null,"张三",25);
insert into user value(null,"李四",20);
insert into user value(null,"小明",12);
insert into user value(null,"王五",45);
```





