package aplication;

import dao.StudentDAO;

public class Delete {

	public static void main(String[] args) {
		
		StudentDAO studentDao = new StudentDAO();

		studentDao.deleteById(4);
	}

}
