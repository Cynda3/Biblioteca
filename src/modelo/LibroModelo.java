package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class LibroModelo extends Conector {

	public ArrayList<Libro> selectAll(){
		//crear arraylist
		ArrayList<Libro> libros = new ArrayList<Libro>();
		
		try {
			Statement st = super.conexion.createStatement();
			ResultSet rs = st.executeQuery("select * from usuarios");
			while(rs.next()){
				Libro libro = new Libro();
				libro.setId(rs.getInt("id"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				
					
				libros.add(libro);
			}
			return libros;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return libros;
		
	}
	
	public Libro select(int id){
		//select * from libros where id = ?
		try{
			PreparedStatement pst = super.conexion.prepareStatement("select * from usuarios where id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				Libro libro = new Libro();
				libro.setId(rs.getInt("id"));
				libro.setTitulo(rs.getString("titulo"));
				libro.setAutor(rs.getString("autor"));
				return libro;
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	public void delet (int id){
		PreparedStatement pst;
		try{
			pst = super.conexion.prepareStatement("delete from usuarios where id = ?");
			pst.setInt(1, id);
			
			pst.execute();
		} catch (Exception e) {
			e.printStackTrace();		}
	}
	
	

	
	
	
	
	
	
}
