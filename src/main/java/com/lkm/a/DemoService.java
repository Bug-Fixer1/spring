package com.lkm.a;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {
	
	@Autowired
	public DemoRepo demoRepo;
	
	public DemoEntity saveData(DemoEntity demoEntity) {
		return demoRepo.save(demoEntity);
	}
	
	public DemoEntity findEntity(Integer id) {
		DemoEntity demoEntity = demoRepo.findById(id).orElse(null);
		return demoEntity;
	}
	
	 
}
