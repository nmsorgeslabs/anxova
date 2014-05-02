package org.nms.anxova.filter;

import org.nms.anxova.process.beans.IElement;

/**
 * Filter for elements.
 * 
 * @author daviz
 *
 */
public interface IFilter {
	
	/**
	 * Decides if the element passes the filter or no.
	 * @param e The element to filter.
	 * @return True if it passes the filter, false otherwise.
	 */
	@SuppressWarnings("rawtypes")
	public boolean passes(IElement e);

}
