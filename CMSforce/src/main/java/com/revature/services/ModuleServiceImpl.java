package com.revature.services;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.entities.Module;
import com.revature.repositories.ModuleRepository;

@Service
public class ModuleServiceImpl implements ModuleService {
	
	@Autowired
	ModuleRepository mr;

	@Override
	public Set<Module> getAllModules() {
		try {
			Set<Module> modules = new HashSet<Module>();
			mr.findAll().forEach(modules :: add);
			return modules;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Module getModuleById(int id) {
		try {
			return mr.findById(id).get();
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}