package CalcularAreaPer;

public class Triangulo extends Figura {
	public double ladoA, ladoB, ladoC;

	public Triangulo(double ladoA, double ladoB, double ladoC) {
		// TODO Auto-generated constructor stub
		this.ladoA=ladoA;
		this.ladoB=ladoB;
		this.ladoC=ladoC;
	}
	 @Override
	public double calcularArea() {
	        // Usamos la fórmula de Herón para el área
	    double s = (ladoA + ladoB + ladoC) / 2; // semi-perímetro
	    return Math.sqrt(s * (s - ladoA) * (s - ladoB) * (s - ladoC));
	}

	    @Override
	public double calcularPerimetro() {
	     return ladoA + ladoB + ladoC;
	}
	    
	    // Método para determinar el tipo de triángulo
	public String tipoTriangulo() {
	     if (ladoA == ladoB && ladoB == ladoC) {
	          return "Equilátero";
	     } else if (ladoA == ladoB || ladoB == ladoC || ladoA == ladoC) {
	            return "Isósceles";
	     } else {
	            return "Escaleno";
	       }
	    }
}
