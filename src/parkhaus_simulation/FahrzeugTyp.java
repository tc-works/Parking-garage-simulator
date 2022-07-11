package parkhaus_simulation;

/* ----------------------------------------------------------------------------------
 * Die Klasse FahrzeugTyp ist abstract damit kein Objekt von dieser Klasse erstellt
 * werden kann, da diese nur zum Definieren der Eigenschaft fahrzeugTyp der Klasse 
 * Fahrzeug als "Auto" und "Motorrad" dient.	
 * ----------------------------------------------------------------------------------*/

public abstract class FahrzeugTyp{
	
	public String getTyp() {
		return null;
	}
}

/* ----------------------------------------------------------------------------------
 * Kindklasse Auto zum Definieren der Eigenschaft Typ als Auto	
 * ----------------------------------------------------------------------------------*/

class Auto extends FahrzeugTyp{
	
	private String Typ = "Auto";
	
	public Auto() {		
	}
	
	public String getTyp() {
		return Typ;
	}
}

/* ----------------------------------------------------------------------------------
 * Kindklasse Motorrad zum Definieren der Eigenschaft Typ als Motorrad	
 * ----------------------------------------------------------------------------------*/

class Motorrad extends FahrzeugTyp{
	
	private String Typ = "Motorrad";
	
	public Motorrad() {
	}
	
	public String getTyp() {
		return Typ;
	}
}
