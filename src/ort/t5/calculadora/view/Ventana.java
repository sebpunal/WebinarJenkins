package ort.t5.calculadora.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Ventana extends JFrame {

	/*Constructor*/
	public Ventana () {
		//Atributos locales
		JPanel panel = null;
		JButton bttn1 = null;
		
		//Cuerpo del Método
		panel = new JPanel();
		bttn1 = new JButton("Boton Hola");
		
		this.setLayout(null);
		this.setSize(800, 600);
		this.setTitle("Ventana Sebastian");
		
		panel.setLayout(null);
		panel.add(bttn1);
		panel.setBackground(Color.BLUE);
		panel.setSize(200, 300);
		
		bttn1.setSize(100, 50);
		bttn1.setLocation(50, 60);
		//Click del botòn
		ClickBoton click = new ClickBoton();
		bttn1.addActionListener(click);
		//this.add(bttn1);
		
		this.add(panel);
	}
	
	/*Métodos*/
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ventana ventana = new Ventana();
		
		ventana.setVisible(true);

	}
	
	private void mostrarDialogo(String str){
		JOptionPane.showMessageDialog(this, str);
	}
	
	/**
	 * Clase interna o InerClass
	 * */
	class ClickBoton implements ActionListener {
		//Atributo
		String strTexto = "Hola, estoy en la clase ClickBoton";
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			JButton bttn = (JButton) arg0.getSource();
			mostrarDialogo(bttn.getText());
		}
	}
	

}
