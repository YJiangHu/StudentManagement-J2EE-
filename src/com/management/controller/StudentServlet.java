package com.management.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.management.pojo.Student;
import com.management.service.StudentService;
import com.management.service.impl.StudentServiceImpl;
import com.management.utils.PageUtil;

public class StudentServlet extends HttpServlet {

	private static final long serialVersionUID = -8393706541110910L;
	
	private StudentService studentService;
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		String uri = request.getRequestURI();
		//����uri���ò�ͬ����
		if(uri.endsWith("/list")) {
			
			list(request, response);
		} else if(uri.endsWith("/updateForm")) {
			
			updateForm(request, response);
		} else if(uri.endsWith("/update")) {
			
			update(request, response);
		} else if(uri.endsWith("/delete")) {
			
			delete(request, response);
		} else if(uri.endsWith("/insert")) {
			
			insert(request, response);
		} else if(uri.endsWith("/getStudent")) {
			
			getStudent(request, response);
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		doGet(request, response);
	}
	
	/**
	 * ��ȡ����ѧ����Ϣ��������ҳ����Ϣ����ѧ����Ϣ�б��ҳ����Ϣת����list.jsp
	 */
	public void list(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		studentService = new StudentServiceImpl();
		List<Student> list = studentService.getAllStudent();	
		int page = 1;
		String pageParam = request.getParameter("page");	
		if(pageParam != null) {
			page = Integer.parseInt(pageParam);
		}
		int max = 5; //ÿҳ��¼��
		PageUtil pageUtil = new PageUtil(list, page, max);
		request.setAttribute("pageInfo", pageUtil);
		request.getRequestDispatcher("/jsp/list.jsp?page=" + page)
				.forward(request, response);
	}
	/**
	 * ����ѧ�Ų�ѯѧ����Ϣ
	 */
	public boolean getStudent(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		studentService = new StudentServiceImpl();
		String idParam = request.getParameter("id").replaceAll(" ", "").replaceAll("//+", "");
		long id = 1;
		try {
			id = Long.parseLong(idParam);
		} catch(Exception e) {
			request.setAttribute("msg", "ѧ�������ʽ����!");
			request.getRequestDispatcher("list")
				.forward(request, response);
			return false;
		}
		Student student = studentService.getStudentById(id);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/jsp/result.jsp")
				.forward(request, response);
		return true;
	}
	/**
	 * ����ѧ��ɾ��ѧ����Ϣ
	 */
	public void delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		studentService = new StudentServiceImpl();		
		long id = Long.parseLong(request.getParameter("id"));
		studentService.deleteStudent(id);
		response.sendRedirect("list");
	}
	/**
	 * ����һ���µ�ѧ����Ϣ
	 */
	public boolean insert(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		studentService = new StudentServiceImpl();
		request.setCharacterEncoding("utf-8");
		String idParam = request.getParameter("id").replaceAll(" ", "").replaceAll("//+", "");
		long id = 0;
		boolean error = false;
		try {
			id = Long.parseLong(idParam);
		} catch (Exception e) {
			request.setAttribute("idmsg", "ѧ�������ʽ����");
			error = true;
		}
		String name = request.getParameter("name").replaceAll(" ", "").replaceAll("//+", "");
		System.out.println(name);
		String sex = request.getParameter("sex");
		System.out.println(sex);
		String clazz = request.getParameter("clazz").replaceAll(" ", "").replaceAll("//+", "");
		System.out.println(clazz);
		String phoneParam = request.getParameter("phone").replaceAll(" ", "").replaceAll("//+", "");
		long phone = 0;
		try {
			phone = Long.parseLong(phoneParam);
		} catch (Exception e) {
			request.setAttribute("phonemsg", "�绰�����ʽ����");
			error = true;
		}
		if(error) {
			request.getRequestDispatcher("/jsp/insertForm.jsp")
				.forward(request, response);
			return false;
		}
		Student student = new Student(id, name, sex, clazz, phone);
		System.out.println(student);
		studentService.insertStudent(student);
		response.sendRedirect("list");
		return true;
	}
	/**
	 * ����ѧ��ȡ��ѧ����Ϣ����ת�������±����л���
	 */
	public void updateForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		studentService = new StudentServiceImpl();
		long id = Long.parseLong(request.getParameter("id"));
		Student student = studentService.getStudentById(id);
		request.setAttribute("student", student);
		request.getRequestDispatcher("/jsp/updateForm.jsp")
			.forward(request, response);
	}
	/**
	 * ����ѧ���޸�һ��ѧ����Ϣ
	 */
	public boolean update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		studentService = new StudentServiceImpl();
		request.setCharacterEncoding("utf-8");
		boolean error = false;
		long id = Long.parseLong(request.getParameter("id"));
		String name = request.getParameter("name").replaceAll(" ", "").replaceAll("//+", "");
		System.out.println(name);
		String sex = request.getParameter("sex");
		System.out.println(sex);
		String clazz = request.getParameter("clazz").replaceAll(" ", "").replaceAll("//+", "");
		System.out.println(clazz);
		String phoneParam = request.getParameter("phone").replaceAll(" ", "").replaceAll("//+", "");
		long phone = 0;
		try {
			phone = Long.parseLong(phoneParam);
		} catch (Exception e) {
			request.setAttribute("phonemsg", "�绰�����ʽ����");
			error = true;
		}
		if(error) {
			request.getRequestDispatcher("/jsp/insertForm.jsp")
				.forward(request, response);
			return false;
		}
		Student student = new Student(id, name, sex, clazz, phone);
		System.out.println(student);
		studentService.updateStudent(id, student);
		response.sendRedirect("list");
		return true;
	}
}
