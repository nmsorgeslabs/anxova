package org.nms.anxova.string.process;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nms.anxova.process.beans.BaseElement;
import org.nms.anxova.process.beans.IElement;
import org.nms.anxova.string.process.impl.StringExtractorProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.sun.istack.internal.NotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:*testContext-stringExtractorProcessorComplexTest.xml")
public class StringExtractorProcessComplexTest {

	/**
	 * Logger.
	 */
	private final static Logger logger = LoggerFactory.getLogger(StringExtractorProcessComplexTest.class);
		
	@Autowired @NotNull
	private StringExtractorProcessor processor;
	
	@Autowired @NotNull
	private BaseElement<String> element;
	
	@Autowired @NotNull
	private String resultValue;
	
	
	@Before
	public void before(){
		
	}
	
	@Test
	public void processTest(){
		
		List<IElement> result = processor.process(element);
		Assert.assertNotNull("Null result",result);
		Assert.assertFalse("Empty result",result.isEmpty());
		Assert.assertEquals(resultValue, result.get(0).getElement().toString());
		// [DBG]
		for(Object r:result){
			System.out.println("Obtained " + r.toString());
		}
		//[ENDDBG]
	}
}
