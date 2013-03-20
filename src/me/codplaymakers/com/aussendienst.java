package me.codplaymakers.com;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ButtonGroup;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JSpinner;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JCheckBox;

public class aussendienst extends JFrame {

	public String [] daten ;
	
	private JPanel contentPane;
	private JTextField txtpraemie;
	private JTextField txtprovision;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					aussendienst frame = new aussendienst();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public aussendienst() {
		setTitle("Aussendienst Erfolgsprogramm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btneintragen = new JButton("Provision Berechnen");
		btneintragen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
//				double txtprov;
//			
//				double txtpraemie = Integer.parseInt(getName());
//				txtprov = (txtpraemie*0.24*0.3);
//				String txtpro = String.valueOf(txtprov);		
//				txtprov.setText(txtprov);
				
			}
		});
		btneintragen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btneintragen.setBounds(21, 213, 165, 23);
		contentPane.add(btneintragen);
		
		String sparten[] = {"Leben", "Sach"};
		JComboBox cbsparte = new JComboBox(sparten);
		cbsparte.setModel(new DefaultComboBoxModel(new String[] {"HRV", "WGV", "GLS", "PHV", "UNF", "KRV", "RSV", "LV"}));
		cbsparte.setEditable(true);
		cbsparte.setSelectedItem("LV");
		cbsparte.setBounds(105, 62, 68, 20);
		contentPane.add(cbsparte);
		
		JTextPane txtpnVertrag = new JTextPane();
		txtpnVertrag.setEditable(false);
		txtpnVertrag.setText("Tätigkeit");
		txtpnVertrag.setBounds(0, 31, 95, 20);
		contentPane.add(txtpnVertrag);
		
		JTextPane txtpnSparte = new JTextPane();
		txtpnSparte.setEditable(false);
		txtpnSparte.setText("Sparte");
		txtpnSparte.setBounds(105, 31, 70, 20);
		contentPane.add(txtpnSparte);
		
		JTextPane txtpnPrmie = new JTextPane();
		txtpnPrmie.setEditable(false);
		txtpnPrmie.setText("Nettojahresprämie");
		txtpnPrmie.setBounds(185, 31, 95, 20);
		contentPane.add(txtpnPrmie);
		
		JTextPane txtpnNettoprovision = new JTextPane();
		txtpnNettoprovision.setEditable(false);
		txtpnNettoprovision.setText("Provision");
		txtpnNettoprovision.setBounds(299, 31, 76, 20);
		contentPane.add(txtpnNettoprovision);
		
		 JPanel paneleingabe  = new JPanel();
		 JPanel panelfortschritt = new JPanel();
		 JPanel panelziele = new JPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.addTab("Ist-Zustand", paneleingabe);
		tabbedPane.addTab("Fortschritt", panelfortschritt);
		tabbedPane.addTab("Soll-Zustand", panelziele);
		tabbedPane.setBounds(0, 0, 200, 20);
		contentPane.add(tabbedPane);
		
		final JComboBox cbtaetigkeit = new JComboBox();
		cbtaetigkeit.setEditable(true);
		cbtaetigkeit.setModel(new DefaultComboBoxModel(new String[] {"Neuabschluss", "Vertragsverl\u00E4ngerung", "Servicetermin", "Storno"}));
		cbtaetigkeit.setBounds(0, 62, 95, 20);
		contentPane.add(cbtaetigkeit);
		

		
		JRadioButton rb30 = new JRadioButton("30");
		rb30.setBounds(0, 148, 54, 23);
		contentPane.add(rb30);
		
		JRadioButton rb40 = new JRadioButton("40");
		rb40.setBounds(56, 148, 54, 23);
		contentPane.add(rb40);
		
		txtpraemie = new JTextField();
		txtpraemie.setBounds(183, 62, 97, 20);
		contentPane.add(txtpraemie);
		txtpraemie.setColumns(10);
		
		txtprovision = new JTextField();
		txtprovision.setBounds(299, 62, 76, 20);
		contentPane.add(txtprovision);
		txtprovision.setColumns(10);
		
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

		btnAblegen.setBounds(227, 213, 165, 23);
		contentPane.add(btnAblegen);
		
		JCheckBox chckbxCrossseling = new JCheckBox("Crossseling");
		chckbxCrossseling.setBounds(0, 89, 97, 23);
		contentPane.add(chckbxCrossseling);
		
		JRadioButton rb50 = new JRadioButton("50");
		rb50.setBounds(112, 148, 48, 23);
		contentPane.add(rb50);
		
		JTextPane txtpnModell = new JTextPane();
		txtpnModell.setEditable(false);
		txtpnModell.setText("Provisionsmodell");
		txtpnModell.setBounds(0, 121, 107, 20);
		contentPane.add(txtpnModell);
	
	    ButtonGroup group = new ButtonGroup();
	    group.add(rb30);
	    group.add(rb40);
	    group.add(rb50);

	

	
	
	}
}
