-- 给定一个数据库表student_score, 字段定义为：学生id（int）,学生姓名（String）,考试科目（String）,考试成绩（int）,所属学期（String）
-- 其中,科目的取值范围为：数学,英语,语文
-- 写一个sql,找到所有一年级的小朋友当中,过去两个学期（一年级上学期、一年级下学期）当中,
-- 所有单科成绩都大于90分,且每学期总成绩大于280分的学生

SELECT name, sum(score) scoreSum FROM student_score WHERE term in ( '一年级上学期','一年级下学期')
and name in (select name from (SELECT name,count(1) count  FROM student_score WHERE
term in( '一年级上学期','一年级下学期') and score > 90
group by name having count =6) a )  group by term having scoreSum > 280