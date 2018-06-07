package com.management.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import com.management.dao.StudentDao;
import com.management.pojo.Student;
import com.management.utils.JDBCUtil;

public class StudentDaoImpl implements StudentDao {

	@Override
	public List<Student> getAllStudent() {
		
		List<Student> list = new ArrayList<Student>();
		Connection con;
		String sql = "select * from student";
		PreparedStatement pstmt;
		try {
			con = JDBCUtil.getConnection();
			pstmt = (PreparedStatement)con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				long id = rs.getLong(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				String clazz = rs.getString(4);
				long phone = rs.getLong(5);
				Student student = new Student(id, name, sex, clazz, phone);
				list.add(student);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public Student getStudentById(Long id) {
		Connection con = null;
		String sql = "select * from student where Sno=?";
		PreparedStatement pstmt = null;
		Student student = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConnection();
			pstmt = (PreparedStatement)con.prepareStatement(sql);
			pstmt.setLong(1, id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				long no = rs.getLong(1);
				String name = rs.getString(2);
				String sex = rs.getString(3);
				String clazz = rs.getString(4);
				long phone = rs.getLong(5);
				student = new Student(no, name, sex, clazz, phone);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return student;
	}

	@Override
	public int updateStudent(long id, Student student) {
		Connection con = null;
		String sql = "update student set Sname=?,Ssex=?,Sclass=?,Sphone=? where Sno=?";
		PreparedStatement pstmt = null;
		int updateCon = 0;
		try {
			con = JDBCUtil.getConnection();
			pstmt = (PreparedStatement) con.prepareStatement(sql);
			pstmt.setString(1, student.getName());
			pstmt.setString(2, student.getSex());
			pstmt.setString(3, student.getClazz());
			pstmt.setLong(4, student.getPhone());
			pstmt.setLong(5, student.getId());
			updateCon = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return updateCon;
	}

	@Override
	public int deleteStudent(long id) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "delete from student where Sno=?";
		PreparedStatement pstmt = null;
		int deleteCon = 0;
		try {
			con = JDBCUtil.getConnection();
			pstmt = (PreparedStatement)con.prepareStatement(sql);
			pstmt.setLong(1, id);
			deleteCon = pstmt.executeUpdate();
		} catch(Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return deleteCon;
	}

	@Override
	public int insertStudent(Student student) {
		// TODO Auto-generated method stub
		Connection con = null;
		String sql = "insert into student values(?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int insertCon = 0;
		try {
			con = JDBCUtil.getConnection();
			pstmt = (PreparedStatement)con.prepareStatement(sql);
			pstmt.setLong(1, student.getId());
			pstmt.setString(2, student.getName());
			pstmt.setString(3, student.getSex());
			pstmt.setString(4, student.getClazz());
			pstmt.setLong(5, student.getPhone());
			insertCon = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(con != null && !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} 
			try {
				if(pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return insertCon;
	}

}
