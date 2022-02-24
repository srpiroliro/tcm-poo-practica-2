package Sessio3;
import java.util.GregorianCalendar;

public abstract class SenyalTransit {

	public static final int Advertencia = 0;
	public static final int Reglamentacio = 1;
	public static final int Indicacio = 2;
	
	public static final int Diametre=50;
	public static final int Costat=70;
	public static final int Alcada=132;
	public static final int Amplada=93;
	
	protected int cntAdvertencia=0;
	protected int cntReglamentacio=0;
	protected int cntIndicacio=0;
	
	private String codi;
	private int tipus;
	private Ubicacio ubicacio;
	private int any_col=0;
	private int any_ret=0;
	
	public SenyalTransit(Ubicacio ubicacio) {
		this((new GregorianCalendar()).get(1), ubicacio);	
	}

	public SenyalTransit(int anyColocacio, Ubicacio ubicacio) {
		this(GenerarParametresSenyal.generarCodi(), 0, ubicacio, anyColocacio);
		this.tipus=quinTipus(this.codi);
	}
	
	public SenyalTransit(Ubicacio ubicacio, int tipus) {
		this(GenerarParametresSenyal.generarCodi(), tipus, ubicacio, GenerarParametresSenyal.generarAny((new GregorianCalendar()).get(1)));
		
		if(quinTipus(this.codi)!=tipus) {			
			String[] c={"ROD","TRI",( Math.random()>0.5  ? "REC" : "QUA")};
			this.codi=c[tipus]+this.codi.substring(3);
		}
	}
	
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
	
	
	private int quinTipus(String codi) {
		switch(codi.substring(0,4)) {
		case "ROD": return Reglamentacio;
		case "TRI": return Advertencia;
		default: return Indicacio;
		}
	}
	
	public boolean retirarViaPublica() {
		return(retirarViaPublica((new GregorianCalendar()).get(1)));
	}
	public boolean retirarViaPublica(int anyRetirada) {
		if(ubicacio.treureSenyal(this)) { 
			any_ret=anyRetirada;
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
	public void visualitza() {
		String msg=
				"Codi: "+codi +"\n" +
				"Tipus: "+getTipusSenyal()+"\n" +
				"Any colocacio: "+any_col+"\n" +
				"Any retirada: "+any_ret+"\n" +
				"Ubicacio: "+getStrUbicacio();
			;
	
		System.out.println(msg);
	}
	
	public abstract float area();
	
	
	// GETs
	public String getStrUbicacio() {// nom en el doc: getUbicacio()
		if(ubicacio != null)
			return ubicacio.getNomVia()+", "+ubicacio.getNumVia();
		return null;
	}
	public Ubicacio getUbicacio() { // nom en el doc: getAtribut3()
		return ubicacio;
	}
	public String getTipusSenyal() {
		switch(tipus) {
			case Advertencia: 	return "Advertència";
			case Reglamentacio: return "Reglamentació";
			case Indicacio: 	return "Indicació"; 
		}
		return null;
	}
	public String getCodi() {return codi;}
	public String getEstat() {
		GregorianCalendar avui = new GregorianCalendar();
		switch(any_col - avui.get(1)) {
			case 0:
			case 1: return "nou";
			case 2:
			case 3: return "semi nou";
			case 4:
			default: return "vell";
		}
	}
	public int getCntAdvertencia(){return cntAdvertencia;}
	public int getCntReglamentacio(){return cntReglamentacio;}
	public int getCntIndicacio(){return cntIndicacio;}
	

}
