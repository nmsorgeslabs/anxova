package org.nms.common.impl;

import org.nms.common.INameable;

public class StringNameable implements INameable<String>{

	private String name;
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

}
