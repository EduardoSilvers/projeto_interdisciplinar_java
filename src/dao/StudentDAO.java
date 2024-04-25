package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import factory.ConnectionFactory;
import model.Student;

public class StudentDAO {

	public void save(Student student) {
		
		String sql = "INSERT INTO student(name,ra) VALUES(?,?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//CRIAR CONEXAO COM DB
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, student.getName());
			pstm.setString(2,student.getRa());
			
			//EXECUTAR A QUERRY
			pstm.execute();
			
			//FECHAR AS CONEXOES
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm!=null) {
					pstm.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public void update(Student student) {
		
		String sql = "UPDATE student SET name = ?, ra = ? WHERE idstudent = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			//criar conexao com o banco 
			conn = ConnectionFactory.createConnectionToMySQL();
			//criar classe para executar a querry
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			//adicionar valores para atualizar
			pstm.setString(1, student.getName());
			pstm.setString(2, student.getRa());
			
			//id do registro para atualizar
			pstm.setInt(3, student.getId());
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try { 
				if(pstm!=null) {
					pstm.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	public void deleteById(int id) {
		
		String sql = "DELETE FROM student WHERE idstudent = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try { 
			
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, id);
			
			pstm.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				if(pstm!=null) {
					pstm.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public List<Student> getStudent() {
		String sql = "SELECT * FROM student";
		
		List<Student> student = new ArrayList<Student>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		//RECUPERA DADOS DO BANCO
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while(rset.next()) {
				
				Student students = new Student();
				//PEGAR ID
				students.setId(rset.getInt("idstudent"));
				//PEGAR NOME
				students.setName(rset.getString("name"));
				//PEGAR RA
				students.setRa(rset.getString("ra"));
				
				student.add(students);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				
				if(pstm!=null) {
					pstm.close();
				}
				
				if(rset!=null) {
					rset.close();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return student;
		
	}
}

