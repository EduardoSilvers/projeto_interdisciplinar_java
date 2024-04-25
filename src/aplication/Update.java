package aplication;

import dao.StudentDAO;
import model.Student;

public class Update {

	public static void main(String[] args) {
		
		StudentDAO studentDao = new StudentDAO();
		Student student = new Student();

		student.setName("Carlos Alberto");
		student.setRa("2019554687");
		student.setId(2);
		
		studentDao.update(student);
	}

}
