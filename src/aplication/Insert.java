package aplication;

import model.Student;
import dao.StudentDAO;

public class Insert {

	public static void main(String[] args) {
		
		StudentDAO studentDAO = new StudentDAO();
		Student student = new Student();
		
		student.setName("Gustavo");
		student.setRa("2023158246");
		
		
		
		studentDAO.save(student);
	}

}
