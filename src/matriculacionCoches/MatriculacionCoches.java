package matriculacionCoches;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Optional;
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
	static int buscarCoche(Scanner in,ArrayList<Coche> listaCoches) {
		int pos=-1;
		String matricula="";
		do {
			System.out.println("Introduzca un matrícula: ");
			matricula=in.nextLine();
		}while(!Coche.validarMatricula(matricula));
		Iterator i=listaCoches.iterator();
		while(i.hasNext()) {
			Coche coche=(Coche) i.next();
			if (matricula.equals(coche.getMatricula())) {
				pos=listaCoches.indexOf(coche);
				break;
			}
			pos=-1;
		}
		return pos;
	}
	static void modificaciones(Scanner in, ArrayList<Coche> listaCoches) {
		String matricula="";
		String valorNuevo="";
		boolean otro=false;
		double nuevoPrecio=-1;
		int campo=0;
		int pos=0;
		pos=buscarCoche(in,listaCoches);

		if(pos==-1) {
			System.out.println("No hay coche con esa matrícula.");
		}
		else {
			Coche coche = listaCoches.get(pos);
			do {
				System.out.println("Campo a modificar: ");
				System.out.println("1. Matrícula");
				System.out.println("2. Marca");
				System.out.println("3. Modelo");
				System.out.println("4. Gama");
				System.out.println("5. Precio");
				do {
					System.out.println("Seleccione un campo(1-5)");
					try {
						campo=in.nextInt();
						in.nextLine();
					}catch(InputMismatchException e){
						in.nextLine();
						System.out.println("Introduce un valor numérico: ");
					}
				}while(campo<1 || campo>5);
				switch(campo) {
				case 1:
					do {
						System.out.println("Introduzca la nueva matrícula: ");
						valorNuevo=in.nextLine();
					}while(!coche.setMatricula(valorNuevo));
					break;
				case 2:
					do {
						System.out.println("Introduzca la nueva marca: ");
						valorNuevo=in.nextLine();
					}while(!coche.setMarca(valorNuevo));
					break;
				case 3:
					do {
						System.out.println("Introduzca la nueva modelo: ");
						valorNuevo=in.nextLine();
					}while(!coche.setModelo(valorNuevo));
					break;
				case 4:
					do {
						System.out.println("Introduzca la nueva gama: ");
						valorNuevo=in.nextLine();
					}while(!coche.setGama(valorNuevo));
					break;
				case 5:
					do {
						try {
							System.out.println("Introduzca la nueva matrícula: ");
							nuevoPrecio=in.nextDouble();
							in.nextLine();
							coche.setPrecio(nuevoPrecio);
						}catch(InputMismatchException e) {
							in.nextLine();
							System.out.println("Introduzca un valor numérico");
							nuevoPrecio=-1;
						}
						
					}while(nuevoPrecio==-1);
					break;
				}
				System.out.println("¿Modificar otro campo?: (s/n)");
				otro="s".equals(in.nextLine());
			}while(otro);
			listaCoches.remove(pos);
			listaCoches.add(pos,coche);
		}
			
	}
	static void consultas(Scanner in, ArrayList<Coche> listaCoches) {
		int pos=-1;
		pos=buscarCoche(in, listaCoches);
		if(pos==-1) {
			System.out.println("No hay coche con esa matrícula.");
		}
		else {
			Coche coche = listaCoches.get(pos);
			System.out.println("Marca: "+coche.getMarca());
			System.out.println("Modelo: "+coche.getModelo());
			System.out.println("Gama: "+coche.getGama());
			System.out.println("Precio: "+coche.getPrecio());
		}
	}
	static void fin() {
		System.out.print("FIN DE PROGRAMA----------------------");
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
					modificaciones(in, listaCoches);
					break;
				case 3:
					consultas(in, listaCoches);
					break;
				case 4:
					listados(listaCoches);
					break;
				case 5:
					fin();
					break;
			}
		}while(opcion!=5);
		
	}
}
