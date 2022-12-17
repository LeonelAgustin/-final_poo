package Datos;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Encargado {
	private int id_encargado;
	private String nombre;
	
	public Encargado(int id_encargado, String nombre) {
		super();
		this.id_encargado = id_encargado;
		this.nombre = nombre;
	}
	
	public int getId_encargado() {
		return id_encargado;
	}
	public void setId_encargado(int id_encargado) {
		this.id_encargado = id_encargado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Encargado [id_encargado=" + id_encargado + ", nombre=" + nombre + "]";
	}
	
	public void buscarTabla(LinkedList<Partido> partidos) {// buscar una tabla
		 
		String tabla = "";
		String grupo = JOptionPane.showInputDialog("ingrese la letra del grupo para mostrar losa partidos de ese grupo");

		for (Partido partido : partidos) {
			if (partido.getEquipo1().getGrupo() == grupo.charAt(0)) {// si grupo convertido en char es igual a Grupo
				tabla += partido.getEquipo1().getNombre() + " VS " + partido.getEquipo2().getNombre() + "\n";
			}
		}
		JOptionPane.showMessageDialog(null, "grupo " + grupo + "\n" + tabla);
	}
	
	public void buscarPartidos(LinkedList<Partido> partidos) {
		boolean encontrado = false;
		
		Partido formado = null;
		// recorre toda la lista de partidos aunque encuentre los partidos que le indico
		String pais = JOptionPane.showInputDialog("ingrese el nombre del pais para buscar los partidos relacionados");
		String enfrentados = "";
		char grupo = '-';
		for (Partido partido : partidos) {
			if (partido.getEquipo1().getNombre().equalsIgnoreCase(pais)	|| partido.getEquipo2().getNombre().equalsIgnoreCase(pais)) {
				encontrado = true;
				enfrentados = enfrentados + "\n" + partido.getEquipo1().getNombre() + " VS "	+ partido.getEquipo2().getNombre();
				grupo = partido.getEquipo1().getGrupo();
			}
		} // terminar de recorrer todos los partidos

		if (encontrado == false) {
			int b = Integer.parseInt(JOptionPane.showInputDialog("No se encontro partidos relacionados con " + pais	+ ", desea agregar este Pais a la base de datos?\n1-SI\n2-NO"));
			if (b == 1) {
				int z = Integer.parseInt(JOptionPane.showInputDialog("Cuantos partidos quiere registrar?"));
				
				for (int i = 0; i < z; i++) {
					String nombre1 = JOptionPane.showInputDialog("ingrese el nombre del primer pais para el partido "+(i+1));
					String nombre2 = JOptionPane.showInputDialog("ingrese el nombre del segundo pais"+(i+1));
					//String nombre, boolean clasificado, char grupo, Equipo representante, int puntos, int posicion
					Pais pais1 = new Pais(nombre1,false,'I',new Equipo("OOO",0),0,0);
					Pais pais2 = new Pais(nombre2,false,'I',new Equipo("OOA",0),0,0);
					formado = crearPartido(i,pais1,pais2);
					JOptionPane.showMessageDialog(null, "Partido creado:\n"+formado.getEquipo1().getNombre()+" VS "+formado.getEquipo2().getNombre());
				}
				
				JOptionPane.showMessageDialog(null, "agregar partido");
			}
		} else if (encontrado) {
			JOptionPane.showMessageDialog(null, "GRUPO "+grupo+partidos);
		}
	}

	
	
	public static Partido crearPartido(int i, Pais pais1, Pais pais2){
		//int id, Pais equipo1, Pais equipo2, int duracion
		Partido formado = new Partido (i,pais1,	pais2,(int)(Math.random()*20+90));// duracion del partido entre 90 y 100 minutos
		return formado;
	}
	
}
