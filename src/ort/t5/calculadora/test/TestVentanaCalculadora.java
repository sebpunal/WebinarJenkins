package ort.t5.calculadora.test;

import javax.swing.JFrame;

import ort.t5.calculadora.core.CalculadoraLineal;
import ort.t5.calculadora.view.VentanaCalculadora;
import ort.t5.calculadora.view.ViewCalculadora;

public class TestVentanaCalculadora {

	public TestVentanaCalculadora() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VentanaCalculadora vistaVentana = new VentanaCalculadora(0);
		vistaVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		vistaVentana.pack();
		vistaVentana.setVisible(true);
		
		vistaVentana.setSize(220, 340);
		vistaVentana.setTitle("Test1");
		
		CalculadoraLineal calc = new CalculadoraLineal();
		
		calc.addObserver(vistaVentana);
		
		calc.agregarNumero(10.25);
		calc.agregarOperacion("+");
		calc.agregarNumero(20);
		calc.agregarOperacion("=");
	}

}
