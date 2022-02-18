package Sessio2;

public class GenerarParametresSenyal {

	public static String generarCodi() {
		String digit="";
		for(int i=0; i<4; i++) digit+=generarDigit();
		
		return( generarForma()+"-"+digit );
	}
	
	public static int generarAny(int maxim) {
		// maxim inclusiu o exclusiu?
		int minim=1980;
		return( (int)(Math.random() * (maxim-minim))+minim ); // max. es exclusiu
	}
	
	public static char generarDigit() {
		int minim=48; int maxim=57+1; // +1 per tal de 57 ser inclusiu.
		int charNum=(int) (Math.random() * (maxim-minim))+minim ;
		return( (char) charNum );
	}
	
	public static String generarForma() {
		String[] conjunt={"ROD","TRI","REC","QUA"};
		return( conjunt[(int) (Math.random()*conjunt.length)] );
	}
}
