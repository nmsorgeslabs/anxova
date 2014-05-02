package org.nms.common.impl;

import org.nms.common.IIdentificable;

public class StringIdentificable implements IIdentificable<String>{

	private String id;
	
	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
		
	}

	@Override
	public boolean isequals(String id) {
		return this.id.equals(id);
	}

}
