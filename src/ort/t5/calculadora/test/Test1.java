package ort.t5.calculadora.test;

import ort.t5.calculadora.core.CalculadoraLineal;
import ort.t5.calculadora.view.ViewCalculadora;

public class Test1 {

	public static void main(String[] args) {
		ViewCalculadora vistaConsola = new ViewCalculadora("Vista1_SS");
		
		CalculadoraLineal calc = new CalculadoraLineal();
		
		calc.addObserver(vistaConsola);
		
		calc.agregarNumero(10.25);
		calc.agregarOperacion("+");
		calc.agregarNumero(20);
		//System.out.println("Subtotal:" + calc.getTotal());
		//calc.getTotal();
	}
}
