package com.example.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.NXBEntity;
import com.example.repository.NXBRepository;
import com.example.service.INXBService;

@Service
public class NXBServiceImpl implements INXBService{

	@Autowired
	private NXBRepository nxbRepository;
	
	@Override
	public NXBEntity addNXB(NXBEntity nxb) {
		// TODO Auto-generated method stub
		if(nxb != null) {
			return nxbRepository.save(nxb);
		}
		return null;
	}

	@Override
	public NXBEntity updateNXB(String id, NXBEntity nxb) {
		// TODO Auto-generated method stub
		if(nxb != null) {
			NXBEntity nxb1 = nxbRepository.getOne(id);
			if(nxb1 != null) {
				nxb1.setName(nxb.getName());
				nxb1.setPhone(nxb.getPhone());
				nxb1.setAddress(nxb.getAddress());
				nxb1.setEmail(nxb.getEmail());
				nxb1.setRepre(nxb.getRepre());
				nxb1.setCreatedBy(nxb.getCreatedBy());
				nxb1.setCreatedDate(nxb.getCreatedDate());
				nxb1.setModifiedBy(nxb.getModifiedBy());
				nxb1.setModifiedDate(nxb.getModifiedDate());
				
				return nxbRepository.save(nxb1);
			}
		}
		return null;
	}

	@Override
	public boolean delNXB(String id) {
		// TODO Auto-generated method stub
		NXBEntity nxb = nxbRepository.getOne(id);
		if(nxb != null) {
			nxbRepository.delete(nxb);
			return true;
		}
		return false;
	}
	
}
