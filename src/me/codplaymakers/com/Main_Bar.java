package me.codplaymakers.com;

public class Main_Bar {
   public static void main(String[] args) {
          KreisDiagramm testing = new KreisDiagramm("Test","Hallo");
          testing.AddValue("TEst1",20.5);
		  testing.AddValue("TEST2",30.1);
		  testing.createDiagramm();
		  testing.pack();
		  testing.setVisible(true);
      }
} 

