package org.nms.anxova.process.impl;

import java.io.Serializable;

/**
 * Abstract base implementation for LIST based processor.
 * 
 * @author daviz
 *
 * @param <O> The origin element class
 * @param <R> The resulting element class
 * @param <N> The name class
 */
public abstract class AbstractBaseListProcessor<O extends Serializable,R extends Serializable, N extends Serializable> 
extends AbstractListProcessor<O,R,N> {


	@Override
	public void before() {
		// Does nothing
		
	}

	@Override
	public void after() {
		// Does nothing
		
	}

}
