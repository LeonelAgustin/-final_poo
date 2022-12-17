package Datos;

import java.util.LinkedList;

public class Partido {
	private int id;
	private Pais equipo1;
	private Pais equipo2;
	private int duracion;
	
	public Partido(int id, Pais equipo1, Pais equipo2, int duracion) {
		super();
		this.id = id;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		this.duracion = duracion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pais getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(Pais equipo1) {
		this.equipo1 = equipo1;
	}
	public Pais getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Pais equipo2) {
		this.equipo2 = equipo2;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	@Override
	public String toString() {
		return "Partido [id=" + id + ", equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", duracion=" + duracion + "]";
	}
	
	
	
	public static LinkedList<Partido> General(){
		
		LinkedList<Partido> todos = new LinkedList<Partido>();
		Partido partido1 = new Partido (1,new Pais("Qatar",false,'A',new Equipo("QFA",0),0,0),	new Pais("Ecuador",true,'A',new Equipo("ECU",0),0,0),100);
		Partido partido2 = new Partido (1,new Pais("Senegal",false,'A',new Equipo("SNG",0),0,0),	new Pais("P.Bajos",true,'A',new Equipo("PBS",0),0,0),100);
		Partido partido3 = new Partido (1,new Pais("Qatar",false,'A',new Equipo("QFA",0),0,0),	new Pais("Senegal",true,'A',new Equipo("SNG",0),0,0),100);
		Partido partido4 = new Partido (1,new Pais("P.Bajos",false,'A',new Equipo("PBS",0),0,0),	new Pais("Ecuador",true,'A',new Equipo("ECU",0),0,0),100);
		Partido partido5 = new Partido (1,new Pais("P.Bajos",true,'A',new Equipo("PBS",0),0,0),	new Pais("Qatar",false,'A',new Equipo("QFA",0),0,0),100);
		Partido partido6 = new Partido (1,new Pais("Ecuador",false,'A',new Equipo("ECU",0),0,0),	new Pais("Senegal",true,'A',new Equipo("SNG",0),0,0),100);
		
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
		
		
		Partido partido25 = new Partido (5,new Pais("España",false,'E',new Equipo("ESP",4),0,0),	new Pais("CostaRica",true,'E',new Equipo("CTR",5),0,0),100);
		Partido partido26 = new Partido (5,new Pais("Alemania",false,'E',new Equipo("ALM",4),0,0),new Pais("Japon",true,'E',new Equipo("JPN",5),0,0),100);
		Partido partido27 = new Partido (5,new Pais("España",false,'E',new Equipo("ESP",4),0,0),	new Pais("Alemania",true,'D',new Equipo("ALM",5),0,0),100);
		Partido partido28 = new Partido (5,new Pais("Japon",false,'E',new Equipo("JPN",4),0,0),	new Pais("CostaRica",true,'D',new Equipo("CTR",5),0,0),100);
		Partido partido29 = new Partido (5,new Pais("Japon",false,'E',new Equipo("JPN",4),0,0),	new Pais("España",true,'D',new Equipo("ESP",5),0,0),100);
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
		todos.add(partido1);
		todos.add(partido2);
		todos.add(partido3);
		todos.add(partido4);
		todos.add(partido5);
		todos.add(partido6);
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
		
		return todos;
	}
}
