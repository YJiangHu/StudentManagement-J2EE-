package com.management.dao;

import java.util.List;

import com.management.pojo.Student;

public interface StudentDao {
	
	// 1. 取得所有学生信息
	List<Student> getAllStudent();
	// 2. 根据学号查询学生信息
	Student getStudentById(Long id);
	// 3. 根据学号编辑学生信息
	int updateStudent(long id, Student student);
	// 4. 根据学号删除学生信息
	int deleteStudent(long id);
	// 5. 插入学生信息
	int insertStudent(Student student);
}
