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

public class WebPageElementParseProcessor  extends AbstractBaseProcessor<JSoupWebPageElement, JSoupWebPageElement, String>{


	/**
	 * Logger.
	 */
	private final static Logger log = LoggerFactory.getLogger(WebPageElementParseProcessor.class);
	
	/**
	 * The JSoup document "select" filter.
	 * <p>
	 * Usable for html elements using like 'div#pages' obtains all div elements with pages class
	 * </p>
	 * @see http://jsoup.org/
	 */
	private String selectFilter;
	
	@Override
	public List<IElement<JSoupWebPageElement>> process(IElement<JSoupWebPageElement> e) {
		List<IElement<JSoupWebPageElement>> result = null;
		if(e!=null){
			log.info("Parsing filter 'select' : {}",selectFilter);
			
			result = new ArrayList<IElement<JSoupWebPageElement>>();
			// Using Jsoup to parse the html from the element and obtain de subelements in the html fragment.
			Document doc = Jsoup.parse(e.getElement().toString());

			Elements elementsSelected = doc.select(selectFilter);
			for(Element es : elementsSelected){
				IElement<JSoupWebPageElement> ie = new BaseElement<JSoupWebPageElement>(new JSoupWebPageElement(es));
				result.add(ie);
			}
			
		}else{
			log.warn("Null element to process");
		}
		return result;
	}

	/**
	 * @return the parseFilter
	 */
	public String getParseFilter() {
		return selectFilter;
	}

	/**
	 * @param parseFilter the parseFilter to set
	 */
	public void setParseFilter(String parseFilter) {
		this.selectFilter = parseFilter;
	}

}
