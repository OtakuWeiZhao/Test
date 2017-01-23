# MySQL

## 简介
*MySQL* 是一个真正的多用户,多线程SQL数据库服务器.
*MySQL* 是一个客户机/服务器结构的实现,它由一个服务器守护程序mysqld和很多不同的客户程序
和库组成.*MySQL* 在windows上不区分大小写,Linux上表明区分大小写
*MySQL* 主要目标是快速,健壮和易用
*MySQL* 具有运行速度很快,容易使用,支持查询语句,多个用户可同时连接客户机和服务器,可以运行
在各种版本的UNIX以及非UNIX得系统上等优点

***
### 创建数据库
`create database if not exists test01;`
### 显示数据库
`show databases like 'test%';`
### 选用数据库
`use test01;`
### 删除数据库
`drop database if exists test01;`

***
### create创建数据库表
`create table test01_01(
 name varchar(40),
 age int(5),
 address varchar(50)
);`

### select创建数据库表
`create table test01_02 select * from test01_01;`

### 显示数据库表信息
`1. show tables [from db_name] [like wild]
2. show columns from tbl_name [from db_name] [like wild]
3. show index from tbl_name [from db_name]
4. show table status [from db_name] [like  wild]
5. {describe| desc} tbl_name {col_name | wild} `

### alter修改表结构
#### 增加列
`alter table test01_01 add gender;`
#### 修改列
`alter table test01_01 modify weight varchar(50);`
#### 删除列
`alter table test01_01 drop weight;`
#### 给列更名
`alter table test01_01 change weight wei int;`
#### 给表更名
`alter table test01_01 rename test01_04;`

### drop删除数据库表
`drop table if exists test01_04;`

###insert添加数据
`insert test01_01 values('jack','23','beijing'),
('gery','34,'ah')`
**这种形式insert不能插入多行**
`insert test01_01 set name = 'sara';`

### insert...select添加数据
`insert into test01_02 select * from test01_01;`
`insert into test01_02(name)
select name from test01_01;`

### select查询
*选择哪些行*
`select selection_list`
*从何处选择行*
`from table_list`
*行必须满足什么条件*
`where primary_constraint`
*怎样对结果进行分组*
`group by grouping columns`
*行必须满足的第二条件*
`having secondary_constraint`
*怎样对结果进行排序*
`order by sorting_columns`
*结果限定*
`limit count`
