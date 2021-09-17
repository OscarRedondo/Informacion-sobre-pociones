package modelo;

public class Pociones {
	private int id_pocion;
	private String nombre_pocion;
	private double litros_realizados_pocion;
	private int usos_pocion;
	
	// CONSTRUCTORES
	
	public Pociones(int id_pocion, String nombre_pocion, double litros_realizados_pocion, int usos_pocion) {
		this.id_pocion = id_pocion;
		this.nombre_pocion = nombre_pocion;
		this.litros_realizados_pocion = litros_realizados_pocion;
		this.usos_pocion = usos_pocion;
	}
	
	public Pociones() {		
	}
	
	// GETTERS & SETTERS
	
	public int getId_pocion() {
		return id_pocion;
	}
	public void setId_pocion(int id_pocion) {
		this.id_pocion = id_pocion;
	}
	
	public String getNombre_pocion() {
		return nombre_pocion;
	}
	public void setNombre_pocion(String nombre_pocion) {
		this.nombre_pocion = nombre_pocion;
	}

	public double getLitros_realizados_pocion() {
		return litros_realizados_pocion;
	}
	public void setLitros_realizados_pocion(double litros_realizados_pocion) {
		this.litros_realizados_pocion = litros_realizados_pocion;
	}

	public int getUsos_pocion() {
		return usos_pocion;
	}
	public void setUsos_pocion(int usos_pocion) {
		this.usos_pocion = usos_pocion;
	}	

}