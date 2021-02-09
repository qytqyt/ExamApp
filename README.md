# ExamApp
 &emsp;&emsp;Examination evaluation system based on C/S architecture
## 功能描述
 &emsp;&emsp;本考试评测系统，采用的主要技术是基于Swing的界面编程，编程语言采用的是JAVA语言，数据库以MySQL为平台，主要编程平台用Eclipse以及用JDBC连接数据库。<br/><br/>
 &emsp;&emsp;该系统分为用户登陆，信息管理系统，以及试卷批阅三个部分。
### 1、用户登陆：
 &emsp;&emsp;通过用户在登录界面选择的身份通过JDBC在数据库中查询账号密码是否匹配。若匹配，则进入相对应的学生、教师、管理员用户界面；若不匹配，则弹出提示框。<br/><br/>
### 2、信息管理系统：
 &emsp;&emsp;系统管理：用来管理用户的登陆，修改密码等功能。<br/><br/>
 &emsp;&emsp;基础数据维护：用来管理学生、教师、管理员等信息的增删改查操作。<br/><br/>
 &emsp;&emsp;题库管理：用来实现试题的增加、删除、修改、查找等操作，并出卷到试卷库中，最后传入学生端考试界面供学生答题。
### 3、试卷批阅：
 &emsp;&emsp;学生答题完成点击提交按钮，系统自动将学生答案与数据库中试题答案进行比较，并计算最终得分、正确率，最后导入学生成绩库中供教师与学生查看考试结果。
## 开发环境
 &emsp;&emsp;Eclipse<br/><br/>
 &emsp;&emsp;Java JDK 1.8<br/><br/>
 &emsp;&emsp;MySQL
