
	import java.util.HashMap;

	import org.xml.sax.Attributes;
	import org.xml.sax.SAXException;
	import org.xml.sax.helpers.DefaultHandler;

	public class ParseLibrosXML extends DefaultHandler{
		
		private Libros libro;
		private HashMap<String,Libros> mapLibros;
		private String actualValue;
		private String isbn;
		
		@Override
		public void startDocument() throws SAXException {
			
			mapLibros = new HashMap<String,Libros>();
		}
		
		
		
		@Override
		public void startElement(String uri, String localName, String qName,Attributes attributes) throws SAXException
		{
			if(localName.equals("libro"))
			{
				isbn = attributes.getValue("isbn");
			libro = new Libros();
			this.libro.setIsbn(isbn);
				
			}
		}
		
		@Override
		public void endElement(String uri, String localName, String qName)throws SAXException
		{
		
			switch (localName) 
			{
			case "titulo":
				libro.setTitulo(actualValue);
				break;
			case "autor":
				libro.setAutor(actualValue);
				break;
			case "anyo":
				libro.setAnyo(actualValue);
				break;
			case "editorial":
				libro.setEditorial(actualValue);
				break;
			case "libro":
				mapLibros.put(isbn, libro);
				break;
				
			default:
				break;
			}
		}
		@Override
		public void endDocument() throws SAXException {
			MainLibro.hacerMapaLibros(mapLibros);		
		}
		
		@Override
		public void characters(char[] ch, int start, int length)throws SAXException
		{
			
			String stringPalabra = new String(ch,start,length);
			
			actualValue = stringPalabra;
		}
	
		
	}
	

