package Sessio1;
import java.util.GregorianCalendar;

public class SenyalTransit {

	public static final int Advertencia = 0;
	public static final int Reglamentacio = 1;
	public static final int Indicacio = 2;
	
	private String CODI;
	private int TIPUS;
	Ubicacio UBICACIO;
	private int ANY_COL;
	private int ANY_RET;
	
	public SenyalTransit(String codi, int tipus, Ubicacio ubicacio, int anyColocacio) {
		CODI = codi;
		TIPUS = tipus;
		UBICACIO = ubicacio;
		ANY_COL = anyColocacio;s
	}
	
	public String getTipusSenyal() { // private o public
		switch(TIPUS) {
			case Advertencia: return "Advertencia";
			case Reglamentacio: return "Reglamentacio";
			case Indicacio: return "Indicacio";
		}
		return null;
	}
	
	public boolean retirarViaPublica() { // private o public
		if(UBICACIO.treureSenyal(SenyalTransit)) { //referencia a la classe Ubicacio
			GregorianCalendar avui = new GregorianCalendar();
			ANY_RET = avui.get(1);
			UBICACIO //posar en null
			ANY_COL = 0;
			return true;
		}
		return false;
	}
	
	public String getUbicacio() { // private o public
		if(UBICACIO != null) // possible falta de referencia a la classe Ubicacio
			return UBICACIO.getNomVia() + ", " + UBICACIO.getNumVia();
		return null;
	}
	
	public boolean canviarUbicacio(Ubicacio novaUbicacio) { // private o public
		
//		 if(afegirSenyal(SenyalTransit){ 
//			UBICACIO = novaUbicacio;
//			return UBICACIO.treureSenyal(SenyalTransit);
//		 }

//		no tinc ni idea de si es aix� o no 

		 return false;
	}
	
	public String getCODI() { return CODI;} // private o public	
	
	public Ubicacio getUBICACIO() {
		if (ANY_COL != 0)
			return UBICACIO;
		return null;
	}
	
	public String getEstat() {
		GregorianCalendar avui = new GregorianCalendar();
		switch(ANY_COL - avui.get(1)) {
			case 0:
			case 1: return "nou";
			case 2:
			case 3: return "semi nou";
			case 4:
			default: return "vell";
		}
	}
}
