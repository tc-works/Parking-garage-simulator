package parkhaus_simulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener{
	Window w;
	Simulation simulation;
	Parkhaus parkhaus;

	public ButtonListener( Window w, Simulation simulation ) {
		this.w = w;
		this.simulation = simulation;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		/* ----------------------------------------------------------------------------------
		 * Wenn der Button "Parkhaus erstellen" geklickt wird, dann wird ein Parkhaus erstellt. 	
		 * ----------------------------------------------------------------------------------*/
		
		if(e.getSource().equals(w.btn_Parkhaus_erstellen) 
				&& !w.textField_parkdecks.getText().equals("") 
				&& !w.textField_parkplaetze.getText().equals("")) {
			
			try {
				int AnzahlParkdecks = Integer.parseInt(w.textField_parkdecks.getText());
				int AnzahlParkplaetze = Integer.parseInt(w.textField_parkplaetze.getText());
				
				parkhaus = new Parkhaus(AnzahlParkdecks, AnzahlParkplaetze);
				simulation.parkhaus = parkhaus.parkhaus;
				w.text_ausgabe.setText("Parkhaus wurde erstellt");
				
			} 
			catch(NumberFormatException e1) {					 
			w.text_ausgabe.setText("Bitte nur Zahlen für Anzahl der Parkdecks und Partplätze eingeben");
			}	
			
		}
		

		/* ----------------------------------------------------------------------------------
		 * Wenn der Button "Fahrzeug parken" geklickt wird, dann wird geprüft ob das
		 * Kennzeichenein bereits in der ArrayListe existiert, und wenn es existiert wird
		 * geprüft ob das Fahrzeug mit Kennzeichen bereits im Parkhaus geparkt ist. Existiert
		 * das Kennzeichen, aber das Fahrzeug ist nicht geparkt, dann wird das bestehende
		 * Fahrzeug im Parkhaus geparkt. Existiert das Kennzeichen und das Fahrzeug ist geparkt,
		 * wird kein neues Fahrzeug mit dem Kennzeichen erstellt. Existiert das Kennzeichen noch
		 * nicht,dann wird ein neues Fahrzeug mit dem Kennzeichen erstellt, dieses im Parkhaus
		 * geparkt und der ArrayListe hinzugefügt. Sollte kein FahrzeugTyp Auto oder Motorrad
		 * ausgewählt sein, dann wird kein Fahrzeug erstellt.  	
		 * ----------------------------------------------------------------------------------*/
		
		if(e.getSource().equals(w.btn_Fahrzeug_parken)) {
			String ParkenKennzeichen = w.textField_kennzeichen.getText();
			String ParkenTyp = w.comboBox_fahrzeugTyp.getSelectedItem().toString();
			
			Fahrzeug fahrzeug = null;
			
			if (ParkenTyp == "Auto"&& !ParkenKennzeichen.equals("") ) {
				if (simulation.Kennzeichenpruefung(ParkenKennzeichen)) {
					
					w.text_ausgabe.setText("Fahrzeug mit Kennzeichen existiert bereits.\n");
					fahrzeug = simulation.holeFahrzeug(ParkenKennzeichen);
					
					if (!simulation.getParkstatus(ParkenKennzeichen)) {
						w.text_ausgabe.setText(w.text_ausgabe.getText()+ "Fahrzeug mit" + " " + ParkenKennzeichen + " " + "wird eingeparkt");
					simulation.AutomatischParken(fahrzeug);
					}
					else {
						w.text_ausgabe.setText(w.text_ausgabe.getText()+ "Fahrzeug mit" + " " + ParkenKennzeichen + " " + "ist bereits eingeparkt");
					}
				}
				else {
					fahrzeug = new Fahrzeug (ParkenKennzeichen, new Auto());
					simulation.fahrzeugliste.add(fahrzeug);
					w.text_ausgabe.setText(simulation.AutomatischParken(fahrzeug));	
				}
			}	
			if (ParkenTyp == "Motorrad"&& !ParkenKennzeichen.equals("")) {
				if (simulation.Kennzeichenpruefung(ParkenKennzeichen)) {
					
					w.text_ausgabe.setText("Fahrzeug mit Kennzeichen existiert bereits.\n");
					fahrzeug = simulation.holeFahrzeug(ParkenKennzeichen);
					
					if (!simulation.getParkstatus(ParkenKennzeichen)) {
						w.text_ausgabe.setText(w.text_ausgabe.getText()+ "Fahrzeug mit" + " " + ParkenKennzeichen + " " + "wird eingeparkt.");
					simulation.AutomatischParken(fahrzeug);
					}
					else {
						w.text_ausgabe.setText(w.text_ausgabe.getText()+ "Fahrzeug mit" + " " + ParkenKennzeichen + " " + "ist bereits eingeparkt.");
					}
				}
				else {
					fahrzeug = new Fahrzeug (ParkenKennzeichen, new Motorrad());
					simulation.fahrzeugliste.add(fahrzeug);
					w.text_ausgabe.setText(simulation.AutomatischParken(fahrzeug));	
				}
			}
			if (ParkenTyp == "-") {
				w.text_ausgabe.setText("Bitte Fahrzeugtyp wählen");
			}
			if (ParkenKennzeichen.equals("")) {
				w.text_ausgabe.setText("Bitte Kennzeichen eingeben");
			}
		}
		
		
		/* ----------------------------------------------------------------------------------
		 * Wenn der Button "Fahrzeug Ausparken" geklickt wird, dann wird das Fahrzeug mit dem
		 * eingegebenen Kennzeichen aus dem Parkhaus ausgeparkt. Das Fahrzeug bleibt jedoch 
		 * selbst als Objebt existent. 	
		 * ----------------------------------------------------------------------------------*/
		
		
		if(e.getSource().equals(w.btn_Fahrzeug_entparken)) {
			
			String EntparkenKennzeichen = w.textField_kennzeichen.getText();
			
			if (!EntparkenKennzeichen.equals("") && simulation.getParkstatus(EntparkenKennzeichen)) {
				simulation.entparken(EntparkenKennzeichen);
				w.text_ausgabe.setText("Das Fahrzeug mit dem Kennzeichen" + " " + EntparkenKennzeichen + " " +"wurde entparkt");	
			}
			else if(!EntparkenKennzeichen.equals("")) {
				if(simulation.Kennzeichenpruefung(EntparkenKennzeichen)) {
					w.text_ausgabe.setText("Das Fahrzeug mit dem Kennzeichen" + " " + EntparkenKennzeichen + " " +"befindet sich nicht im Parkhaus");		
				}
				else {
					w.text_ausgabe.setText("Das Fahrzeug mit dem Kennzeichen" + " " + EntparkenKennzeichen + " " +"existiert nicht");		
				}
			}
			else {
				w.text_ausgabe.setText("Bitte Kennzeichen eingeben");
			}
		}
		
		
		/* ----------------------------------------------------------------------------------
		 * Wenn der Button "Suche nach Kennzeichen" geklickt wird, dann wird das Kennzeichen
		 * mit dazugehörigen Parkplatz und FahrzeugTyp ausgegeben. 	
		 * ----------------------------------------------------------------------------------*/
		
		if(e.getSource().equals(w.btn_ausgabe_kennzeichensuche)) {
			String SucheKennzeichen = w.textField_kennzeichen.getText();
			if (!SucheKennzeichen.equals("") ) {
				w.text_ausgabe.setText(simulation.getParkplatz(SucheKennzeichen));
			}
			else {
				w.text_ausgabe.setText("Bitte Kennzeichen eingeben");
			}
		}
		
		
		/* ----------------------------------------------------------------------------------
		 * Wenn der Button "Freie Parkplaetze" geklickt wird, dann wird die Anzahl und eine
		 * Liste aller freien Parklpaetze im Parkhaus ausgegeben. 	
		 * ----------------------------------------------------------------------------------*/
		
		if(e.getSource().equals(w.btn_ausgabe_freieplaetze)) {
			w.text_ausgabe.setText(simulation.getFreiePlaetze());
		}
		
		/* ----------------------------------------------------------------------------------
		 * Wenn der Button "Belegte Parkplaetze" geklickt wird, dann werden alle belegten
		 * Parklpaetze im Parkhaus, dazugehörige Kennzeichen und FarhzeugTyp ausgegeben. 	
		 * ----------------------------------------------------------------------------------*/
		
		if(e.getSource().equals(w.btn_ausgabe_belegteplaetze)) {
			w.text_ausgabe.setText(simulation.getBelegtePlaetze());
		}
		

		
	}
	
}
