package org.nms.anxova.process.impl;

import java.io.Serializable;

/**
 * Abstract base processor.
 * <p>
 * Implements void methods before and after.
 * </p>
 * @author daviz
 *
 */
public abstract class AbstractBaseProcessor<O extends Serializable,R extends Serializable, N extends Serializable> 
extends AbstractProcessor<O,R,N>{

	
	/**
	 * A void implementation for the before method.
	 */
	@Override
	public void before() {
		// Does nothing
		
	}

	/**
	 * A void implementation for the after method.
	 */
	@Override
	public void after() {
		// Does nothing
		
	}

}
