package Sessio3;


public class Advertencia extends SenyalTransit{

	private String significatSenyal;
	private int costat;
	
	
	public Advertencia(String codi, Ubicacio ubicacio, int anyColocacio, String descripcio) {
		this(codi, ubicacio, anyColocacio, descripcio, Costat);
	}
	public Advertencia(String codi, Ubicacio ubicacio, int anyColocacio, String descripcio, int costat) {
		super(codi, Advertencia, ubicacio, anyColocacio);
		
		this.costat=costat;
		significatSenyal=descripcio;
	}
	
	public void visualitza() {
		super.visualitza();
		System.out.println("Descripcio: "+significatSenyal);
		System.out.println("Cada costat de: "+costat);
	}
	
	public float area() { return (float) (Math.sqrt(costat)/2); }
	public String getSignificat() { return significatSenyal; }
	public int getCostat() { return costat; }
}