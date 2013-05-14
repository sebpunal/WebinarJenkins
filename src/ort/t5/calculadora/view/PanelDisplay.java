package ort.t5.calculadora.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PanelDisplay extends JPanel {
	//Atributos.
	private JTextField txtFieldDisplay = null;
	private JButton bttnClear = null; 
	private VentanaCalculadora ventanaContenedora = null;
	
	private FlowLayout lyoMgnFlow = null;
	
	//Constructor.
	/**
	 * <H2>Constructor</H2>
	 * 
	 * <div>Constructor por defecto.</div>
	 * */
	public PanelDisplay(){
		super();
	}
	
	/**
	 * <H2>Constructor</H2>
	 * 
	 * <div>Este contructor genera un objeto de tipo panel con display de n�mero y un bot�n borrar (clear).</div>
	 * 
	 * @param strValorInicial (tipo String) Valor inical para que cargue el diplay.
	 * @param lblClear (tipo String) Valor para que cargue el bot�n que tiene al lado el diplay. Este bot�n tendr� la funci�n de borrar el contenido del display.
	 * 
	 * */
	public PanelDisplay(String strValorInicial, String lblClear){
		//Llamamos al constructor por defecto
		this();
		
		//Establecemos el tama�o del panel.
		this.setSize(400, 400);
		
		//Instanciamos los componentes del panel.
		this.generarComponentes();
		
		cargarValoresComponentes(strValorInicial, lblClear);
		
		//Agregamos el escuchador del mouse a los botones de la lista
		//this.agregarEscuchadorDelClick(getListaBotones());
		
		//Establecemos el Layout del panel.
		//this.establecerLayoutGrid();
		this.establecerLayoutNull();
		
		//Agregamos los componentes al panel.
		//this.agregarComponentes(getTxtFieldDisplay(), getBttnClear());
		this.agregarComponentesOrdenados(getTxtFieldDisplay(), getBttnClear());
		
		//Establecemos el tama�o de los botones. El mimos tama�o para todos.
		//this.tamanioBoton(getListaBotones(), 100, 100);
		//getTxtFieldDisplay().setSize(300, 100);
		//getBttnClear().setSize (100, 100);
	}
	
	/**
	 * <H2>Constructor</H2>
	 * 
	 * <div>Este contructor genera un objeto de tipo panel con display de n�mero y un bot�n borrar (clear).</div>
	 * 
	 * @param strValorInicial (tipo String) Valor inical para que cargue el diplay.
	 * @param lblClear (tipo String) Valor para que cargue el bot�n que tiene al lado el diplay. Este bot�n tendr� la funci�n de borrar el contenido del display.
	 * @param iTamX (tipo int) Tama�o del panel referido al eje X o tama�o horizontal.
	 * @param iTamY (tipo int) Tama�o del panel referido al eje Y o tama�o vertical.
	 * 
	 * */
	public PanelDisplay(String strValorInicial, String lblClear, int iTamX, int iTamY){
		//Llamamos al constructor por defecto
		this();
		
		//Establecemos el tama�o del panel.
		this.setSize(iTamX, iTamY);
		
		//Instanciamos los componentes del panel.
		this.generarComponentes();
		
		cargarValoresComponentes(strValorInicial, lblClear);
		
		//Establecemos el Layout del panel.
		this.establecerLayoutNull();
		
		//Agregamos los componente ordenados
		this.agregarComponentesOrdenados(getTxtFieldDisplay(), getBttnClear(), iTamX, iTamY);
	}
	
	/**
	 * <H2>Constructor</H2>
	 * 
	 * <div>Este contructor genera un objeto de tipo panel con display de n�mero y un bot�n borrar (clear).</div>
	 * <p>Ademas establecemos la referencia al marco o frame que lo contiene.</p>
	 * 
	 * @param strValorInicial (tipo String) Valor inical para que cargue el diplay.
	 * @param lblClear (tipo String) Valor para que cargue el bot�n que tiene al lado el diplay. Este bot�n tendr� la funci�n de borrar el contenido del display.
	 * @param ventanaContenedora (tipo VentanaCalculadora) Referencia al objeto que contiene el panel.
	 * 
	 * */
	public PanelDisplay(VentanaCalculadora ventanaContenedora, String strValorInicial, String lblClear){
		//Llamamos al constructor por defecto
		this(strValorInicial, lblClear);
		
		//Cargamos el valor del contenedor del panel para que el panel pueda enviarle mensajes.
		setVentanaContenedora(ventanaContenedora);
	}
	
	/**
	 * <H2>Constructor</H2>
	 * 
	 * <div>Este contructor genera un objeto de tipo panel con display de n�mero y un bot�n borrar (clear).</div>
	 * <p>Ademas establecemos la referencia al marco o frame que lo contiene.</p>
	 * 
	 * @param strValorInicial (tipo String) Valor inical para que cargue el diplay.
	 * @param lblClear (tipo String) Valor para que cargue el bot�n que tiene al lado el diplay. Este bot�n tendr� la funci�n de borrar el contenido del display.
	 * @param iTamX (tipo int) Tama�o del panel referido al eje X o tama�o horizontal.
	 * @param iTamY (tipo int) Tama�o del panel referido al eje Y o tama�o vertical.
	 * @param ventanaContenedora (tipo VentanaCalculadora) Referencia al objeto que contiene el panel.
	 * 
	 * */
	public PanelDisplay(VentanaCalculadora ventanaContenedora, String strValorInicial, String lblClear, int iTamX, int iTamY){
		//Llamamos al constructor por defecto
		this(strValorInicial, lblClear, iTamX, iTamY);
		
		//Cargamos algunas propiedades del panel.
		getTxtFieldDisplay().setEnabled(false);
		getTxtFieldDisplay().setHorizontalAlignment(JTextField.RIGHT);
		getTxtFieldDisplay().setCaretColor(Color.BLACK);
		
		//Cargamos el valor del contenedor del panel para que el panel pueda enviarle mensajes.
		setVentanaContenedora(ventanaContenedora);
	}
	
	//M�todos.
	/**
	 * <div>Por este m�todo instanciaremos los compnentes que pertenecen al panel.</div>
	 * 
	 * */
	private void generarComponentes(){
		//Atributos Locales
		//int iTamanioLargoDisplay = 300;
		//String strValorInicial = "0";
		//String lblBttnClear = "C";
		
		//Cuerpo del m�todo
		setTxtFieldDisplay(new JTextField());
		
		setBttnClear(new JButton());
	}
	
	private void cargarValoresComponentes (String strValor, String strLbl){
		//Cuerpo del m�todo
		if(strValor != null && strLbl != null) {
			getTxtFieldDisplay().setText(strValor);
			getBttnClear().setText(strLbl);
		}
	}
	
	/**
	 * <div>M�todo que utilizamos para definir el LayOut del Panel.</div>
	 * */
	private void establecerLayoutGrid() {
		//Cuerpo del M�todo.
		setLyoMgnFlow(new FlowLayout());
		
		this.setLayout(getLyoMgnFlow());
	}
	
	/**
	 * <div>M�todo que utilizamos para definir el LayOut del Panel.</div>
	 * <p>Este Layout ser� null.</p>
	 * */
	private void establecerLayoutNull() {
		//Cuerpo del M�todo.
		this.setLayout(null);
	}
	
	/**
	 * <div>Por este m�todo agraremos todos los botones que est�n en la lista al panel.</div>
	 * 
	 * @param lista (tipo ArrayList<JButton>)Lista de botones.
	 * */
	private void agregarComponentes(JTextField txtField, JButton bttn) {
		//Atributos Locales
		
		//Cuerpo del m�todo
		if (txtField != null && bttn != null){
			this.add(txtField);
			this.add(bttn);
		} //Fin del if (txtField != null && bttn != null)
	}
	
	/**
	 * <div>Por este m�todo agraremos todos los botones que est�n en la lista al panel con la ubicaci�n y el tama�o.</div>
	 * 
	 * @param lista (tipo ArrayList<JButton>)Lista de botones.
	 * */
	private void agregarComponentesOrdenados(JTextField txtField, JButton bttn) {
		//Atributos Locales
		
		//Cuerpo del m�todo
		if (txtField != null && bttn != null){
			this.agregarComponentes(txtField, bttn);
			
			txtField.setLocation(0, 0);
			txtField.setSize(300, 50);
			
			bttn.setLocation(301, 0);
			bttn.setSize(100, 50);
		} //Fin del if (txtField != null && bttn != null)
	}
	
	/**
	 * <div>
	 * 		Agregamos los componentes ordenados seg�n el tama�o del panel.
	 * 		<p>Definimos que el bot�n de borrado tendr� 80pxl, el resto se calcula en base al tama�o del panel.</p>
	 * </div>
	 * 
	 * @param txtField (Tipo JTextField) Es el display o pantalla.
	 * @param bttn (Tipo JButton) Es el bot�n de borrado.
	 * @param iTamPanelX (Tipo int) Tama�o del panel con respecto del eje X, o tama�o horizontal.
	 * @param iTamPanelY (Tipo int) Tama�o del panel con respecto del eje Y, o tama�o vertical.
	 * */
	private void agregarComponentesOrdenados(JTextField txtField, JButton bttn, int iTamPanelX, int iTamPanelY) {
		//Atributos Locales
		int iTamBotonClearX = 80;
		
		//Cuerpo del m�todo
		if (txtField != null && bttn != null){
			this.agregarComponentes(txtField, bttn);
			
			txtField.setLocation(0, 0);
			txtField.setSize(iTamPanelX-iTamBotonClearX, iTamPanelY-1);
			
			bttn.setLocation(txtField.getWidth(), 0);
			bttn.setSize(iTamBotonClearX, iTamPanelY-1);
		} //Fin del if (txtField != null && bttn != null)
	}
	
	public JTextField getTxtFieldDisplay() {
		return txtFieldDisplay;
	}

	private void setTxtFieldDisplay(JTextField txtFieldDisplay) {
		this.txtFieldDisplay = txtFieldDisplay;
	}

	public JButton getBttnClear() {
		return bttnClear;
	}

	private void setBttnClear(JButton bttnClear) {
		this.bttnClear = bttnClear;
	}
	
	/**
	 * <div>Obtenemos la ventana que contiene al panel.</div>
	 * </br>
	 * @return {@link VentanaCalculadora}
	 * */
	public VentanaCalculadora getVentanaContenedora() {
		return ventanaContenedora;
	}

	/**
	 * <div>Cargamos la instancia del marco que va a contener a este componente.</div>
	 * </br>
	 * @param ventanaContenedora (tipo VentanaCalculadora) En este argumento colocaremos la instancia del marco que contiene a este panel.
	 * */
	private void setVentanaContenedora(VentanaCalculadora ventanaContenedora) {
		this.ventanaContenedora = ventanaContenedora;
	}

	public FlowLayout getLyoMgnFlow() {
		return lyoMgnFlow;
	}

	private void setLyoMgnFlow(FlowLayout lyoMgnFlow) {
		this.lyoMgnFlow = lyoMgnFlow;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		BorderLayout brdLayout = new BorderLayout(); 
		PanelDisplay panel = new PanelDisplay("0", "Clear");
		
		ventana.setBackground(Color.BLUE);
		ventana.getContentPane().setLayout(brdLayout);
		//ventana.setLayout(brdLayout);
		//ventana.add(panel, BorderLayout.SOUTH);
		ventana.add(panel, BorderLayout.CENTER);
		
		ventana.setSize(800, 600);
		ventana.setTitle("Ventana Control");
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);

	}

}
