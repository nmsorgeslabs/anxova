package org.nms.anxova.process.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.nms.anxova.process.IProcessor;
import org.nms.anxova.process.beans.IElement;
import org.nms.common.IIdentificable;
import org.nms.common.INameable;
import org.slf4j.Logger;

/**
 * Abstract processor.
 * <p>
 * Provides a default implementation for element list processing.
 * </p>
 * @author daviz
 * 
 * <O> The origin generic type for the elements.
 * <R> The resulting generic type for the elements.
 * <N> The name type
 */
public abstract class AbstractProcessor<O extends Serializable,R extends Serializable, N extends Serializable> 
implements IIdentificable<String>,INameable<N>, IProcessor<O,R> {

	/**
	 * The origin object. Used for validation purposes.
	 */
	private O origin;
	
	/**
	 * The resulting object. Used for validation purposes.
	 */
	private R result;
	
	/**
	 * Log.
	 */
	Logger log = LoggerFactory.getLogger(AbstractProcessor.class);
	
	/**
	 * The processor ID.
	 */
	private String id;

	/**
	 * The processor name.
	 */
	private N name;

	/**
	 * Flag of active processor.
	 */
	private boolean active = Boolean.TRUE;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public N getName() {
		return name;
	}

	public void setName(N name) {
		this.name = name;
	}

	public boolean isequals(String id) {
		if (id == null)
			return false;

		return id.equals(this.id);
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String toString() {

		StringBuffer sb = new StringBuffer();
		sb.append("[").append(id).append("]-").append("[").append(name)
				.append("]");

		return sb.toString();
	}

	/**
	 * Implementation of the process list of elements.
	 * <p>
	 * Calls the process(e) method for each element.
	 * </p>
	 * <p>
	 * If the processor is not active, it returns NULL.
	 * </p>
	 * TODO daviz Provide a way to pass the processor and do not transform elements. Must be a just transform form O to R element generic type?
	 */
	public List<IElement<R>> process(List<IElement<O>> elements){
		
		// Call the before method of the processor.
		before();
		
		if(!active){
			log.warn("This processor [name:{}] is not active, nothing done!",name);
			return null;
		}
		List<IElement<R>> result = new ArrayList<IElement<R>>();
		if(elements!=null && elements.size()!=0){
			log.debug("To process : {} elements",elements.size());
			
			for(IElement<O> e:elements){
				result.addAll(this.process(e));
			}
		}
		
		log.debug("Obtained {} elements",result.size());
		// Call the after method for the processor.
		after();
		return result;
	}

	/**
	 * An implementation for a single element process method, using the list
	 * abstract one.
	 * 
	 * @param e
	 *            The element to process
	 * @return The result of processing the element as a 1-element list.
	 */
	public abstract List<IElement<R>> process(IElement<O> e);
	
	/**
	 * The before method. Will be executed BEFORE any operation in the process List method.
	 */
	public abstract void before();

	/**
	 * The after method. Will be executed AFTER all operations in the process List method.
	 */
	public abstract void after();
	
	/**
	 * Obtains the origin class of the genericType O.
	 * <p>
	 * For validation purposes.
	 * </p>
	 * @return The origin Class.
	 */
	public Class<?> getOriginClass(){
		return origin.getClass();
	}
	
	/**
	 * Obtains the resulting class of the genericType R.
	 * <p>
	 * For validation purposes.
	 * </p>
	 * @return The resulting Class.
	 */
	public Class<?> getResultClass(){
		return result.getClass();
	}
	
}
