package com.management.service.impl;

import java.util.List;

import com.management.dao.StudentDao;
import com.management.dao.impl.StudentDaoImpl;
import com.management.pojo.Student;
import com.management.service.StudentService;

public class StudentServiceImpl implements StudentService {

	StudentDao studentDao;
	
	@Override
	public List<Student> getAllStudent() {
		
		studentDao = new StudentDaoImpl();
		return studentDao.getAllStudent();
	}

	@Override
	public Student getStudentById(long id) {

		studentDao = new StudentDaoImpl();
		return studentDao.getStudentById(id);
	}

	@Override
	public int updateStudent(long id, Student student) {

		studentDao = new StudentDaoImpl();
		return studentDao.updateStudent(id, student);
	}

	@Override
	public int deleteStudent(long id) {

		studentDao = new StudentDaoImpl();
		return studentDao.deleteStudent(id);
	}

	@Override
	public int insertStudent(Student student) {

		studentDao = new StudentDaoImpl();
		return studentDao.insertStudent(student);
	}
}
