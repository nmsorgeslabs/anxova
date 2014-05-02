package org.nms.anxova.process.impl;

import java.util.ArrayList;
import java.util.List;

import org.nms.anxova.process.beans.IElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * Processor just for a "delay" in a process chain.
 * 
 * @author daviz
 *
 */
public class DelayProcessor
extends AbstractBaseProcessor{

	private final static Logger log = LoggerFactory.getLogger(DelayProcessor.class);
	
	/**
	 * The delay time (in ms)
	 */
	private long sleepTime;
	
	@Override
	public List<IElement> process(IElement e) {
		List<IElement> result = null;
		if(e!=null){
			
			log.debug("Delay {} for element {}",this.getName(),e.toString());
			
			result = new ArrayList<IElement>();
			
			try {
				Thread.sleep(sleepTime);
			} catch (InterruptedException e1) {
				// Nothing todo
				log.warn("Error during delay {} for {} ",this.getName(),e.toString());
				log.error("Exception in delay ",e1);
				
			}
			result.add(e);
		}
		return result;
	}

	/**
	 * @return the sleepTime
	 */
	public long getSleepTime() {
		return sleepTime;
	}

	/**
	 * @param sleepTime the sleepTime to set
	 */
	public void setSleepTime(long sleepTime) {
		this.sleepTime = sleepTime;
	}

}
