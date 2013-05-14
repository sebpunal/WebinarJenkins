package ort.t5.calculadora.core;

import java.lang.*;
import java.util.Observable;

public final class CalculadoraLineal extends Observable{
	/*Atributos*/
	private double total;
	private Operacion operacion;
	
	/*Constructores*/
	
	/*Métodos*/
	
	/**
	 * Este método limpiará los valores que tiene la calculara.
	 * 
	 * Como la calculadora extiende de "Observable" llamamos a los métodos:
	 * 		"setChanged()"
	 * 		"notifyObservers()"
	 * */
	public void limpiar(){
		total = 0 ;
		operacion = null;
		
		//Métodos de MVC (extend Observable e implements Observer)
		this.setChanged();
		this.notifyObservers((Double)total);
	}
	
	public double getTotal(){
		return total;
	}
	
	/**
	 * Este método agregará el parámetro a los valores que tiene la calculara.
	 * 
	 * Como la calculadora extiende de "Observable" llamamos a los métodos:
	 * 		"setChanged()"
	 * 		"notifyObservers()"
	 * */
	public void agregarNumero(double n){
		if (operacion == null){
			total = n ;
		} else {
				total = operacion.calcular(total,n);
			}
		 
		//Métodos de MVC (extend Observable e implements Observer)
			this.setChanged();
			this.notifyObservers((Double)total);
	}
	 
	 public void agregarOperacion(String o){
		FabricaOperaciones fab = FabricaOperaciones.getInstance();
		operacion = fab.crearOperacion(o);
	}
	 
	 
	
}
