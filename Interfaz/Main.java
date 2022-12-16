package Interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Datos.Encargado;
import Datos.Equipo;
import Datos.Pais;
import Datos.Partido;

public class Main {

	public static void main(String[] args) {
		Encargado pablo = new Encargado(01, "Pablo");
		LinkedList<Partido> partidos = General();
		LinkedList<Pais> ordenada = new LinkedList<Pais>();

		LinkedList<Pais> paisesA = grupoA();
		LinkedList<Pais> paisesB = grupoB();
		LinkedList<Pais> paisesC = grupoC();
		LinkedList<Pais> paisesD = grupoD();
		LinkedList<Pais> paisesE = grupoE();
		LinkedList<Pais> paisesF = grupoF();
		LinkedList<Pais> paisesG = grupoG();
		LinkedList<Pais> paisesH = grupoH();

		pasarFinal(paisesA,paisesB,paisesC,paisesD,paisesE,paisesF,paisesG,paisesH);

	}// termina el main
	
	public static LinkedList<Pais> pasarFinal(LinkedList<Pais> paisesA, LinkedList<Pais> paisesB, LinkedList<Pais> paisesC, LinkedList<Pais> paisesD, LinkedList<Pais> paisesE, LinkedList<Pais> paisesF, LinkedList<Pais> paisesG, LinkedList<Pais> paisesH){
		
		String ganadores = "pasan a FINAL\n";
		LinkedList<Pais> dupla3 = new LinkedList<Pais> ();
		LinkedList<Pais> semis = new LinkedList<Pais> ();
		LinkedList<Pais> granfinal = new LinkedList<Pais> ();
		
		semis=pasarCuartos(paisesA,paisesB,paisesC,paisesD,paisesE,paisesF,paisesG,paisesH);// 0-4 paises
		JOptionPane.showMessageDialog(null, "GRAN FINAL");
		
		// PRIMERO PAIS
				dupla3.add(0,semis.get(0));
				dupla3.add(1,semis.get(1));
				dupla3 = primeroSegundoEmpate(dupla3);
				granfinal.add(0,dupla3.get(0));
		// SEGUNDO PAIS
				dupla3.remove(1);
				dupla3.remove(0);		
				
				dupla3.add(0,semis.get(2));
				dupla3.add(1,semis.get(3));
				dupla3 = primeroSegundoEmpate(dupla3);
				granfinal.add(1,dupla3.get(0));
				
				for (Pais pais : granfinal) {
					ganadores += pais.getNombre()+" grupo: "+pais.getGrupo()+"\n";
				}
				JOptionPane.showMessageDialog(null, "pasaron a la gran final:\n"+ganadores);
				
		return granfinal;
	}
	
	public static LinkedList<Pais> pasarSemi(LinkedList<Pais> paisesA, LinkedList<Pais> paisesB, LinkedList<Pais> paisesC, LinkedList<Pais> paisesD, LinkedList<Pais> paisesE, LinkedList<Pais> paisesF, LinkedList<Pais> paisesG, LinkedList<Pais> paisesH) {
		String ganadores = "pasan a SEMIFINAL\n";
		LinkedList<Pais> dupla2 = new LinkedList<Pais> ();
		LinkedList<Pais> cuartos = new LinkedList<Pais> ();
		LinkedList<Pais> semis = new LinkedList<Pais> ();
		
		cuartos=pasarCuartos(paisesA,paisesB,paisesC,paisesD,paisesE,paisesF,paisesG,paisesH);// 0-7 paises
		JOptionPane.showMessageDialog(null, "SEMIFINAL");
						
		// PRIMERO PAIS
		dupla2.add(0,cuartos.get(0));
		dupla2.add(1,cuartos.get(1));
		dupla2 = primeroSegundoEmpate(dupla2);
		semis.add(0,dupla2.get(0));
		// SEGUNDO PAIS
		dupla2.remove(1);
		dupla2.remove(0);		
		
		dupla2.add(0,cuartos.get(2));
		dupla2.add(1,cuartos.get(3));
		dupla2 = primeroSegundoEmpate(dupla2);
		semis.add(1,dupla2.get(0));
		// TERCER PAIS
				dupla2.remove(1);
				dupla2.remove(0);				
				dupla2.add(0,cuartos.get(4));
				dupla2.add(1,cuartos.get(5));
				dupla2 = primeroSegundoEmpate(dupla2);
				semis.add(2,dupla2.get(0));
		// CUARTO PAIS
				dupla2.remove(1);
				dupla2.remove(0);				
				dupla2.add(0,cuartos.get(6));
				dupla2.add(1,cuartos.get(7));
				dupla2 = primeroSegundoEmpate(dupla2);
				semis.add(3,dupla2.get(0));
				
				for (Pais pais : semis) {
					ganadores += pais.getNombre()+" grupo: "+pais.getGrupo()+"\n";
				}
				JOptionPane.showMessageDialog(null, "pasaron a semifinal:\n"+ganadores);
		
		return semis;// o-3 paises
	} 
	
	public static LinkedList<Pais> pasarCuartos(LinkedList<Pais> paisesA, LinkedList<Pais> paisesB, LinkedList<Pais> paisesC, LinkedList<Pais> paisesD, LinkedList<Pais> paisesE, LinkedList<Pais> paisesF, LinkedList<Pais> paisesG, LinkedList<Pais> paisesH) {// recibe lista de octavos ordenados
		String ganadores = "pasan a CUARTOS DE FINAL\n";
		LinkedList<Pais> dupla1 = new LinkedList<Pais> ();
		LinkedList<Pais> octavos = new LinkedList<Pais> ();
		LinkedList<Pais> cuartos = new LinkedList<Pais> ();
		
		octavos = pasarOctavos(paisesA,paisesB,paisesC,paisesD,paisesE,paisesF,paisesG,paisesH);
		
		JOptionPane.showMessageDialog(null, "CUARTOS DE FINAL");
		/*
		for (int i = 0; i < 8; i++) {
			octavos1.add(octavos.get(i));
		}
		for (int i = 8; i < 16; i++) {
			octavos2.add(octavos.get(i));
		}
		
		dupla.add(octavos1.get(0));
		dupla.add(octavos1.get(1));
		cuartos1.add(primeroSegundoEmpate(dupla).get(0));// solo tomo el ganador y lo guardo en cuartos1*/
		
		dupla1.add(0,octavos.get(0));
		dupla1.add(1,octavos.get(1));
		dupla1 = primeroSegundoEmpate(dupla1);
		cuartos.add(0,dupla1.get(0));
		//System.out.println(cuartos.get(0).getNombre()+ " grupo: "+cuartos.get(0).getGrupo());

		// AGARRO EL SEGUNDO PAR DE PAISES 1C y 2D
		
		dupla1.remove(1);// debo eliminar el ultimo primero sino se mueve a la posicion 0 como una pila
		dupla1.remove(0);				
		dupla1.add(0,octavos.get(2));// no los esta agregando en la posicion 0 y 1, sino en la 3 y 4
		dupla1.add(1,octavos.get(3));// no los esta agregando en la posicion 0 y 1, sino en la 3 y 4
		/*
		for (Pais pais : dupla1) {
			System.out.println(pais.getNombre());
		}*/
		dupla1 = primeroSegundoEmpate(dupla1);// empieza con 1C y 2D
		cuartos.add(1,dupla1.get(0));
		//System.out.println(cuartos.get(1).getNombre()+ " grupo: "+cuartos.get(1).getGrupo());
		
		// AGARRO EL TERCER PAR DE PAISES 1E y 2F
		
		dupla1.remove(1);
		dupla1.remove(0);				
		dupla1.add(0,octavos.get(4));
		dupla1.add(1,octavos.get(5));
		dupla1 = primeroSegundoEmpate(dupla1);
		cuartos.add(2,dupla1.get(0));
		// AGARRO EL TERCER PAR DE PAISES 1G y 2H
		dupla1.remove(1);
		dupla1.remove(0);				
		dupla1.add(0,octavos.get(6));
		dupla1.add(1,octavos.get(7));
		dupla1 = primeroSegundoEmpate(dupla1);
		cuartos.add(3,dupla1.get(0));
		
		// AGARRO EL TERCER PAR DE PAISES 1B y 2A
		
				dupla1.remove(1);
				dupla1.remove(0);	
				
				dupla1.add(0,octavos.get(8));
				dupla1.add(1,octavos.get(9));
				dupla1 = primeroSegundoEmpate(dupla1);
				cuartos.add(4,dupla1.get(0));
		// AGARRO EL TERCER PAR DE PAISES 1D y 2C
				dupla1.remove(1);
				dupla1.remove(0);	
				
				dupla1.add(0,octavos.get(10));
				dupla1.add(1,octavos.get(11));
				dupla1 = primeroSegundoEmpate(dupla1);
				cuartos.add(5,dupla1.get(0));
		
		// AGARRO EL TERCER PAR DE PAISES 1F y 2E
				
				dupla1.remove(1);
				dupla1.remove(0);	
				
				dupla1.add(0,octavos.get(12));
				dupla1.add(1,octavos.get(13));
				dupla1 = primeroSegundoEmpate(dupla1);
				cuartos.add(6,dupla1.get(0));
		// AGARRO EL TERCER PAR DE PAISES 1H y 2G				
				dupla1.remove(1);
				dupla1.remove(0);			
				
				dupla1.add(0,octavos.get(14));
				dupla1.add(1,octavos.get(15));
				dupla1 = primeroSegundoEmpate(dupla1);
				cuartos.add(7,dupla1.get(0));
		
		for (Pais pais : cuartos) {
			ganadores += pais.getNombre()+" grupo: "+pais.getGrupo()+"\n";
		}
		
		JOptionPane.showMessageDialog(null, "pasaron a cuartos:\n"+ganadores);		
		// 0-7 paises		
		return cuartos;// devuelve los que estan en cuartos ordenado igual que en octavos
	}
	
public static LinkedList<Pais> pasarOctavos(LinkedList<Pais> paisesA, LinkedList<Pais> paisesB, LinkedList<Pais> paisesC, LinkedList<Pais> paisesD, LinkedList<Pais> paisesE, LinkedList<Pais> paisesF, LinkedList<Pais> paisesG, LinkedList<Pais> paisesH) {
		
		String octavos1 = "octavos 1\n";
		String octavos2 = "octavos 2\n";
		LinkedList<Pais> octavos = new LinkedList<Pais> ();
		LinkedList<Pais> dupla = new LinkedList<Pais>();
		LinkedList<Pais> sinorden = new LinkedList<Pais>();
		
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
			octavos1 += octavos.get(i).getNombre()+"\n";
		}
		for (int i = 8; i < 16; i++) {
			octavos2 += octavos.get(i).getNombre()+"\n";
		}
		
		JOptionPane.showMessageDialog(null, "primeros \n"+octavos1);
		JOptionPane.showMessageDialog(null, "segundos \n"+octavos2);
		// devuelve cordenado los octavos de la izquierda luego de la derecha
		return octavos;// 0-15 paises
	}
	
	public static LinkedList<Pais> primeroSegundoEmpate(LinkedList<Pais> paises) {
		LinkedList<Pais> dupla = new LinkedList<Pais> ();
		
		String mostrar2 = "GRUPO "+paises.getFirst().getGrupo()+"\n";// puntos cambiados
		
		paises = puntosGrupo(paises);// cambio los puntos de cada pais
		for (Pais pais : paises) {
			mostrar2 += "pais= " + pais.getNombre() + "\npuntos= " + pais.getPuntos() + "\n";
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
							JOptionPane.showMessageDialog(null,	"hubo empate en el partido de " + pais.getNombre() + " se jugara desempate");
							nuevoPunto = puntos[k] - 1;
							puntos[k] = nuevoPunto;
							pais.setPuntos(nuevoPunto);
						}
					}
				}
			}
		}
		
		for (Pais pais : paises) {// recorro la lista de paises comparando puntos para ver los ganadores
			if (pais.getPuntos() == puntos[5]) {// si los puntos del pais son iguales a los puntos que tengo en la
												// ultima posicion del array guardo ese pais
				pos1 = paises.indexOf(pais);// posicion primer ganador
				System.out.println("primero: "+pais.getNombre());// consola pirmer pais ganador
			}

			if (pais.getPuntos() == puntos[4]) {// si los puntos del pais son iguales a los puntos que tengo en la
												// ante-ultima posicion del array guardo ese pais
				pos2 = paises.indexOf(pais);// posicion segundo ganador
				System.out.println("segundo: "+pais.getNombre());// consola segundo pais ganador
			}
		}
		for (Pais pais : paises) {
			System.out.println(pais);
			// muestro por consola los paises toString
		}
		JOptionPane.showMessageDialog(null,
				"GRUPO " + paises.get(0).getGrupo() + "\nPrimero: " + paises.get(pos1) + "\nSegundo: " + paises.get(pos2));
		dupla.add(0, paises.get(pos1));
		dupla.add(1, paises.get(pos2));
		return dupla;// devuelve los el primer y segundo ganador
	}
	
	
	
	


	public static LinkedList<Pais> puntosGrupo(LinkedList<Pais> paises) {
		// puntos aleatorios de cada pais entre 0 y 9
		for (Pais pais : paises) {
			pais.setPuntos((int) (Math.random() * 9 + 1));
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

	public static LinkedList<Partido> golesPartidos(LinkedList<Partido> partidos) {

		for (Partido partido : partidos) {
			partido.getEquipo1().setGoles((int) (Math.random() * 5));
			partido.getEquipo2().setGoles((int) (Math.random() * 5));
		}

		return partidos;
	}

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

	public static LinkedList<Partido> General() {
		// int id, Pais equipo1, Pais equipo2, int duracion
		// String nombre, boolean clasificado, char grupo, Equipo representante, int
		// puntos, int posicion
		LinkedList<Partido> todos = new LinkedList<Partido>();
		Partido partido1 = new Partido(1, new Pais("Qatar", false, 'A', new Equipo("QFA", 0), 0, 0),
				new Pais("Ecuador", true, 'A', new Equipo("ECU", 0), 0, 0), 100);
		Partido partido2 = new Partido(1, new Pais("Senegal", false, 'A', new Equipo("SNG", 0), 0, 0),
				new Pais("P.Bajos", true, 'A', new Equipo("PBS", 0), 0, 0), 100);
		Partido partido3 = new Partido(1, new Pais("Qatar", false, 'A', new Equipo("QFA", 0), 0, 0),
				new Pais("Senegal", true, 'A', new Equipo("SNG", 0), 0, 0), 100);
		Partido partido4 = new Partido(1, new Pais("P.Bajos", false, 'A', new Equipo("PBS", 0), 0, 0),
				new Pais("Ecuador", true, 'A', new Equipo("ECU", 0), 0, 0), 100);
		Partido partido5 = new Partido(1, new Pais("P.Bajos", true, 'A', new Equipo("PBS", 0), 0, 0),
				new Pais("Qatar", false, 'A', new Equipo("QFA", 0), 0, 0), 100);
		Partido partido6 = new Partido(1, new Pais("Ecuador", false, 'A', new Equipo("ECU", 0), 0, 0),
				new Pais("Senegal", true, 'A', new Equipo("SNG", 0), 0, 0), 100);
		todos.add(partido1);
		todos.add(partido2);
		todos.add(partido3);
		todos.add(partido4);
		todos.add(partido5);
		todos.add(partido6);
		/*
		 * Partido partido7 = new Partido (2,new Pais("Inglaterra",false,'B',new
		 * Equipo("ING",4),0,0), new Pais("Iran",true,'B',new Equipo("IRN",5),0,0),100);
		 * Partido partido8 = new Partido (2,new Pais("EstadosUnidos",false,'B',new
		 * Equipo("EEUU",4),0,0),new Pais("Gales",true,'B',new
		 * Equipo("GLS",5),0,0),100); Partido partido9 = new Partido (2,new
		 * Pais("Inglaterra",false,'B',new Equipo("ING",4),0,0), new
		 * Pais("EstadosUnidos",true,'B',new Equipo("EEUU",5),0,0),100); Partido
		 * partido10 = new Partido (2,new Pais("Gales",false,'B',new
		 * Equipo("GLS",4),0,0), new Pais("Iran",true,'B',new Equipo("IRN",5),0,0),100);
		 * Partido partido11 = new Partido (2,new Pais("Gales",false,'B',new
		 * Equipo("GLS",4),0,0), new Pais("Inglaterra",true,'B',new
		 * Equipo("ING",5),0,0),100); Partido partido12 = new Partido (2,new
		 * Pais("Iran",false,'B',new Equipo("IRN",4),0,0), new
		 * Pais("EstadosUnidos",true,'B',new Equipo("EEUU",5),0,0),100);
		 * 
		 * 
		 * Partido partido13 = new Partido (3,new Pais("Argentina",false,'C',new
		 * Equipo("ARG",4),0,0),new Pais("Arabia.s",true,'C',new
		 * Equipo("ARS",5),0,0),100); Partido partido14 = new Partido (3,new
		 * Pais("Mexico",false,'C',new Equipo("MEX",4),0,0), new
		 * Pais("Polonia",true,'C',new Equipo("PLN",5),0,0),100); Partido partido15 =
		 * new Partido (3,new Pais("Argentina",false,'C',new Equipo("ARG",4),0,0),new
		 * Pais("Mexico",true,'C',new Equipo("MEX",5),0,0),100); Partido partido16 = new
		 * Partido (3,new Pais("Polonia",false,'C',new Equipo("PLN",4),0,0), new
		 * Pais("Arabia.s",true,'C',new Equipo("ARS",5),0,0),100); Partido partido17 =
		 * new Partido (3,new Pais("Polonia",false,'C',new Equipo("PLN",4),0,0), new
		 * Pais("Argentina",true,'C',new Equipo("ARG",5),0,0),100); Partido partido18 =
		 * new Partido (3,new Pais("Arabia.s",false,'C',new Equipo("ARS",4),0,0),new
		 * Pais("Mexico",true,'C',new Equipo("MEX",5),0,0),100);
		 * 
		 * 
		 * Partido partido19 = new Partido (4,new Pais("Francia",false,'D',new
		 * Equipo("FRN",4),0,0), new Pais("Australia",true,'D',new
		 * Equipo("AUS",5),0,0),100); Partido partido20 = new Partido (4,new
		 * Pais("Dinamarca",false,'D',new Equipo("DNM",4),0,0),new
		 * Pais("Tunez",true,'D',new Equipo("TNZ",5),0,0),100); Partido partido21 = new
		 * Partido (4,new Pais("Francia",false,'D',new Equipo("FRN",4),0,0), new
		 * Pais("Dinamarca",true,'D',new Equipo("DNM",5),0,0),100); Partido partido22 =
		 * new Partido (4,new Pais("Tunez",false,'D',new Equipo("TNZ",4),0,0), new
		 * Pais("Australia",true,'D',new Equipo("AUS",5),0,0),100); Partido partido23 =
		 * new Partido (4,new Pais("Tunez",false,'D',new Equipo("TNZ",4),0,0), new
		 * Pais("Francia",true,'D',new Equipo("FRN",5),0,0),100); Partido partido24 =
		 * new Partido (4,new Pais("Australia",false,'D',new Equipo("AUS",4),0,0),new
		 * Pais("Dinamarca",true,'D',new Equipo("DNM",5),0,0),100);
		 * 
		 * 
		 * Partido partido25 = new Partido (5,new Pais("España",false,'E',new
		 * Equipo("ESP",4),0,0), new Pais("CostaRica",true,'E',new
		 * Equipo("CTR",5),0,0),100); Partido partido26 = new Partido (5,new
		 * Pais("Alemania",false,'E',new Equipo("ALM",4),0,0),new
		 * Pais("Japon",true,'E',new Equipo("JPN",5),0,0),100); Partido partido27 = new
		 * Partido (5,new Pais("España",false,'E',new Equipo("ESP",4),0,0), new
		 * Pais("Alemania",true,'D',new Equipo("ALM",5),0,0),100); Partido partido28 =
		 * new Partido (5,new Pais("Japon",false,'E',new Equipo("JPN",4),0,0), new
		 * Pais("CostaRica",true,'D',new Equipo("CTR",5),0,0),100); Partido partido29 =
		 * new Partido (5,new Pais("Japon",false,'E',new Equipo("JPN",4),0,0), new
		 * Pais("España",true,'D',new Equipo("ESP",5),0,0),100); Partido partido30 = new
		 * Partido (5,new Pais("CostaRica",false,'E',new Equipo("CTR",4),0,0),new
		 * Pais("Alemania",true,'D',new Equipo("ALM",5),0,0),100);
		 * 
		 * 
		 * Partido partido31 = new Partido (6,new Pais("Belgica",false,'F',new
		 * Equipo("BLG",4),0,0), new Pais("Canada",true,'F',new
		 * Equipo("CND",5),0,0),100); Partido partido32 = new Partido (6,new
		 * Pais("Marruecos",false,'F',new Equipo("MRC",4),0,0),new
		 * Pais("Croacia",true,'F',new Equipo("CRC",5),0,0),100); Partido partido33 =
		 * new Partido (6,new Pais("Belgica",false,'F',new Equipo("BLG",4),0,0), new
		 * Pais("Marruecos",true,'F',new Equipo("MRC",5),0,0),100); Partido partido34 =
		 * new Partido (6,new Pais("Croacia",false,'F',new Equipo("CRC",4),0,0), new
		 * Pais("Canada",true,'F',new Equipo("CND",5),0,0),100); Partido partido35 = new
		 * Partido (6,new Pais("Croacia",false,'F',new Equipo("CRC",4),0,0), new
		 * Pais("Belgica",true,'F',new Equipo("BLG",5),0,0),100); Partido partido36 =
		 * new Partido (6,new Pais("Canada",false,'F',new Equipo("CND",4),0,0), new
		 * Pais("Marruecos",true,'F',new Equipo("MRC",5),0,0),100);
		 * 
		 * 
		 * Partido partido37 = new Partido (7,new Pais("Brasil",false,'G',new
		 * Equipo("BRS",4),0,0), new Pais("Serbia",true,'G',new
		 * Equipo("SRB",5),0,0),100); Partido partido38 = new Partido (7,new
		 * Pais("Suiza",false,'G',new Equipo("SZA",4),0,0), new
		 * Pais("Camerun",true,'G',new Equipo("CMR",5),0,0),100); Partido partido39 =
		 * new Partido (7,new Pais("Brasil",false,'G',new Equipo("BRS",4),0,0), new
		 * Pais("Suiza",true,'G',new Equipo("SZA",5),0,0),100); Partido partido40 = new
		 * Partido (7,new Pais("Camerun",false,'G',new Equipo("CMR",4),0,0), new
		 * Pais("Serbia",true,'G',new Equipo("SRB",5),0,0),100); Partido partido41 = new
		 * Partido (7,new Pais("Camerun",false,'G',new Equipo("CMR",4),0,0), new
		 * Pais("Brasil",true,'G',new Equipo("BRS",5),0,0),100); Partido partido42 = new
		 * Partido (7,new Pais("Serbia",false,'G',new Equipo("SRB",4),0,0), new
		 * Pais("Suiza",true,'G',new Equipo("SZA",5),0,0),100);
		 * 
		 * 
		 * Partido partido43 = new Partido (8,new Pais("Portugal",false,'H',new
		 * Equipo("PRT",4),0,0),new Pais("Ghana",true,'H',new Equipo("GHN",5),0,0),100);
		 * Partido partido44 = new Partido (8,new Pais("Uruguay",false,'H',new
		 * Equipo("URG",4),0,0), new Pais("Corea.s",true,'H',new
		 * Equipo("CRS",5),0,0),100); Partido partido45 = new Partido (8,new
		 * Pais("Portugal",false,'H',new Equipo("PRT",4),0,0),new
		 * Pais("Uruguay",true,'H',new Equipo("URG",5),0,0),100); Partido partido46 =
		 * new Partido (8,new Pais("Corea.s",false,'H',new Equipo("CRS",4),0,0), new
		 * Pais("Ghana",true,'H',new Equipo("GHN",5),0,0),100); Partido partido47 = new
		 * Partido (8,new Pais("Corea.s",false,'H',new Equipo("CRS",4),0,0), new
		 * Pais("Portugal",true,'H',new Equipo("PRT",5),0,0),100); Partido partido48 =
		 * new Partido (8,new Pais("Ghana",false,'H',new Equipo("GHN",4),0,0), new
		 * Pais("Uruguay",true,'H',new Equipo("URG",5),0,0),100);
		 * 
		 * todos.add(partido7); todos.add(partido8); todos.add(partido9);
		 * todos.add(partido10); todos.add(partido11); todos.add(partido12);
		 * todos.add(partido13); todos.add(partido14); todos.add(partido15);
		 * todos.add(partido16); todos.add(partido17); todos.add(partido18);
		 * todos.add(partido19); todos.add(partido20); todos.add(partido21);
		 * todos.add(partido22); todos.add(partido23); todos.add(partido24);
		 * todos.add(partido25); todos.add(partido26); todos.add(partido27);
		 * todos.add(partido28); todos.add(partido29); todos.add(partido30);
		 * todos.add(partido31); todos.add(partido32); todos.add(partido33);
		 * todos.add(partido34); todos.add(partido35); todos.add(partido36);
		 * todos.add(partido37); todos.add(partido38); todos.add(partido39);
		 * todos.add(partido40); todos.add(partido41); todos.add(partido42);
		 * todos.add(partido43); todos.add(partido44); todos.add(partido45);
		 * todos.add(partido46); todos.add(partido47); todos.add(partido48);
		 */
		return todos;
	}

}
