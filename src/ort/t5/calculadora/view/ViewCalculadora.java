package ort.t5.calculadora.view;

import java.util.Observable;
import java.util.Observer;

import ort.t5.calculadora.core.CalculadoraLineal;

public class ViewCalculadora implements Observer{
	private String strImprimir = "";
	
	public ViewCalculadora(String str) {
		strImprimir = str;
	}
	
	@Override
	public void update(Observable who, Object arg) {
		CalculadoraLineal calc = (CalculadoraLineal) who;
		
		System.out.println(strImprimir + ": " + calc.getTotal());
	}

}
