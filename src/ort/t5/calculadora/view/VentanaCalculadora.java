package ort.t5.calculadora.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;

import ort.t5.calculadora.core.CalculadoraLineal;

public class VentanaCalculadora extends JFrame implements Observer{
	//Atributos
	PanelNumeros panelNumeros = null;
	PanelOperaciones panelOperaciones = null;
	PanelDisplay panelDisplay = null;
	
	BorderLayout brdLayout = null; 
	
	//Constructor
	public VentanaCalculadora(){
		//Primero llamamos al constructor del padre.
		super();
	}
	
	
	public VentanaCalculadora(int iNum){
		//Primero llamamos al constructor del padre. Pero usando nuestro contructor sin parámetros.
		this();
		
		//Atributos Locales
		int iTamVistaX = 200;
		int iTamVistaY = 300;
		
		//Atributos Locales
		String operaciones[] = {"+", "-", "*", "/"};
		
		//Cuerpo del Método
		
		//panelNumeros = new PanelNumeros("1", "2", "3", "4", "5", "6", "7", "8", "9");
		//panelNumeros = new PanelNumeros(0, ".", "=");
		panelNumeros = new PanelNumeros(this, 0, ".", "=");
		panelOperaciones = new PanelOperaciones(operaciones);
		panelDisplay = new PanelDisplay(this, "", "Clear", iTamVistaX, 50);
		
		//brdLayout = new BorderLayout();
		
		//this.establecerLayoutCalculadora();
		establecerLayoutNull();
		
		//Establecemos el tamaño de la ventana
		this.setSize(iTamVistaX, iTamVistaY);
				
		this.add(panelDisplay);
		this.add(panelNumeros);
		this.add(panelOperaciones);
				
		
		this.panelOperaciones.setBackground(Color.BLUE);
		this.panelDisplay.setBackground(Color.GREEN);
		
		establecerTamanioPaneles(iTamVistaX, iTamVistaY);
		
		//ordenarPaneles(panelDisplay, panelNumeros, panelOperaciones);
		ordenarPaneles();
		
	}
	
	//Métodos
	private void establecerLayoutCalculadora() {
		
		this.getContentPane().setLayout(brdLayout);
		
		this.add(panelDisplay, BorderLayout.NORTH);
		this.add(panelNumeros, BorderLayout.CENTER);
		this.add(panelOperaciones, BorderLayout.EAST);
	}
	
	/**
	 * <div>Método que utilizamos para definir el LayOut del Panel.</div>
	 * */
	private void establecerLayoutNull() {
		//Cuerpo del Método.
		this.setLayout(null);
	}
	
	private void ordenarPaneles(JPanel panelDisplay, JPanel panelTeclado, JPanel panelOperaciones) {
		//Cuerpo del Método
		panelDisplay.setLocation(0, 0);
		panelTeclado.setLocation(0, 61);
		panelOperaciones.setLocation(601, 61);
	}
	
	private void ordenarPaneles() {
		//Cuerpo del Método
		panelDisplay.setLocation(0, 0);
		panelNumeros.setLocation(0, panelDisplay.getHeight() + 1);
		panelOperaciones.setLocation(panelNumeros.getWidth() + 1, panelDisplay.getHeight() + 1);
	}
	
	private void establecerTamanioPaneles(int iTamCalcX, int iTamCalcY) {
		//Atributos Locales
		int iTamPanelDisplay = 60;
		int iTamPanelNumeros = 0;
		int iTamPanelOperaciones = 0;
		
		//Cuerpo del Método
		
		iTamPanelNumeros =(int)(((iTamCalcX / 4) * 3));
		iTamPanelOperaciones = (int)((iTamCalcX / 4));		
		this.panelDisplay.setSize(iTamCalcX, iTamPanelDisplay);
		this.panelNumeros.setSize(iTamPanelNumeros, iTamCalcY-iTamPanelDisplay);
		this.panelOperaciones.setSize(iTamPanelOperaciones, iTamCalcY-iTamPanelDisplay);
	}
	
	/*Puñal - Agregado para que el teclado se comunique con el panel - INICIO*/
	public void recibirBotonPresionado(String lbl) {
		//Atritos Locales
		String strNumeroDiplay = "";
		
		//Cuerpo del Método
		strNumeroDiplay = getPanelDisplay().getTxtFieldDisplay().getText();
		
		if(lbl != null){
			if("0".equals(lbl) || "1".equals(lbl) || "2".equals(lbl) || "3".equals(lbl)
					|| "4".equals(lbl) || "5".equals(lbl) || "6".equals(lbl)
					|| "7".equals(lbl) || "8".equals(lbl) || "9".equals(lbl)
					|| ".".equals(lbl)){
				if(strNumeroDiplay != null && !"0".equals(strNumeroDiplay)){
					strNumeroDiplay=strNumeroDiplay.concat(lbl);
				}else {
						strNumeroDiplay = lbl;
					}
				getPanelDisplay().getTxtFieldDisplay().setText(strNumeroDiplay);
				System.out.println("Este es el boton que se presiono: " + lbl);
				System.out.println("Este es el numero que se debe ver en el diplay: "+ strNumeroDiplay);
			}
		}
	}
	/*Puñal - Agregado para que el teclado se comunique con el panel - FIN*/
	
	public PanelNumeros getPanelNumeros() {
		return panelNumeros;
	}


	public void setPanelNumeros(PanelNumeros panelNumeros) {
		this.panelNumeros = panelNumeros;
	}


	public PanelOperaciones getPanelOperaciones() {
		return panelOperaciones;
	}


	public void setPanelOperaciones(PanelOperaciones panelOperaciones) {
		this.panelOperaciones = panelOperaciones;
	}


	public PanelDisplay getPanelDisplay() {
		return panelDisplay;
	}


	public void setPanelDisplay(PanelDisplay panelDisplay) {
		this.panelDisplay = panelDisplay;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		VentanaCalculadora ventana = new VentanaCalculadora(1);
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ventana.pack();
		ventana.setVisible(true);

	}


	@Override
	public void update(Observable arg0, Object arg1) {
		//Atributos Locales
		String strResultado = "";
		
		//Cuerpo del Método
		
		//Obtenemos el observador
		CalculadoraLineal calc = (CalculadoraLineal) arg0;
		
		//Obtenemos el resultado
		strResultado = String.valueOf(calc.getTotal());
		
		//Pasamos el resultado a String para imprimirlo
		getPanelDisplay().getTxtFieldDisplay().setText(strResultado);
	}

}
