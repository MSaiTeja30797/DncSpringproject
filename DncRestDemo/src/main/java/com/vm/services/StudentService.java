package com.vm.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;



import com.vm.entity.Student;
@Service
public class StudentService {
	List<Student> students = new ArrayList<Student>();
	List<Student> createStudent(){
		students.add(new Student(1, "sai", 8, 7));
		students.add(new Student(2, "teja", 8, 8));
		students.add(new Student(3, "maturi", 8, 7));
		students.add(new Student(4, "ashok", 8, 8));
		return students;
	}
	public List<Student> getStudents(){
		createStudent();//replace this with call to database...
		return students;
	}
	public Student getStudentId(int id) {
		Student student=  students.stream().filter(s -> s.getId() == id ).findFirst().get();
		return student;
	}
	public void addStudent(Student student) {
		System.out.println("controllers add student");
		students.add(student);
	}
	public void updateStudent(Student student, int id) {
		for(int i = 0; i< students.size(); i++) {
			Student s = students.get(0);
			if(s.getId() == id) {
				students.set(id, student);
				return;
			}
		}
	}
	public void removeStudent(int id) {
		students.removeIf(s -> s.getId() == id);
	}


}