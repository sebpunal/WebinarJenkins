package ort.t5.calculadora.view;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import ort.t5.calculadora.view.Ventana.ClickBoton;

public class PanelOperaciones extends JPanel {
	//Atributos
	ArrayList<JButton> bttonOp = null;

	
	GridLayout lyoMgnGrid = null;

	//Contructor
	public PanelOperaciones(){
		super();
	}
	
	//Constuctor parametrizado. Recibe las operaciones que tiene la calculadora
	public PanelOperaciones(String[] operaciones){
		int tamanio = operaciones.length;
		
		bttonOp = new ArrayList<JButton>();
		for(int i = 0; i < tamanio; i++){
			bttonOp.add(new JButton(operaciones[i]));
		}
		
		
		this.establecerLayoutGrid();
		
		this.setSize(100, 100);
		
		this.agregarBotones(bttonOp);
		
		this.tamanioBoton(bttonOp, 40);
		
	}
	
	//Métodos
	
	//Metodo para agrega los botones en el Frame. Recibe el arraylist de botones
	private void agregarBotones(ArrayList<JButton>  bttonOp) {
		Iterator it = bttonOp.iterator();
		ClickBoton click = new ClickBoton();
		while(it.hasNext()){
			JButton boton = (JButton)it.next();
			this.add(boton);
			boton.addActionListener(click);
		}
	}
	
	private void establecerLayoutGrid() {
		
		lyoMgnGrid = new GridLayout(4,1);
		
		this.setLayout(lyoMgnGrid);
	}
	
	
	//Metodo para darle tamaño a los botones. Recibe el arraylist de botones y el tamaño
	private void tamanioBoton(ArrayList<JButton> bttonOp, int iTamanio) {
		Iterator it = bttonOp.iterator();
		JButton boton = null;
		while(it.hasNext()){
			boton = (JButton)it.next();
			boton.setSize(iTamanio, iTamanio);
		}
	}
	
	
	class ClickBoton implements ActionListener {
		//Atributo
		String strTexto = "Hola, estoy en la clase ClickBoton";
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JButton bttn = (JButton) arg0.getSource();
			mostrarDialogo(bttn.getText());
		}
	}
	
	
	private void mostrarDialogo(String str){
		JOptionPane.showMessageDialog(this, str);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		BorderLayout brdLayout = new BorderLayout(); 
		String[] operaciones = {"+", "-", "*", "/"};
		PanelOperaciones panel = new PanelOperaciones(operaciones);
		
		ventana.setBackground(Color.BLUE);
		ventana.getContentPane().setLayout(brdLayout);
		//ventana.setLayout(brdLayout);
		ventana.add(panel, BorderLayout.EAST);
		
		ventana.setSize(800, 600);
		ventana.setTitle("Ventana Control");
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
	}

}

