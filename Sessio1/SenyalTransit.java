package Sessio1;
import java.util.GregorianCalendar;

public class SenyalTransit {

	public static final int Advertencia = 0;
	public static final int Reglamentacio = 1;
	public static final int Indicacio = 2;
	
	private String codi;
	private int tipus;
	private Ubicacio ubicacio;
	private int any_col=0;
	private int any_ret=0;
	
	public SenyalTransit(String codi, int tipus, Ubicacio ubicacio, int anyColocacio) {
		this.codi = codi;
		this.tipus = tipus;
		
		if (ubicacio.afegirSenyal(this)) {
			this.ubicacio = ubicacio;
			any_col=anyColocacio;
		} else {
			ubicacio=null;
			any_ret=anyColocacio;
		}
	}
	
	
	public boolean retirarViaPublica() {
		if(ubicacio.treureSenyal(this)) { 
			GregorianCalendar avui = new GregorianCalendar();
			any_ret=avui.get(1);
			
			ubicacio=null;
			
			return true;
		}
		return false;
	}
	
	public boolean canviarUbicacio(Ubicacio novaUbicacio) { 
		 if(novaUbicacio.afegirSenyal(this)){ 
			ubicacio=novaUbicacio;
			return ubicacio.treureSenyal(this);
		 }

		 return false;
	}
	
	
	
	// GETs
	public String getCodi() {return codi;}
	public Ubicacio getUbicacio() { return ubicacio; } // nom en el doc: getAtribut3()
	public String getStrUbicacio() { // private o public // nom en el doc: getUbicacio()
		if(ubicacio != null)
			return ubicacio.getNomVia() + ", " + ubicacio.getNumVia();
		return null;
	}
	public String getTipusSenyal() {
		switch(tipus) {
			case Advertencia: 	return "Advertència";
			case Reglamentacio: return "Reglamentació";
			case Indicacio: 	return "Indicació"; 
		}
		return null;
	}
	
	
	public String getEstat() { // Sessio 2?
		if (any_col==0) return "retirat";
		switch(any_col - (new GregorianCalendar().get(1)) ) {
			case 0: 
			case 1: return "nou";
			case 2:
			case 3: return "semi nou";
			case 4:
			default: return "vell";
		}
	}
}
