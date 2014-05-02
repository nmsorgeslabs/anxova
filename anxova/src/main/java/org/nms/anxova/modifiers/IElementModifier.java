package org.nms.anxova.modifiers;

import java.io.Serializable;

import org.nms.anxova.process.beans.IElement;

/**
 * Modify an element.
 * 
 * @author daviz
 *
 * T Element type.
 */
public interface IElementModifier<T extends Serializable> {

	/**
	 * Modifies the element.
	 * @param e The element to modify.
	 * @return The modified element.
	 */
	public IElement<T> modify(IElement<T> e);
}
