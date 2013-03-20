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
        dbc.insertBestand("abc", "dfg", 12.5, 54.3, "yes", 30.0);
        //dbc.insertZiele("Zgt", "Guf", 17.5, 47.2, "no", 40.0);
        //dbc.ausgabeBestand();
       // dbc.ausgabeZiele();
        dbc.ausgabeDiagrammBestand("03");
        System.out.println(String.valueOf(dbc.ausgabeDiagrammZiele()));
	}

}
