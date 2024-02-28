package matriculacionCoches;

public class Coche {
	private String matricula;
	private String marca;
	private String modelo;
	private String gama;
	private double precio;
	
	public Coche() {
		this.matricula="";
		this.marca="";
		this.modelo="";
		this.gama="";
		this.precio=0;
	}
	public static boolean validarMatricula(String matricula) {
		if(matricula.isEmpty())
			return false;
		if(matricula.length()!=7)
			return false;
		for(int i=0;i<4;i++) {
			if(!Character.isDigit(matricula.charAt(i))) return false;
		}
		for(int i=4;i<7;i++) {
			if(!Character.isLetter(matricula.charAt(i))) return false;
		}
		return true;
	}
	public String getMatricula() {
		return matricula;
	}

	public boolean setMatricula(String matricula) {
		if(!validarMatricula(matricula))
			return false;
		this.matricula = matricula;
		return true;
	}

	public String getMarca() {
		return marca;
	}

	public boolean setMarca(String marca) {
		if(marca.isEmpty())
			return false;
		if(marca.length()>10)
			return false;
		this.marca = marca;
		return true;
	}

	public String getModelo() {
		return modelo;
	}

	public boolean setModelo(String modelo) {
		if(modelo.isEmpty())
			return false;
		if(modelo.length()>15)
			return false;
		this.modelo = modelo;
		return true;
	}

	public String getGama() {
		return gama;
	}

	public boolean setGama(String gama) {
		if(gama.isEmpty())
			return false;
		if(!gama.equals("a") && !gama.equals("b") && !gama.equals("m"))
			return false;
		switch(gama) {
		case "a":
			this.gama="Alta";
			break;
		case "b":
			this.gama="Baja";
			break;
		case "m":
			this.gama="Media";
			break;
		}
		return true;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	

}
