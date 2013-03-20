package me.codplaymakers.com;

public class TestDiagram {


	public static void main(String[] args) {
		
		    KreisDiagramm demo = new KreisDiagramm("Vergleich", "Test");
		    demo.AddValue("TEst1",20.5);
		    demo.AddValue("TEST2",30.1);
		    demo.createDiagramm();
		    demo.pack();
	        demo.setVisible(true);
	}

}
