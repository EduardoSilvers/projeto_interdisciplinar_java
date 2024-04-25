package aplication;

import dao.StudentDAO;
import model.Student;

public class Select {
	
	public static void main(String[] args){
		
		StudentDAO studentDAO = new StudentDAO();
		
		for(Student s : studentDAO.getStudent()) {
			System.out.println("Aluno: "+s.getName());
		}
	}
}
