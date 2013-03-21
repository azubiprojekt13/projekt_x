package me.codplaymakers.com;

public class DiagrammAusZiel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DBController dbc = new DBController();
		dbc.initDBConnection();
		/*
		Balkendiagramm dia1 = new Balkendiagramm("Testdiagramm", 1.0, dbc.ausgabeDiagrammZiele("Neuabschluss", "WGV"));
        dia1.pack();
        dia1.setVisible(true);*/
		KreisDiagramm dia2 = new KreisDiagramm("Provionsübersicht", "Provision");
		dia2.AddValue("Provisionsstand", dbc.
		dia2.AddValue("Wunschprovision",dbc.ausgabeDiagrammProv());
		
	}

}
