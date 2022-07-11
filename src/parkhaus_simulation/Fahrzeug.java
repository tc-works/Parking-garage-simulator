package parkhaus_simulation;

import java.util.Objects;

/* ----------------------------------------------------------------------------------
 * Von der Klasse Fahrzeug werden Objekte erzeugt die im Parkhaus dann parken können.
 * Fahrzeuge haben jeweils die Attribute Kennzeichen und FahrzeugTyp. Durch die Klasse
 * FahzeugTyp werden die Werte "Auto" und "Motorrad" fuer fahrzeugTyp bereitgestellt.	
 *  ----------------------------------------------------------------------------------*/

public class Fahrzeug {
	
	
	private String Kennzeichen;
	private FahrzeugTyp fahrzeugTyp;
	
	public Fahrzeug(String Kennzeichen, FahrzeugTyp fahrzeugTyp) {
		
				
			this.Kennzeichen=Kennzeichen;
			this.fahrzeugTyp=fahrzeugTyp;
			
			

		

		
	}
	
	public String getTyp(){		
		return this.fahrzeugTyp.getTyp();		
	}
	
	public String getKennzeichen() {
		return this.Kennzeichen;
	}
		
}
