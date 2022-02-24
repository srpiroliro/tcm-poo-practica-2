package Sessio3;

public class Indicacio extends SenyalTransit{

	private String significatSenyal;
	private int amplada;
	private int alcada;
	
	
	public Indicacio(String codi, Ubicacio ubicacio, int anyColocacio, String descripcio) {
		this(codi, ubicacio, anyColocacio, descripcio, Amplada, Alcada);
	}
	public Indicacio(String codi, Ubicacio ubicacio, int anyColocacio, String descripcio, int amplada, int alcada) {
		super(codi, Advertencia, ubicacio, anyColocacio);
		
		this.amplada=amplada;
		this.alcada=alcada;
		significatSenyal=descripcio;
		cntIndicacio++;
	}
	
	public void visualitza() {
		super.visualitza();
		System.out.println("Descripcio: "+significatSenyal);
		System.out.println("Dimensions: (h x a) "+amplada+"x"+alcada);
	}
	
	public float area() {
		return (amplada*alcada);
	}
	
	public String getSignificat() { return significatSenyal; }
	public int getAmplada() { return amplada; }
	public int getAlcada() { return alcada; }
}
