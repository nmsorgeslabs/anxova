package org.nms.anxova.html.process;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nms.anxova.html.process.beans.JSoupWebPage;
import org.nms.anxova.html.process.beans.JSoupWebPageElement;
import org.nms.anxova.process.beans.BaseElement;
import org.nms.anxova.process.beans.IElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:*testContext-webPageProcessorTest.xml")
public class WebPageProcessorTest {

	@Autowired
	private BaseElement<String> initElement;
	
	@Autowired
	private WebPageProcessor processor;
	
	@Autowired
	private WebPageParseProcessor webElementProcessor;
	
	
	@Before
	public void before(){
		Assert.assertNotNull(processor);
		Assert.assertNotNull(initElement);
	}
	
	@Test
	public void processTest(){
		
		List<IElement<JSoupWebPage>> result = processor.process(initElement);
		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
		
		List<IElement<JSoupWebPageElement>> resultElements = webElementProcessor.process(result);
		Assert.assertNotNull(resultElements);
		Assert.assertFalse(resultElements.isEmpty());
		
		
	}
}
