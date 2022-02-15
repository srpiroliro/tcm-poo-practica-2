// hola

package Sessio1;

public class Ubicacio {
	private String nom_via;
	private int num_via;
	private boolean cruilla;
	
	
	
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
	
	public String getNomVia() {return(nom_via);}
	public int getNumVia() {return(num_via);}
	public boolean getCruilla() {return(cruilla);}
//	public SenyalTransit[] getSenyals() {return(senyals);}
	public int getNumSenyals() {return(numSenyals);}
	public int getMaxSenyals() {return(MAX_SENYALS);}
	
	public void setCruilla() { cruilla=!cruilla; }
	
	public SenyalTransit getSenyal(int quin) {
		if (quin>=0 && quin<MAX_SENYALS && quin<numSenyals) return senyals[quin];
		return null;
	}
	
	public boolean afegirSenyal(SenyalTransit c) { // private or public?
		if (numSenyals==MAX_SENYALS) return false;
		int cnt=0; boolean trobat=false;
		while (cnt<numSenyals) {
			// comprova que ja no hi hagi una senyal igual a la llista. (no s’admeten repetits)
			trobat=c.getCodi().equals(senyals[cnt].getCodi()) ; 
			if(trobat) return false;
			cnt++;
		}
		
		senyals[numSenyals]=c; numSenyals++;
		return true;
	}
	
	public boolean treureSenyal(SenyalTransit c) { // private or public?
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
	
	public String getSenyals() {
		String msg="";
		for(SenyalTransit senyal : senyals) msg+=senyal.getCodi()+" - "; // remove last " - "
		return msg;
	}
}