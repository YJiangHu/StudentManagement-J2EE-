package com.management.service;

import java.util.List;

import com.management.pojo.Student;

public interface StudentService {
	
	// 1. ȡ������ѧ����Ϣ
	List<Student> getAllStudent();
	// 2. ����ѧ�Ų�ѯѧ����Ϣ
	Student getStudentById(long id);
	// 3. ����ѧ�ű༭ѧ����Ϣ
	int updateStudent(long id, Student student);
	// 4. ����ѧ��ɾ��ѧ����Ϣ
	int deleteStudent(long id);
	// 5. ����ѧ����Ϣ
	int insertStudent(Student student);
}
