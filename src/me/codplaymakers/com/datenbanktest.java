package me.codplaymakers.com;

public class datenbanktest {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

        DBController dbc = new DBController(); 
        dbc.initDBConnection(); 
        //dbc.handleDB(); 
        dbc.insert("abc", "dfg", 12.5, 54.3, "yes", 30.0);
        dbc.ausgabe();
	}

}
