package com.lkm.a;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@Autowired
	public DemoService demoService;

    @GetMapping("/demos")
    public String demos() {
        return "This is Demo";
    }
    
    @PostMapping("/entery")
    public ResponseEntity<DemoEntity> entery(@RequestBody DemoEntity entity) {
    	
    	return ResponseEntity.ok(demoService.saveData(entity));
    }
    
    @GetMapping("/entery/{id}")
    public ResponseEntity<DemoEntity> getId(@PathVariable("id") Integer id) {
        DemoEntity entity = demoService.findEntity(id);
        if (entity == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(entity);
    }

}
