package com.sw300.schedulingservice.controller;



import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import com.sw300.schedulingservice.exception.CustomizedNotFoundException;
import com.sw300.schedulingservice.service.ClassDay;
import com.sw300.schedulingservice.service.ClassDayRepository;
import com.sw300.schedulingservice.service.Clazz;
import com.sw300.schedulingservice.service.ClazzRepository;
import com.sw300.schedulingservice.service.Venu;
import com.sw300.schedulingservice.service.VenuInfo;
import com.sw300.schedulingservice.service.VenuRepository;

import io.swagger.annotations.ApiOperation;

@RefreshScope
@RestController
public class ScheduleController {
	
	@Autowired
	private ClassDayRepository classDayRepository;
	
	@Autowired
	private ClazzRepository clazzRepository;
	
	@Autowired
	private VenuRepository venuRepository;
	
    @GetMapping(value = "/classdays")
	public Iterable<ClassDay> retrieveAllClassDays () {
    	
    	return classDayRepository.findAll();		
		
	} 
  	
    @GetMapping(value = "/classdays/{id}")
    public ClassDay retrieveClassDay (@PathVariable long id) {
    	
    	Optional<ClassDay> classDays = classDayRepository.findById(id);
		if (!classDays.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
    	
		return classDays.get();	
		
	} 
	
    @ApiOperation(value = "View a list of available Clazz",response = List.class)
    @GetMapping(value = "/course-clazzes/{courseId}")
	public List<Clazz> retrieveClazz (@PathVariable long courseId) {
    	
		return clazzRepository.findByCourseId(courseId);	
		
	} 
    
    @GetMapping(value = "/clazzes-detail/{clazzId}")
	public Clazz retrieveClazzDetail (@PathVariable long clazzId) {
    	
    	Optional<Clazz> clazzs = clazzRepository.findById(clazzId);
		if (!clazzs.isPresent())
			throw new CustomizedNotFoundException("id - " + clazzId);
    	
		return clazzs.get();	
		
	} 
    

    
    @GetMapping(value = "/venus")
	public Iterator<Venu> retrieveAllVenus () {
    	
    	return venuRepository.findAll().iterator();		
		
	} 
  	
    @GetMapping(value = "/venus/{id}")
    public Venu retrieveVenu (@PathVariable long id) {
    	
    	Optional<Venu> venus = venuRepository.findById(id);
		if (!venus.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
    	
		return venus.get();	
		
	}
    

    @PostMapping("/venus")
	public ResponseEntity<Object> createInstructor (@Valid @RequestBody Venu venu) {
		
		venuRepository.save(venu);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(venu.getId())
				.toUri();
					
			return ResponseEntity.created(location).build();
	
		
	} 
    
	//GET /payments
	//retrieveAllUsers
	@GetMapping("/clazzes/{id}/classDays")
	public List<ClassDay> retrieveClazzAllClassDay(@PathVariable long id) {
		
		Optional<Clazz> clazzes = clazzRepository.findById(id);
		if (!clazzes.isPresent()) {
			throw new CustomizedNotFoundException("id - " + id);
		}
		
		//return service.findAll();
		return clazzes.get().getClassDayList();
	}
	
	//Data insert를 위한 부
	@PostMapping("/clazzes/{id}/classDays")
	public ResponseEntity<Object> createClazzForClassDay(
			@PathVariable long id, @RequestBody ClassDay classDay) {
		
		Optional<Clazz> clazzes = clazzRepository.findById(id);
		if (!clazzes.isPresent()) {
			throw new CustomizedNotFoundException("id - " + id);
		}
		
		classDay.setClazz(clazzes.get());
		
		
		classDayRepository.save(classDay);

		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(classDay.getId())
			.toUri();
	
		
		return ResponseEntity.created(location).build();
		
	} 
	
	@PostMapping(value = "/associate-venu")
	public ResponseEntity<Object> createVenuForClassDay (@Valid @RequestBody VenuInfo venuInfo) {
		Optional<ClassDay> classDays = classDayRepository.findById(venuInfo.getClassDayId());
		
		Optional<Venu> Venus = venuRepository.findById(venuInfo.getVenuId());
		
		ClassDay classDay = classDays.get();
		classDay.setVenu(Venus.get());
		
		classDayRepository.save(classDay);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(classDay.getId())
				.toUri();
					
			return ResponseEntity.created(location).build();
	
		
	} 
    
    

}
