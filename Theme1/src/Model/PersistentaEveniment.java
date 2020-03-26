package Model;

import java.beans.XMLEncoder;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class PersistentaEveniment extends Persistenta {	

	public PersistentaEveniment(String numeFisier) {
		super(numeFisier);	
		
	}
	
	public boolean salvareEveniment(Eveniment event) {
		 
		try {
			File file = new File(fisierPersistenta.getName());
			if(file.length() == 0) {        //daca fisierul este gol scriem evenimentul
				FileOutputStream file2 = new FileOutputStream(fisierPersistenta); 
	            ObjectOutputStream out = new ObjectOutputStream(file2);
	            ArrayList<Eveniment> evenimente = new ArrayList<Eveniment>();
	            event.setIdEvent(1);
	            evenimente.add(event);
	            out.writeObject(evenimente);
	            out.close(); 
	            file2.close();
				
			}	
			else {       //altfel deserealizam,adaugam evenimentul apoi serializam cu noul eveniment
				FileInputStream file3 = new FileInputStream(fisierPersistenta); 
				ObjectInputStream in = new ObjectInputStream(file3);
				ArrayList<Eveniment> evenimente = (ArrayList<Eveniment>)in.readObject();
				event.setIdEvent(evenimente.get(evenimente.size()-1).getIdEvent() + 1);
				evenimente.add(event);			
				in.close();
				file3.close();
				FileOutputStream file2 = new FileOutputStream(fisierPersistenta); 
	            ObjectOutputStream out = new ObjectOutputStream(file2);
	            out.writeObject(evenimente);
	            out.close(); 
	            file2.close();				
			}
			
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		} 
		return true;
         
	}
	
	
	public boolean stergereEveniment(String tip,String oras, String nume, String data,int nrPers) {
		
		boolean eventExista = false;
		ArrayList<Eveniment> evenimenteSterse = new ArrayList<Eveniment>();
		try {			
			FileInputStream file3 = new FileInputStream(fisierPersistenta); 
			ObjectInputStream in = new ObjectInputStream(file3);
			ArrayList<Eveniment> evenimenteAux = (ArrayList<Eveniment>)in.readObject();			
			for(Eveniment x : evenimenteAux) {
				if(x.getTip().matches(tip) && x.getLocatie().toString().matches(oras + " "+nume) && x.getPerioada().matches(data) && x.getNrPersoane() ==nrPers) {
					eventExista = true;
					continue;
				}
				else
					evenimenteSterse.add(x);
			}
			
			FileOutputStream file2 = new FileOutputStream(fisierPersistenta); 
            ObjectOutputStream out = new ObjectOutputStream(file2);
            out.writeObject(evenimenteSterse);
            out.close(); 
            file2.close();			
			
			
			 
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}		
		return eventExista;
	}
	
	public Eveniment cautareEveniment(int id) {		
		try {
			FileInputStream file3 = new FileInputStream(fisierPersistenta); 
			ObjectInputStream in = new ObjectInputStream(file3);
			ArrayList<Eveniment> evenimenteAux = (ArrayList<Eveniment>)in.readObject();
			
			for(Eveniment x : evenimenteAux) {
				if(x.getIdEvent() == id) {
					return x;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean actualizareEveniment(int id, String tip,String oras, String nume, String data,int nrPers) {
		Eveniment event = cautareEveniment(id);		
		if(event != null){		
			String tipp = event.getTip();
			String orass = event.getLocatie().getOras();
			String numeR = event.getLocatie().getNume();
			String dataa = event.getPerioada();
			int nrPerss = event.getNrPersoane();
			
			Eveniment newEvent = new Eveniment();
			newEvent.setId(id);			
			if(tip.matches(tipp) || tip.matches(""))
				newEvent.setTip(tipp);				
			else
				newEvent.setTip(tip);	
				
			if(oras.matches(orass) || oras.matches(""))
				newEvent.setOras(orass);				
			else
				newEvent.setOras(oras);	
				
			if(nume.matches(numeR) || nume.matches(""))
				newEvent.setNumeR(numeR);			
			else
				newEvent.setNumeR(nume);					
			if(data.matches(dataa) || data.matches(""))
				newEvent.setPerioada(dataa);				
			else
				newEvent.setPerioada(data);
				
			if(nrPers == nrPerss || nrPers == -1)
				newEvent.setNrPersoane(nrPerss);				
			else
				newEvent.setNrPersoane(nrPers);
				
			ArrayList<Eveniment> evenimenteModificate = new ArrayList<Eveniment>();
			
			try {				
				FileInputStream file3 = new FileInputStream(fisierPersistenta); 
				ObjectInputStream in = new ObjectInputStream(file3);
				ArrayList<Eveniment> evenimenteAux = (ArrayList<Eveniment>)in.readObject();
				for(Eveniment x : evenimenteAux) {
					if(x.getIdEvent()==id)
						evenimenteModificate.add(newEvent);
					else
						evenimenteModificate.add(x);
						
				}
				FileOutputStream file2 = new FileOutputStream(fisierPersistenta); 
	            ObjectOutputStream out = new ObjectOutputStream(file2);
	            out.writeObject(evenimenteModificate);
	            out.close(); 
	            file2.close();			
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
			return true;
			
			
		}
		else	
			
			return false;
	}
	
	public ArrayList<Eveniment> filtreazaLocatie(String locatie){
		ArrayList<Eveniment> evenimente = new ArrayList<Eveniment>();		
		try {
			FileInputStream file3 = new FileInputStream(fisierPersistenta); 
			ObjectInputStream in = new ObjectInputStream(file3);
			ArrayList<Eveniment> evenimenteAux = (ArrayList<Eveniment>)in.readObject();
			for(Eveniment x : evenimenteAux) {
				if (x.getLocatie().toString().matches(locatie)) {
					evenimente.add(x);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return evenimente;
		
	}


	public ArrayList<Eveniment> filtreazaPersoane(String inputText) {
		ArrayList<Eveniment> evenimente = new ArrayList<Eveniment>();
		int nrPers = Integer.parseInt(inputText.substring(1));
		char micMare = inputText.charAt(0);
		try {
			FileInputStream file3 = new FileInputStream(fisierPersistenta); 
			ObjectInputStream in = new ObjectInputStream(file3);
			ArrayList<Eveniment> evenimenteAux = (ArrayList<Eveniment>)in.readObject();			
			for(Eveniment x : evenimenteAux) {
				int nrCurentPers = x.getNrPersoane();
				if(micMare == '<')
					if(nrCurentPers < nrPers)
						evenimente.add(x);
					else
						;
				else
					if(micMare == '>')
						if(nrCurentPers > nrPers)
							evenimente.add(x);
						else
							;
				
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return evenimente;
		
	}


	public ArrayList<Eveniment> filtreazaScop(String inputText) {
		ArrayList<Eveniment> evenimenteFiltrate = new ArrayList<Eveniment>();		
		try {
			FileInputStream file3 = new FileInputStream(fisierPersistenta); 
			ObjectInputStream in = new ObjectInputStream(file3);
			ArrayList<Eveniment> evenimenteAux = (ArrayList<Eveniment>)in.readObject();
			for(Eveniment x : evenimenteAux) {
				if(x.getTip().matches(inputText))
					evenimenteFiltrate.add(x);
			}		
		}	
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return evenimenteFiltrate;
	}

	
	public void salvareInDiferiteFormate() {
		ArrayList<ArrayList<String>> evenimente = gasesteEvenimente();
		
		try {
			FileWriter csvWriter = new FileWriter("new.csv");
			csvWriter.append("Id");
			csvWriter.append(",");
			csvWriter.append("Tip");
			csvWriter.append(",");
			csvWriter.append("Oras");
			csvWriter.append(",");
			csvWriter.append("Nume");
			csvWriter.append(",");
			csvWriter.append("Data");
			csvWriter.append(",");
			csvWriter.append("NrPers");
			csvWriter.append("\n");
			for(ArrayList<String> x : evenimente) {
				csvWriter.append(String.join(",", x));
			    csvWriter.append("\n");
				
			}	
			csvWriter.flush();
			csvWriter.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileOutputStream fos =new FileOutputStream(new File("./event.xml"));
			XMLEncoder encoder = new XMLEncoder(fos);
			encoder.writeObject(evenimente);
			encoder.close();
			fos.close();
			
		}
		catch(Exception e) {
			
		}
		try {
		JSONObject obj = new JSONObject();
		FileWriter file = new FileWriter("myJson.json");
		for(ArrayList<String> x : evenimente) {
			
				
				obj.put("id", x.get(0));
				obj.put("tip",x.get(1));
				obj.put("oras", x.get(2));
				obj.put("nume",x.get(3));
				obj.put("data", x.get(4));
				obj.put("nrPersoane",x.get(5));	
				file.append(obj.toString());
				
				
		}	
		file.flush();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
	}


	private ArrayList<ArrayList<String>> gasesteEvenimente() {
		ArrayList<ArrayList<String>> evenimente = new ArrayList<ArrayList<String>>();
		try {
			FileInputStream file3 = new FileInputStream(fisierPersistenta); 
			ObjectInputStream in = new ObjectInputStream(file3);
			ArrayList<Eveniment> evenimenteAux = (ArrayList<Eveniment>)in.readObject();
			for(Eveniment x : evenimenteAux) {
				evenimente.add(new ArrayList<String>(Arrays.asList(Integer.toString(x.getIdEvent()),x.getTip().toString(),x.getLocatie().getOras(),x.getLocatie().getNume(),x.getPerioada(),Integer.toString(x.getNrPersoane()))));
				
			}
			System.out.println(evenimente);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}		
		
		return evenimente;
	}

	

	public ArrayList<Eveniment> showAll() {
		
		try {
			FileInputStream file3 = new FileInputStream(fisierPersistenta);
			ObjectInputStream in = new ObjectInputStream(file3);
			ArrayList<Eveniment> evenimente = (ArrayList<Eveniment>)in.readObject();
			return evenimente;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	




}
