# MySQL

## ���
*MySQL* ��һ�������Ķ��û�,���߳�SQL���ݿ������.
*MySQL* ��һ���ͻ���/�������ṹ��ʵ��,����һ���������ػ�����mysqld�ͺܶ಻ͬ�Ŀͻ�����
�Ϳ����.*MySQL* ��windows�ϲ����ִ�Сд,Linux�ϱ������ִ�Сд
*MySQL* ��ҪĿ���ǿ���,��׳������
*MySQL* ���������ٶȺܿ�,����ʹ��,֧�ֲ�ѯ���,����û���ͬʱ���ӿͻ����ͷ�����,��������
�ڸ��ְ汾��UNIX�Լ���UNIX��ϵͳ�ϵ��ŵ�

***
### �������ݿ�
`create database if not exists test01;`
### ��ʾ���ݿ�
`show databases like 'test%';`
### ѡ�����ݿ�
`use test01;`
### ɾ�����ݿ�
`drop database if exists test01;`

***
### create�������ݿ��
`create table test01_01(
 name varchar(40),
 age int(5),
 address varchar(50)
);`

### select�������ݿ��
`create table test01_02 select * from test01_01;`

### ��ʾ���ݿ����Ϣ
`1. show tables [from db_name] [like wild]
2. show columns from tbl_name [from db_name] [like wild]
3. show index from tbl_name [from db_name]
4. show table status [from db_name] [like  wild]
5. {describe| desc} tbl_name {col_name | wild} `

### alter�޸ı�ṹ
#### ������
`alter table test01_01 add gender;`
#### �޸���
`alter table test01_01 modify weight varchar(50);`
#### ɾ����
`alter table test01_01 drop weight;`
#### ���и���
`alter table test01_01 change weight wei int;`
#### �������
`alter table test01_01 rename test01_04;`

### dropɾ�����ݿ��
`drop table if exists test01_04;`

###insert�������
`insert test01_01 values('jack','23','beijing'),
('gery','34,'ah')`
**������ʽinsert���ܲ������**
`insert test01_01 set name = 'sara';`

### insert...select�������
`insert into test01_02 select * from test01_01;`
`insert into test01_02(name)
select name from test01_01;`

### select��ѯ
*ѡ����Щ��*
`select selection_list`
*�Ӻδ�ѡ����*
`from table_list`
*�б�������ʲô����*
`where primary_constraint`
*�����Խ�����з���*
`group by grouping columns`
*�б�������ĵڶ�����*
`having secondary_constraint`
*�����Խ����������*
`order by sorting_columns`
*����޶�*
`limit count`
