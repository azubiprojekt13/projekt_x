package me.codplaymakers.com;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;


import java.awt.GridLayout;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import java.awt.Point;
import java.awt.Color;
import java.awt.SystemColor;

public class Eingabe 
	extends JFrame {

	public String [] daten ;
	
	private JTabbedPane tabbedPane;
	private JPanel tabeingabe ;
	private JPanel tabzusammenfassung ;
	private JPanel tabziele;
	private static DBController dbc;

	private void EingabeTabErzeugen(){

		tabbedPane = new JTabbedPane();
		tabeingabe  = new JPanel();
		tabeingabe.setLayout(null);
		
		JTextPane txtpnVertrag = new JTextPane();
		txtpnVertrag.setBackground(SystemColor.menu);
		txtpnVertrag.setEditable(false);
		txtpnVertrag.setText("Tätigkeit");
		txtpnVertrag.setBounds(10, 5, 132, 20);
		tabeingabe.add(txtpnVertrag);
		
				
				JTextPane txtpnSparte = new JTextPane();
				txtpnSparte.setBackground(SystemColor.menu);
				txtpnSparte.setEditable(false);
				txtpnSparte.setText("Sparte");
				txtpnSparte.setBounds(10, 36, 66, 20);
				tabeingabe.add(txtpnSparte);
				
				JTextPane txtpnPrmie = new JTextPane();
				txtpnPrmie.setBackground(SystemColor.menu);
				txtpnPrmie.setEditable(false);
				txtpnPrmie.setText("Nettojahresprämie");
				txtpnPrmie.setBounds(10, 67, 105, 20);
				tabeingabe.add(txtpnPrmie);
				
				JTextPane txtpnNettoprovision = new JTextPane();
				txtpnNettoprovision.setBackground(SystemColor.menu);
				txtpnNettoprovision.setEditable(false);
				txtpnNettoprovision.setText("Provision");
				txtpnNettoprovision.setBounds(10, 101, 76, 20);
				tabeingabe.add(txtpnNettoprovision);
				
				final JComboBox cbsparte = new JComboBox();
				cbsparte.setModel(new DefaultComboBoxModel(new String[] {"HRV", "WGV", "GLS", "PHV", "UNF", "KRV", "RSV", "LV", "   "}));
				cbsparte.setSelectedItem(" ");
				cbsparte.setBounds(152, 36, 154, 20);
				tabeingabe.add(cbsparte);
				

				
				
				final JComboBox cbtaetigkeit = new JComboBox();
				cbtaetigkeit.setModel(new DefaultComboBoxModel(new String[] {"Neuabschluss", "Vertragsverl\u00E4ngerung", "Servicetermin", "Storno"}));
				cbtaetigkeit.setBounds(152, 5, 154, 20);
				tabeingabe.add(cbtaetigkeit);
				
				//final csvErzeugen blubb = new csvErzeugen();
				
				JButton btnAblegen = new JButton("Ablegen");
				//

					btnAblegen.setBounds(192, 245, 154, 23);
					tabeingabe.add(btnAblegen);
					
					final JCheckBox chckbxCrossseling = new JCheckBox("Cross-Selling");
					chckbxCrossseling.setBounds(10, 202, 183, 23);
					tabeingabe.add(chckbxCrossseling);
					
					
					    
					    final JFormattedTextField ftfpraemie = new JFormattedTextField();
					    ftfpraemie.setBounds(152, 67, 154, 20);
					    tabeingabe.add(ftfpraemie);
					    
					    final JFormattedTextField ftfprov = new JFormattedTextField();
					    ftfprov.setBounds(152, 101, 154, 20);
					    tabeingabe.add(ftfprov);
					    
					    		JButton btneintragen = new JButton("Provision berechnen");
					    		btneintragen.setBounds(10, 245, 172, 23);
					    		tabeingabe.add(btneintragen);
					    		
					    		JTextPane txtpnAblauf = new JTextPane();
					    		txtpnAblauf.setBackground(SystemColor.menu);
					    		txtpnAblauf.setSelectedTextColor(SystemColor.menu);
					    		txtpnAblauf.setText("Ablaufdatum");
					    		txtpnAblauf.setBounds(10, 163, 66, 20);
					    		tabeingabe.add(txtpnAblauf);
					    		

					    		btneintragen.addMouseListener(new MouseAdapter() {
					    			@Override
					    			public void mouseClicked(MouseEvent arg0) {
					    			
					    			try {
					    				double ergebnis, praemie;


					    				if ((cbsparte.getSelectedItem()=="HRV") && (cbtaetigkeit.getSelectedItem()=="Neuabschluss"))
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.2);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="WGV") && (cbtaetigkeit.getSelectedItem()=="Neuabschluss")) 
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.24);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="GLS") && (cbtaetigkeit.getSelectedItem()=="Neuabschluss")) 
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.18);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="PHV") && (cbtaetigkeit.getSelectedItem()=="Neuabschluss"))
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.17);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="UNF") && (cbtaetigkeit.getSelectedItem()=="Neuabschluss"))
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.21);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="KRV") && (cbtaetigkeit.getSelectedItem()=="Neuabschluss")) 
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (((praemie/12)*5)*0.3);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="RSV") && (cbtaetigkeit.getSelectedItem()=="Neuabschluss"))
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = ((praemie*0.5)*0.3);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if((cbsparte.getSelectedItem()=="LV") && (cbtaetigkeit.getSelectedItem()=="Neuabschluss")) 
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie/0.0275*0.3);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
			    						else if((cbsparte.getSelectedItem()=="HRV") && (cbtaetigkeit.getSelectedItem()=="Storno")) 
			    						{
			    						praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*(-0.2));
			    						ftfprov.setText(String.valueOf(ergebnis));
			    						}
			    						
			    						else if((cbsparte.getSelectedItem()=="WGV") && (cbtaetigkeit.getSelectedItem()=="Storno")) 
			    						{
			    						praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*(-0.24));
			    						ftfprov.setText(String.valueOf(ergebnis));
			    						}
			    						
			    						else if((cbsparte.getSelectedItem()=="GLS") && (cbtaetigkeit.getSelectedItem()=="Storno")) 
			    						{
			    						praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*(-0.18));
			    						ftfprov.setText(String.valueOf(ergebnis));
			    						}
			    						
			    						else if((cbsparte.getSelectedItem()=="PHV") && (cbtaetigkeit.getSelectedItem()=="Storno")) 
			    						{
			    						praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*(-0.17));
			    						ftfprov.setText(String.valueOf(ergebnis));
			    						}
			    						
			    						else if((cbsparte.getSelectedItem()=="UNF") && (cbtaetigkeit.getSelectedItem()=="Storno")) 
			    						{
			    						praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*(-0.21));
			    						ftfprov.setText(String.valueOf(ergebnis));
			    						}
			    						
			    						else if((cbsparte.getSelectedItem()=="KRV") && (cbtaetigkeit.getSelectedItem()=="Storno")) 
			    						{
			    						praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (((praemie/12)*5)*(-0.3));
			    						ftfprov.setText(String.valueOf(ergebnis));
			    						}
			    						
			    						else if((cbsparte.getSelectedItem()=="RSV") && (cbtaetigkeit.getSelectedItem()=="Storno")) 
			    						{
			    						praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = ((praemie*0.5)*(-0.3));
			    						ftfprov.setText(String.valueOf(ergebnis));
			    						}
					    				
			    						else 
			    						{
			    						praemie = Double.parseDouble(ftfpraemie.getText());
			    						ergebnis = (praemie/0.0275*(-0.3));
			    						ftfprov.setText(String.valueOf(ergebnis));
			    						}

					    				
					    			}
					    				
					    			catch (Exception e)
					    			{
					    				System.out.println("Keine Zahl eingegeben!");
					    			}

					    				
					    			}
					    		}
	
	);
					    		

					    				tabbedPane.addTab("Eingabe", tabeingabe);
					    				
					    				JFormattedTextField formattedTextField = new JFormattedTextField();
					    				formattedTextField.setBounds(151, 163, 155, 20);
					    				tabeingabe.add(formattedTextField);
					    				
					    				JFormattedTextField formattedTextField_1 = new JFormattedTextField();
					    				formattedTextField_1.setBounds(152, 132, 154, 20);
					    				tabeingabe.add(formattedTextField_1);
					    				
					    				JTextPane txtpnBeginnDarum = new JTextPane();
					    				txtpnBeginnDarum.setBackground(SystemColor.menu);
					    				txtpnBeginnDarum.setSelectedTextColor(SystemColor.menu);
					    				txtpnBeginnDarum.setText("Beginn Datum");
					    				txtpnBeginnDarum.setBounds(10, 132, 88, 20);
					    				tabeingabe.add(txtpnBeginnDarum);

		
		
		btnAblegen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				/*daten = new String [4]; //4 = anzahl an elementen
				daten[0] = cbtaetigkeit.getSelectedItem().toString();
				txtprov.setText(daten[0]);
				blubb.generateCsvFile(daten);*/
				
				String taetigkeit = cbtaetigkeit.getSelectedItem().toString();
				String sparte = cbsparte.getSelectedItem().toString();
				Double praemie = Double.valueOf(ftfpraemie.getText());
				Double netto_provision = Double.valueOf(ftfprov.getText());
				String crossselling;
				if(chckbxCrossseling.isSelected()) {
					crossselling="yes";
					
				}
				else {
					crossselling = "no";
				};
			
				dbc.insertBestand(taetigkeit, sparte, praemie, netto_provision, crossselling);
				dbc.ausgabeBestand();
			}
		});
		
			
		
		
		
	}

	
	private void ZusammenfassungTabErzeugen(){
		tabzusammenfassung = new JPanel();
		tabzusammenfassung.setLayout(null);
		
		JTextPane txtpnabschlussquote = new JTextPane();
		txtpnabschlussquote.setBackground(SystemColor.menu);
		txtpnabschlussquote.setText("Abschlussquote");
		txtpnabschlussquote.setBounds(10, 11, 132, 20);
		tabzusammenfassung.add(txtpnabschlussquote);
		
		JTextPane txtpnstornoquote = new JTextPane();
		txtpnstornoquote.setBackground(SystemColor.menu);
		txtpnstornoquote.setText("Stornoquote");
		txtpnstornoquote.setBounds(10, 42, 120, 20);
		tabzusammenfassung.add(txtpnstornoquote);
		
		JTextPane txtpndiagramme = new JTextPane();
		txtpndiagramme.setBackground(SystemColor.menu);
		txtpndiagramme.setText("Diagramme:");
		txtpndiagramme.setBounds(10, 90, 81, 20);
		tabzusammenfassung.add(txtpndiagramme);
		
	    final JFormattedTextField ftfaquote = new JFormattedTextField();
	    ftfaquote.setBounds(152, 11, 154, 20);
	    tabzusammenfassung.add(ftfaquote);
	    
	    final JFormattedTextField ftfsquote = new JFormattedTextField();
	    ftfsquote.setBounds(152, 42, 154, 20);
	    tabzusammenfassung.add(ftfsquote);
	    
		JButton ziel1 = new JButton("Abschlüsse pro Monat");
		ziel1.setBounds(10, 121, 185, 23);
		tabzusammenfassung.add(ziel1);
		
		JButton ziel2 = new JButton("Termine pro Monat");
		ziel2.setBounds(10, 189, 185, 23);
		tabzusammenfassung.add(ziel2);
		
		JButton ziel3 = new JButton("Provisionsziel");
		ziel3.setBounds(10, 155, 185, 23);
		tabzusammenfassung.add(ziel3);
		
		
		tabbedPane.addTab("Zusammenfassung", tabzusammenfassung);
	}
	
	private void ZieleTabErzeugen(){
		tabziele = new JPanel();
		tabziele.setLayout(null);
		

		JTextPane txtpnZieleProMonat = new JTextPane();
		txtpnZieleProMonat.setBackground(SystemColor.menu);
		txtpnZieleProMonat.setText("Anzahl");
		txtpnZieleProMonat.setBounds(10, 73, 66, 20);
		tabziele.add(txtpnZieleProMonat);
		
		JTextPane txtpntaetig = new JTextPane();
		txtpntaetig.setBackground(SystemColor.menu);
		txtpntaetig.setText("Tätigkeit");
		txtpntaetig.setBounds(10, 11, 77, 20);
		tabziele.add(txtpntaetig);
		
		JTextPane txtpnzsparte = new JTextPane();
		txtpnzsparte.setBackground(SystemColor.menu);
		txtpnzsparte.setText("Sparte");
		txtpnzsparte.setBounds(9, 42, 77, 20);
		tabziele.add(txtpnzsparte);
		
		JTextPane txtpnprovision = new JTextPane();
		txtpnprovision.setBackground(SystemColor.menu);
		txtpnprovision.setEditable(false);
		txtpnprovision.setText("Provision");
		txtpnprovision.setBounds(10, 104, 76, 20);
		tabziele.add(txtpnprovision);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(118, 73, 143, 20);
		tabziele.add(spinner);
		
		JButton button = new JButton("Ablegen");
		button.setBounds(10, 245, 154, 23);
		tabziele.add(button);
		
		final JComboBox cbztaetigkeit = new JComboBox();
		cbztaetigkeit.setModel(new DefaultComboBoxModel(new String[] {"Neuabschluss", "Vertragsverl\u00E4ngerung", "Servicetermin", "Storno"}));
		cbztaetigkeit.setBounds(118, 11, 143, 20);
		tabziele.add(cbztaetigkeit);
		
		final JComboBox cbzsparte = new JComboBox();
		cbzsparte.setModel(new DefaultComboBoxModel(new String[] {"HRV", "WGV", "GLS", "PHV", "UNF", "KRV", "RSV", "LV", "   "}));
		cbzsparte.setSelectedItem(" ");
		cbzsparte.setBounds(118, 42, 143, 20);
		tabziele.add(cbzsparte);
		
	    final JFormattedTextField ftfprovision = new JFormattedTextField();
	    ftfprovision.setBounds(118, 104, 143, 20);
	    tabziele.add(ftfprovision);
		
		
		
		tabbedPane.addTab("Ziele", tabziele);

	}

	public Eingabe() {
		setTitle("Außendienst Erfolgsprogramm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 381, 345);

		

		  EingabeTabErzeugen();
		  ZusammenfassungTabErzeugen();
		  ZieleTabErzeugen();
		  setContentPane(tabbedPane);
		

	
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dbc = new DBController(); 
			        dbc.initDBConnection(); 
					Eingabe frame = new Eingabe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
