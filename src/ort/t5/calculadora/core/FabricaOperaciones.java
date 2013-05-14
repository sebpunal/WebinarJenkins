package ort.t5.calculadora.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class FabricaOperaciones {
	private static FabricaOperaciones singleton;
	private Properties props;
	
	private FabricaOperaciones(){
		props = new Properties();
		try {
			InputStream is = getClass().getResourceAsStream("operaciones.properties");
			props.load(is);
		}catch (IOException e){
		}
		props.put("+",Suma.class.getCanonicalName());
		props.put("-",Resta.class.getCanonicalName());
		props.put("*",Multiplicacion.class.getCanonicalName());
		props.put("/",Division.class.getCanonicalName());
	}
	
	public static final FabricaOperaciones getInstance(){
		if (singleton == null) return new FabricaOperaciones();
		return singleton;
	}
	
	public Operacion crearOperacion(String signo){
		String nombreClase = props.getProperty(signo);
		try {
			Class<Operacion> claseOperacion = (Class<Operacion>) Class.forName(nombreClase);
			return (Operacion) claseOperacion.newInstance();
		}catch (Exception e) {
			return null;
		}
	}
}
