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




//package WindowBuilder;

import java.sql.Connection; 
import java.sql.Date; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 




public class WindowBuilderTEst extends JFrame {

	public String [] daten ;
	
	private JPanel contentPane;
	private JTextField txtprov;
	private JTextField txtpraemie;
	private JTextField txtnetto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowBuilderTEst frame = new WindowBuilderTEst();
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
	public WindowBuilderTEst() {
		setTitle("Aussendienst Erfolgsprogramm");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btneintragen = new JButton("Provision Berechnen");
		btneintragen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		btneintragen.setBounds(242, 143, 165, 23);
		contentPane.add(btneintragen);
		
		String sparten[] = {"Leben", "Sach"};
		JComboBox cbsparte = new JComboBox(sparten);
		cbsparte.setEditable(true);
		cbsparte.setSelectedItem("Leben");
		cbsparte.setBounds(75, 62, 68, 20);
		contentPane.add(cbsparte);
		
		JTextPane txtpnVertrag = new JTextPane();
		txtpnVertrag.setText("Tätigkeit");
		txtpnVertrag.setBounds(0, 31, 68, 20);
		contentPane.add(txtpnVertrag);
		
		JTextPane txtpnSparte = new JTextPane();
		txtpnSparte.setText("Sparte");
		txtpnSparte.setBounds(73, 31, 70, 20);
		contentPane.add(txtpnSparte);
		
		JTextPane txtpnPrmie = new JTextPane();
		txtpnPrmie.setText("Pr\u00E4mie");
		txtpnPrmie.setBounds(152, 31, 69, 20);
		contentPane.add(txtpnPrmie);
		
		JTextPane txtpnNettoprovision = new JTextPane();
		txtpnNettoprovision.setText("Netto/Provision");
		txtpnNettoprovision.setBounds(321, 31, 86, 20);
		contentPane.add(txtpnNettoprovision);
		
		txtprov = new JTextField();
		txtprov.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		txtprov.setBounds(231, 62, 68, 20);
		contentPane.add(txtprov);
		txtprov.setColumns(10);
		
		 JPanel paneleingabe  = new JPanel();
		 JPanel panelfortschritt = new JPanel();
		 JPanel panelbestand = new JPanel();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.addTab("Ist-Zustand", paneleingabe);
		tabbedPane.addTab("Fortschritt", panelfortschritt);
		tabbedPane.addTab("Soll-Zustand", panelbestand);
		tabbedPane.setBounds(0, 0, 200, 20);
		contentPane.add(tabbedPane);
		
		final JComboBox cbtaetigkeit = new JComboBox();
		cbtaetigkeit.setEditable(true);
		cbtaetigkeit.setModel(new DefaultComboBoxModel(new String[] {"Kunde", "Abschluss"}));
		cbtaetigkeit.setBounds(0, 62, 65, 20);
		contentPane.add(cbtaetigkeit);
		
		JRadioButton rb30 = new JRadioButton("30");
		rb30.setBounds(319, 113, 109, 23);
		contentPane.add(rb30);
		
		JRadioButton rb40 = new JRadioButton("40");
		rb40.setBounds(319, 89, 109, 23);
		contentPane.add(rb40);
		
		txtpraemie = new JTextField();
		txtpraemie.setText("526");
		txtpraemie.setBounds(147, 62, 76, 20);
		contentPane.add(txtpraemie);
		txtpraemie.setColumns(10);
		
		JTextPane txtpnBewertung = new JTextPane();
		txtpnBewertung.setText("Bewertung");
		txtpnBewertung.setBounds(231, 31, 68, 20);
		contentPane.add(txtpnBewertung);
		
		txtnetto = new JTextField();
		txtnetto.setBounds(321, 62, 76, 20);
		contentPane.add(txtnetto);
		txtnetto.setColumns(10);
		
		final csvErzeugen blubb = new csvErzeugen();
		
		JButton btnAblegen = new JButton("Ablegen");
		btnAblegen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				

				daten = new String [4]; //4 = anzahl an elementen
				daten[0] = cbtaetigkeit.getSelectedItem().toString();
				txtprov.setText(daten[0]);
				blubb.generateCsvFile(daten);
			}
		});

		btnAblegen.setBounds(242, 177, 165, 23);
		contentPane.add(btnAblegen);
	
		  

	

	
	
	}

	public JTextField getTxtpraemie() {
		return txtpraemie;
	}

	public void setTxtpraemie(JTextField txtpraemie) {
		this.txtpraemie = txtpraemie;
	}
}


