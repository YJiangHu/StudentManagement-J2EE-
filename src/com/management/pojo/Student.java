package com.management.pojo;

public class Student {
	
	private long id; //ѧ��
	private String name; //����
	private String sex; //�Ա�
	private String clazz; //�༶
	private long phone; //�绰
	
	public Student() {}
	
	public Student(long id, String name, String sex, String clazz, long phone) {
		this.id = id;
		this.name = name;
		this.sex = sex;
		this.clazz = clazz;
		this.phone = phone;
	}
	
	/** ������Getter��Setter���� **/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", sex=" + sex + ", clazz=" + clazz + ", phone=" + phone + "]";
	}
	
	
}
