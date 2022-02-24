package Sessio3;

public class Prova {
	public static void main(String[] args) {
		int len_ubicacions=5;
		int len_senyals=30;
		int capacitat_ubicacio=5;
		
		SenyalTransit [] senyals = new SenyalTransit[len_senyals];
		Ubicacio[] ubicacions=new Ubicacio[len_ubicacions];
		
		for(int i=0; i<len_ubicacions; i++) {
			ubicacions[i]=new Ubicacio(capacitat_ubicacio, "Carrer "+i, 1);
			if ( (int)(Math.random()*4)==2 ) ubicacions[i].setCruilla(); // 1/3 de cada ubi sera cruilla
		}
		
		
		for(int i=0; i<senyals.length; i++) {
			int any=GenerarParametresSenyal.generarAny(2022);
			String codi=GenerarParametresSenyal.generarCodi();
			Ubicacio ubi=ubicacions[i%len_ubicacions];
			String desc="descripcio de "+codi;
			switch(codi.substring(0,3)) {
				case "ROD": senyals[i]=new Reglamentacio(codi, ubi, any, desc); break;
				case "TRI": senyals[i]=new Advertencia(codi, ubi, any, desc); break;
				default: 	senyals[i]=new Indicacio(codi, ubi, any, desc); break;
			}
		}
		
		visualitzaSenyals(senyals);
		
	}
	private static void visualitzaSenyals(SenyalTransit [] senyals){
		for(SenyalTransit senyal : senyals) {
			senyal.visualitza();
			System.out.println("Area: "+senyal.area()+" cm2");
			System.out.println();
		}
	}
}
