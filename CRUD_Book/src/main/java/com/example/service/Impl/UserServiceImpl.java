package com.example.service.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.RoleEntity;
import com.example.entity.UserEntity;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import com.example.service.IUserService;

@Service
@Transactional
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public UserEntity addUser(UserEntity user) {
		// TODO Auto-generated method stub
		List<RoleEntity> entities = new ArrayList<>();
		
		RoleEntity role = roleRepository.findByName("ROLE_MEMBER");
		entities.add(role);
		
		UserEntity user1 = new UserEntity();
		user1.setUsername(user.getUsername());
		user1.setPassword(user.getPassword());
		user1.setFullName(user.getFullName());
		user1.setEmail(user.getEmail());
		user1.setPhone(user.getPhone());
		user1.setCreatedBy(user.getCreatedBy());
		user1.setCreatedDate(user.getCreatedDate());
		user1.setModifiedBy(user.getModifiedBy());
		user1.setModifiedDate(user.getModifiedDate());
		user1.setRoles(entities);
		return userRepository.save(user1);
	}

	@Override
	public UserEntity updateUser(String id, UserEntity user) {
		// TODO Auto-generated method stub
		if(user != null) {
			UserEntity user1 = userRepository.findById(id).get();
			if(user1 != null) {
				user1.setUsername(user.getUsername());
				user1.setPassword(user.getPassword());
				user1.setFullName(user.getFullName());
				user1.setEmail(user.getEmail());
				user1.setPhone(user.getPhone());
				user1.setCreatedBy(user.getCreatedBy());
				user1.setCreatedDate(user.getCreatedDate());
				user1.setModifiedBy(user.getModifiedBy());
				user1.setModifiedDate(user.getModifiedDate());
				
				return userRepository.save(user1);
			}
		}
		return null;
	}

	@Override
	public boolean delUser(String id) {
		// TODO Auto-generated method stub
		UserEntity user = userRepository.getOne(id);
		if(user != null) {
			userRepository.delete(user);
			return true;
		}
		return false;
	}

}
