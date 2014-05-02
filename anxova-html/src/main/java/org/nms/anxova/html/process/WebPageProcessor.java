package org.nms.anxova.html.process;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.nms.anxova.html.process.beans.JSoupWebPage;
import org.nms.anxova.process.beans.BaseElement;
import org.nms.anxova.process.beans.IElement;
import org.nms.anxova.process.impl.AbstractBaseProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * WebPage processor.
 * <p>
 * Origin : url  <br/>
 * Result : IElement&lt;JSoupWebPage&gt; document page using JSoup. <br/>
 * </p>
 * @author daviz
 *
 */
public class WebPageProcessor extends AbstractBaseProcessor<String, JSoupWebPage, String>{

	
	/**
	 * Logger.
	 */
	private final static Logger log = LoggerFactory.getLogger(WebPageProcessor.class);
	
	/**
	 * Connection timeout (in ms)
	 */
	private  int timeOut = 10000;
	
	@Override
	public List<IElement<JSoupWebPage>> process(IElement<String> e) {
		List<IElement<JSoupWebPage>> result = null;
		if(e!=null && e.getElement()!=null){
			String urlString = e.getElement();
			try {
				log.debug("Obtaining {} with timeout {}.",urlString,timeOut);
				Document doc = Jsoup.connect(urlString).timeout(timeOut).get();
				
				// Create resulting element.
				IElement<JSoupWebPage> elementResult = new BaseElement<JSoupWebPage>(new JSoupWebPage(urlString,doc));

				// Add to the result list.
				result = new ArrayList<IElement<JSoupWebPage>>();
				result.add(elementResult);
				
			} catch (IOException ioe) {
				log.error("Error processing " + e.getElement(),ioe);
			}
		}else{
			log.warn("Null element to process");
		}
		
		return result;
	}

	/**
	 * @return the timeOut
	 */
	public int getTimeOut() {
		return timeOut;
	}

	/**
	 * @param timeOut the timeOut to set
	 */
	public void setTimeOut(int timeOut) {
		this.timeOut = timeOut;
	}


}
