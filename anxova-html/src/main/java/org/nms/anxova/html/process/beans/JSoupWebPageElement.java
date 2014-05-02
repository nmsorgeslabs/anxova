package org.nms.anxova.html.process.beans;

import java.io.Serializable;

import org.jsoup.nodes.Element;

public class JSoupWebPageElement implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4014731857459410510L;
	/**
	 * The JSoup element.
	 */
	private Element element;

	/**
	 * Default constructor
	 */
	public JSoupWebPageElement(){
		
	}
	
	public JSoupWebPageElement(Element e){
		this.element = e;
	}
	/**
	 * @return the element
	 */
	public Element getElement() {
		return element;
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(Element element) {
		this.element = element;
	}
	
	public String toString(){
		return element.toString();
	}
	
	
}
