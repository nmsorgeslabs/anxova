package org.nms.anxova.process;

import java.io.Serializable;
import java.util.List;

import org.nms.anxova.process.beans.IElement;

/**
 * Processor interface for the processors.
 * 
 * @author daviz
 *
 * @param <O> Origin element generic type.
 * @param <R> Resulting element generic type.
 */
public interface IProcessor<O extends Serializable ,R extends Serializable> {

	/**
	 * Processes a list of elements.
	 * @param elements The list of elements.
	 * @return The resulting elements list.
	 */
	List<IElement<R>> process(List<IElement<O>> elements);

	/**
	 * Processes a single element.
	 * @param e The element to process.
	 * @return The resulting elements list.
	 */
	List<IElement<R>> process(IElement<O> e);

	/**
	 * Indicates if the processor is active.
	 * @return
	 */
	boolean isActive();
	
	Class<?> getOriginClass();
	
	Class<?> getResultClass();
}
