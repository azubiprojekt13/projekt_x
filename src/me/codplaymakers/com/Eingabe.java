package me.codplaymakers.com;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;

public class Eingabe 
	extends JFrame {

	public String [] daten ;
	
	private JTabbedPane tabbedPane;
	private JPanel tabeingabe ;
	private JPanel tabzusammenfassung ;
	private JPanel tabziele;

	private void EingabeTabErzeugen(){
		tabeingabe  = new JPanel();
tabeingabe.setLayout(null);
		
		JTextPane txtpnVertrag = new JTextPane();
		txtpnVertrag.setEditable(false);
		txtpnVertrag.setText("T�tigkeit");
		txtpnVertrag.setBounds(35, 5, 47, 20);
		tabeingabe.add(txtpnVertrag);
		
		JTextPane txtpnSparte = new JTextPane();
		txtpnSparte.setEditable(false);
		txtpnSparte.setText("Sparte");
		txtpnSparte.setBounds(92, 5, 38, 20);
		tabeingabe.add(txtpnSparte);
		
		JTextPane txtpnPrmie = new JTextPane();
		txtpnPrmie.setEditable(false);
		txtpnPrmie.setText("Nettojahrespr�mie");
		txtpnPrmie.setBounds(135, 5, 95, 20);
		tabeingabe.add(txtpnPrmie);
		
		JTextPane txtpnNettoprovision = new JTextPane();
		txtpnNettoprovision.setEditable(false);
		txtpnNettoprovision.setText("Provision");
		txtpnNettoprovision.setBounds(235, 5, 49, 20);
		tabeingabe.add(txtpnNettoprovision);
		JComboBox cbsparte = new JComboBox();
		cbsparte.setModel(new DefaultComboBoxModel(new String[] {"HRV", "WGV", "GLS", "PHV", "UNF", "KRV", "RSV", "LV"}));
		cbsparte.setEditable(true);
		cbsparte.setSelectedItem("LV");
		cbsparte.setBounds(289, 5, 98, 20);
		tabeingabe.add(cbsparte);
		

		
		
		final JComboBox cbtaetigkeit = new JComboBox();
		cbtaetigkeit.setEditable(true);
		cbtaetigkeit.setModel(new DefaultComboBoxModel(new String[] {"Neuabschluss", "Vertragsverl\u00E4ngerung", "Servicetermin", "Storno"}));
		cbtaetigkeit.setBounds(35, 79, 130, 20);
		tabeingabe.add(cbtaetigkeit);
		
		//final csvErzeugen blubb = new csvErzeugen();
		
		JButton btnAblegen = new JButton("Ablegen");
		btnAblegen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				/*daten = new String [4]; //4 = anzahl an elementen
				daten[0] = cbtaetigkeit.getSelectedItem().toString();
				txtprov.setText(daten[0]);
				blubb.generateCsvFile(daten);*/
			}
		});

		btnAblegen.setBounds(192, 30, 71, 23);
		tabeingabe.add(btnAblegen);
		
		JCheckBox chckbxCrossseling = new JCheckBox("Crossseling");
		chckbxCrossseling.setBounds(268, 30, 79, 23);
		tabeingabe.add(chckbxCrossseling);
	
	
	    
	    final JFormattedTextField ftfpraemie = new JFormattedTextField();
	    ftfpraemie.setBounds(352, 31, 6, 20);
	    tabeingabe.add(ftfpraemie);
	    
	    final JFormattedTextField ftfprov = new JFormattedTextField();
	    ftfprov.setBounds(363, 31, 6, 20);
	    tabeingabe.add(ftfprov);

		JButton btneintragen = new JButton("Provision Berechnen");
		btneintragen.setBounds(149, 58, 129, 23);
		tabeingabe.add(btneintragen);
		

		btneintragen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
			try {
				double ergebnis, praemie;
				praemie = Double.parseDouble(ftfpraemie.getText());
				ergebnis = (praemie*0.24*0.3);
				ftfprov.setText(String.valueOf(ergebnis));
			}
			catch (Exception e)
			{
				System.out.println("Keine Zahl eingegeben!");
			}

				
			}
		}
	);
	}

	
	private void ZusammenfassungTabErzeugen(){
		tabzusammenfassung = new JPanel();
		
		
	}
	
	private void ZieleTabErzeugen(){
		tabziele = new JPanel();
	}

	public Eingabe() {
		setTitle("Aussendienst Erfolgsprogramm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 288);


		

		  EingabeTabErzeugen();
		  ZusammenfassungTabErzeugen();
		  ZieleTabErzeugen();
		  
		
		tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Eingabe", tabeingabe);
		tabbedPane.addTab("Zusammenfassung", tabzusammenfassung);
		tabbedPane.addTab("Ziele", tabziele);
		tabbedPane.setBounds(0, 0, 200, 20);
		setContentPane(tabbedPane);
		
		
		
	}


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eingabe frame = new Eingabe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
