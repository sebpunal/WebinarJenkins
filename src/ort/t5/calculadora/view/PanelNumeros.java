package ort.t5.calculadora.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ort.t5.calculadora.core.CalculadoraLineal;

public class PanelNumeros extends JPanel implements Observer, MouseListener{
	//Atributos.
	private ArrayList<JButton> listaBotones = null;

	private GridLayout lyoMgnGrid = null;
	
	private VentanaCalculadora ventanaContenedora = null;

	//Contructor.
	/**
	 * <H2>Constructor</H2>
	 * 
	 * <div>Constructor por defecto.</div>
	 * */
	public PanelNumeros(){
		super();
	}
	
	/**
	 * <H2>Constructor</H2>
	 * 
	 * <div>Este contructor genera un objeto de tipo panel con botones los cuales inician en el "iNumInicio" y contiene 2 valores String.</div>
	 * <div>Así se verá la distribución de los botones</div>
	 * <table>
	 * 	<tbody>
	 * 		<tr>
	 * 			<td>[iNumInicio+7]</td>		<td>[iNumInicio+8]</td>	<td>[iNumInicio+9]</td>
	 * 		</tr>
	 * 		<tr>
	 * 			<td>[iNumInicio+4]</td>		<td>[iNumInicio+5]</td>	<td>[iNumInicio+6]</td>
	 * 		</tr>
	 * 		<tr>
	 * 			<td>[iNumInicio+3]</td>		<td>[iNumInicio+2]</td>	<td>[iNumInicio+1]</td>
	 * 		</tr>
	 * 		<tr>
	 * 			<td>[lblPuntoDecimal]</td>		<td>[iNumInicio]</td>	<td>[lblIgual]</td>
	 * 		</tr>
	 * 	</tbody>
	 * </table> 
	 * <br></br>
	 * @param iNumInicio (tipo int) valor que será tomado como referencia para iniciar las etiquetas de los botones. Este número será incluido en una de las vistas de los botones.
	 * @param lblPuntoDecimal (tipo String) argumento que será agregado en una de las vistas de los botones.
	 * @param lblIgual (tipo String) argumento que será agregado en una de las vistas de los botones.
	 * */
	public PanelNumeros(int iNumInicio, String lblPuntoDecimal, String lblIgual){
		//Llamamos al constructor por defecto.
		this();
		
		//Atributos Locales
		
		//Cuerpo del Metodo
		
		//Generamos la lista.
		setListaBotones(new ArrayList<JButton>());
		
		//Establecemos el tamaño del panel.
		this.setSize(400, 400);
		
		//Agregamos los botoenes a la lista con el foramto de un teclado.
		this.agregarListaBotonesTecladoCalculadora(getListaBotones(), iNumInicio, lblPuntoDecimal, lblIgual);
		
		//Agregamos el escuchador del mouse a los botones de la lista
		//this.agregarEscuchadorDelClick(getListaBotones());
		
		//Establecemos el Layout del panel.
		this.establecerLayoutGrid();
		
		//Agregamos los botones anteriormente generados al panel.
		this.agregarListaBotones(getListaBotones());
		
		//Establecemos el tamaño de los botones. El mimos tamaño para todos.
		this.tamanioBoton(getListaBotones(), 100, 100);
	}
	
	/**
	 * <H2>Constructor</H2>
	 * 
	 * <div>Este contructor genera un objeto de tipo panel con botones los cuales inician en el "iNumInicio" y contiene 2 valores String.</div>
	 * <p>Ademas establecemos la referencia al marco o frame que lo contiene.</p>
	 * 
	 * @param ventanaContenedora (tipo VentanaCalculadora) Referencia al objeto que contiene el panel.
	 * @see {@link PanelNumeros(int iNumInicio, String lblPuntoDecimal, String lblIgual) }
	 * 
	 * */
	public PanelNumeros(VentanaCalculadora ventanaContenedora, int iNumInicio, String lblPuntoDecimal, String lblIgual){
		//Llamamos al constructor parametrizado
		this(iNumInicio, lblPuntoDecimal, lblIgual);
		
		//Cargamos el valor del contenedor del panel para que el panel pueda enviarle mensajes.
		setVentanaContenedora(ventanaContenedora);
	}
	
	//Métodos
	
	/**
	 * Método que utilizamos para definir el LayOut del Panel
	 * */
	private void establecerLayoutGrid() {
		
		//lyoMgnGrid = new GridLayout(3,3);
		//lyoMgnGrid = new GridLayout(3,4); (fila, columna)
		setLyoMgnGrid(new GridLayout(4,3)); //(fila, columna)
		
		this.setLayout(getLyoMgnGrid());
	}
	
	/**
	 * Por este método agraremos todos los botones que están en la lista al panel
	 * 
	 * @param lista (tipo ArrayList<JButton>)Lista de botones.
	 * */
	private void agregarListaBotones(ArrayList<JButton> lista) {
		//Atributos Locales
		Iterator<JButton> iteradorLocal = null;
		
		//Cuerpo del método
		if (lista != null){
			iteradorLocal = lista.iterator();
			
			while(iteradorLocal.hasNext()){
				this.add((JButton)iteradorLocal.next());
			} //Fin del while(iteradorLocal.hasNext())
		} //Fin del if (lista != null)
	}
	
	/**
	 * Por este método genera una lista con el orden del teclado de una calculadora
	 * 
	 * @param lista Lista de botones.
	 * */
	private void agregarListaBotonesTecladoCalculadora(ArrayList<JButton> lista, int iNumInicio, String lblPuntoDecimal, String lblIgual ) {
		//Atributos Locales
		int iContNum = 0;
		
		JButton btton0 = null;
		JButton btton1 = null;
		JButton btton2 = null;
		JButton btton3 = null;
		JButton btton4 = null;
		JButton btton5 = null;
		JButton btton6 = null;
		JButton btton7 = null;
		JButton btton8 = null;
		JButton btton9 = null;
		JButton bttonIgual = null;
		JButton bttonPuntoDecimal = null;
		
		String strLabel = "";
		
		//Cuerpo del método
		if (lista != null && lblIgual != null && lblPuntoDecimal != null){
			
			//Generamos los botones con sus respectivas etiquetas
			iContNum = iContNum + iNumInicio;
			strLabel = String.valueOf(iContNum);
			btton0 = new JButton(strLabel);
			iContNum = iContNum + iNumInicio + 1 ;
			strLabel = String.valueOf(iContNum);
			btton1 = new JButton(strLabel);
			iContNum = iContNum + iNumInicio + 1;
			strLabel = String.valueOf(iContNum);
			btton2 = new JButton(strLabel);
			iContNum = iContNum + iNumInicio + 1;
			strLabel = String.valueOf(iContNum);
			btton3 = new JButton(strLabel);
			iContNum = iContNum + iNumInicio + 1;
			strLabel = String.valueOf(iContNum);
			btton4 = new JButton(strLabel);
			iContNum = iContNum + iNumInicio + 1;
			strLabel = String.valueOf(iContNum);
			btton5 = new JButton(strLabel);
			iContNum = iContNum + iNumInicio + 1;
			strLabel = String.valueOf(iContNum);
			btton6 = new JButton(strLabel);
			iContNum = iContNum + iNumInicio + 1;
			strLabel = String.valueOf(iContNum);
			btton7 = new JButton(strLabel);
			iContNum = iContNum + iNumInicio + 1;
			strLabel = String.valueOf(iContNum);
			btton8 = new JButton(strLabel);
			iContNum = iContNum + iNumInicio + 1;
			strLabel = String.valueOf(iContNum);
			btton9 = new JButton(strLabel);
			
			bttonIgual = new JButton(lblIgual);
			bttonPuntoDecimal = new JButton(lblPuntoDecimal);
			
			//Agregamos los botones a la lista.
			lista.add(0, btton7);
			lista.add(1, btton8);
			lista.add(2, btton9);
			lista.add(3, btton4);
			lista.add(4, btton5);
			lista.add(5, btton6);
			lista.add(6, btton1);
			lista.add(7, btton2);
			lista.add(8, btton3);
			lista.add(9, bttonPuntoDecimal);
			lista.add(10, btton0);
			lista.add(11, bttonIgual);
		} //Fin del if (lista != null)
	}
	
	/**
	 * Por este método definiremos el tamaño de los botones de la lista.
	 * 
	 * @param lista Lista de botones.
	 * @param iTamanioX Tamañio sobre el eje X (horizontal)
	 * @param iTamanioY Tamañio sobre el eje Y (vertical)
	 * */
	private void tamanioBoton(ArrayList<JButton> lista, int iTamanioX, int iTamanioY) {
		//Atributos Locales
		Iterator<JButton> iteradorLocal = null;
		
		//Cuerpo del método
		if (lista != null){
			iteradorLocal = lista.iterator();
			
			while(iteradorLocal.hasNext()){
				((JButton)iteradorLocal.next()).setSize(iTamanioX, iTamanioY);
			} //Fin del while(iteradorLocal.hasNext())
		} //Fin del if (lista != null)
	}
	
	/**
	 * TODO: Completar desde ACA. OJO*/
	private void agregarEscuchadorDelClick(ArrayList<JButton> lista){
		//Atributos Locales
		Iterator<JButton> iteradorLocal = null;
		
		//Cuerpo del método
		if (lista != null){
			iteradorLocal = lista.iterator();
			
			while(iteradorLocal.hasNext()){
				((JButton)iteradorLocal.next()).addMouseListener(this);;
			} //Fin del while(iteradorLocal.hasNext())
		} //Fin del if (lista != null)
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		//Atributos Locales
		String lblBttnPresionado = "";
		
		//Cuerpo del Método
		lblBttnPresionado = ((JButton)arg).getText();
		System.out.println("Se presioné el botón: " + lblBttnPresionado);
		if (o instanceof CalculadoraLineal) {
			CalculadoraLineal observador = (CalculadoraLineal) o;
			
			//observador.agregarNumero(n);
		}
	}
	
	public ArrayList<JButton> getListaBotones() {
		return listaBotones;
	}

	private void setListaBotones(ArrayList<JButton> listaBotones) {
		this.listaBotones = listaBotones;
	}

	public GridLayout getLyoMgnGrid() {
		return lyoMgnGrid;
	}

	private void setLyoMgnGrid(GridLayout lyoMgnGrid) {
		this.lyoMgnGrid = lyoMgnGrid;
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

	@Override
	public void mouseClicked(MouseEvent e) {
		//Atributos Locales
		String lblBttnPresionado = "";
		
		//Cuerpo del Método
		lblBttnPresionado = ((JButton)(e.getComponent())).getText();
		getVentanaContenedora().recibirBotonPresionado(lblBttnPresionado);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame ventana = new JFrame();
		BorderLayout brdLayout = new BorderLayout(); 
		//PanelNumeros panel = new PanelNumeros("1", "2", "3", "4", "5", "6", "7", "8", "9");
		PanelNumeros panel = new PanelNumeros(0, ".", "=");
		
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
