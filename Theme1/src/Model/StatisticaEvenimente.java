package Model;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatisticaEvenimente {
	private ArrayList<Eveniment> evenimente;
	
	public StatisticaEvenimente(ArrayList<Eveniment> evenimente) {
		this.evenimente = evenimente;
		
	}
	
	public static class Builder{
		private ArrayList<Eveniment> evenimente;
		
		public Builder setEvenimente(ArrayList<Eveniment> evenimente) {
			this.evenimente = evenimente;
			return this;
		}
		
		public StatisticaEvenimente build() {
			return new StatisticaEvenimente(evenimente);
		}
		
		
	}
	
public Map<String, Integer> returnScopMap() {			
			Map<String,Integer> mapi = new HashMap<String,Integer>();		
			for(Eveniment x : evenimente) {
				String tip = x.getTip();
				if(mapi.containsKey(tip)) {
					mapi.put(tip, mapi.get(tip) + 1);
				}
				else
					mapi.put(tip, 1);
			}
			return mapi;	
}
		
	

public Map<String, Integer> returnNrPersMap() {	
			Map<String,Integer> mapi = new HashMap<String,Integer>();
			String nrPers;
			for(Eveniment x : evenimente) {
				if(x.getNrPersoane() < 50) 
					nrPers = "<50";
				else
				if(x.getNrPersoane()<100)
					nrPers = "50-100";
				else
				if(x.getNrPersoane()<150)
					nrPers = "100-150";
				else
					nrPers = "150+";
				if(mapi.containsKey(nrPers)) {
					mapi.put(nrPers, mapi.get(nrPers)+1);
				}
				else
					mapi.put(nrPers,1);				
			}
			return mapi;		
	}

}
