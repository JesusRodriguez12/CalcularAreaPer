package CalcularAreaPer;

public class Circulo extends Figura {
	public double radio; 
	
	  public Circulo(double radio) {
	        this.radio = radio;
	    }

	    @Override
	    public double calcularArea() {
	        return Math.PI * radio * radio;
	    }

	    @Override
	    public double calcularPerimetro() {
	        return 2 * Math.PI * radio;
	    }
}
