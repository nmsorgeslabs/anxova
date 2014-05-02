package org.nms.anxova.process.beans;

import java.io.Serializable;

public class BaseElement<T extends Serializable> implements IElement<T> {

	private String id;
	
	private T element;
	
	/**
	 * Default Constructor
	 */
	public BaseElement(){
		
	}
	
	/**
	 * Constructor with the element to contain.
	 * @param obj
	 */
	public BaseElement(T obj){
		this.element = obj;
	}
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id= id;
		
	}

	@Override
	public boolean isequals(String id) {
		return (id!=null) && id.equalsIgnoreCase(this.id);
	}

	@Override
	public T getElement() {
		return element;
	}

	@Override
	public void setElement(T e) {
		this.element = e;
		
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		sb.append("Element [").append(element.toString());
		sb.append("]");
		return sb.toString();
	}

}
