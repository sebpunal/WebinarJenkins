package ort.t5.calculadora.core;

import java.lang.*;
import java.util.Observable;

public final class CalculadoraLineal extends Observable{
	/*Atributos*/
	private double total;
	private Operacion operacion;
	
	/*Constructores*/
	
	/*M�todos*/
	
	/**
	 * Este m�todo limpiar� los valores que tiene la calculara.
	 * 
	 * Como la calculadora extiende de "Observable" llamamos a los m�todos:
	 * 		"setChanged()"
	 * 		"notifyObservers()"
	 * */
	public void limpiar(){
		total = 0 ;
		operacion = null;
		
		//M�todos de MVC (extend Observable e implements Observer)
		this.setChanged();
		this.notifyObservers((Double)total);
	}
	
	public double getTotal(){
		return total;
	}
	
	/**
	 * Este m�todo agregar� el par�metro a los valores que tiene la calculara.
	 * 
	 * Como la calculadora extiende de "Observable" llamamos a los m�todos:
	 * 		"setChanged()"
	 * 		"notifyObservers()"
	 * */
	public void agregarNumero(double n){
		if (operacion == null){
			total = n ;
		} else {
				total = operacion.calcular(total,n);
			}
		 
		//M�todos de MVC (extend Observable e implements Observer)
			this.setChanged();
			this.notifyObservers((Double)total);
	}
	 
	 public void agregarOperacion(String o){
		FabricaOperaciones fab = FabricaOperaciones.getInstance();
		operacion = fab.crearOperacion(o);
	}
	 
	 
	
}
