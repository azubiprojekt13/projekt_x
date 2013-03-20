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

class DBController 
{ 
	

     
   // private static final DBController dbcontroller = new DBController(); 
    private  Connection connection; 
    private static final String DB_PATH = System.getProperty("user.home") + "/" + "testdb.db"; 

    
    static 
    { 
        try 
        { 
            Class.forName("org.sqlite.JDBC"); 
        } catch (ClassNotFoundException e) 
        
        { 
            System.err.println("Fehler beim Laden des JDBC-Treibers"); 
            e.printStackTrace(); 
        } 
    } 
     
    protected DBController()
    { 
    
    } 
     
 //   public static DBController getInstance(){ 
 //       return dbcontroller; 
//    } 
     
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
/*       Runtime.getRuntime().addShutdownHook(new Thread() { 
            public void run() { 
                try { 
                    if (!connection.isClosed() && connection != null) { 
                        connection.close(); 
                        if (connection.isClosed()) 
                            System.out.println("Connection to Database closed"); 
                    } 
                } catch (SQLException e) { 
                    e.printStackTrace(); 
                } 
            } 
        }); 
    } */
    public void ausgabe()
    {
    	try
    {
    	Statement stmt = connection.createStatement(); 
    	ResultSet rs = stmt.executeQuery("SELECT * FROM bestand;"); 
        while (rs.next()) { 
            System.out.println("ID = " + rs.getInt("id")); 
            System.out.println("Taetigkeit = " + rs.getString("taetigkeit")); 
            System.out.println("Sparte = " + rs.getString("sparte")); 
            System.out.println("Prämie = " + rs.getDouble("praemie")); 
            System.out.println("Netto Provision = " + rs.getDouble("netto_provison"));
            System.out.println("Crossseling = " + rs.getString("crossselling"));
            System.out.println("Provisionssatz = " + rs.getDouble("provisionssatz"));
            System.out.println("Create Stamp = " + rs.getTimestamp("create_stamp"));
            System.out.println("Update Stamp = " + rs.getTimestamp("update_stamp"));
        }
        rs.close(); 
    } catch (SQLException e) 
    
    { 
        System.err.println("Couldn't handle DB-Query"); 
        e.printStackTrace(); 
    } 
    	 
    }
    public void insert(String taetigkeit, String sparte, Double praemie, Double netto_provision, String crossselling, Double provisionssatz)
    {
    	java.sql.Timestamp  sqlDate = new java.sql.Timestamp(new java.util.Date().getTime());
    	
    	try 
    	{ 
            //Statement stmt = connection.createStatement();
            
    	PreparedStatement ps = connection 
                .prepareStatement("INSERT INTO bestand VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);"); 
    	
    	 ps.setInt(1, 1); 
         ps.setString(2, taetigkeit);
         ps.setString(3, sparte);
         ps.setDouble(4, praemie);
         ps.setDouble(5, netto_provision);
         ps.setString(6, crossselling);
         ps.setDouble(7, provisionssatz);
         ps.setTimestamp(8, sqlDate); 
         ps.setTimestamp(9, sqlDate);  
         ps.addBatch();
         ps.executeBatch();
    	}
    	
    	catch (SQLException e)
    	{ 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
            
        }
    	
    }
    protected void handleDB() 
    { 
        try { 
            Statement stmt = connection.createStatement(); 
           //CREATE DROP
            stmt.executeUpdate("DROP TABLE IF EXISTS bestand;"); 
            stmt.executeUpdate("CREATE TABLE bestand (id, taetigkeit, sparte, praemie, netto_provison, crossselling, provisionssatz, create_stamp, update_stamp);");
            //stmt.executeUpdate("CREATE TABLE ziele (anzahl, taetigkeit, sparte, provisionssumme");
            //INSERT 1
           // stmt.execute("INSERT INTO bestand (id, taetigkeit, sparte, praemie, netto_provison, crossselling, provisionssatz, create_stamp, update_stamp) VALUES ('1', 'Termin', 'KFZ', '123', '', 'yes', '30', '09.09.2012', '09.09.2012')"); 
             
            PreparedStatement ps = connection 
                    .prepareStatement("INSERT INTO bestand VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);"); 
            
         /*
            //INSERT 2
            ps.setInt(1, 1); 
            ps.setString(2, "Vertraege");
            ps.setString(3, "Leben");
            ps.setDouble(4, 800.23);
            ps.setDouble(5, 0);
            ps.setString(6, "No");
            ps.setDouble(7, 30);
            ps.setDate(8, Date.valueOf("2011-05-16")); 
            ps.setDate(9, Date.valueOf("2011-05-16"));  
            ps.addBatch(); 
*/


            connection.setAutoCommit(false); 
            ps.executeBatch(); 
            connection.setAutoCommit(true); 
            
            connection.close(); 
        } catch (SQLException e) { 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
        } 
    } 
}