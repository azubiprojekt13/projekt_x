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
        //dbc.insertBestand("abc", "dfg", 12.5, 54.3, "yes", 30.0);
        dbc.insertZielsetzungen("blabla", "jkdfalkdsj", 5.0, 6.0);
        //dbc.ausgabeBestand();
        dbc.ausgabeZiele();
       // dbc.ausgabeDiagrammBestand("03");
        //System.out.println(String.valueOf(dbc.ausgabeDiagrammZiele()));
	}

}
