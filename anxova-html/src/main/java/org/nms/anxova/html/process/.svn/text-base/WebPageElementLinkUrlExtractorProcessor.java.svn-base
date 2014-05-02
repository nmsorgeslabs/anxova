package org.nms.anxova.html.process;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.nms.anxova.html.process.beans.JSoupWebPage;
import org.nms.anxova.html.process.beans.JSoupWebPageElement;
import org.nms.anxova.process.beans.BaseElement;
import org.nms.anxova.process.beans.IElement;
import org.nms.anxova.process.impl.AbstractBaseProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WebPageElementLinkUrlExtractorProcessor  
extends AbstractBaseProcessor<JSoupWebPageElement, String, String>{


	/**
	 * Logger.
	 */
	private final static Logger log = LoggerFactory.getLogger(WebPageElementLinkUrlExtractorProcessor.class);
	
	private String prepend = "";
	
	private String append = "";
	
	@Override
	public List<IElement<String>> process(IElement<JSoupWebPageElement> e) {
		List<IElement<String>> result = null;
		if(e!=null){
			
			result = new ArrayList<IElement<String>>();
			
			String link = e.getElement().getElement().attr("href");
			if(link!=null && !"".equals(link)){
				link = prepend + link + append;
				
				BaseElement<String> be = new BaseElement<String>();
				be.setElement(link);
				result.add(be);
			}
			
		}else{
			log.warn("Null element to process");
		}
		return result;
	}

	/**
	 * @return the prepend
	 */
	public String getPrepend() {
		return prepend;
	}

	/**
	 * @param prepend the prepend to set
	 */
	public void setPrepend(String prepend) {
		this.prepend = prepend;
	}

	/**
	 * @return the append
	 */
	public String getAppend() {
		return append;
	}

	/**
	 * @param append the append to set
	 */
	public void setAppend(String append) {
		this.append = append;
	}


}
