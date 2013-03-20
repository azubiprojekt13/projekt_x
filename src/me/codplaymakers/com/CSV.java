package me.codplaymakers.com;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSV 
{

	private String zeile;
	private ArrayList list = new ArrayList();
	private String[] split = null;
		
	public static void main(String[] args) 
	{
		CSV c = new CSV();
		c.readData();
		c.printData();
	}
	

	// Einlesen der Datei

	public void readData() 
	{
		try 
		{
				FileReader file = new FileReader("Test.csv");
				BufferedReader data = new BufferedReader(file);
				while ((zeile = data.readLine()) != null) 
				{
					split = zeile.split(";");
					for(int i=0; i<split.length; i++)  //ignoriert leerzeilen
					{ 
						if( !(split[i].equals("")) )   //entfernt Leerzeichen zwischen zwei Simikolon (;)
						list.add(split[i].trim());
					}
				}
		} 

	//Exception 
		  catch (FileNotFoundException e) 
		{
			System.out.println("Datei nicht gefunden");
		} catch (IOException e) {
			System.out.println("E/Anicht-Fehler");
		}
	}
	
	// Ausgabe

	public void printData() 
	{
		int max = list.size();
        for(int i=0; i<max; i++) 
        {
			System.out.println(list.get(i));
        }
	}
}