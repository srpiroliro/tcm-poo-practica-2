package Sessio3;

public class Prova {
	public static void main(String[] args) {
		int len_ubicacions=5;
		int len_senyals=30;
		int capacitat_ubicacio=5;
		
		SenyalTransit [] senyals = new SenyalTransit[len_senyals];
		Ubicacio[] ubicacions=new Ubicacio[len_ubicacions];
		
		for(int i=0; i<len_ubicacions; i++) {
			ubicacions[i]=new Ubicacio(capacitat_ubicacio, "via"+i, 1);
			if ( (int)(Math.random()*4)==2 ) ubicacions[i].setCruilla(); // 1/3 de cada ubi sera cruilla
		}
		
		int any=2022;
		for(int i=0; i<senyals.length; i++) {
			String codi=GenerarParametresSenyal.generarCodi();
			Ubicacio ubi=ubicacions[i%len_ubicacions];
			String desc="descripcio de "+codi;
			
			switch(codi.substring(0,4)) {
			case "ROD": senyals[i]=new Reglamentacio(codi, ubi, any, desc);
			case "TRI": senyals[i]=new Advertencia(codi, ubi, any, desc);
			default: 	senyals[i]=new Indicacio(codi, ubi, any, desc);
			}
			
		}
		
		for(Ubicacio ubi : ubicacions) {
			System.out.println("Carrer: "+ubi.getNomVia()+"\nNum: "+ubi.getNumVia()+"\nCruilla? "+( ubi.getCruilla() ? "Si" : "No" ) );
			System.out.println("Num de senyals: "+ubi.getNumSenyals());
			System.out.println("Senyals: "+ubi.getSenyals());
			
			System.out.println("");
		}
		
	}
}