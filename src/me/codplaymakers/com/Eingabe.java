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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

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
		txtpnVertrag.setText("T‰tigkeit");
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
				txtpnPrmie.setText("Nettojahrespr‰mie");
				txtpnPrmie.setBounds(10, 67, 105, 20);
				tabeingabe.add(txtpnPrmie);
				
				JTextPane txtpnNettoprovision = new JTextPane();
				txtpnNettoprovision.setBackground(SystemColor.menu);
				txtpnNettoprovision.setEditable(false);
				txtpnNettoprovision.setText("Provision");
				txtpnNettoprovision.setBounds(10, 101, 76, 20);
				tabeingabe.add(txtpnNettoprovision);
				
				final JComboBox cbsparte = new JComboBox();
				cbsparte.setModel(new DefaultComboBoxModel(new String[] {"HRV", "WGV", "GLS", "PHV", "UNF", "LV", "KFZ",  "   "}));
				cbsparte.setSelectedItem(" ");
				cbsparte.setBounds(152, 36, 154, 20);
				tabeingabe.add(cbsparte);
				
				
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
					    
						final JComboBox cbtaetigkeit = new JComboBox();
						cbtaetigkeit.addItemListener(new ItemListener() {
							public void itemStateChanged(ItemEvent arg0) {
								
								if(cbtaetigkeit.getSelectedItem()=="Anbahnung")
								{
									ftfpraemie.setVisible(false);
									ftfprov.setVisible(false);
									ftfpraemie.setValue(0.0);
									ftfprov.setValue(0.0);
								}
								else if(cbtaetigkeit.getSelectedItem()!="Anbahnung")
								{
									ftfpraemie.setVisible(true);
									ftfprov.setVisible(true);
								}
								else 
								{
									System.out.println("Nichts angew‰hlt");
								}
								
							}
						});
						cbtaetigkeit.setModel(new DefaultComboBoxModel(new String[] {"Abschluss", "Vertragsverl\u00E4ngerung", "Anbahnung", "Storno"}));
						cbtaetigkeit.setBounds(152, 5, 154, 20);
						tabeingabe.add(cbtaetigkeit);
					    
					    		JButton btneintragen = new JButton("Provision berechnen");
					    		btneintragen.setBounds(10, 245, 172, 23);
					    		tabeingabe.add(btneintragen);
					    		
					    		JTextPane txtpnAblauf = new JTextPane();
					    		txtpnAblauf.setEditable(false);
					    		txtpnAblauf.setBackground(SystemColor.menu);
					    		txtpnAblauf.setSelectedTextColor(SystemColor.menu);
					    		txtpnAblauf.setText("Ablaufdatum");
					    		txtpnAblauf.setBounds(10, 163, 88, 20);
					    		tabeingabe.add(txtpnAblauf);
					    		

					    		btneintragen.addMouseListener(new MouseAdapter() {
					    			@Override
					    			public void mouseClicked(MouseEvent arg0) {
					    			
					    			try {
					    				double ergebnis, praemie;


					    				if ((cbsparte.getSelectedItem()=="HRV") && (cbtaetigkeit.getSelectedItem()=="Abschluss"))
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.24);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="WGV") && (cbtaetigkeit.getSelectedItem()=="Abschluss")) 
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.24);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="GLS") && (cbtaetigkeit.getSelectedItem()=="Abschluss")) 
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.18);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="PHV") && (cbtaetigkeit.getSelectedItem()=="Abschluss"))
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.17);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="UNF") && (cbtaetigkeit.getSelectedItem()=="Abschluss"))
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.21);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
//					    				else if ((cbsparte.getSelectedItem()=="KRV") && (cbtaetigkeit.getSelectedItem()=="Abschluss")) 
//					    				{
//					    				praemie = Double.parseDouble(ftfpraemie.getText());
//					    				ergebnis = (((praemie/12)*5)*0.3);
//					    				ftfprov.setText(String.valueOf(ergebnis));
//					    				}
//					    				
//					    				else if ((cbsparte.getSelectedItem()=="RSV") && (cbtaetigkeit.getSelectedItem()=="Abschluss"))
//					    				{
//					    				praemie = Double.parseDouble(ftfpraemie.getText());
//					    				ergebnis = ((praemie*0.5)*0.3);
//					    				ftfprov.setText(String.valueOf(ergebnis));
//					    				}
					    				
					    				else if((cbsparte.getSelectedItem()=="LV") && (cbtaetigkeit.getSelectedItem()=="Abschluss")) 
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
					    				
			    						else if((cbsparte.getSelectedItem()=="LV") && (cbtaetigkeit.getSelectedItem()=="Storno"))
			    						{
			    						praemie = Double.parseDouble(ftfpraemie.getText());
			    						ergebnis = (praemie/0.0275*(-0.3));
			    						ftfprov.setText(String.valueOf(ergebnis));
			    						}
					    				
			    						else {
			    							System.out.println("Keine Sparte ausgew‰hlt");
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
					    				txtpnBeginnDarum.setEditable(false);
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
		txtpnabschlussquote.setBounds(10, 223, 132, 20);
		txtpnabschlussquote.setBackground(SystemColor.menu);
		txtpnabschlussquote.setText("Abschlussquote");
		tabzusammenfassung.add(txtpnabschlussquote);
		
		JTextPane txtpnstornoquote = new JTextPane();
		txtpnstornoquote.setBounds(10, 248, 120, 20);
		txtpnstornoquote.setBackground(SystemColor.menu);
		txtpnstornoquote.setText("Stornoquote");
		tabzusammenfassung.add(txtpnstornoquote);
		
		JTextPane txtpndiagramme = new JTextPane();
		txtpndiagramme.setBounds(10, 67, 81, 20);
		txtpndiagramme.setBackground(SystemColor.menu);
		txtpndiagramme.setText("Diagramme:");
		tabzusammenfassung.add(txtpndiagramme);
		
		JTextPane txtpnzfSparte = new JTextPane();
		txtpnzfSparte.setBounds(10, 36, 66, 20);
		txtpnzfSparte.setBackground(SystemColor.menu);
		txtpnzfSparte.setEditable(false);
		txtpnzfSparte.setText("Sparte");
		tabzusammenfassung.add(txtpnzfSparte);
		
		JTextPane txtpnzfVertrag = new JTextPane();
		txtpnzfVertrag.setBounds(10, 5, 132, 20);
		txtpnzfVertrag.setBackground(SystemColor.menu);
		txtpnzfVertrag.setEditable(false);
		txtpnzfVertrag.setText("T‰tigkeit");
		tabzusammenfassung.add(txtpnzfVertrag);
		
	    final JFormattedTextField ftfaquote = new JFormattedTextField();
	    ftfaquote.setBounds(152, 223, 154, 20);
	    tabzusammenfassung.add(ftfaquote);
	    
	    final JFormattedTextField ftfsquote = new JFormattedTextField();
	    ftfsquote.setBounds(152, 248, 154, 20);
	    tabzusammenfassung.add(ftfsquote);
		
		//ziel4.setBounds(10, 123, 100, 20);
		//tabzusammenfassung.add(ziel4);
		
		
		JButton ziel3 = new JButton("Provisionsziel");
		ziel3.setBounds(10, 189, 185, 23);
		ziel3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Balkendiagramm bd_2 = new Balkendiagramm("Aktuelle Provision", dbc.ausgabeDiagrammProvSumme(), dbc.ausgabeDiagrammProv());
				bd_2.pack();
				bd_2.setVisible(true);				
			}
		});
		tabzusammenfassung.add(ziel3);
		
		final JComboBox cbzfsparte = new JComboBox();
		cbzfsparte.setBounds(152, 36, 154, 20);
		cbzfsparte.setModel(new DefaultComboBoxModel(new String[] {"SHU", "L", "K", "   "}));
		cbzfsparte.setSelectedItem(" ");
		tabzusammenfassung.add(cbzfsparte);
		
		final JComboBox cbzftaetigkeit = new JComboBox();
		cbzftaetigkeit.setBounds(152, 5, 154, 20);
		cbzftaetigkeit.setModel(new DefaultComboBoxModel(new String[] {"Abschluss", "Vertragsverl\u00E4ngerung", "Anbahnung", "Storno"}));
		tabzusammenfassung.add(cbzftaetigkeit);
		
		JButton ziel4 = new JButton("KFZ pro Monat");
		ziel4.setBounds(10, 98, 132, 20);
		ziel4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Balkendiagramm kfz_bd = new Balkendiagramm("Uebersicht KFZ", dbc.ausgabeDiagrammBestandKFZ(cbzftaetigkeit.getSelectedItem().toString()), dbc.ausgabeDiagrammZieleKFZ(cbzftaetigkeit.getSelectedItem().toString()));
				kfz_bd.pack();
				kfz_bd.setVisible(true);
			}
		});
		
		tabzusammenfassung.add(ziel4);
		
		JButton ziel2 = new JButton("SHU pro Monat");
		ziel2.setBounds(10, 129, 132, 20);
		ziel2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Balkendiagramm shu_bd = new Balkendiagramm("Uebersicht SHU", dbc.ausgabeDiagrammBestandSHU(cbzftaetigkeit.getSelectedItem().toString()), dbc.ausgabeDiagrammZieleSHU(cbzftaetigkeit.getSelectedItem().toString()));
				shu_bd.pack();
				shu_bd.setVisible(true);
				
			}
		});
		
		tabzusammenfassung.add(ziel2);
		
		JButton ziel5 = new JButton("Leben pro Monat");
		ziel5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Balkendiagramm leben_bd = new Balkendiagramm("Uebersicht Leben", dbc.ausgabeDiagrammBestandL(cbzftaetigkeit.getSelectedItem().toString()), dbc.ausgabeDiagrammZieleL(cbzftaetigkeit.getSelectedItem().toString()));
				leben_bd.pack();
				leben_bd.setVisible(true);
				
			}
		});
		ziel5.setBounds(10, 160, 132, 20);
		tabzusammenfassung.add(ziel5);
		
		JButton ziel7 = new JButton("KFZ pro Jahr");
		ziel7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//Balkendiagramm lebenjahr = new Balkendiagramm("Uebersicht Leben/Jahr", dbc.ausg, wert2)
				
			}
		});
		ziel7.setBounds(196, 98, 143, 20);
		
		tabzusammenfassung.add(ziel7);
		
		JButton ziel8 = new JButton("Leben pro Jahr");
		ziel8.setBounds(196, 160, 143, 20);
		
		tabzusammenfassung.add(ziel8);
		
		JButton ziel9 = new JButton("SHU pro Jahr");
		ziel9.setBounds(196, 129, 143, 20);
		
		tabzusammenfassung.add(ziel9);
		
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
		txtpntaetig.setText("T‰tigkeit");
		txtpntaetig.setBounds(10, 11, 77, 20);
		tabziele.add(txtpntaetig);
		
		JTextPane txtpnzsparte = new JTextPane();
		txtpnzsparte.setBackground(SystemColor.menu);
		txtpnzsparte.setText("Sparte");
		txtpnzsparte.setBounds(9, 42, 77, 20);
		tabziele.add(txtpnzsparte);
		
		final JTextPane txtpnprovision = new JTextPane();
		txtpnprovision.setBackground(SystemColor.menu);
		txtpnprovision.setEditable(false);
		txtpnprovision.setText("Provision");
		txtpnprovision.setBounds(10, 104, 76, 20);
		txtpnprovision.setVisible(false);
		tabziele.add(txtpnprovision);
		
		final JSpinner sanzahl = new JSpinner();
		sanzahl.setBounds(118, 73, 143, 20);
		tabziele.add(sanzahl);
		
		JButton zablegen = new JButton("Ablegen");
		zablegen.setBounds(10, 245, 154, 23);
		
	    final JFormattedTextField ftfprovision = new JFormattedTextField();
	    ftfprovision.setBounds(118, 104, 143, 20);
	    ftfprovision.setVisible(false);
	    ftfprovision.setValue(0.0);
	    tabziele.add(ftfprovision);
		
		
		final JComboBox cbztaetigkeit = new JComboBox();
		cbztaetigkeit.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				if(cbztaetigkeit.getSelectedItem()=="Wunschprovision")
				{
					txtpnprovision.setVisible(true);
					ftfprovision.setVisible(true);
				}
				else
				{
					txtpnprovision.setVisible(false);
					ftfprovision.setVisible(false);
				}
				
			}
		});
		cbztaetigkeit.setModel(new DefaultComboBoxModel(new String[] {"Abschluss", "Vertragsverl\u00E4ngerung", "Anbahnung", "Storno", "Wunschprovision"}));
		cbztaetigkeit.setBounds(118, 11, 143, 20);
		tabziele.add(cbztaetigkeit);
		
		final JComboBox cbzsparte = new JComboBox();
		cbzsparte.setModel(new DefaultComboBoxModel(new String[] {"SHU", "L", "K", "   "}));
		cbzsparte.setSelectedItem(" ");
		cbzsparte.setBounds(118, 42, 143, 20);
		tabziele.add(cbzsparte);
	    
		final JCheckBox cbSollIst = new JCheckBox();
		cbSollIst.setBounds(10, 163, 143, 20);
		cbSollIst.setText("Soll");
		cbSollIst.setSelected(true);
		tabziele.add(cbSollIst);
		
		zablegen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				 String taetigkeit = cbztaetigkeit.getSelectedItem().toString();
				 String sparte = cbzsparte.getSelectedItem().toString();
				 Double anzahl_taetigkeiten = Double.valueOf(sanzahl.getValue().toString());
				 Double provisionsziel = Double.valueOf(ftfprovision.getText());
				
		if (cbSollIst.isSelected()){
			dbc.insertZielsetzungen(taetigkeit, sparte, anzahl_taetigkeiten, provisionsziel);
		    dbc.ausgabeZiele();
		} else{
			dbc.insertistzustand(taetigkeit, sparte, anzahl_taetigkeiten, provisionsziel);
			dbc.ausgabeIstZustand();
		}
				

				
			}
		});
		tabziele.add(zablegen);
		
		tabbedPane.addTab("Ziele", tabziele);

	}

	public Eingabe() {
		setTitle("Auﬂendienst Erfolgsprogramm");
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
