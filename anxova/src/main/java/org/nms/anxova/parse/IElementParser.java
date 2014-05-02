package org.nms.anxova.parse;

import java.util.List;

import org.nms.anxova.process.beans.IElement;

public interface IElementParser {

	/**
	 * Parses a list of elements.
	 * 
	 * @param elements List of elements
	 * @return List of elements parsed
	 */
	@SuppressWarnings("rawtypes")
	public List<IElement> parse(IElement...elements);
	
	
}
