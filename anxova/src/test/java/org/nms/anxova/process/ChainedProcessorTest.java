package org.nms.anxova.process;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.nms.anxova.process.beans.BaseElement;
import org.nms.anxova.process.beans.IElement;
import org.nms.anxova.process.impl.ChainedProcessor;
import org.nms.anxova.process.impl.DelayProcessor;

public class ChainedProcessorTest {

	private final int NUM_OF_DELAYS = 3;
	
	private ChainedProcessor chainprocessor;
	
	@Before
	public void before(){
		
		chainprocessor = new ChainedProcessor();
		
		
		List<IProcessor> processorChain = new ArrayList<IProcessor>();
		
		// Create some delay processors
		for(int i=0;i<NUM_OF_DELAYS;i++){
			DelayProcessor dp = new DelayProcessor();
			dp.setName("Delay-" + i);
			dp.setSleepTime(1000L); // 1 sec sleep time
			processorChain.add(dp);
		}
		
		chainprocessor.setProcessorChain(processorChain);
	}
	
	@Test
	public void processTest(){
		
		BaseElement<String> testElement = new BaseElement<String>();
		testElement.setElement("test");
		
		List<IElement> result = chainprocessor.process(testElement);
		
		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
		
		
		
		
	}
}
