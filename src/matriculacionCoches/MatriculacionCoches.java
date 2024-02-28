package matriculacionCoches;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
public class MatriculacionCoches {
	static int menu(Scanner in) {
		int opcion=0;
		System.out.println("\tMENÚ");
		System.out.println("1. Altas");
		System.out.println("2. Modificaciones");
		System.out.println("3. Consultas");
		System.out.println("4. Listados");
		System.out.println("5. Fin");
		do {
			System.out.println("Seleccione una opción (1-5");
			try {
				opcion=in.nextInt();
				in.nextLine();
			}catch(InputMismatchException e) {
				in.nextLine();
				System.out.println("Introduce un valor numérico");
			}
			
		}while(opcion<1 || opcion>5);
		return opcion;
	}
	static void altas(ArrayList<Coche> listaCoches, Scanner in) {
		Coche coche= new Coche();
		String matricula="";
		String marca="";
		String modelo="";
		String gama="";
		double precio=0;
		System.out.println("DATOS DEL NUEVO COCHE:");
		do {
			System.out.println("Matrícula: ");
			matricula=in.nextLine();
		}while (!coche.setMatricula(matricula));
		do {
			System.out.println("Marca: ");
			marca=in.nextLine();
		}while(!coche.setMarca(marca));
		do {
			System.out.println("Modelo: ");
			modelo=in.nextLine();
		}while(!coche.setModelo(modelo));
		do {
			System.out.println("Gama (a|b|m): ");
			gama=in.nextLine();
		}while(!coche.setGama(gama));
		do {
			System.out.println("Precio: ");
			try {
				precio=in.nextDouble();
				in.nextLine();
				coche.setPrecio(precio);
			}catch(InputMismatchException e) {
				in.nextLine();
				System.out.println("Introduce un valor numérico");
				precio=-1;
			}
		}while(precio==-1);
		
		listaCoches.add(coche);
	}
	static void listados(ArrayList<Coche> listaCoches) {
		Iterator i=listaCoches.iterator();
		while(i.hasNext()) {
			Coche coche=(Coche) i.next();
			System.out.println("Matrícula: "+coche.getMatricula());
			System.out.println("Modelo: "+coche.getModelo());
			System.out.println("Marca: "+coche.getMarca());
			System.out.println("Gama: "+coche.getGama());
			System.out.println("Precio: "+coche.getPrecio());
			System.out.println("---------------------------------");
		}
		
	}
	public static void main (String []args) {
		Scanner in = new Scanner(System.in);
		int opcion=0;
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();
		do {
			opcion=menu(in);
			switch(opcion) {
				case 1:
					altas(listaCoches,in);
					break;
				case 2:
//					modificaciones();
					break;
				case 3:
//					consultas();
					break;
				case 4:
					listados(listaCoches);
					break;
				case 5:
//					fin();
					break;
			}
		}while(opcion!=5);
		
	}
}
