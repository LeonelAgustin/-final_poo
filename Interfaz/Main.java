package Interfaz;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import Datos.Encargado;
import Datos.Equipo;
import Datos.Pais;
import Datos.Partido;

public class Main {

	public static void main(String[] args) {
		Encargado pablo = new Encargado (01,"Pablo");
		LinkedList<Partido> partidos = General();
		LinkedList<Pais> ordenada= new LinkedList<Pais>();
		
		LinkedList<Pais> paisesA = grupoA();
		LinkedList<Pais> paisesB = grupoB();
		LinkedList<Pais> paisesC = grupoC();
		LinkedList<Pais> paisesD = grupoD();
		LinkedList<Pais> paisesE = grupoE();
		LinkedList<Pais> paisesF = grupoF();
		LinkedList<Pais> paisesG = grupoG();
		LinkedList<Pais> paisesH = grupoH();
		// CAMIBAR GOLES DE CADA PAIS
		String mostrar1 = "Grupo A\n";
		String mostrar2 = "Grupo A\n";
		String mostrar3 = "";
		
		for (Pais pais : paisesA) {
			mostrar1 += "pais: "+pais.getNombre()+"\npuntos= "+pais.getPuntos()+"\n";	
		}
		
		JOptionPane.showMessageDialog(null, mostrar1);
		
		// goles aleatorios para cada pais
		paisesA = puntosGrupo(paisesA);
		
		for (Pais pais : paisesA) {
			mostrar2 += "pais= "+pais.getNombre()+"\npuntos= "+pais.getPuntos()+"\n";	
		}
		
		// la funcion cambia los goles de cada pais
		JOptionPane.showMessageDialog(null, mostrar2);
		
		// ordenar lista de paises
		
		int []puntos= new int[6];
		int i=0;
		// paso los goles a un array comun
		for (Pais pais : paisesA) {
			puntos[i]=pais.getPuntos();
			i++;
		}
				
		puntos=burbuja(puntos);// ordeno los goles de mayor a menor
		String primero = "";
		String segundo = "";
		
		//System.out.println("puntos 6: "+puntos[5]);
		//System.out.println("puntos 5: "+puntos[4]);
	for (Pais pais : paisesA) {
		System.out.println(pais);
		
	}
		for (Pais pais : paisesA) {
			
			if(pais.getPuntos()==puntos[5]) {
				primero= pais.getNombre();
				System.out.println(pais.getNombre());
				//JOptionPane primer pais
			}
			
			if(pais.getPuntos()==puntos[4]) {
				segundo = pais.getNombre();
				//JOptionPane segundo pais
			}
		}
		
		JOptionPane.showMessageDialog(null, "Primero: "+primero+"\nSegundo: "+segundo);
		
	}
	
	private static int [] burbuja(int []goles) {
		for (int x = 0; x < goles.length; x++) {
	        // AquÌ "y" se detiene antes de llegar
	        // a length - 1 porque dentro del for, accedemos
	        // al siguiente elemento con el Ìndice actual + 1
	        for (int y = 0; y < goles.length - 1; y++) {
	            int elementoActual = goles[y],
	                    elementoSiguiente = goles[y + 1];
	            if (elementoActual > elementoSiguiente) {
	                // Intercambiar
	                goles[y] = elementoSiguiente;
	                goles[y + 1] = elementoActual;
	            }
	        }
	    }
		return goles;
	}
	
	public static LinkedList<Pais> puntosGrupo(LinkedList<Pais> paises) {
		
		for (Pais pais : paises) {
			pais.setPuntos((int)(Math.random()*10));
		}
		
		return paises;
	}
	
	public static LinkedList<Partido> golesPartidos(LinkedList<Partido> partidos) {
		
		for (Partido partido : partidos) {
			partido.getEquipo1().setGoles((int)(Math.random()*5));
			partido.getEquipo2().setGoles((int)(Math.random()*5));
		}
		
		return partidos;
	}
	
	
	public static LinkedList<Pais> grupoA() {
		LinkedList<Pais> paises1 = new LinkedList<Pais>();
		Pais qatar = 	new Pais("Qatar",false,'A',new Equipo("QFA",4),0,0);
		Pais ecuador = 	new Pais("Ecuador",true,'A',new Equipo("ECU",5),0,0);
		Pais senegal = 	new Pais("Senegal",false,'A',new Equipo("SNG",4),0,0);
		Pais paisesBajos = new Pais("P.Bajos",false,'A',new Equipo("PBS",4),0,0);
		paises1.add(qatar);
		paises1.add(ecuador);
		paises1.add(senegal);
		paises1.add(paisesBajos);

		return paises1;
	}
	
	public static LinkedList<Pais> grupoB() {
		LinkedList<Pais> paises1 = new LinkedList<Pais>();
		Pais inglaterra = new Pais("Inglaterra",false,'B',new Equipo("ING",4),0,0);
		Pais iran = 	new Pais("Iran",true,'B',new Equipo("IRN",5),0,0);
		Pais estadosUnidos = new Pais("EstadosUnidos",false,'B',new Equipo("EEUU",4),0,0);
		Pais gales = 	new Pais("Gales",false,'B',new Equipo("GLS",4),0,0);
		paises1.add(inglaterra);
		paises1.add(iran);
		paises1.add(estadosUnidos);
		paises1.add(gales);
		return paises1;
	}
	
	
	
	public static LinkedList<Pais> grupoC() {
		LinkedList<Pais> paises1 = new LinkedList<Pais>();
		Pais argentina = new Pais("Argentina",false,'C',new Equipo("ARG",4),0,0);
		Pais arabiaSaudita = new Pais("Arabia.s",true,'C',new Equipo("ARS",5),0,0);
		Pais mexico = 	new Pais("Mexico",false,'C',new Equipo("MEX",4),0,0);
		Pais polonia = 	new Pais("Polonia",false,'C',new Equipo("PLN",4),0,0);
		paises1.add(argentina);
		paises1.add(arabiaSaudita);
		paises1.add(mexico);
		paises1.add(polonia);
		return paises1;
	}
	
	public static LinkedList<Pais> grupoD() {
		LinkedList<Pais> paises1 = new LinkedList<Pais>();
		Pais francia = 	new Pais("Francia",false,'D',new Equipo("FRN",4),0,0);
		Pais australia = new Pais("Australia",false,'D',new Equipo("AUS",4),0,0);
		Pais dinamarca = new Pais("Dinamarca",false,'D',new Equipo("DNM",4),0,0);
		Pais tunez = 	new Pais("Tunez",false,'D',new Equipo("TNZ",4),0,0);
		paises1.add(francia);
		paises1.add(australia);
		paises1.add(dinamarca);
		paises1.add(tunez);
		return paises1;
	}
	public static LinkedList<Pais> grupoE() {
		LinkedList<Pais> paises1 = new LinkedList<Pais>();
		Pais espana = 	new Pais("Espania",false,'E',new Equipo("ESP",4),0,0);
		Pais costaRica = new Pais("CostaRica",false,'E',new Equipo("CTR",4),0,0);
		Pais alemania = new Pais("Alemania",false,'E',new Equipo("ALM",4),0,0);
		Pais japon = 	new Pais("Japon",false,'E',new Equipo("JPN",4),0,0);
		paises1.add(espana);
		paises1.add(costaRica);
		paises1.add(alemania);
		paises1.add(japon);
		return paises1;
	}
	public static LinkedList<Pais> grupoF() {
		LinkedList<Pais> paises1 = new LinkedList<Pais>();
		Pais belgica = 	new Pais("Belgica",false,'F',new Equipo("BLG",4),0,0);
		Pais canada = 	new Pais("Canada",false,'F',new Equipo("CND",4),0,0);
		Pais marruecos = new Pais("Marruecos",false,'F',new Equipo("MRC",4),0,0);
		Pais croacia = 	new Pais("Croacia",false,'F',new Equipo("CRC",4),0,0);
		paises1.add(belgica);
		paises1.add(canada);
		paises1.add(marruecos);
		paises1.add(croacia);
		return paises1;
	}
	
	public static LinkedList<Pais> grupoG() {
		LinkedList<Pais> paises1 = new LinkedList<Pais>();
		Pais brasil = 	new Pais("Brasil",false,'G',new Equipo("BRS",4),0,0);
		Pais serbia = 	new Pais("Serbia",false,'G',new Equipo("SRB",4),0,0);
		Pais suiza = 	new Pais("Suiza",false,'G',new Equipo("SZA",4),0,0);
		Pais camerun = 	new Pais("Camerun",false,'G',new Equipo("CMR",4),0,0);
		paises1.add(brasil);
		paises1.add(serbia);
		paises1.add(suiza);
		paises1.add(camerun);
		return paises1;
	}
	public static LinkedList<Pais> grupoH() {
		LinkedList<Pais> paises1 = new LinkedList<Pais>();
		Pais portugal = new Pais("Portugal",false,'H',new Equipo("PRT",4),0,0);
		Pais ghana = 	new Pais("Ghana",false,'H',new Equipo("GHN",4),0,0);
		Pais uruguay = 	new Pais("Uruguay",false,'H',new Equipo("URG",4),0,0);
		Pais coreaSur = new Pais("Corea.s",false,'H',new Equipo("CRS",4),0,0);
				
		paises1.add(portugal);
		paises1.add(ghana);
		paises1.add(uruguay);
		paises1.add(coreaSur);
		return paises1;
	}
	
public static LinkedList<Partido> General(){
		// int id, Pais equipo1, Pais equipo2, int duracion
		// String nombre, boolean clasificado, char grupo, Equipo representante, int puntos, int posicion 
		LinkedList<Partido> todos = new LinkedList<Partido>();
		Partido partido1 = new Partido (1,new Pais("Qatar",false,'A',new Equipo("QFA",0),0,0),	new Pais("Ecuador",true,'A',new Equipo("ECU",0),0,0),100);
		Partido partido2 = new Partido (1,new Pais("Senegal",false,'A',new Equipo("SNG",0),0,0),	new Pais("P.Bajos",true,'A',new Equipo("PBS",0),0,0),100);
		Partido partido3 = new Partido (1,new Pais("Qatar",false,'A',new Equipo("QFA",0),0,0),	new Pais("Senegal",true,'A',new Equipo("SNG",0),0,0),100);
		Partido partido4 = new Partido (1,new Pais("P.Bajos",false,'A',new Equipo("PBS",0),0,0),	new Pais("Ecuador",true,'A',new Equipo("ECU",0),0,0),100);
		Partido partido5 = new Partido (1,new Pais("P.Bajos",true,'A',new Equipo("PBS",0),0,0),	new Pais("Qatar",false,'A',new Equipo("QFA",0),0,0),100);
		Partido partido6 = new Partido (1,new Pais("Ecuador",false,'A',new Equipo("ECU",0),0,0),	new Pais("Senegal",true,'A',new Equipo("SNG",0),0,0),100);
		todos.add(partido1);
		todos.add(partido2);
		todos.add(partido3);
		todos.add(partido4);
		todos.add(partido5);
		todos.add(partido6);
		/*
		Partido partido7 = new Partido (2,new Pais("Inglaterra",false,'B',new Equipo("ING",4),0,0),	new Pais("Iran",true,'B',new Equipo("IRN",5),0,0),100);
		Partido partido8 = new Partido (2,new Pais("EstadosUnidos",false,'B',new Equipo("EEUU",4),0,0),new Pais("Gales",true,'B',new Equipo("GLS",5),0,0),100);
		Partido partido9 = new Partido (2,new Pais("Inglaterra",false,'B',new Equipo("ING",4),0,0),	new Pais("EstadosUnidos",true,'B',new Equipo("EEUU",5),0,0),100);
		Partido partido10 = new Partido (2,new Pais("Gales",false,'B',new Equipo("GLS",4),0,0),		new Pais("Iran",true,'B',new Equipo("IRN",5),0,0),100);
		Partido partido11 = new Partido (2,new Pais("Gales",false,'B',new Equipo("GLS",4),0,0),		new Pais("Inglaterra",true,'B',new Equipo("ING",5),0,0),100);
		Partido partido12 = new Partido (2,new Pais("Iran",false,'B',new Equipo("IRN",4),0,0),		new Pais("EstadosUnidos",true,'B',new Equipo("EEUU",5),0,0),100);
		
		
		Partido partido13 = new Partido (3,new Pais("Argentina",false,'C',new Equipo("ARG",4),0,0),new Pais("Arabia.s",true,'C',new Equipo("ARS",5),0,0),100);
		Partido partido14 = new Partido (3,new Pais("Mexico",false,'C',new Equipo("MEX",4),0,0),	new Pais("Polonia",true,'C',new Equipo("PLN",5),0,0),100);
		Partido partido15 = new Partido (3,new Pais("Argentina",false,'C',new Equipo("ARG",4),0,0),new Pais("Mexico",true,'C',new Equipo("MEX",5),0,0),100);
		Partido partido16 = new Partido (3,new Pais("Polonia",false,'C',new Equipo("PLN",4),0,0),	new Pais("Arabia.s",true,'C',new Equipo("ARS",5),0,0),100);
		Partido partido17 = new Partido (3,new Pais("Polonia",false,'C',new Equipo("PLN",4),0,0),	new Pais("Argentina",true,'C',new Equipo("ARG",5),0,0),100);
		Partido partido18 = new Partido (3,new Pais("Arabia.s",false,'C',new Equipo("ARS",4),0,0),new Pais("Mexico",true,'C',new Equipo("MEX",5),0,0),100);
	
		
		Partido partido19 = new Partido (4,new Pais("Francia",false,'D',new Equipo("FRN",4),0,0),	new Pais("Australia",true,'D',new Equipo("AUS",5),0,0),100);
		Partido partido20 = new Partido (4,new Pais("Dinamarca",false,'D',new Equipo("DNM",4),0,0),new Pais("Tunez",true,'D',new Equipo("TNZ",5),0,0),100);
		Partido partido21 = new Partido (4,new Pais("Francia",false,'D',new Equipo("FRN",4),0,0),	new Pais("Dinamarca",true,'D',new Equipo("DNM",5),0,0),100);
		Partido partido22 = new Partido (4,new Pais("Tunez",false,'D',new Equipo("TNZ",4),0,0),	new Pais("Australia",true,'D',new Equipo("AUS",5),0,0),100);
		Partido partido23 = new Partido (4,new Pais("Tunez",false,'D',new Equipo("TNZ",4),0,0),	new Pais("Francia",true,'D',new Equipo("FRN",5),0,0),100);
		Partido partido24 = new Partido (4,new Pais("Australia",false,'D',new Equipo("AUS",4),0,0),new Pais("Dinamarca",true,'D',new Equipo("DNM",5),0,0),100);
		
		
		Partido partido25 = new Partido (5,new Pais("Espa√±a",false,'E',new Equipo("ESP",4),0,0),	new Pais("CostaRica",true,'E',new Equipo("CTR",5),0,0),100);
		Partido partido26 = new Partido (5,new Pais("Alemania",false,'E',new Equipo("ALM",4),0,0),new Pais("Japon",true,'E',new Equipo("JPN",5),0,0),100);
		Partido partido27 = new Partido (5,new Pais("Espa√±a",false,'E',new Equipo("ESP",4),0,0),	new Pais("Alemania",true,'D',new Equipo("ALM",5),0,0),100);
		Partido partido28 = new Partido (5,new Pais("Japon",false,'E',new Equipo("JPN",4),0,0),	new Pais("CostaRica",true,'D',new Equipo("CTR",5),0,0),100);
		Partido partido29 = new Partido (5,new Pais("Japon",false,'E',new Equipo("JPN",4),0,0),	new Pais("Espa√±a",true,'D',new Equipo("ESP",5),0,0),100);
		Partido partido30 = new Partido (5,new Pais("CostaRica",false,'E',new Equipo("CTR",4),0,0),new Pais("Alemania",true,'D',new Equipo("ALM",5),0,0),100);
		
		
		Partido partido31 = new Partido (6,new Pais("Belgica",false,'F',new Equipo("BLG",4),0,0),	new Pais("Canada",true,'F',new Equipo("CND",5),0,0),100);
		Partido partido32 = new Partido (6,new Pais("Marruecos",false,'F',new Equipo("MRC",4),0,0),new Pais("Croacia",true,'F',new Equipo("CRC",5),0,0),100);
		Partido partido33 = new Partido (6,new Pais("Belgica",false,'F',new Equipo("BLG",4),0,0),	new Pais("Marruecos",true,'F',new Equipo("MRC",5),0,0),100);
		Partido partido34 = new Partido (6,new Pais("Croacia",false,'F',new Equipo("CRC",4),0,0),	new Pais("Canada",true,'F',new Equipo("CND",5),0,0),100);
		Partido partido35 = new Partido (6,new Pais("Croacia",false,'F',new Equipo("CRC",4),0,0),	new Pais("Belgica",true,'F',new Equipo("BLG",5),0,0),100);
		Partido partido36 = new Partido (6,new Pais("Canada",false,'F',new Equipo("CND",4),0,0),	new Pais("Marruecos",true,'F',new Equipo("MRC",5),0,0),100);
		
		
		Partido partido37 = new Partido (7,new Pais("Brasil",false,'G',new Equipo("BRS",4),0,0),	new Pais("Serbia",true,'G',new Equipo("SRB",5),0,0),100);
		Partido partido38 = new Partido (7,new Pais("Suiza",false,'G',new Equipo("SZA",4),0,0),	new Pais("Camerun",true,'G',new Equipo("CMR",5),0,0),100);
		Partido partido39 = new Partido (7,new Pais("Brasil",false,'G',new Equipo("BRS",4),0,0),	new Pais("Suiza",true,'G',new Equipo("SZA",5),0,0),100);
		Partido partido40 = new Partido (7,new Pais("Camerun",false,'G',new Equipo("CMR",4),0,0),	new Pais("Serbia",true,'G',new Equipo("SRB",5),0,0),100);
		Partido partido41 = new Partido (7,new Pais("Camerun",false,'G',new Equipo("CMR",4),0,0),	new Pais("Brasil",true,'G',new Equipo("BRS",5),0,0),100);
		Partido partido42 = new Partido (7,new Pais("Serbia",false,'G',new Equipo("SRB",4),0,0),	new Pais("Suiza",true,'G',new Equipo("SZA",5),0,0),100);
		
		
		Partido partido43 = new Partido (8,new Pais("Portugal",false,'H',new Equipo("PRT",4),0,0),new Pais("Ghana",true,'H',new Equipo("GHN",5),0,0),100);
		Partido partido44 = new Partido (8,new Pais("Uruguay",false,'H',new Equipo("URG",4),0,0),	new Pais("Corea.s",true,'H',new Equipo("CRS",5),0,0),100);
		Partido partido45 = new Partido (8,new Pais("Portugal",false,'H',new Equipo("PRT",4),0,0),new Pais("Uruguay",true,'H',new Equipo("URG",5),0,0),100);
		Partido partido46 = new Partido (8,new Pais("Corea.s",false,'H',new Equipo("CRS",4),0,0),	new Pais("Ghana",true,'H',new Equipo("GHN",5),0,0),100);
		Partido partido47 = new Partido (8,new Pais("Corea.s",false,'H',new Equipo("CRS",4),0,0),	new Pais("Portugal",true,'H',new Equipo("PRT",5),0,0),100);
		Partido partido48 = new Partido (8,new Pais("Ghana",false,'H',new Equipo("GHN",4),0,0),	new Pais("Uruguay",true,'H',new Equipo("URG",5),0,0),100);
		
		todos.add(partido7);
		todos.add(partido8);
		todos.add(partido9);
		todos.add(partido10);
		todos.add(partido11);
		todos.add(partido12);
		todos.add(partido13);
		todos.add(partido14);
		todos.add(partido15);
		todos.add(partido16);
		todos.add(partido17);
		todos.add(partido18);
		todos.add(partido19);
		todos.add(partido20);
		todos.add(partido21);
		todos.add(partido22);
		todos.add(partido23);
		todos.add(partido24);
		todos.add(partido25);
		todos.add(partido26);
		todos.add(partido27);
		todos.add(partido28);
		todos.add(partido29);
		todos.add(partido30);
		todos.add(partido31);
		todos.add(partido32);
		todos.add(partido33);
		todos.add(partido34);
		todos.add(partido35);
		todos.add(partido36);
		todos.add(partido37);
		todos.add(partido38);
		todos.add(partido39);
		todos.add(partido40);
		todos.add(partido41);
		todos.add(partido42);
		todos.add(partido43);
		todos.add(partido44);
		todos.add(partido45);
		todos.add(partido46);
		todos.add(partido47);
		todos.add(partido48);
		*/
		return todos;
	}

}
