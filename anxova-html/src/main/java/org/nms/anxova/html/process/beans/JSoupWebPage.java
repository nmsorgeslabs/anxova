package org.nms.anxova.html.process.beans;

import java.io.Serializable;

import org.jsoup.nodes.Document;


/**
 * WebPage element.
 * Contains the url and the document (JSoup based) downloaded.
 * 
 * @author daviz
 *
 */
public class JSoupWebPage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * The url.
	 */
	private String url;
	
	/**
	 * The document.
	 */
	private Document document;

	/**
	 * Default constructor.
	 */
	public JSoupWebPage(){
		
	}
	
	/**
	 * Constructor.
	 * @param url The url.
	 * @param document The document.
	 */
	public JSoupWebPage(String url,Document document){
		this.url = url;
		this.document = document;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the document
	 */
	public Document getDocument() {
		return document;
	}

	/**
	 * @param document the document to set
	 */
	public void setDocument(Document document) {
		this.document = document;
	}
	
	public String toString(){
		return (document!=null)?document.toString():"null";
	}
	

}
