package me.codplaymakers.com;
import java.sql.Connection; 
import java.sql.Date; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.sql.Statement; 

class DBController { 
     
    private static final DBController dbcontroller = new DBController(); 
    private static Connection connection; 
    private static final String DB_PATH = System.getProperty("user.home") + "/" + "testdb.db"; 

    static { 
        try { 
            Class.forName("org.sqlite.JDBC"); 
        } catch (ClassNotFoundException e) { 
            System.err.println("Fehler beim Laden des JDBC-Treibers"); 
            e.printStackTrace(); 
        } 
    } 
     
    private DBController(){ 
    } 
     
    public static DBController getInstance(){ 
        return dbcontroller; 
    } 
     
    private void initDBConnection() { 
        try { 
            if (connection != null) 
                return; 
            System.out.println("Creating Connection to Database..."); 
            connection = DriverManager.getConnection("jdbc:sqlite:" + DB_PATH); 
            if (!connection.isClosed()) 
                System.out.println("...Connection established"); 
        } catch (SQLException e) { 
            throw new RuntimeException(e); 
        } 

        Runtime.getRuntime().addShutdownHook(new Thread() { 
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
    } 

    private void handleDB() { 
        try { 
            Statement stmt = connection.createStatement(); 
           //CREATE DROP
            stmt.executeUpdate("DROP TABLE IF EXISTS bestand;"); 
            stmt.executeUpdate("DROP TABLE IF EXISTS ziele;"); 
            stmt.executeUpdate("CREATE TABLE bestand (id, taetigkeit, sparte, praemie, netto_provison, crossselling, provisionssatz, create_stamp, update_stamp);");
            stmt.executeUpdate("CREATE TABLE ziele (anzahl, taetigkeit, sparte, provisionssumme)");
            //INSERT 1
            stmt.execute("INSERT INTO bestand (id, taetigkeit, sparte, praemie, netto_provison, crossselling, provisionssatz, create_stamp, update_stamp) VALUES ('1', 'Termin', 'KFZ', '123', '', 'yes', '30', '09.09.2012', '09.09.2012')"); 
             
            PreparedStatement ps = connection 
                    .prepareStatement("INSERT INTO bestand VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);"); 
            
         
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



            connection.setAutoCommit(false); 
            ps.executeBatch(); 
            connection.setAutoCommit(true); 

            ResultSet rs = stmt.executeQuery("SELECT * FROM bestand WHERE create_stamp = to_date('date','MM');"); 
            while (rs.next()) { 
                System.out.println("ID = " + rs.getInt("id")); 
                System.out.println("Taetigkeit = " + rs.getString("taetigkeit")); 
                System.out.println("Sparte = " + rs.getString("sparte")); 
                System.out.println("Prämie = " + rs.getDouble("praemie")); 
                System.out.println("Netto Provision = " + rs.getDouble("netto_provison"));
                System.out.println("Crossseling = " + rs.getString("crossselling"));
                System.out.println("Provisionssatz = " + rs.getDouble("provisionssatz"));
                System.out.println("Create Stamp = " + rs.getDate("create_stamp"));
                System.out.println("Update Stamp = " + rs.getDate("update_stamp"));
            } 
            rs.close(); 
            connection.close(); 
        } catch (SQLException e) { 
            System.err.println("Couldn't handle DB-Query"); 
            e.printStackTrace(); 
        } 
    } 

    public static void main(String[] args) { 
        DBController dbc = DBController.getInstance(); 
        dbc.initDBConnection(); 
        dbc.handleDB(); 
    } 
}
