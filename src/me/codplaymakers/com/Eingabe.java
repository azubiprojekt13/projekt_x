package me.codplaymakers.com;

import javax.swing.*;

public class Eingabe 
	extends JFrame {

	public String [] daten ;
	
	private JTabbedPane tabbedPane;
	private JPanel tabeingabe ;
	private JPanel tabzusammenfassung ;
	private JPanel tabziele;
	private static DBController dbc;

	private void EingabeTabErzeugen(){
	}

	
	private void ZusammenfassungTabErzeugen(){
		tabzusammenfassung = new JPanel();
		
		
	}
	
	private void ZieleTabErzeugen(){
		tabziele = new JPanel();
		tabziele.setLayout(null);
		
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
				txtpnSparte.setBounds(152, 5, 66, 20);
				tabeingabe.add(txtpnSparte);
				
				JTextPane txtpnPrmie = new JTextPane();
				txtpnPrmie.setBackground(SystemColor.menu);
				txtpnPrmie.setEditable(false);
				txtpnPrmie.setText("Nettojahresprämie");
				txtpnPrmie.setBounds(228, 5, 105, 20);
				tabeingabe.add(txtpnPrmie);
				
				JTextPane txtpnNettoprovision = new JTextPane();
				txtpnNettoprovision.setBackground(SystemColor.menu);
				txtpnNettoprovision.setEditable(false);
				txtpnNettoprovision.setText("Provision");
				txtpnNettoprovision.setBounds(343, 5, 76, 20);
				tabeingabe.add(txtpnNettoprovision);
				final JComboBox cbsparte = new JComboBox();
				cbsparte.setModel(new DefaultComboBoxModel(new String[] {"HRV", "WGV", "GLS", "PHV", "UNF", "KRV", "RSV", "LV", "   "}));
				cbsparte.setSelectedItem(" ");
				cbsparte.setBounds(152, 36, 66, 20);
				tabeingabe.add(cbsparte);
				

				
				
				final JComboBox cbtaetigkeit = new JComboBox();
				cbtaetigkeit.setModel(new DefaultComboBoxModel(new String[] {"Neuabschluss", "Vertragsverl\u00E4ngerung", "Servicetermin", "Storno"}));
				cbtaetigkeit.setBounds(10, 36, 132, 20);
				tabeingabe.add(cbtaetigkeit);
				
				//final csvErzeugen blubb = new csvErzeugen();
				
				JButton btnAblegen = new JButton("Ablegen");
				//

					btnAblegen.setBounds(265, 207, 154, 23);
					tabeingabe.add(btnAblegen);
					
					final JCheckBox chckbxCrossseling = new JCheckBox("Crossseling");
					chckbxCrossseling.setBounds(10, 149, 183, 23);
					tabeingabe.add(chckbxCrossseling);
					
					
					    
					    final JFormattedTextField ftfpraemie = new JFormattedTextField();
					    ftfpraemie.setBounds(228, 36, 105, 20);
					    tabeingabe.add(ftfpraemie);
					    
					    final JFormattedTextField ftfprov = new JFormattedTextField();
					    ftfprov.setBounds(343, 36, 76, 20);
					    tabeingabe.add(ftfprov);
					    
					    		JButton btneintragen = new JButton("Provision Berechnen");
					    		btneintragen.setBounds(10, 207, 172, 23);
					    		tabeingabe.add(btneintragen);
					    		
					    		JTextPane txtpnAblauf = new JTextPane();
					    		txtpnAblauf.setBackground(SystemColor.menu);
					    		txtpnAblauf.setSelectedTextColor(SystemColor.menu);
					    		txtpnAblauf.setText("Ablaufdatum");
					    		txtpnAblauf.setBounds(152, 81, 66, 20);
					    		tabeingabe.add(txtpnAblauf);
					    		

					    		btneintragen.addMouseListener(new MouseAdapter() {
					    			@Override
					    			public void mouseClicked(MouseEvent arg0) {
					    			
					    			try {
					    				double ergebnis, praemie;


					    				if ((cbsparte.getSelectedItem()=="HRV") && (cbtaetigkeit.getSelectedItem()=="Vertragsabschluss"))
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.2);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="WGV") && (cbtaetigkeit.getSelectedItem()=="Vertragsabschluss")) 
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.24);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="GLS") && (cbtaetigkeit.getSelectedItem()=="Vertragsabschluss")) 
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.18);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="PHV") && (cbtaetigkeit.getSelectedItem()=="Vertragsabschluss"))
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.17);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="UNF") && (cbtaetigkeit.getSelectedItem()=="Vertragsabschluss"))
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (praemie*0.21);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="KRV") && (cbtaetigkeit.getSelectedItem()=="Vertragsabschluss")) 
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = (((praemie/12)*5)*0.3);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if ((cbsparte.getSelectedItem()=="RSV") && (cbtaetigkeit.getSelectedItem()=="Vertragsabschluss"))
					    				{
					    				praemie = Double.parseDouble(ftfpraemie.getText());
					    				ergebnis = ((praemie*0.5)*0.3);
					    				ftfprov.setText(String.valueOf(ergebnis));
					    				}
					    				
					    				else if((cbsparte.getSelectedItem()=="LV") && (cbtaetigkeit.getSelectedItem()=="Vertragsabschluss")) 
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
					    					
					    						
//					    						dbc.insert(taetigkeit, sparte, praemie, netto_provision, crossselling,0.0);
//					    						dbc.ausgabe();
					    					}
					    				});
					    				tabbedPane.addTab("Eingabe", tabeingabe);
					    				
					    				JFormattedTextField formattedTextField = new JFormattedTextField();
					    				formattedTextField.setBounds(10, 112, 66, 20);
					    				tabeingabe.add(formattedTextField);
					    				
					    				JFormattedTextField formattedTextField_1 = new JFormattedTextField();
					    				formattedTextField_1.setBounds(152, 112, 66, 20);
					    				tabeingabe.add(formattedTextField_1);
					    				
					    				JTextPane txtpnBeginnDarum = new JTextPane();
					    				txtpnBeginnDarum.setBackground(SystemColor.menu);
					    				txtpnBeginnDarum.setSelectedTextColor(SystemColor.menu);
					    				txtpnBeginnDarum.setText("Beginn Datum");
					    				txtpnBeginnDarum.setBounds(10, 81, 88, 20);
					    				tabeingabe.add(txtpnBeginnDarum);
		tabbedPane.addTab("Zusammenfassung", tabzusammenfassung);
		tabbedPane.addTab("Ziele", tabziele);
		
		JTextPane txtpnZieleProMonat = new JTextPane();
		txtpnZieleProMonat.setBackground(SystemColor.menu);
		txtpnZieleProMonat.setText("Provisionsziel pro Monat");
		txtpnZieleProMonat.setBounds(10, 17, 205, 20);
		tabziele.add(txtpnZieleProMonat);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(10, 51, 121, 20);
		tabziele.add(spinner);
		
		JButton button = new JButton("Ablegen");
		button.setBounds(265, 207, 154, 23);
		tabziele.add(button);
		
		
	}

	public Eingabe() {
		setTitle("Aussendienst Erfolgsprogramm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 432, 315);

		

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
