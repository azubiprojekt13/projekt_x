package me.codplaymakers.com;

/* 
***************************************************
  V 1.0  
  Frederick Harnisch 
  18.03.2013
  CSV Datei erzeugen und werte hineinschreiben
  ProjektID:
*************************************************** 
*/
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class csvErzeugen
{
	
	private String zeile;
	private ArrayList list = new ArrayList();
	private String[] split = null;
    private String File;
    private String[] ArrayReturn;
    
    
	private String getFile() {
		return File;
	}

	private void setFile(String file) {
		File = file;
	}

	private String[] getArrayReturn() {
		return ArrayReturn;
	}

	private void setArrayReturn(String[] arrayReturn) {
		ArrayReturn = arrayReturn;
	}


   
   public csvErzeugen(){
	   setFile("c:\\Temp\\Test.csv");
	  
   }
 
   public void  generateCsvFile(String[] sArray )
   {
    try
    {
        FileWriter writer = new FileWriter(getFile());
        for (int i = 0; i < sArray.length; i++)
        {
        
        writer.append(""+sArray[i]);
        writer.append(';');                    //Zeilenumbruch
        }
        writer.append('\n');
        writer.flush();
        writer.close();
    }
    catch(IOException e)
    {
         e.printStackTrace();
    } 
    }
   
   public String[] readData(int Index) 
	{
		try 
		{
				FileReader file = new FileReader("Test.csv");
				BufferedReader data = new BufferedReader(file);
				while ((zeile = data.readLine()) != null) 
				{
					setArrayReturn(zeile.split(";"));
					
				/*	for(int i=0; i<split.length; i++)  //ignoriert leerzeilen
					{ 
						set.ArrayReturn
						if( !(split[i].equals("")) )   //entfernt Leerzeichen zwischen zwei Simikolon (;)
						list.add(split[i].trim());
					}*/
				}

		} 

	//Exception 
		  catch (FileNotFoundException e) 
		{
			System.out.println("Datei nicht gefunden");
		} catch (IOException e) {
			System.out.println("E/Anicht-Fehler");
		}
		return getArrayReturn();
	}
}

