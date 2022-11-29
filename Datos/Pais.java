package Datos;

public class Pais {
	private String nombre;
	private int goles;
	private boolean clasificado;
	private char grupo;
	//private int resultado;//cantidad de goles
	private Equipo representante;
	private int puntos;// suma 1 si gana si pierde no suma
	private int posicion;//primero o segundos
	
	public Pais(String nombre, boolean clasificado, char grupo, Equipo representante, int puntos, int posicion) {
		super();
		this.nombre = nombre;
		this.goles = goles;
		this.clasificado = clasificado;
		this.grupo = grupo;
		this.representante = representante;
		this.puntos = puntos;
		this.posicion = posicion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getGoles() {
		return goles;
	}

	public void setGoles(int goles) {
		this.goles = goles;
	}

	public boolean isClasificado() {
		return clasificado;
	}

	public void setClasificado(boolean clasificado) {
		this.clasificado = clasificado;
	}

	public char getGrupo() {
		return grupo;
	}

	public void setGrupo(char grupo) {
		this.grupo = grupo;
	}

	public Equipo getRepresentante() {
		return representante;
	}

	public void setRepresentante(Equipo representante) {
		this.representante = representante;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Pais [nombre=" + nombre + ", goles=" + goles + ", clasificado=" + clasificado + ", grupo=" + grupo
				+ ", representante=" + representante + ", puntos=" + puntos + ", posicion=" + posicion + "]";
	}
	
	
}
