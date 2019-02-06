package com.sw300.developmentservice.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.Iterator;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sw300.developmentservice.exception.CustomizedNotFoundException;
import com.sw300.developmentservice.service.Industry;
import com.sw300.developmentservice.service.IndustryRepository;
import com.sw300.developmentservice.service.InstructorRepository;
import com.sw300.developmentservice.service.Job;
import com.sw300.developmentservice.service.JobRepository;
import com.sw300.developmentservice.service.LearningObject;
import com.sw300.developmentservice.service.LearningObjectRepository;
import com.sw300.developmentservice.service.Practice;
import com.sw300.developmentservice.service.PracticeRepository;
import com.sw300.developmentservice.service.Theory;
import com.sw300.developmentservice.service.TheoryRepository;

@RestController
public class CourseMetaDataController {
	
	@Autowired
	private IndustryRepository industryRepository;
	
	@Autowired
	private JobRepository jobRepository;
	
	@Autowired
	private LearningObjectRepository learningObjectRepository;
	
	@Autowired
	private PracticeRepository practiceRepository;
	
	@Autowired
	private TheoryRepository theoryRepository;
	
	//모든 정보 가져오
	@GetMapping("/industries")
	public Iterator<Industry> retrieveIndustryAll() {
		
		return industryRepository.findAll().iterator();
		
	}
	
	//customer ID에 따른 결과 
	@GetMapping("/industries/{id}")
	public Resource<Industry> retrieveIndustries (@PathVariable long id) {
		Optional<Industry> industries = industryRepository.findById(id);
		if (!industries.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		Resource<Industry> resource = new Resource<Industry>(industries.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveIndustryAll());
		
		resource.add(linkTo.withRel("/all-industries"));
		
		return resource;
		
	}
	
	//Data insert를 위한 부
	@PostMapping("/industries")
	public ResponseEntity<Object> createDiscipline(@Valid @RequestBody Industry industry) {
		
		industryRepository.save(industry);
	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(industry.getId())
			.toUri();
				
		return ResponseEntity.created(location).build();
		
	} 
	
	@DeleteMapping("/industries/{id}")
	public void deleteIndustry (@PathVariable long id) {
		
		Optional<Industry> industries = industryRepository.findById(id);
		if (!industries.isPresent())
			throw new CustomizedNotFoundException ("id - " + id);
		
		industryRepository.delete(industries.get());
		
	}
	
	//모든 정보 가져오
	@GetMapping("/jobs")
	public Iterator<Job> retrieveJobAll() {
		
		return jobRepository.findAll().iterator();
		
	}
	
	//customer ID에 따른 결과 
	@GetMapping("/jobs/{id}")
	public Resource<Job> retrieveJob (@PathVariable long id) {
		Optional<Job> jobs = jobRepository.findById(id);
		if (!jobs.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		Resource<Job> resource = new Resource<Job>(jobs.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveJobAll());
		
		resource.add(linkTo.withRel("/all-instructors"));
		
		return resource;
		
	}
	
	//Data insert를 위한 부
	@PostMapping("/jobs")
	public ResponseEntity<Object> createJob (@Valid @RequestBody Job job) {
		
		jobRepository.save(job);
	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(job.getId())
			.toUri();
				
		return ResponseEntity.created(location).build();
		
	} 
	
	@DeleteMapping("/jobs/{id}")
	public void deleteJob (@PathVariable long id) {
		
		Optional<Job> jobs = jobRepository.findById(id);
		if (!jobs.isPresent())
			throw new CustomizedNotFoundException ("id - " + id);
		
		jobRepository.delete(jobs.get());
		
	}
	
	//모든 정보 가져오
	@GetMapping("/learningObjects")
	public Iterator<LearningObject> retrieveLearningObjectAll() {
		
		return learningObjectRepository.findAll().iterator();
		
	}
	
	//customer ID에 따른 결과 
	@GetMapping("/learningObjects/{id}")
	public Resource<LearningObject> retrieveLearningObject (@PathVariable long id) {
		Optional<LearningObject> learningObjects = learningObjectRepository.findById(id);
		if (!learningObjects.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		Resource<LearningObject> resource = new Resource<LearningObject>(learningObjects.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveLearningObjectAll());
		
		resource.add(linkTo.withRel("/all-learningObjects"));
		
		return resource;
		
	}
	
	//Data insert를 위한 부
	@PostMapping("/learningObjects")
	public ResponseEntity<Object> createLearningObject (@Valid @RequestBody LearningObject learningObject) {
		
		learningObjectRepository.save(learningObject);
	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(learningObject.getId())
			.toUri();
				
		return ResponseEntity.created(location).build();
		
	} 
	
	@DeleteMapping("/learningObjects/{id}")
	public void deleteLearningObject (@PathVariable long id) {
		
		Optional<LearningObject> learningObjects = learningObjectRepository.findById(id);
		if (!learningObjects.isPresent())
			throw new CustomizedNotFoundException ("id - " + id);
		
		learningObjectRepository.delete(learningObjects.get());
		
	}
	
	//모든 정보 가져오
	@GetMapping("/practices")
	public Iterator<Practice> retrievePractieAll() {
		
		return practiceRepository.findAll().iterator();
		
	}
	
	//customer ID에 따른 결과 
	@GetMapping("/practices/{id}")
	public Resource<Practice> retrievePractice (@PathVariable long id) {
		Optional<Practice> practices = practiceRepository.findById(id);
		if (!practices.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		Resource<Practice> resource = new Resource<Practice>(practices.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrievePractieAll());
		
		resource.add(linkTo.withRel("/all-practices"));
		
		return resource;
		
	}
	
	//Data insert를 위한 부
	@PostMapping("/practices")
	public ResponseEntity<Object> createPractice (@Valid @RequestBody Practice practice) {
		
		practiceRepository.save(practice);
	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(practice.getId())
			.toUri();
				
		return ResponseEntity.created(location).build();
		
	} 
	
	@DeleteMapping("/practices/{id}")
	public void deletePractice (@PathVariable long id) {
		
		Optional<Practice> practices = practiceRepository.findById(id);
		if (!practices.isPresent())
			throw new CustomizedNotFoundException ("id - " + id);
		
		practiceRepository.delete(practices.get());
		
	}
	
	//모든 정보 가져오
	@GetMapping("/theories")
	public Iterator<Theory> retrieveTheoryAll() {
		
		return theoryRepository.findAll().iterator();
		
	}
	
	//customer ID에 따른 결과 
	@GetMapping("/theories/{id}")
	public Resource<Theory> retrieveTheory (@PathVariable long id) {
		Optional<Theory> theories = theoryRepository.findById(id);
		if (!theories.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		Resource<Theory> resource = new Resource<Theory>(theories.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrievePractieAll());
		
		resource.add(linkTo.withRel("/all-theories"));
		
		return resource;
		
	}
	
	//Data insert를 위한 부
	@PostMapping("/theories")
	public ResponseEntity<Object> createTheory (@Valid @RequestBody Theory theory) {
		
		theoryRepository.save(theory);
	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(theory.getId())
			.toUri();
				
		return ResponseEntity.created(location).build();
		
	} 
	
	@DeleteMapping("/theories/{id}")
	public void deleteTheory (@PathVariable long id) {
		
		Optional<Theory> theories = theoryRepository.findById(id);
		if (!theories.isPresent())
			throw new CustomizedNotFoundException ("id - " + id);
		
		theoryRepository.delete(theories.get());
		
	}
	

}
