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
		
		Pais pais = null;
		LinkedList<Partido> partidos = Partido.General();
		LinkedList<Pais> finalistas = new LinkedList<Pais>();
		
		boolean salir = false;
		LinkedList<Pais> paisesA = Pais.grupoA();
		LinkedList<Pais> paisesB = Pais.grupoB();
		LinkedList<Pais> paisesC = Pais.grupoC();
		LinkedList<Pais> paisesD = Pais.grupoD();
		LinkedList<Pais> paisesE = Pais.grupoE();
		LinkedList<Pais> paisesF = Pais.grupoF();
		LinkedList<Pais> paisesG = Pais.grupoG();
		LinkedList<Pais> paisesH = Pais.grupoH();
		
		//MENU INTERACTIVO
		do {
			int a = Integer.parseInt(JOptionPane.showInputDialog("BIENVENIDO\nComo quiere ingresar:\n1-Encargado\n2-Hincha\n3-Salir"));

			if (a == 1) {// MENU PRINCIPAL
				
				int menu = Integer.parseInt(JOptionPane.showInputDialog("HOLA ENCARGADO\n1-Buscar los datos de un partido\n2-Empezar a jugar las etapas del mundial"));
				switch (menu) {
				case 1:
					int res = Integer.parseInt(JOptionPane.showInputDialog("ENCARGADO\n1-Ver la tabla de un grupo\n2-Ver un partido"));
					if (res == 1) {
						pablo.buscarTabla(partidos);
					} else if (res == 2) {
						pablo.buscarPartidos(partidos);
					}
					break;
				case 2:
					int b = Integer.parseInt(JOptionPane.showInputDialog("ENCARGADO\nHasta que etapa desea que se juegue:\n1-Fase de grupos\n2-Octavos de final\n3-Cuartos de final\n4-Semifinales\n5-La gran final"));
					
					switch (b) {
					case 1:
						Pais.pasarOctavos(paisesA, paisesB, paisesC, paisesD, paisesE, paisesF, paisesG, paisesH);
						
						break;
					case 2:
						Pais.pasarCuartos(paisesA, paisesB, paisesC, paisesD, paisesE, paisesF, paisesG, paisesH);
						
						break;
					case 3:
						Pais.pasarSemi(paisesA, paisesB, paisesC, paisesD, paisesE, paisesF, paisesG, paisesH);
						
						break;
					case 4:
						Pais.pasarFinal(paisesA, paisesB, paisesC, paisesD, paisesE, paisesF, paisesG, paisesH);
						
						break;
					case 5:
						finalistas = Pais.pasarFinal(paisesA, paisesB, paisesC, paisesD, paisesE, paisesF, paisesG, paisesH);
						
						JOptionPane.showMessageDialog(null,	"1º lugar: " + finalistas.get(0).getNombre() + "\n2º lugar: " + finalistas.get(1).getNombre());
						break;
					}
					break;
				}
				
			} else if (a == 2) {
				menuHincha(paisesA, paisesB, paisesC, paisesD, paisesE, paisesF, paisesG, paisesH);
			} else {
				salir = true;
			}

		} while (!salir);
	
	}// termina el main
	
	public static void menuHincha(LinkedList<Pais> paisesA, LinkedList<Pais> paisesB,LinkedList<Pais> paisesC, LinkedList<Pais> paisesD, LinkedList<Pais> paisesE, LinkedList<Pais> paisesF,LinkedList<Pais> paisesG, LinkedList<Pais> paisesH) {
		int recom=0;
		int cant=0;
		
		LinkedList<Pais> octavos = new LinkedList<Pais>();
		LinkedList<Pais> cuartos = new LinkedList<Pais>();
		LinkedList<Pais> semis = new LinkedList<Pais>();
		LinkedList<Pais> finalistas = new LinkedList<Pais>();
		
		int d =  Integer.parseInt(JOptionPane.showInputDialog("HINCHA\nTENGA en cuenta que las apuestas sobre puntos solo se hacen en la fase de grupos,"
				+ "\nya que a partir de octavos NO se tiene en cuenta los puntos \nSobre que desea apostar:"
				+ "\n1-Cantidad de puntos de un partido (probabilidad de 10-1)\n2-Clasificacion de un Pais a una etapa (probabilidad de 6-1)"));
			switch (d) {
			case 1://apostar puntos
				String resul="Perdio la apuesta";
				recom=0;
				cant = 0;
				String pais = JOptionPane.showInputDialog("Ingrese el nombre del pais");
				int puntos = Integer.parseInt(JOptionPane.showInputDialog("ingrese los puntos con los que clasifico a OCTAVOS"));
				cant = Integer.parseInt(JOptionPane.showInputDialog("cuantas personas van apostar?"));
				for (int i = 0; i < cant; i++) {
					recom += Integer.parseInt(JOptionPane.showInputDialog("probabilidad 10-1, cuanto quiere apostar el hincha "+(i+1)+" ?"));							
				}
				octavos = Pais.pasarOctavos(paisesA, paisesB, paisesC, paisesD, paisesE, paisesF, paisesG, paisesH);
				
				for (Pais pais2 : octavos) {
					if (pais2.getNombre().equalsIgnoreCase(pais) && pais2.getPuntos()==puntos) {
							resul = "Pais: "+pais2.getNombre()+" puntos: "+pais2.getPuntos()+"\ngano la apuesta cada jugador gano: "+((recom*100)/cant);
					}
				}
				JOptionPane.showMessageDialog(null, resul);
				break;
			case 2:// apostar clasificacion
				recom=0;
				cant = 0;
				resul="Perdio la apuesta, No clasifico";
				String pais2 = JOptionPane.showInputDialog("Ingrese el nombre del pais");
				
				int etapa = Integer.parseInt(JOptionPane.showInputDialog("Ingrese hasta que etapa apuesta que clasifico el pais"));
				
				cant = Integer.parseInt(JOptionPane.showInputDialog("cuantas personas van apostar?"));
				for (int i = 0; i < cant; i++) {
					recom += Integer.parseInt(JOptionPane.showInputDialog("probabilidad 6-1, cuanto quiere apostar el hincha "+(i+1)+" ?"));							
				}
				
				switch (etapa) {
				case 1://octavos
					octavos = Pais.pasarOctavos(paisesA, paisesB, paisesC, paisesD, paisesE, paisesF, paisesG, paisesH);
					for (Pais pais1 : octavos) {
						if (pais1.getNombre().equalsIgnoreCase(pais2) ) {
								resul = "El Pais: "+pais2+" clasifico a octavos\ngano la apuesta cada jugador gano: "+((recom*60)/cant);
						}
					}
					JOptionPane.showMessageDialog(null, resul);
					break;
				case 2:// cuartos
					cuartos = Pais.pasarCuartos(paisesA, paisesB, paisesC, paisesD, paisesE, paisesF, paisesG, paisesH);
					for (Pais pais1 : cuartos) {
						if (pais1.getNombre().equalsIgnoreCase(pais2) ) {
								resul = "El Pais: "+pais2+" clasifico a cuartos\ngano la apuesta cada jugador gano: "+((recom*60)/cant);
						}
					}
					JOptionPane.showMessageDialog(null, resul);
					break;
				case 3:// semis
					semis = Pais.pasarSemi(paisesA, paisesB, paisesC, paisesD, paisesE, paisesF, paisesG, paisesH);
					for (Pais pais1 : semis) {
						if (pais1.getNombre().equalsIgnoreCase(pais2) ) {
								resul = "El Pais: "+pais2+" clasifico a semiFinal\ngano la apuesta cada jugador gano: "+((recom*60)/cant);
						}
					}
					JOptionPane.showMessageDialog(null, resul);
					break;
				case 4:// final
					finalistas = Pais.pasarFinal(paisesA, paisesB, paisesC, paisesD, paisesE, paisesF, paisesG, paisesH);
					
					for (Pais pais1 : finalistas) {
						if (pais1.getNombre().equalsIgnoreCase(pais2) ) {
								resul = "El Pais: "+pais2+" clasifico a la gran final\ngano la apuesta cada jugador gano: "+((recom*60)/cant);
						}
					}
					JOptionPane.showMessageDialog(null, resul);
					break;
				}
				break;
			
			}
		
	}
	
	public static Partido crearPartido(int i, Pais pais1, Pais pais2){
		//int id, Pais equipo1, Pais equipo2, int duracion
		Partido formado = new Partido (i,pais1,	pais2,(int)(Math.random()*20+90));// duracion del partido entre 90 y 100 minutos
		return formado;
	}


}
