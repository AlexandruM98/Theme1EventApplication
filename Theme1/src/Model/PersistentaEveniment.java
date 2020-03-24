package Model;

import java.beans.XMLEncoder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONException;
import org.json.JSONObject;

public class PersistentaEveniment extends Persistenta {	

	public PersistentaEveniment(String numeFisier) {
		super(numeFisier);	
		
	}
	
	
	public boolean salvareEveniment(Eveniment event) {		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));
			File tempFile = new File("myTempFile.txt");
			BufferedWriter tempWriter = new BufferedWriter(new FileWriter(tempFile));
			String line;
			int lastId = 0;
			while((line = reader.readLine()) != null) {
				String[] tokens = line.split(" ");
				lastId = Integer.parseInt(tokens[0]);
				tempWriter.write(line);
				tempWriter.newLine();
				
			}
			
			event.setId(lastId+1);
			reader.close();
			tempWriter.write(event.toString());
			tempWriter.newLine();
			tempWriter.close();
			
			fisierPersistenta.delete();
			tempFile.renameTo(fisierPersistenta);
			return true;
		}
		catch (Exception e) {			
			e.printStackTrace();
			return false;
		}
		
		
	}
	
	
	public boolean stergereEveniment(String tip,String oras, String nume, String data,int nrPers) {
		
		boolean eventExista = false;
		try {			
			File tempFile = new File("myTempFile.txt");
			BufferedWriter writerTemp = new BufferedWriter(new FileWriter(tempFile));
			String toCheck;		
			String deSters = tip + " " + oras + " "+ nume +" "+data + " "+nrPers+" ";
			BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));
			while((toCheck = reader.readLine()) != null) {				
				String[] tokens = toCheck.split(" ");
				String toCheckFaraId = "";
				for(int i = 1; i < tokens.length;i++) {
					toCheckFaraId += tokens[i] + " ";
				}
				System.out.println("Voi verifica pe "+ toCheckFaraId + " cu " + deSters);
				if(toCheckFaraId.matches(deSters)) {
					eventExista = true;					
					continue;
				}					
				else
					writerTemp.write(toCheck);
				writerTemp.write("\n");
				 	
			}	
			reader.close();
			writerTemp.close();
			fisierPersistenta.delete();
			tempFile.renameTo(fisierPersistenta);
			 
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}		
		return eventExista;
	}
	
	public String cautareEveniment(int id) {
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));
			String line;
			while((line = reader.readLine()) != null) {
				String[] tokens = line.split(" ");
				int idToCheck = Integer.parseInt(tokens[0]);
				if(idToCheck == id) {
					reader.close();
					return line;	
				}
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean actualizareEveniment(int id, String tip,String oras, String nume, String data,int nrPers) {
		String info = cautareEveniment(id);
		if(info != null){			
			String newEvent = "";
			newEvent = newEvent + id + " ";
			String[] tokens = info.split(" ");			
			if(tip.matches(tokens[1]) || tip.matches(""))
				newEvent = newEvent + tokens[1] + " ";				
			else
				newEvent = newEvent + tip + " ";
				
			if(oras.matches(tokens[2]) || oras.matches(""))
				newEvent = newEvent + tokens[2] + " ";				
			else
				newEvent = newEvent + oras + " ";
				
			if(nume.matches(tokens[3]) || nume.matches(""))
				newEvent = newEvent + tokens[3] + " ";				
			else
				newEvent = newEvent + nume + " ";				
			if(data.matches(tokens[4]) || data.matches(""))
				newEvent = newEvent + tokens[4] + " ";				
			else
				newEvent = newEvent + data + " ";
				
			if((nrPers == Integer.parseInt(tokens[5])) || nrPers == -1)
				newEvent = newEvent + tokens[5] + " ";				
			else
				newEvent = newEvent + nrPers + " ";
				
			//ce mai ramane de facut e de a inlocui linia din fisier cu noua linie
			
			try {
				
				File tempFile = new File("myTempFile.txt");
				BufferedWriter writerTemp = new BufferedWriter(new FileWriter(tempFile));	
				BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));				
				String toCheck;
				
				while((toCheck = reader.readLine()) != null) {
					String[] tokens2 = toCheck.split(" ");
					if(Integer.parseInt(tokens2[0]) == id) { //daca suntem la eventul cu id ce l-am actualizat
						writerTemp.write(newEvent); //scriem in noul fisier ce newEvent 
						
					}
					else
						writerTemp.write(toCheck);
					writerTemp.newLine();					
					
				}				
				reader.close();	
				writerTemp.close();
				fisierPersistenta.delete();				
				tempFile.renameTo(fisierPersistenta);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
				
			return true;
			
			
		}
		else	
			
			return false;
	}
	
	public ArrayList<Eveniment> filtreazaLocatie(String lo){
		ArrayList<Eveniment> evenimente = new ArrayList<Eveniment>();
		String[] locc = lo.split(" ");
		Locatie locatie = new Locatie(locc[0],locc[1]);
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));
			String toCheck;
			while((toCheck = reader.readLine()) != null) {
				String[] tokens = toCheck.split(" ");
				if(locatie.getOras().matches(tokens[2]) && locatie.getNume().matches(tokens[3])) {
					evenimente.add(new Eveniment(Integer.parseInt(tokens[0]),tokens[1],locatie,tokens[4],Integer.parseInt(tokens[5])));					
				}
				
			}
			reader.close();
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
			BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));
			String toCheck;
			while((toCheck = reader.readLine()) != null) {
				String[] tokens = toCheck.split(" ");
				int nrCurentPers = Integer.parseInt(tokens[5]);
				if(micMare == '<')
					if(nrCurentPers < nrPers)
						evenimente.add(new Eveniment(Integer.parseInt(tokens[0]),tokens[1],new Locatie(tokens[2],tokens[3]),tokens[4],Integer.parseInt(tokens[5])));
					else
						;
				else
					if(micMare == '>')
						if(nrCurentPers > nrPers)
							evenimente.add(new Eveniment(Integer.parseInt(tokens[0]),tokens[1],new Locatie(tokens[2],tokens[3]),tokens[4],Integer.parseInt(tokens[5])));
						else
							;
			}
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return evenimente;
		
	}


	public ArrayList<Eveniment> filtreazaScop(String inputText) {
		ArrayList<Eveniment> evenimente = new ArrayList<Eveniment>();		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));
			String toCheck;
			while((toCheck = reader.readLine()) != null) {
				String[] tokens = toCheck.split(" ");
				if(tokens[1].matches(inputText))
					evenimente.add(new Eveniment(Integer.parseInt(tokens[0]),tokens[1],new Locatie(tokens[2],tokens[3]),tokens[4],Integer.parseInt(tokens[5])));
			}
			
			reader.close();				
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return evenimente;
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
			BufferedReader reader = new BufferedReader(new FileReader(fisierPersistenta));
			String event;
			while((event = reader.readLine()) != null) {
				String[] tokens = event.split(" ");
				evenimente.add(new ArrayList<String>(Arrays.asList(tokens[0],tokens[1],tokens[2],tokens[3],tokens[4],tokens[5])));
			}
			reader.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return evenimente;
	}
	
	




}
