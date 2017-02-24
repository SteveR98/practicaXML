import java.io.FileInputStream;
import java.util.HashMap;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class MainLibro {
	
	private static HashMap<String, Libros> mapLibros;
	
	public static void main(String[] args) throws Throwable {

		XMLReader xmlReader = XMLReaderFactory.createXMLReader();
		ParseLibrosXML parseLibros = new ParseLibrosXML();

		xmlReader.setContentHandler(parseLibros);

		xmlReader.parse(new InputSource(new FileInputStream("Libros.xml")));

		mostrar();
		}

		public static void mostrar()
		{
			for (String titulo: mapLibros.keySet())
		{
		   	String auxValor = mapLibros.get(titulo).toString();
		   	
		   	System.out.println(auxValor);
		} 
		}

		public static int getNLibros()
		{
			int numeroLib = 0;
		
		
			return numeroLib;
		}

		
		public static void hacerMapaLibros(HashMap<String,Libros> mapLibros1){
		
			mapLibros = mapLibros1;
		}
		

}
	
	
