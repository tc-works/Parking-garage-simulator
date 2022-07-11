package parkhaus_simulation;

public class Parkhaus {
	
	private int parkdecks;
	private int parkplaetze;
	
	public Fahrzeug [][] parkhaus;
		
/* ----------------------------------------------------------------------------------
 * Das Parkhaus wird mit einem zweidimensionalen Array erstellt in dem nur Objekte 
 * der Klasse Fahrzeug gespeichert werden. Die Anzahl der Zeilen des Arrays entspricht
 * der Anzahl der eingegbenen Parkdecks und die Anzahl der Spalten des Arrays der
 * Anzahl der eingegeben Parkplaetze. 
 * ----------------------------------------------------------------------------------*/
			
		public Parkhaus(int parkdecks, int parkplaetze){
			
			parkhaus = new Fahrzeug [parkdecks][parkplaetze];
		
		}
	
	
}
