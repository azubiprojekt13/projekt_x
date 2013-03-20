package me.codplaymakers.com;

public class datenbanktest {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

        DBController dbc = DBController.getInstance(); 
        dbc.initDBConnection(); 
        dbc.handleDB(); 
	}

}
