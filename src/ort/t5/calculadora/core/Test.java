package ort.t5.calculadora.core;

public class Test {

	
	public static void main(String[] args) {
		CalculadoraLineal calc = new CalculadoraLineal();
		calc.agregarNumero(10.25);
		calc.agregarOperacion("+");
		calc.agregarNumero(20);
		System.out.println("Subtotal:" + calc.getTotal());
	}

}
