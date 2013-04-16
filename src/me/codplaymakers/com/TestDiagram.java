package me.codplaymakers.com;

public class TestDiagram {

	//dbc = new DBController;

	public static void main(String[] args) {
		
		DBController dbc = new DBController();
		dbc.initDBConnection();
		
		Eingabe ein = new Eingabe();
		
		
		    /*KreisDiagramm demo = new KreisDiagramm("Vergleich", "Test");
		    demo.AddValue("TEst1",20.5);
		    
		    sssss
		    demo.AddValue("TEST2",30.1);
		    demo.createDiagramm();
		    demo.pack();
		    
		    tada
	        demo.setVisible(true);*/
//	        Balkendiagramm balken1 = new Balkendiagramm("Dia1", 5.0, 7.0);
//	        balken1.pack();
//	        balken1.setVisible(true);
	        KreisDiagramm test = new KreisDiagramm("Uebersicht Bestand", "Alle Abschlüsse pro Sparte");
	        test.AddValue("SHU Vertraege", dbc.ausgabeDiagrammBestandSHUproJahr("Abschluss"));
	        test.AddValue("Leben Vertraege", dbc.ausgabeDiagrammBestandLEBENproJahr("Abschluss"));
	        test.AddValue("KFZ Vertraege", dbc.ausgabeDiagrammBestandKFZproJahr("Abschluss"));
	        test.createDiagramm();
		    test.pack();
		    test.setVisible(true);
	        
	}

}
