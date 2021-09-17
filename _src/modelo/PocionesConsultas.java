package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class PocionesConsultas extends Conexion {

	public boolean agregar(Pociones poc) {
		Connection con = Conexion.getConexion();
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO pociones(id_pocion, nombre_pocion, litros_realizados_pocion, usos_pocion)"
					+ " VALUES (?,?,?,?)");
			ps.setInt(1, poc.getId_pocion());
			ps.setString(2, poc.getNombre_pocion());
			ps.setDouble(3, poc.getLitros_realizados_pocion());
			ps.setInt(4, poc.getUsos_pocion());						
			ps.executeUpdate();
			return true;
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
			return false;
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e.toString());
			}
		}
	}
	
	public boolean modificar(Pociones poc) {
		Connection con = Conexion.getConexion();
		
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE pociones "
					+ "SET nombre_pocion=?, litros_realizados_pocion=?, usos_pocion=? "
					+ "WHERE id_pocion=?");						
			ps.setString(1, poc.getNombre_pocion());
			ps.setDouble(2, poc.getLitros_realizados_pocion());
			ps.setInt(3, poc.getUsos_pocion());					
			ps.setInt(4, poc.getId_pocion());
			ps.executeUpdate();
			return true;
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
			return false;
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e.toString());
			}
		}
	}
	
	public boolean eliminar(Pociones poc) {
		Connection con = Conexion.getConexion();
		int yes_no = JOptionPane.showConfirmDialog(null, "¿Quieres eliminar esta poci\u00F3n?", "Eliminar poci\u00F3n", JOptionPane.YES_NO_OPTION);

		try {
			if(yes_no == JOptionPane.YES_OPTION) {
				PreparedStatement ps = con.prepareStatement("DELETE FROM pociones "
						+ "WHERE id_pocion=?");
				ps.setInt(1, poc.getId_pocion());								
				ps.executeUpdate();			
				return true;
			}
			return false;
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
			return false;
		}
		finally {
			try { con.close(); }
			catch(SQLException e) { JOptionPane.showMessageDialog(null, e.toString()); }		
		}
	}

	public boolean buscar(Pociones poc) {
		Connection con = Conexion.getConexion();
		ResultSet rs = null;
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * "
					+ "FROM pociones "
					+ "WHERE id_pocion=?");
			ps.setInt(1, poc.getId_pocion());
			rs = ps.executeQuery();
			
			if(rs.next()) {
				poc.setId_pocion(Integer.parseInt(rs.getString("id_pocion")));
				poc.setNombre_pocion(rs.getString("nombre_pocion"));
				poc.setLitros_realizados_pocion(Double.parseDouble(rs.getString("litros_realizados_pocion")));
				poc.setUsos_pocion(Integer.parseInt(rs.getString("usos_pocion")));
				return true;
			}
			return false;
		}
		catch(SQLException ex) {
			JOptionPane.showMessageDialog(null, ex.toString());
			return false;
		}
		finally {
			try {
				con.close();
			}
			catch(SQLException e) {
				JOptionPane.showMessageDialog(null, e.toString());
			}
		}
	}
	
	public boolean limpiar() {
		int yes_no = JOptionPane.showConfirmDialog(null, "¿Quieres limpiar los datos ingresados?", "Limpieza", JOptionPane.YES_NO_OPTION);

		if(yes_no == JOptionPane.YES_OPTION) {
			return true;
		}
		return false;
	}

}