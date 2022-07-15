package com.example.service;

import com.example.entity.NXBEntity;

public interface INXBService {
	public NXBEntity addNXB(NXBEntity nxb);
	

	public NXBEntity updateNXB(String id, NXBEntity nxb);
	
	public boolean delNXB(String id);
}
