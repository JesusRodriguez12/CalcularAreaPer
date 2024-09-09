package CalcularAreaPer;

public class Cuadrado extends Figura {
	public double lado;
	
	public Cuadrado(double lado) {
		// TODO Auto-generated constructor stub
		this.lado = lado;
	}
	
	@Override
	public double calcularArea() {
	    return lado * lado;
	}

	  @Override
	public double calcularPerimetro() {
	    return 4 * lado;
	}
}
