package org.nms.anxova.process.impl;

import java.util.ArrayList;
import java.util.List;

import org.nms.anxova.process.beans.IElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogProcessor extends AbstractBaseProcessor{

	private final static Logger log = LoggerFactory.getLogger(LogProcessor.class);


	@Override
	public List process(IElement e) {
		log.info((e!=null)?e.toString():"null");
		// Construct result.
		List result = new ArrayList();
		result.add(e);
		return result;
	}
	

}
