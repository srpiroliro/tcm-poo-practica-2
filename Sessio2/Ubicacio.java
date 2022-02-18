package Sessio2;

public class Ubicacio {
	private String nom_via; 	// Atr. 1
	private int num_via; 		// Atr. 2
	private boolean cruilla; 	// Atr. 3
	
	
	private SenyalTransit[] senyals;
	private int numSenyals;
	private final int MAX_SENYALS;
	
	public Ubicacio(int Maxim, String carrer, int numero) {
		MAX_SENYALS=Maxim;
		
		nom_via=carrer;
		num_via=numero;
		cruilla=false;
		
		senyals=new SenyalTransit[MAX_SENYALS];
		numSenyals=0;
	}
	
	public boolean afegirSenyal(SenyalTransit c) {
		if (numSenyals==MAX_SENYALS) return false;
		int cnt=0; boolean trobat=false;
		while (cnt<numSenyals) {
			trobat=c.getCodi().equals(senyals[cnt].getCodi()) ; 
			if(trobat) return false;
			cnt++;
		}
		
		senyals[numSenyals]=c; numSenyals++;
		return true;
	}
	public boolean treureSenyal(SenyalTransit c) {
		for(int cnt=0;cnt<numSenyals; cnt++) {
			if(c.getCodi().equals(senyals[cnt].getCodi())) {
				senyals[cnt]=null;
				
				for (int i=cnt; (i>0 && i<numSenyals);  i++) {
					senyals[cnt]= (cnt+1==MAX_SENYALS) ? null : senyals[cnt+1] ;
				}
			};
			cnt++;
		}
		return false;
	}
	
	
	//SETs
	public void setCruilla() { cruilla=!cruilla; }
	
	//GETs
	public String getNomVia() {return(nom_via);}
	public int getNumVia() {return(num_via);}
	public boolean getCruilla() {return(cruilla);}
	public int getNumSenyals() {return(numSenyals);}
	public int getMaxSenyals() {return(MAX_SENYALS);}
	public SenyalTransit getSenyal(int quin) {
		if (quin>=0 && quin<MAX_SENYALS && quin<numSenyals) return senyals[quin];
		return null;
	}
	public String getSenyals() {
		String msg="";
		for(SenyalTransit senyal : senyals) msg+=senyal.getCodi()+" - "; // remove last " - "
		return msg;
	}
}