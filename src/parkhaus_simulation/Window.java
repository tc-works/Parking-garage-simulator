package parkhaus_simulation;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JEditorPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JSplitPane;
import javax.swing.JSeparator;
import javax.swing.JFormattedTextField;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.AbstractListModel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JScrollPane;
import java.awt.Point;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Rectangle;
import java.awt.Label;
import java.awt.FlowLayout;
import java.awt.Insets;

public class Window extends JFrame {
	
	// GUI - Graphical User Interface
	// 1. Deklaration der Formular-Elemente

	private JPanel contentPane;
	
	JLabel lblFahrzeugtyp;
	JLabel lblAnzahlDerParkdecks;
	JLabel lblAnzahlDerParkpltze;
	JLabel lblKennzeichen;
	JLabel lblTextAusgabe;
	JLabel lblParkhaus;	
	JLabel lblSimulator;
	
	JTextField textField_parkdecks;
	JTextField textField_parkplaetze;
	JTextField textField_kennzeichen;	
	
	JButton btn_Parkhaus_erstellen;
	JButton btn_Fahrzeug_parken;
	JButton btn_Fahrzeug_entparken;
	JButton btn_ausgabe_freieplaetze;
	JButton btn_ausgabe_belegteplaetze;
	JButton btn_ausgabe_kennzeichensuche;

	JComboBox comboBox_fahrzeugTyp;
	JTextPane text_ausgabe;
	
	private Simulation simulation;
	
	/**
	 * Create the frame.
	 */
	public Window() {
		
		setTitle("Parkhaus Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 650);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		
	/*---------------------------------------------------------------------------*/		
		
		lblFahrzeugtyp = new JLabel("Fahrzeugtyp:");
		lblFahrzeugtyp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFahrzeugtyp.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFahrzeugtyp.setBounds(126, 161, 81, 22);
		contentPane.add(lblFahrzeugtyp);
		
		lblAnzahlDerParkdecks = new JLabel("Anzahl der Parkdecks:");
		lblAnzahlDerParkdecks.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnzahlDerParkdecks.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAnzahlDerParkdecks.setBounds(126, 18, 117, 31);
		contentPane.add(lblAnzahlDerParkdecks);	
		
		lblAnzahlDerParkpltze = new JLabel("Parkpl\u00E4tze pro Parkdeck:");
		lblAnzahlDerParkpltze.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAnzahlDerParkpltze.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAnzahlDerParkpltze.setBounds(126, 60, 121, 31);
		contentPane.add(lblAnzahlDerParkpltze);
				
		lblKennzeichen = new JLabel("Kennzeichen:");
		lblKennzeichen.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKennzeichen.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblKennzeichen.setBounds(126, 115, 117, 31);
		contentPane.add(lblKennzeichen);
		
		lblParkhaus = new JLabel("PARKHAUS");
		lblParkhaus.setForeground(SystemColor.activeCaption);
		lblParkhaus.setHorizontalAlignment(SwingConstants.LEFT);
		lblParkhaus.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblParkhaus.setBounds(34, 223, 266, 31);
		contentPane.add(lblParkhaus);
		
		lblSimulator = new JLabel("SIMULATOR");
		lblSimulator.setForeground(SystemColor.activeCaption);
		lblSimulator.setHorizontalAlignment(SwingConstants.LEFT);
		lblSimulator.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblSimulator.setBounds(34, 253, 266, 31);
		contentPane.add(lblSimulator);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(126, 102, 369, 2);
		contentPane.add(separator);
			
	/*---------------------------------------------------------------------------*/		
		
		JTextPane txtpnAnleitungSchritt = new JTextPane();
		txtpnAnleitungSchritt.setMargin(new Insets(10, 10, 10, 10));
		txtpnAnleitungSchritt.setBackground(SystemColor.controlHighlight);
		txtpnAnleitungSchritt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtpnAnleitungSchritt.setEditable(false);
		txtpnAnleitungSchritt.setText("Bedienungshinweis:\r\n\r\nGebe als erstes die Anzahl der Parkdecks und der Parkpl\u00E4tze pro Parckdeck ein und Klicke auf \"Parkhaus erstellen\".\r\n\r\nGebe das Kennzeichen ein,w\u00E4hle einen Fahrzeugtyp und klicke auf \"Fahrzeug erstellen und parken\" um das Fahrzeug zu erstellen und es im Parkhaus zu parken. \r\n\r\nMit \"Fahrzeug entparken\" wird das Fahrzeug des eingegeben Kennzeichens aus dem Parkhaus entparkt. Es kann mit dem Button \"Fahrzeug erstellen und parken\" erneut im Parkhaus geparkt werden.\r\n\r\nKlicke auf \"Fahrzeug im Parkhaus suchen\" um Kennzeichen, den Parklatz und den Fahrzeugtyp des eingegebenen Kennzeichen ausgeben zu lassen.\r\n\r\nKlicke auf \"Belegte Parkpl\u00E4tze\" um alle geparkten Fahrzeuge im Parkhaus mit Kennzeichen, Parklatz und Fahrzeugtyp ausgeben zu lassen.\r\n\r\nKlicke auf \"Freie Parkpl\u00E4tze\" um die Anzahl der freien Parkpl\u00E4tze im Parkhaus und deren Positionen ausgeben zu lassen.\r\n\r\nACHTUNG: Bei erneuter Erstellung des Parkhaus werden alle zuvor geparkten Fahrzeuge entparkt und m\u00FCssen neu geparkt werden.");
		txtpnAnleitungSchritt.setBounds(529, 18, 273, 582);
		contentPane.add(txtpnAnleitungSchritt);
				
	/*---------------------------------------------------------------------------*/	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.YELLOW);
		scrollPane.setBounds(34, 343, 461, 257);
		contentPane.add(scrollPane);
		
			
			text_ausgabe = new JTextPane();
			text_ausgabe.setMargin(new Insets(10, 10, 10, 0));
			text_ausgabe.setLocation(new Point(50, 50));
			text_ausgabe.setFont(new Font("Arial", Font.PLAIN, 13));
			scrollPane.setViewportView(text_ausgabe);
			text_ausgabe.setEditable(false);
			
			lblTextAusgabe = new JLabel("Textausgabe");
			scrollPane.setColumnHeaderView(lblTextAusgabe);
			lblTextAusgabe.setHorizontalAlignment(SwingConstants.CENTER);
			lblTextAusgabe.setFont(new Font("Tahoma", Font.BOLD, 11));
						
	/*---------------------------------------------------------------------------*/	
					
		textField_parkdecks = new JTextField();
		textField_parkdecks.setBounds(253, 18, 47, 31);
		contentPane.add(textField_parkdecks);
		textField_parkdecks.setColumns(10);
				
		textField_parkplaetze = new JTextField();
		textField_parkplaetze.setColumns(10);
		textField_parkplaetze.setBounds(253, 60, 47, 31);
		contentPane.add(textField_parkplaetze);
				
		textField_kennzeichen = new JTextField();
		textField_kennzeichen.setColumns(10);
		textField_kennzeichen.setBounds(253, 115, 47, 31);
		contentPane.add(textField_kennzeichen);
				
	/*---------------------------------------------------------------------------*/	
													
		comboBox_fahrzeugTyp = new JComboBox();
		comboBox_fahrzeugTyp.setBackground(Color.WHITE);
		comboBox_fahrzeugTyp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		comboBox_fahrzeugTyp.setModel(new DefaultComboBoxModel(new String[] {"-", "Auto", "Motorrad"}));
		comboBox_fahrzeugTyp.setMaximumRowCount(3);
		comboBox_fahrzeugTyp.setBounds(217, 161, 83, 22);
		contentPane.add(comboBox_fahrzeugTyp);
				
		btn_Parkhaus_erstellen = new JButton("Parkhaus erstellen");
		btn_Parkhaus_erstellen.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_Parkhaus_erstellen.setBounds(310, 18, 185, 73);
		contentPane.add(btn_Parkhaus_erstellen);
		
		btn_Fahrzeug_parken = new JButton("Fahrzeug erstellen und parken");
		btn_Fahrzeug_parken.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_Fahrzeug_parken.setBounds(310, 115, 185, 31);
		contentPane.add(btn_Fahrzeug_parken);
		
		btn_Fahrzeug_entparken = new JButton("Fahrzeug entparken");
		btn_Fahrzeug_entparken.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_Fahrzeug_entparken.setBounds(310, 157, 185, 31);
		contentPane.add(btn_Fahrzeug_entparken);		
				
		btn_ausgabe_freieplaetze = new JButton("Freie Parkpl\u00E4tze");
		btn_ausgabe_freieplaetze.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_ausgabe_freieplaetze.setBounds(310, 283, 185, 31);
		contentPane.add(btn_ausgabe_freieplaetze);
								
		btn_ausgabe_belegteplaetze = new JButton("Belegte Parkpl\u00E4tze");
		btn_ausgabe_belegteplaetze.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_ausgabe_belegteplaetze.setBounds(310, 241, 185, 31);
		contentPane.add(btn_ausgabe_belegteplaetze);
	
		btn_ausgabe_kennzeichensuche = new JButton("Fahrzeug im Parkhaus suchen");
		btn_ausgabe_kennzeichensuche.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btn_ausgabe_kennzeichensuche.setBounds(310, 199, 185, 31);
		contentPane.add(btn_ausgabe_kennzeichensuche);
		
	/*---------------------------------------------------------------------------*/	
		
		simulation = new Simulation();
		ButtonListener bl = new ButtonListener(this, simulation);
		btn_Parkhaus_erstellen.addActionListener(bl);
		btn_Fahrzeug_parken.addActionListener(bl);
		btn_Fahrzeug_entparken.addActionListener(bl);
		btn_ausgabe_freieplaetze.addActionListener(bl);
		btn_ausgabe_belegteplaetze.addActionListener(bl);
		btn_ausgabe_kennzeichensuche.addActionListener(bl);
		
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		new Window().setVisible(true);
		
	}
}
