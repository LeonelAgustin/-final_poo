package Datos;

import java.util.LinkedList;

import javax.swing.JOptionPane;

public class Pais {
	private String nombre;
	private int goles;
	private boolean clasificado;
	private char grupo;
	private Equipo representante;
	private int puntos;
	private int posicion;
	
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
	
	public static Partido crearPartido(int i, Pais pais1, Pais pais2){
		//int id, Pais equipo1, Pais equipo2, int duracion
		Partido formado = new Partido (i,pais1,	pais2,(int)(Math.random()*20+90));// duracion del partido entre 90 y 100 minutos
		return formado;
	}
	
	public static LinkedList<Pais> pasarFinal(LinkedList<Pais> paisesA, LinkedList<Pais> paisesB,LinkedList<Pais> paisesC, LinkedList<Pais> paisesD, LinkedList<Pais> paisesE, LinkedList<Pais> paisesF,LinkedList<Pais> paisesG, LinkedList<Pais> paisesH) {

		String listado = "ASI QUEDA EL PARTIDO EN LA GRAN FINAL\n";
		String ganadores = "pasan a LA GRAN FINAL\n";
		LinkedList<Pais> dupla3 = new LinkedList<Pais>();
		LinkedList<Pais> semis = new LinkedList<Pais>();
		LinkedList<Pais> granfinal = new LinkedList<Pais>();
		LinkedList<Partido> partidos =  new LinkedList<Partido>();

		semis = pasarSemi(paisesA, paisesB, paisesC, paisesD, paisesE, paisesF, paisesG, paisesH);// 0-4 paises
		JOptionPane.showMessageDialog(null, "GRAN FINAL");

		// PRIMERO PAIS
		dupla3.add(0, semis.get(0));
		dupla3.add(1, semis.get(1));
		dupla3 = primeroSegundoEmpate(dupla3);
		granfinal.add(0, dupla3.get(0));
		// SEGUNDO PAIS
		dupla3.remove(1);
		dupla3.remove(0);

		dupla3.add(0, semis.get(2));
		dupla3.add(1, semis.get(3));
		dupla3 = primeroSegundoEmpate(dupla3);
		granfinal.add(1, dupla3.get(0));

		for (int i = 0; i < 2; i++) {
			ganadores += "\nPais: "+granfinal.get(i).getNombre() + ", Goles: "+granfinal.get(i).getGoles();
		}
		
		for (int i = 0; i < 2; i+=2) {
			partidos.add(crearPartido(i,granfinal.get(i),granfinal.get(i+1)));
		}		
		
		for (Partido partido : partidos) {
			listado +=partido.getEquipo1().getNombre()+" VS "+partido.getEquipo2().getNombre()+"\n";
		}

		JOptionPane.showMessageDialog(null, ganadores);
		JOptionPane.showMessageDialog(null, listado);

		return granfinal;
	}

	public static LinkedList<Pais> pasarSemi(LinkedList<Pais> paisesA, LinkedList<Pais> paisesB,LinkedList<Pais> paisesC, LinkedList<Pais> paisesD, LinkedList<Pais> paisesE, LinkedList<Pais> paisesF,	LinkedList<Pais> paisesG, LinkedList<Pais> paisesH) {
		
		String listado = "ASI QUEDAN LOS PARTIDOS EN SEMIFINAL\n";
		String ganadores = "pasan a SEMIFINAL\n";
		LinkedList<Pais> dupla2 = new LinkedList<Pais>();
		LinkedList<Pais> cuartos = new LinkedList<Pais>();
		LinkedList<Pais> semis = new LinkedList<Pais>();
		LinkedList<Partido> partidos =  new LinkedList<Partido>();

		cuartos = pasarCuartos(paisesA, paisesB, paisesC, paisesD, paisesE, paisesF, paisesG, paisesH);// 0-7 paises
		JOptionPane.showMessageDialog(null, "CUARTOS DE FINAL");

		// PRIMERO PAIS
		dupla2.add(0, cuartos.get(0));
		dupla2.add(1, cuartos.get(1));
		dupla2 = primeroSegundoEmpate(dupla2);
		semis.add(0, dupla2.get(0));
		// SEGUNDO PAIS
		dupla2.remove(1);
		dupla2.remove(0);

		dupla2.add(0, cuartos.get(2));
		dupla2.add(1, cuartos.get(3));
		dupla2 = primeroSegundoEmpate(dupla2);
		semis.add(1, dupla2.get(0));
		// TERCER PAIS
		dupla2.remove(1);
		dupla2.remove(0);
		dupla2.add(0, cuartos.get(4));
		dupla2.add(1, cuartos.get(5));
		dupla2 = primeroSegundoEmpate(dupla2);
		semis.add(2, dupla2.get(0));
		// CUARTO PAIS
		dupla2.remove(1);
		dupla2.remove(0);
		dupla2.add(0, cuartos.get(6));
		dupla2.add(1, cuartos.get(7));
		dupla2 = primeroSegundoEmpate(dupla2);
		semis.add(3, dupla2.get(0));

		
		
		for (int i = 0; i < 4; i++) {
			ganadores += "\nPais: "+semis.get(i).getNombre() +", Goles: "+semis.get(i).getGoles();
		}
		
		for (int i = 0; i < 4; i+=2) {
			partidos.add(crearPartido(i,semis.get(i),semis.get(i+1)));
		}		
		
		for (Partido partido : partidos) {
			listado +=partido.getEquipo1().getNombre()+" VS "+partido.getEquipo2().getNombre()+"\n";
		}

		JOptionPane.showMessageDialog(null, ganadores);
		JOptionPane.showMessageDialog(null, listado);

		return semis;// o-3 paises
	}

	public static LinkedList<Pais> pasarCuartos(LinkedList<Pais> paisesA, LinkedList<Pais> paisesB,LinkedList<Pais> paisesC, LinkedList<Pais> paisesD, LinkedList<Pais> paisesE, LinkedList<Pais> paisesF,	LinkedList<Pais> paisesG, LinkedList<Pais> paisesH) {// recibe lista de octavos ordenados

		String listado = "ASI QUEDAN LOS PARTIDOS EN CUARTOS\n";		
		String ganadores = " PASAN A CUARTOS \n";
		LinkedList<Pais> dupla1 = new LinkedList<Pais>();
		LinkedList<Pais> octavos = new LinkedList<Pais>();
		LinkedList<Pais> cuartos = new LinkedList<Pais>();
		LinkedList<Partido> partidos =  new LinkedList<Partido>();

		octavos = pasarOctavos(paisesA, paisesB, paisesC, paisesD, paisesE, paisesF, paisesG, paisesH);

		JOptionPane.showMessageDialog(null, "OCTAVOS DE FINAL");
		
		dupla1.add(0, octavos.get(0));
		dupla1.add(1, octavos.get(1));
		dupla1 = primeroSegundoEmpate(dupla1);
		cuartos.add(0, dupla1.get(0));

		// AGARRO EL SEGUNDO PAR DE PAISES 1C y 2D

		dupla1.remove(1);// debo eliminar el ultimo primero sino se mueve a la posicion 0 como una pila
		dupla1.remove(0);
		dupla1.add(0, octavos.get(2));// no los esta agregando en la posicion 0 y 1, sino en la 3 y 4
		dupla1.add(1, octavos.get(3));// no los esta agregando en la posicion 0 y 1, sino en la 3 y 4
		
		dupla1 = primeroSegundoEmpate(dupla1);// empieza con 1C y 2D
		cuartos.add(1, dupla1.get(0));

		// AGARRO EL TERCER PAR DE PAISES 1E y 2F

		dupla1.remove(1);
		dupla1.remove(0);
		dupla1.add(0, octavos.get(4));
		dupla1.add(1, octavos.get(5));
		dupla1 = primeroSegundoEmpate(dupla1);
		cuartos.add(2, dupla1.get(0));
		// AGARRO EL TERCER PAR DE PAISES 1G y 2H
		dupla1.remove(1);
		dupla1.remove(0);
		dupla1.add(0, octavos.get(6));
		dupla1.add(1, octavos.get(7));
		dupla1 = primeroSegundoEmpate(dupla1);
		cuartos.add(3, dupla1.get(0));

		// AGARRO EL TERCER PAR DE PAISES 1B y 2A

		dupla1.remove(1);
		dupla1.remove(0);

		dupla1.add(0, octavos.get(8));
		dupla1.add(1, octavos.get(9));
		dupla1 = primeroSegundoEmpate(dupla1);
		cuartos.add(4, dupla1.get(0));
		// AGARRO EL TERCER PAR DE PAISES 1D y 2C
		dupla1.remove(1);
		dupla1.remove(0);

		dupla1.add(0, octavos.get(10));
		dupla1.add(1, octavos.get(11));
		dupla1 = primeroSegundoEmpate(dupla1);
		cuartos.add(5, dupla1.get(0));

		// AGARRO EL TERCER PAR DE PAISES 1F y 2E

		dupla1.remove(1);
		dupla1.remove(0);

		dupla1.add(0, octavos.get(12));
		dupla1.add(1, octavos.get(13));
		dupla1 = primeroSegundoEmpate(dupla1);
		cuartos.add(6, dupla1.get(0));
		// AGARRO EL TERCER PAR DE PAISES 1H y 2G
		dupla1.remove(1);
		dupla1.remove(0);

		dupla1.add(0, octavos.get(14));
		dupla1.add(1, octavos.get(15));
		dupla1 = primeroSegundoEmpate(dupla1);
		cuartos.add(7, dupla1.get(0));
		
		for (int i = 0; i < 8; i++) {
			ganadores += "\nPais: "+cuartos.get(i).getNombre() +", Goles: "+cuartos.get(i).getGoles();
		}
		
		for (int i = 0; i < 8; i+=2) {
			partidos.add(crearPartido(i,cuartos.get(i),cuartos.get(i+1)));
		}		
		
		for (Partido partido : partidos) {
			listado +=partido.getEquipo1().getNombre()+" VS "+partido.getEquipo2().getNombre()+"\n";
		}

		JOptionPane.showMessageDialog(null, ganadores);
		JOptionPane.showMessageDialog(null, listado);
		// 0-7 paises
		return cuartos;// devuelve los que estan en cuartos ordenado igual que en octavos
	}

	public static LinkedList<Pais> pasarOctavos(LinkedList<Pais> paisesA, LinkedList<Pais> paisesB,	LinkedList<Pais> paisesC, LinkedList<Pais> paisesD, LinkedList<Pais> paisesE, LinkedList<Pais> paisesF,LinkedList<Pais> paisesG, LinkedList<Pais> paisesH) {

		String octavos1 = " PASAN A OCTAVOS ";
		String octavos2 = " PASAN A OCTAVOS ";
		String listado = "ASI QUEDAN LOS PARTIDOS EN OCTAVOS\n";
		
		LinkedList<Pais> octavos = new LinkedList<Pais>();
		LinkedList<Pais> dupla = new LinkedList<Pais>();
		LinkedList<Pais> sinorden = new LinkedList<Pais>();
		LinkedList<Partido> partidos =  new LinkedList<Partido>();
		
		JOptionPane.showMessageDialog(null, "FASE DE GRUPOS");
		
		dupla = primeroSegundoEmpate(paisesA);
		sinorden.add(0, dupla.get(0));// 1A
		sinorden.add(1, dupla.get(1));// 2A
		dupla = primeroSegundoEmpate(paisesB);
		sinorden.add(2, dupla.get(0));// 1B
		sinorden.add(3, dupla.get(1));// 2B
		dupla = primeroSegundoEmpate(paisesC);
		sinorden.add(4, dupla.get(0));// 1C
		sinorden.add(5, dupla.get(1));// 2C
		dupla = primeroSegundoEmpate(paisesD);
		sinorden.add(6, dupla.get(0));// 1D
		sinorden.add(7, dupla.get(1));// 2D
		dupla = primeroSegundoEmpate(paisesE);
		sinorden.add(8, dupla.get(0));// 1E
		sinorden.add(9, dupla.get(1));// 2E
		dupla = primeroSegundoEmpate(paisesF);
		sinorden.add(10, dupla.get(0));// 1F
		sinorden.add(11, dupla.get(1));// 2F
		dupla = primeroSegundoEmpate(paisesG);
		sinorden.add(12, dupla.get(0));// 1G
		sinorden.add(13, dupla.get(1));// 2G
		dupla = primeroSegundoEmpate(paisesH);
		sinorden.add(14, dupla.get(0));// 1H
		sinorden.add(15, dupla.get(1));// 2H
		// acomodo los octavos de la izquierda primero luego los octavos de la derecha
		octavos.add(0, sinorden.get(0));// 1A
		octavos.add(1, sinorden.get(3));// 2B
		octavos.add(2, sinorden.get(4));// 1C
		octavos.add(3, sinorden.get(7));// 2D
		octavos.add(4, sinorden.get(8));// 1E
		octavos.add(5, sinorden.get(11));// 2F
		octavos.add(6, sinorden.get(12));// 1G
		octavos.add(7, sinorden.get(15));// 2H

		octavos.add(8, sinorden.get(2));// 1B
		octavos.add(9, sinorden.get(1));// 2A
		octavos.add(10, sinorden.get(6));// 1D
		octavos.add(11, sinorden.get(5));// 2C
		octavos.add(12, sinorden.get(10));// 1F
		octavos.add(13, sinorden.get(9));// 2E
		octavos.add(14, sinorden.get(14));// 1H
		octavos.add(15, sinorden.get(13));// 2G

		for (int i = 0; i < 8; i++) {
			octavos1 += "\nPais: "+octavos.get(i).getNombre() + ", grupo: "+octavos.get(i).getGrupo()+", Goles: "+octavos.get(i).getGoles();
		}
		for (int i = 8; i < 16; i++) {
			octavos2 += "\nPais: "+octavos.get(i).getNombre() + ", grupo: "+octavos.get(i).getGrupo()+", Goles: "+octavos.get(i).getGoles();
		}
		
		for (int i = 0; i < 16; i+=2) {
			partidos.add(crearPartido(i,octavos.get(i),octavos.get(i+1)));
		}
		
		for (Partido partido : partidos) {
			listado +=partido.getEquipo1().getNombre()+" VS "+partido.getEquipo2().getNombre()+"\n";
		}

		JOptionPane.showMessageDialog(null, " izquierda" + octavos1);
		JOptionPane.showMessageDialog(null, " derecha" + octavos2);
		JOptionPane.showMessageDialog(null, listado);
		// devuelve ordenado los octavos de la izquierda luego de la derecha
		return octavos;// 0-15 paises
	}
	
	
	public static LinkedList<Pais> primeroSegundoEmpate(LinkedList<Pais> paises) {
		LinkedList<Pais> dupla = new LinkedList<Pais>();
		String mostrar2 = "JUGANDO PARTIDOS\n";

		paises = puntosGrupo(paises);
		for (Pais pais : paises) {
			mostrar2 += "Pais= " + pais.getNombre() + ", Grupo= " + pais.getGrupo() +", Goles= "+pais.getGoles()+"\n";
		}
		JOptionPane.showMessageDialog(null, mostrar2);// muestro los paises con los puntos cambiados sin orden
		// ordenar lista de paises
		int[] puntos = new int[6];// de 0 a 5
		int i = 0;
		for (Pais pais : paises) {
			puntos[i] = pais.getPuntos();
			i++;
		} // paso los puntos a un array comun
		puntos = burbuja(puntos);// ordeno el array de puntos de menor a mayor

		int pos1 = 0;
		int pos2 = 0;
		// System.out.println("puntos 6: "+puntos[5]); los puntos en esa posicion
		// System.out.println("puntos 5: "+puntos[4]);
		for (Pais pais : paises) {
			System.out.println(pais);
			// muestro por consola los paises toString
		}

		int nuevoPunto = 0;
		for (int j = 0; j < puntos.length; j++) {// recorro 5 veces el array para que no quede empate
			for (int k = 0; k < 5; k++) {// recorro el array y los paises para volver a jugar en caso de empate
				for (Pais pais : paises) {// comparo los puntos de cada pais con el punto de la posicion k
					if (pais.getPuntos() == puntos[k]) {
						if (puntos[k] == puntos[k + 1]) {// al estar ordenado de menor a mayor pregunto por el siguiente
							JOptionPane.showMessageDialog(null,	"hubo EMPATE en el partido de " + pais.getNombre() + " se jugara desempate");
							if (puntos[k]==0) {
								nuevoPunto = puntos[k] + 1;
								puntos[k] = nuevoPunto;
								pais.setPuntos(nuevoPunto);
								pais.setGoles(pais.getGoles()+1);
							}else {								
								nuevoPunto = puntos[k] - 1;
								puntos[k] = nuevoPunto;
								pais.setPuntos(nuevoPunto);
								pais.setGoles(pais.getGoles()-1);
							}
						}
					}
				}
			}
		}

		for (Pais pais : paises) {// recorro la lista de paises comparando puntos para ver los ganadores
			if (pais.getPuntos() == puntos[5]) {// si los puntos del pais son iguales a los puntos que tengo en la
												// ultima posicion del array guardo ese pais
				pos1 = paises.indexOf(pais);// posicion primer ganador
				System.out.println("primero: " + pais.getNombre());// consola pirmer pais ganador
			}

			if (pais.getPuntos() == puntos[4]) {// si los puntos del pais son iguales a los puntos que tengo en la
												// ante-ultima posicion del array guardo ese pais
				pos2 = paises.indexOf(pais);// posicion segundo ganador
				System.out.println("segundo: " + pais.getNombre());// consola segundo pais ganador
			}
		}
		for (Pais pais : paises) {
			System.out.println(pais);
			// muestro por consola los paises toString
		}
		
		JOptionPane.showMessageDialog(null, "RESULTADOS\nPrimero: " + paises.get(pos1).getNombre()+ ", Grupo= " + paises.get(pos1).getGrupo() +", Goles= "+paises.get(pos1).getGoles()+ "\nSegundo: " + paises.get(pos2).getNombre()+ ", Grupo= " + paises.get(pos2).getGrupo() +", Goles= "+paises.get(pos2).getGoles());
		
		dupla.add(0, paises.get(pos1));
		dupla.add(1, paises.get(pos2));
		
		return dupla;// devuelve los el primer y segundo ganador
	}

	public static LinkedList<Pais> puntosGrupo(LinkedList<Pais> paises) {
		// puntos aleatorios de cada pais entre 0 y 9
		for (Pais pais : paises) {
			pais.setPuntos((int) (Math.random() * 9 + 1));
			if (pais.getPuntos()<=1) {
				pais.setGoles(0);
			} else if (pais.getPuntos()<=3) {
				pais.setGoles(1);
			} else if(pais.getPuntos()<=6) {
				pais.setGoles(2);
			} else if (pais.getPuntos()<=9) {
				pais.setGoles(3);
			}
		}
		return paises;
	}

	private static int[] burbuja(int[] puntos) {
		// ordena el array de puntos recibidos de menor a mayor dejando los 2 mas altos
		// al final del array
		for (int x = 0; x < puntos.length; x++) {
			// Aqui "y" se detiene antes de llegar
			// a length - 1 porque dentro del for, accedemos
			// al siguiente elemento con el �ndice actual + 1
			for (int y = 0; y < puntos.length - 1; y++) {
				int elementoActual = puntos[y], elementoSiguiente = puntos[y + 1];
				if (elementoActual > elementoSiguiente) {
					// Intercambiar
					puntos[y] = elementoSiguiente;
					puntos[y + 1] = elementoActual;
				}
			}
		}
		return puntos;
	}
	
	// BASE DE DATOS PARTIDOS y PAISES agrupados por letra de grupo
		public static LinkedList<Pais> grupoA() {
			LinkedList<Pais> paises1 = new LinkedList<Pais>();
			Pais qatar = new Pais("Qatar", false, 'A', new Equipo("QFA", 4), 0, 0);
			Pais ecuador = new Pais("Ecuador", true, 'A', new Equipo("ECU", 5), 0, 0);
			Pais senegal = new Pais("Senegal", false, 'A', new Equipo("SNG", 4), 0, 0);
			Pais paisesBajos = new Pais("P.Bajos", false, 'A', new Equipo("PBS", 4), 0, 0);
			paises1.add(qatar);
			paises1.add(ecuador);
			paises1.add(senegal);
			paises1.add(paisesBajos);

			return paises1;
		}

		public static LinkedList<Pais> grupoB() {
			LinkedList<Pais> paises1 = new LinkedList<Pais>();
			Pais inglaterra = new Pais("Inglaterra", false, 'B', new Equipo("ING", 4), 0, 0);
			Pais iran = new Pais("Iran", true, 'B', new Equipo("IRN", 5), 0, 0);
			Pais estadosUnidos = new Pais("EstadosUnidos", false, 'B', new Equipo("EEUU", 4), 0, 0);
			Pais gales = new Pais("Gales", false, 'B', new Equipo("GLS", 4), 0, 0);
			paises1.add(inglaterra);
			paises1.add(iran);
			paises1.add(estadosUnidos);
			paises1.add(gales);
			return paises1;
		}

		public static LinkedList<Pais> grupoC() {
			LinkedList<Pais> paises1 = new LinkedList<Pais>();
			Pais argentina = new Pais("Argentina", false, 'C', new Equipo("ARG", 4), 0, 0);
			Pais arabiaSaudita = new Pais("Arabia.s", true, 'C', new Equipo("ARS", 5), 0, 0);
			Pais mexico = new Pais("Mexico", false, 'C', new Equipo("MEX", 4), 0, 0);
			Pais polonia = new Pais("Polonia", false, 'C', new Equipo("PLN", 4), 0, 0);
			paises1.add(argentina);
			paises1.add(arabiaSaudita);
			paises1.add(mexico);
			paises1.add(polonia);
			return paises1;
		}

		public static LinkedList<Pais> grupoD() {
			LinkedList<Pais> paises1 = new LinkedList<Pais>();
			Pais francia = new Pais("Francia", false, 'D', new Equipo("FRN", 4), 0, 0);
			Pais australia = new Pais("Australia", false, 'D', new Equipo("AUS", 4), 0, 0);
			Pais dinamarca = new Pais("Dinamarca", false, 'D', new Equipo("DNM", 4), 0, 0);
			Pais tunez = new Pais("Tunez", false, 'D', new Equipo("TNZ", 4), 0, 0);
			paises1.add(francia);
			paises1.add(australia);
			paises1.add(dinamarca);
			paises1.add(tunez);
			return paises1;
		}

		public static LinkedList<Pais> grupoE() {
			LinkedList<Pais> paises1 = new LinkedList<Pais>();
			Pais espana = new Pais("Espania", false, 'E', new Equipo("ESP", 4), 0, 0);
			Pais costaRica = new Pais("CostaRica", false, 'E', new Equipo("CTR", 4), 0, 0);
			Pais alemania = new Pais("Alemania", false, 'E', new Equipo("ALM", 4), 0, 0);
			Pais japon = new Pais("Japon", false, 'E', new Equipo("JPN", 4), 0, 0);
			paises1.add(espana);
			paises1.add(costaRica);
			paises1.add(alemania);
			paises1.add(japon);
			return paises1;
		}

		public static LinkedList<Pais> grupoF() {
			LinkedList<Pais> paises1 = new LinkedList<Pais>();
			Pais belgica = new Pais("Belgica", false, 'F', new Equipo("BLG", 4), 0, 0);
			Pais canada = new Pais("Canada", false, 'F', new Equipo("CND", 4), 0, 0);
			Pais marruecos = new Pais("Marruecos", false, 'F', new Equipo("MRC", 4), 0, 0);
			Pais croacia = new Pais("Croacia", false, 'F', new Equipo("CRC", 4), 0, 0);
			paises1.add(belgica);
			paises1.add(canada);
			paises1.add(marruecos);
			paises1.add(croacia);
			return paises1;
		}

		public static LinkedList<Pais> grupoG() {
			LinkedList<Pais> paises1 = new LinkedList<Pais>();
			Pais brasil = new Pais("Brasil", false, 'G', new Equipo("BRS", 4), 0, 0);
			Pais serbia = new Pais("Serbia", false, 'G', new Equipo("SRB", 4), 0, 0);
			Pais suiza = new Pais("Suiza", false, 'G', new Equipo("SZA", 4), 0, 0);
			Pais camerun = new Pais("Camerun", false, 'G', new Equipo("CMR", 4), 0, 0);
			paises1.add(brasil);
			paises1.add(serbia);
			paises1.add(suiza);
			paises1.add(camerun);
			return paises1;
		}

		public static LinkedList<Pais> grupoH() {
			LinkedList<Pais> paises1 = new LinkedList<Pais>();
			Pais portugal = new Pais("Portugal", false, 'H', new Equipo("PRT", 4), 0, 0);
			Pais ghana = new Pais("Ghana", false, 'H', new Equipo("GHN", 4), 0, 0);
			Pais uruguay = new Pais("Uruguay", false, 'H', new Equipo("URG", 4), 0, 0);
			Pais coreaSur = new Pais("Corea.s", false, 'H', new Equipo("CRS", 4), 0, 0);

			paises1.add(portugal);
			paises1.add(ghana);
			paises1.add(uruguay);
			paises1.add(coreaSur);
			return paises1;
		}
	
}
