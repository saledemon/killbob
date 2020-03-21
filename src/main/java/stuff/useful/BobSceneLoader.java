package stuff.useful;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import stuff.deed.LineDeed;
import stuff.deed.CommandDeed;
import stuff.deed.CommonDeed;
import stuff.deed.Deed;

@SuppressWarnings("rawtypes")
public class BobSceneLoader {
	
	//TODO Handle deeds
	
	private BobScene parentScene;
	private Stack<Node> stack = new Stack<>();
	private Root root = new Root();
	private String xml;
	private XMLEventReader reader;
	
	private static final String PACK = "stuff.deed.";
	
	/**
	 * Constructs a new BobSceneLoader with given <code>BobScene</code> as parent. Parent is used
	 * to get the <code>Deed</code> associated with a given line.
	 * @param parentScene The parent of this <code>BobSceneLoader</code>
	 */
	public BobSceneLoader(BobScene parentScene, String xml) {
		this.parentScene = parentScene;
		this.xml = xml;
		
		try {
			XMLInputFactory factory = XMLInputFactory.newInstance();
			reader = factory.createXMLEventReader(new FileInputStream(xml));
		} catch (XMLStreamException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Root parseXml() {
		try {
			while(reader.hasNext()){
				XMLEvent event = reader.nextEvent();
				
				if (event.isStartElement()){
					handleStartElement(event.asStartElement());
				} else if (event.isEndElement()) {
					handleEndElement(event.asEndElement());
				}
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
		
		return root;
	}
	
	
	private void handleStartElement(StartElement startElement) throws XMLStreamException {
		
		Node n = null;
		String elementType = startElement.getName().getLocalPart();
	    
	    if(elementType.equals("line")) {
	    	
	    	n = createNewLine(startElement);
	    	
	    } else if (elementType.equals("answer")) {
	    	n = new Answer(startElement.getAttributeByName(QName.valueOf("text")).getValue());
	    } else if (elementType.equals("root")) {
	    	if(stack.size()>0) throw new XMLStreamException("Root element must be first in the document.");
	    	n = this.root;
	    } else {
	    	throw new XMLStreamException("Invalid element: "+elementType);
	    }
	    
	    stack.push(n);
	}
	
	
	private Line createNewLine(StartElement startElement) {
		
		Deed deed = null;
		String text = null;
		
		for (Iterator iterator = startElement.getAttributes(); iterator.hasNext();) {
			Attribute att = (Attribute) iterator.next();

			if (att.getName().getLocalPart().equals("deed")) {
				deed = makeDeed(att);
			} else if (att.getName().getLocalPart().equals("text")) {
				text = att.getValue();
			}
		}
    	
		return new Line(text, deed);
	}

	// TODO for answers as well!!
	private Deed makeDeed(Attribute att) {
		Deed ret = null;
		
		try {
			Field f = this.parentScene.getClass().getDeclaredField(att.getValue());
			String typeName = f.getGenericType().getTypeName(); 
			
			if (typeName.equals(PACK+"LineDeed")) {
				ret = (LineDeed)f.get(parentScene);
			} else if (typeName.equals(PACK+"CommonDeed")) {
				ret = (CommonDeed)f.get(parentScene);
			} else if (typeName.equals(PACK+"CommandDeed")) {
				ret = (CommandDeed)f.get(parentScene);
			} else {
				throw new IllegalArgumentException("Look at the XML file: "+xml+". "
						+ "A deed is that you've used has not yet been implemented "
						+ "in BobSceneLoader.makeDeed().");
			}
		} catch (NoSuchFieldException | SecurityException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		return ret;
	}

	private void handleEndElement(EndElement endElement) throws XMLStreamException {
		
		String elementType = endElement.getName().getLocalPart();
		
		if(elementType.equals("line")) {
			List<Answer> answers = new ArrayList<>();
			
	    	while(stack.peek() instanceof Answer) {
	    		answers.add((Answer)stack.pop());
	    	}
	    	
	    	Collections.reverse(answers);
	    	
	    	for(Answer ans : answers) ((Line)stack.peek()).attach(ans);
    	
	    } else if (elementType.equals("answer")) {
	    	
	    	if(stack.peek() instanceof Line) {
	    		Line line = (Line)stack.pop();
	    		((Answer)stack.peek()).attach(line);
	    	}
	    	
	    } else if (elementType.equals("root")) {
	    	
	    	Root root = (Root)stack.get(0);
	    	
	    	for(int i = 1 ; i < stack.size() ; i++) {
	    		root.attach((Line)stack.get(i));
	    	}
	    	
	    } else {
	    	throw new XMLStreamException("Invalid element: "+elementType);
	    }
	}

}
