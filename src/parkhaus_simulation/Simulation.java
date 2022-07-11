package parkhaus_simulation;

import java.util.ArrayList;
import java.util.List;


public class Simulation {
	

	private String freierPlatz="kein Fahrzeug";
	public Fahrzeug [][] parkhaus;
	public List<Fahrzeug> fahrzeugliste = new ArrayList<Fahrzeug>();
	

	/* ----------------------------------------------------------------------------------	
	 * Methode zur Kennzeichenpruefung beim Erstellen eines Fahrzeuges. Es wird 
	 * nacheinander jedes Fahrzeug aus der ArrayList als vergleichsFahrzeug geholt
	 * und mit dem eingegebenen Kennzeichen verglichen.
	 * ----------------------------------------------------------------------------------*/	
	
	public boolean Kennzeichenpruefung(String kennzeichen) {
		
		Boolean existiert = false;
		
		for(Fahrzeug vergleichsFahrzeug : fahrzeugliste) {
			if(vergleichsFahrzeug.getKennzeichen().equals(kennzeichen)){
				existiert = true;	
			}
		}
			return existiert;
	}
	
	/* ----------------------------------------------------------------------------------	
	 * Methode zum Holen des Fahrzeuges aus der ArrayList wenn es bereits existiert
	 * aber nicht im Parkhaus geparkt ist 
	 * ----------------------------------------------------------------------------------*/	
	
	public Fahrzeug holeFahrzeug(String kennzeichen) {
		
		for(Fahrzeug vergleichsFahrzeug : fahrzeugliste) {
			if(vergleichsFahrzeug.getKennzeichen().equals(kennzeichen)){
				return vergleichsFahrzeug;	
			}
		}
	return null;	
	}
	
		
	/* ----------------------------------------------------------------------------------
	 * Methode zum automatischen Parken eines Fahzeuges im naechsten freien Platz. 
	 * Der naechste freie Platz im Array (also dem Parkhaus) wird mittels einer
	 * for Schleife ermittelt und bei Erfolg (freierPlatz=true) wird das Fahrzeug 
	 * in diesem gespeichert (parkhaus[i][j]=fahrzeug). 
	 * ----------------------------------------------------------------------------------*/
	
	public String AutomatischParken(Fahrzeug fahrzeug) {
				
		Boolean freierPlatz = false;
		
		outerloop:
		for(int i=0;i<parkhaus.length;i++) {
			for(int j=0;j<parkhaus[0].length;j++) {	
				
					if(parkhaus[i][j]==null) {													
						parkhaus[i][j]=fahrzeug;
						freierPlatz=true;						
						break outerloop;
					}	
			}
		}		
		if(freierPlatz) {
			return "Das Fahrzeug mit dem Kennzeichen" + " " + fahrzeug.getKennzeichen() + " " + "wurde erstellt und geparkt";
		}
		else {
			return "Das Parkhaus ist voll!";
		}	
	}	
	
	/* ----------------------------------------------------------------------------------
	 * Methode zum Ausparken eines Fahzeuges aus dem Parkhaus	
	 * ----------------------------------------------------------------------------------*/	
		
	public void entparken(String kennzeichen) {
					
			for(int i=0;i<parkhaus.length;i++) {
				for(int j=0;j<parkhaus[0].length;j++) {
					
					try {
						if(kennzeichen.equals(parkhaus[i][j].getKennzeichen())) {
							parkhaus[i][j]=null;
						}
					} 
					catch(NullPointerException e) {					 
					}				
				}
			}			
	}
	
 
	/* ----------------------------------------------------------------------------------
	 * Methode zum Abfragen der Parkebene und des Parkplatzes mittels Kennzeichen eines
	 * Fahrzeuges	
	 * ----------------------------------------------------------------------------------*/
		
	public String getParkplatz(String kennzeichen) {
				
		
		for(int i=0;i<parkhaus.length;i++) {
			for(int j=0;j<parkhaus[0].length;j++) {
				
				try {
					if(kennzeichen.equals(parkhaus[i][j].getKennzeichen())) {
						return "Kennzeichen: " + parkhaus[i][j].getKennzeichen() + ", Parkebene: " 
								+ i + ", Parkplatz: "+j+", Fahrzeugtyp: "+parkhaus[i][j].getTyp();
					}
					
				} 
				catch(NullPointerException e) {
					 
				}				
			}
		}		
		return "Kennzeichen" + " " + kennzeichen + " " + "wurde nicht gefunden";
	}
	
	/* ----------------------------------------------------------------------------------
	 * Methode zum Abfragen aller belegten Parkplätze des Parkhauses	
	 * ----------------------------------------------------------------------------------*/
	
	public String getBelegtePlaetze() {
		
		String Ausgabe="";
		
	try {
		for(int i=0;i<parkhaus.length;i++) {
			for(int j=0;j<parkhaus[0].length;j++) {
				
					if(parkhaus[i][j]!=null) {
						Ausgabe+="Kennzeichen: "+parkhaus[i][j].getKennzeichen()+", Parkebene: "
							+i+", Parkplatz: "+j+", Fahrzeugtyp: "+parkhaus[i][j].getTyp()+'\n';
					}									
			}
		}
	} 
	catch(NullPointerException e) {
		 
	}	
		return Ausgabe;
	}	
		
	/* ----------------------------------------------------------------------------------
	 * Methode zum Abfragen aller freien Parkplätze des Parkhauses	
	 * ----------------------------------------------------------------------------------*/
	
	public String getFreiePlaetze() {
		
			String Ausgabe="";
			int Zähler=0;
	
		try {
			for(int i=0;i<parkhaus.length;i++) {
				for(int j=0;j<parkhaus[0].length;j++) {
				
						if(parkhaus[i][j]==null) {
							Zähler++;							
							Ausgabe+="Parkebene: "+i+", Parkplatz: "+j+'\n';
						}							 			
				}
			}
		} 
		catch(NullPointerException e) {	 
		}
		return "Es gibt " + Zähler + " freie Plätze im Parkhaus. \n\n" + Ausgabe;	
	}
	
	
	/* ----------------------------------------------------------------------------------	
	 * Methode zum Abfragen ob ein Kennzeichen, dass bei der Erstellung eines Fahrzeuges
	 * bereits existiert, sich innerhalb oder ausserhalb des Parkhauses befindet.
	 * Sollte es bereits ausserhalb existieren dann wird es mit der	
	 * ----------------------------------------------------------------------------------*/
			
		public Boolean getParkstatus(String kennzeichen) {
					
			boolean imParkhaus = false;
			
			for(int i=0;i<parkhaus.length;i++) {
				for(int j=0;j<parkhaus[0].length;j++) {
					
					try {
						if(kennzeichen.equals(parkhaus[i][j].getKennzeichen())) {
							imParkhaus = true;
						}
					} 
					catch(NullPointerException e) {	 
					}				
				}
			}		
			return imParkhaus;
		}


}
