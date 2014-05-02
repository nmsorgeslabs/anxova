package org.nms.common;

/**
 * Defines a identificable interface to compare to elements.
 * 
 * @author daviz
 * 
 * @param <PK>
 *            The primary key.
 */
public interface IIdentificable<PK> {

	public PK getId();

	public void setId(PK id);

	public boolean isequals(PK id);
}
