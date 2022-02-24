package Sessio3;
public class Reglamentacio extends SenyalTransit{

	private String significatSenyal;
	private int diametre;
	
	
	public Reglamentacio(String codi, Ubicacio ubicacio, int anyColocacio, String descripcio) {
		this(codi, ubicacio, anyColocacio, descripcio, Diametre);
	}
	public Reglamentacio(String codi, Ubicacio ubicacio, int anyColocacio, String descripcio, int diametre) {
		super(codi, Reglamentacio, ubicacio, anyColocacio);
		
		this.diametre=diametre;
		significatSenyal=descripcio;
		cntReglamentacio++;
	}
	
	public void visualitza() {
		super.visualitza();
		System.out.println("Descripcio: "+significatSenyal);
		System.out.println("Diametre: "+diametre);
	}
	
	public float area() { return (float) (Math.PI*Math.pow(diametre/2, 2)); }
	public String getSignificat() { return significatSenyal; }
	public int getDiametre() { return diametre; }
}
