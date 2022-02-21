package Sessio3;

public class Prova {
	public static void main(String[] args) {
		SenyalTransit [] senyals = new SenyalTransit[30];
		Ubicacio[] ubicacions=new Ubicacio[10];
		
		for(int i=0; i<10; i++) ubicacions[i]=new Ubicacio(3, "via"+i, 1);
		
		
		// Advertencia
		for(int i=0; i<10; i++) {
			senyals[i]=new Advertencia("TRI-"+(1000+i), ubicacions[i], 2022, "descripcio");
			ubicacions[i].afegirSenyal(senyals[i]);
		}
		
		
		// Indicacio
		for(int i=0; i<10; i++) {
			senyals[i+10]=new Indicacio("REC-"+(1010+i), ubicacions[i], 2022, "descripcio");
			ubicacions[i].afegirSenyal(senyals[i+10]);
		}
		
		
		// Reglamentacio
		for(int i=0; i<10; i++) {
			senyals[i+20]=new Reglamentacio("ROD-"+(1020+i), ubicacions[i], 2022, "descripcio");
			ubicacions[i].afegirSenyal(senyals[i+20]);
		}
		
		System.out.println("\n\n");
		
		for(SenyalTransit senyal : senyals) {
			senyal.visualitza();
			System.out.println();
		}
		
	}
}