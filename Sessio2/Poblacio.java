package Sessio2;

import Sessio1.Ubicacio;

public class Poblacio {
	private String nomPoblacio;
	private int numHabitants;
	
	private Ubicacio ubicacions[][]; // ? 0=cruilles , 1=no cuilles? ()
	private int numParells;
	private int numSenars;
	private final int MAX_UBICACIONS; 
	
	public Poblacio(int Maxim, String poblacio, int numHabitants) {
		nomPoblacio=poblacio;
		this.numHabitants=numHabitants;
		MAX_UBICACIONS=Maxim;
		
		numParells=0;
		numSenars=0;
		ubicacions=new Ubicacio[2][MAX_UBICACIONS];
	}
	
	public boolean afegirUbicacio(Ubicacio c) {
		int idx=c.getCruilla() ? 0 : 1;
		for (Ubicacio x: ubicacions[idx]) {
			if(x.getNomVia().equals(c.getNomVia()) && x.getNumVia()==c.getNumVia()) 
				return false;
		}
		
		
		// *1
		int llargada=(idx==1) ? numSenars : numParells;
			
		ubicacions[idx][llargada]=c;
		
		// *1
		if (idx==1) numSenars++;
		else numParells++;
		
		
		// *1 = trobar solucio mes eficient si n'hi ha.
		
		return true;
	}
	public boolean eliminarUbicacio(Ubicacio c) {
		int idx=c.getCruilla() ? 0 : 1;
		int llargada=(idx==1) ? numSenars : numParells;

		int cnt=0; boolean trobat=false; 
		while(cnt<llargada && !trobat) {
			trobat=ubicacions[idx][cnt].getNomVia().equals(c.getNomVia()) && ubicacions[idx][cnt].getNumVia()==c.getNumVia();
			cnt++;
		}
		
		if(trobat) {
			ubicacions[idx][cnt-1]=null;
			
			// correcte?
			for (int i=cnt-1; i<llargada-1; i++) ubicacions[idx][i]=ubicacions[idx][i+1]; 
			
			if (idx==1) numSenars--;
			else numParells--;
			
			return true;
		}
		
		return false;
		
	}
	public int eliminarBuides() {
		int cnt=0;
		for(int x=0; x<ubicacions.length; x++) {
			for (int y=0; y<ubicacions.length; x++) {
				if (ubicacions[x][y].getNumSenyals()==0) {
					eliminarUbicacio(ubicacions[x][y]);
					cnt++;
				}
			}
		}
		
		return cnt;
	}
	public int quantes() {
		int cnt=0;
		for(int x=0; x<ubicacions.length; x++) {
			for (int y=0; y<ubicacions.length; x++) {
				cnt+=ubicacions[x][y].getNumSenyals();
			}
		}
		
		return cnt;
	}
	
	// GETs
	public String getNomPoblacio() {return nomPoblacio;}
	public int getNumHabitants() {return numHabitants;}
	public int getNumParells() {return numParells;}
	public int getNumSenars() {return numSenars;}
	public int getMaxUbicacions() {return MAX_UBICACIONS;}
}