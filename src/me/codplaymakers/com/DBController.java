package me.codplaymakers.com;

/*import java.awt.BorderLayout;
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
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.*;

class DBController 
{ 
   // Erstellt Datenbankverbindung 
   // private static final DBController dbcontroller = new DBController(); 
    private  Connection connection; 
    // Legt den Standartpfad auf das Heimverzeichnis des Benutzers
    private static final String DB_PATH = System.getProperty("user.home") + "/" + "produktionsliste.db"; 
    
    static 
    { 
        try 
        { 
            Class.forName("org.sqlite.JDBC"); 
        } catch (ClassNotFoundException e) 
    // Exception    
        { 
            System.err.println("Fehler beim Laden des JDBC-Treibers"); 
            e.printStackTrace(); 
        } 
    } 
     
    protected DBController()
    { 
    	File f = new File(DB_PATH);
    	if(!f.exists()) { 
    		initDBConnection();
    		InstallDB();
    	}
    } 
     
    protected void initDBConnection() 
    { 
        try 
        { 
            if (connection != null) 
                return; 
            System.out.println("Creating Connection to Database..."); 
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH); 
            if (!connection.isClosed()) 
                System.out.println("...Connection established"); 
        } catch (SQLException e) 
        
        { 
            throw new RuntimeException(e); 
        } 
    }
    
    public int ausgabeDiagrammBestandSHU(String taetigkeit)
    {
    	int i = 0;
    	try
    	{
	    	Statement stmt = connection.createStatement(); 
	    	ResultSet rs = stmt.executeQuery("SELECT * FROM bestand WHERE strftime('%m',datetime(update_stamp,'unixepoch'))= strftime('%m','now') AND taetigkeit = '"+taetigkeit+"' AND sparte ='HRV' OR sparte ='WGV' OR sparte ='GLS' OR sparte ='UNF';"); 
	        while (rs.next()) 
	        {
	        	i++;
	        }
    	}
    	catch (SQLException e) 
        { 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
        }
    	return i;
    }
    public int ausgabeDiagrammBestandL(String taetigkeit)
    {
    	int i = 0;
    	try
    	{
	    	Statement stmt = connection.createStatement(); 
	    	ResultSet rs = stmt.executeQuery("SELECT * FROM bestand WHERE strftime('%m',datetime(update_stamp,'unixepoch'))= strftime('%m','now') AND taetigkeit = '"+taetigkeit+"' AND sparte ='L';"); 
	        while (rs.next()) 
	        {
	        	i++;
	        }
    	}
    	catch (SQLException e) 
        { 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
        }
    	return i;
    }
    public int ausgabeDiagrammBestandKFZ(String taetigkeit)
    {
    	int i = 0;
    	try
    	{
	    	Statement stmt = connection.createStatement(); 
	    	ResultSet rs = stmt.executeQuery("SELECT * FROM bestand WHERE strftime('%m',datetime(update_stamp,'unixepoch'))= strftime('%m','now') AND taetigkeit = '"+taetigkeit+"' AND sparte ='KFZ';"); 
	        while (rs.next()) 
	        {
	        	i++;
	        }
    	}
    	catch (SQLException e) 
        { 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
        }
    	return i;
    }
    
    
    
    public double ausgabeDiagrammZieleSHU(String taetigkeit)
    {
    	double anzahl = 0.0;
    	try
    	{
	    	Statement stmt = connection.createStatement(); 
	    	ResultSet rs = stmt.executeQuery("SELECT anzahl FROM ziele where taetigkeit = '"+taetigkeit+"' AND sparte ='HRV' OR sparte ='WGV' OR sparte ='GLS' OR sparte ='UNF' AND create_stamp = (select max(create_stamp) from ziele);"); 
	        while (rs.next()) 
	        {
	        	anzahl=rs.getDouble("anzahl");
	        }
    	}
    	catch (SQLException e) 
        { 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
        }
    	return anzahl;
    }
    
    public double ausgabeDiagrammZieleL(String taetigkeit)
    {
    	double anzahl = 0.0;
    	try
    	{
	    	Statement stmt = connection.createStatement(); 
	    	ResultSet rs = stmt.executeQuery("SELECT anzahl FROM ziele where taetigkeit = '"+taetigkeit+"' AND sparte ='L' AND create_stamp = (select max(create_stamp) from ziele);"); 
	        while (rs.next()) 
	        {
	        	anzahl=rs.getDouble("anzahl");
	        }
    	}
    	catch (SQLException e) 
        { 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
        }
    	return anzahl;
    }
    
    public double ausgabeDiagrammZieleKFZ(String taetigkeit)
    {
    	double anzahl = 0.0;
    	try
    	{
	    	Statement stmt = connection.createStatement(); 
	    	ResultSet rs = stmt.executeQuery("SELECT anzahl FROM ziele where taetigkeit = '"+taetigkeit+"' AND sparte ='KFZ' AND create_stamp = (select max(create_stamp) from ziele);"); 
	        while (rs.next()) 
	        {
	        	anzahl=rs.getDouble("anzahl");
	        }
    	}
    	catch (SQLException e) 
        { 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
        }
    	return anzahl;
    }
    
    public double ausgabeDiagrammZieleKFZproJahr(String taetigkeit)
    {
    	double KFZprojahr = 0;
    	try
    	{
	    	Statement stmt = connection.createStatement(); 
	    	ResultSet rs = stmt.executeQuery("SELECT anzahl FROM Ziele WHERE AND sparte ='KFZ' and create_stamp = (select max(create_stamp) from ziele);"); 
	        while (rs.next()) 
	        {
	        	KFZprojahr = rs.getDouble("anzahl");
	        }
    	}
    	catch (SQLException e) 
        { 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
        }
    	KFZprojahr=KFZprojahr*12;
    	return KFZprojahr;
    }
    public double ausgabeDiagrammZieleSHUproJahr(String taetigkeit)
    {
    	double SHUprojahr = 0;
    	try
    	{
	    	Statement stmt = connection.createStatement(); 
	    	ResultSet rs = stmt.executeQuery("SELECT anzahl FROM Ziele WHERE AND sparte ='SHU' and create_stamp = (select max(create_stamp) from ziele);"); 
	        while (rs.next()) 
	        {
	        	SHUprojahr = rs.getDouble("anzahl");
	        }
    	}
    	catch (SQLException e) 
        { 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
        }
    	SHUprojahr=SHUprojahr*12;
    	return SHUprojahr;
    }
    
    public double ausgabeDiagrammZieleLEBENproJahr(String taetigkeit)
    {
    	double LEBENprojahr = 0;
    	try
    	{
	    	Statement stmt = connection.createStatement(); 
	    	ResultSet rs = stmt.executeQuery("SELECT anzahl FROM Ziele WHERE AND sparte ='L' and create_stamp = (select max(create_stamp) from ziele);"); 
	        while (rs.next()) 
	        {
	        	LEBENprojahr = rs.getDouble("anzahl");
	        }
    	}
    	catch (SQLException e) 
        { 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
        }
    	LEBENprojahr=LEBENprojahr*12;
    	return LEBENprojahr;
    }
    
    public double ausgabeDiagrammProv()
    {
    	double provsumme = 0;
    	try
    	{
	    	Statement stmt = connection.createStatement(); 
	    	ResultSet rs = stmt.executeQuery("SELECT provisionssumme FROM ziele where provisionssumme IS NOT NULL AND create_stamp = (select max(create_stamp)from ziele) "); 
	        while (rs.next()) 
	        {
	        	provsumme = rs.getDouble("provisionssumme");
	        }
    	}
    	catch (SQLException e) 
        { 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
        }
    	return provsumme;
    }
    
    public double ausgabeDiagrammProvSumme()
    {
    	double provsumme = 0;
    	try
    	{
	    	Statement stmt = connection.createStatement(); 
	    	ResultSet rs = stmt.executeQuery("SELECT sum(netto_provison) AS provisionssummenwurst FROM bestand WHERE strftime('%m',datetime(update_stamp,'unixepoch')) = strftime('%m','now');"); 
	        while (rs.next()) 
	        {
	        	provsumme = rs.getDouble("provisionssummenwurst");
	        }
    	}
    	catch (SQLException e) 
        { 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
        }
    	return provsumme;
    }
    
    public void ausgabeZiele()

    {
	    	try
	    {
	    	Statement stmt = connection.createStatement(); 
	    	ResultSet rs = stmt.executeQuery("SELECT * FROM ziele;"); 
	        while (rs.next()) 
	        { 
	            System.out.println("Taetigkeit = " + rs.getString("taetigkeit"));
	            System.out.println("Sparte = " + rs.getString("sparte"));
	            System.out.println("Anzahl = " + rs.getDouble("anzahl"));
	            System.out.println("Provisionssumme = " + rs.getDouble("provisionssumme"));
	        }
	        rs.close(); 
	    } catch (SQLException e) 
	    
	    { 
	        System.err.println("Couldn't handle DB-Query"); 
	        e.printStackTrace(); 
	    }
    	
    }   
    
    public void ausgabeIstZustand()
    {
    	try
    {
    	Statement stmt = connection.createStatement(); 
    	ResultSet rs = stmt.executeQuery("SELECT * FROM istzustand;"); 
        while (rs.next()) 
        { 
            System.out.println("Taetigkeit = " + rs.getString("taetigkeit"));
            System.out.println("Sparte = " + rs.getString("sparte"));
            System.out.println("Anzahl = " + rs.getDouble("anzahl"));
            System.out.println("Provisionssumme = " + rs.getDouble("provisionssumme"));
        }
        rs.close(); 
    } catch (SQLException e) 
    
    { 
        System.err.println("Couldn't handle DB-Query"); 
        e.printStackTrace(); 
    }
	
}
    
    public void ausgabeBestand()
    {
    	try
    {
    	Statement stmt = connection.createStatement(); 
    	ResultSet rs = stmt.executeQuery("SELECT * FROM bestand;"); 
        while (rs.next()) 
        { 
            System.out.println("ID = " + rs.getInt("id")); 
            System.out.println("Taetigkeit = " + rs.getString("taetigkeit")); 
            System.out.println("Sparte = " + rs.getString("sparte")); 
            System.out.println("Pr�mie = " + rs.getDouble("praemie")); 
            System.out.println("Netto Provision = " + rs.getDouble("netto_provison"));
            System.out.println("Crossseling = " + rs.getString("crossselling"));
            System.out.println("Create Stamp = " + rs.getTimestamp("create_stamp"));
            System.out.println("Update Stamp = " + rs.getTimestamp("update_stamp"));
        }
        rs.close(); 
    } catch (SQLException e) 
    // Exception
    { 
        System.err.println("Couldn't handle DB-Query"); 
        e.printStackTrace(); 
    } 
    	 
    }
    
    // Insert Zielsetzung
    public void insertZielsetzungen(String taetigkeit, String sparte, Double anzahl_taetigkeiten, Double provisionsziel)
    {
    	java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
    	
    	try 
    	{ 
            //Statement stmt = connection.createStatement();
            
    	PreparedStatement ps = connection 
                .prepareStatement("INSERT INTO ziele VALUES (?, ?, ?, ?, ?);"); 
    	
    	long create_stamp = System.currentTimeMillis()/1000;

         ps.setString(1, taetigkeit);
         ps.setString(2, sparte);
         ps.setDouble(3, anzahl_taetigkeiten);
         ps.setDouble(4, provisionsziel); 
         ps.setDouble(5, create_stamp); 
         ps.addBatch();
         ps.executeBatch();
    	}
    	//Exception
    	catch (SQLException e)
    	{ 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
            
        }
    	
    }
    // Befuelle IST-Zustand
    
    public void insertistzustand(String taetigkeit, String sparte, Double anzahl_taetigkeiten, Double provisionsziel)
    {
    	java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
    	
    	try 
    	{ 
            //Statement stmt = connection.createStatement();
            
    	PreparedStatement ps = connection 
                .prepareStatement("INSERT INTO istzustand VALUES (?, ?, ?, ?, ?);"); 
    	
    	long create_stamp = System.currentTimeMillis()/1000;

         ps.setString(1, taetigkeit);
         ps.setString(2, sparte);
         ps.setDouble(3, anzahl_taetigkeiten);
         ps.setDouble(4, provisionsziel);  
         ps.setLong(5, create_stamp);  
         ps.addBatch();
         ps.executeBatch();
    	}
    	//Exception
    	catch (SQLException e)
    	{ 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
            
        }
    	
    }
 
    public void insertBestand(String taetigkeit, String sparte, Double praemie, Double netto_provision, String crossselling)
    {
    	
    	long timestamp = System.currentTimeMillis()/1000;
    	try 
    	{ 
            //Statement stmt = connection.createStatement();
            
    	PreparedStatement ps = connection 
                .prepareStatement("INSERT INTO bestand VALUES (?, ?, ?, ?, ?, ?, ?, ?);"); 
    	
    	 ps.setInt(1, 1); 
         ps.setString(2, taetigkeit);
         ps.setString(3, sparte);
         ps.setDouble(4, praemie);
         ps.setDouble(5, netto_provision);
         ps.setString(6, crossselling);
         ps.setLong(7, timestamp); 
         ps.setLong(8, timestamp);  
         ps.addBatch();
         ps.executeBatch();
    	}
    	
    	catch (SQLException e)
    	{ 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
            
        }
    	
    }
    
    
    // Create Tabellen Ziele und Bestand und IST-Zustand
    // Insert f�r die oben genannten Tabellen
    protected void InstallDB() 
    { 
        try { 
            Statement stmt = connection.createStatement(); 
            stmt.executeUpdate("CREATE TABLE bestand (id, taetigkeit, sparte, praemie, netto_provison, crossselling, create_stamp, update_stamp);");
            stmt.executeUpdate("CREATE TABLE ziele (taetigkeit, sparte, anzahl, provisionssumme,create_stamp);");
            stmt.executeUpdate("CREATE TABLE istzustand (taetigkeit, sparte, anzahl, provisionssumme,create_stamp);");
            connection.setAutoCommit(true); 
            connection.close(); 
            connection=null;
        } catch (SQLException e) { 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
        } 
    } 
    
}