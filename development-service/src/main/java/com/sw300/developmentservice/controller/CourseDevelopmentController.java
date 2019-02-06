package com.sw300.developmentservice.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
import com.sw300.developmentservice.service.Course;
import com.sw300.developmentservice.service.CourseRepository;
import com.sw300.developmentservice.service.Courseware;
import com.sw300.developmentservice.service.CoursewareRepository;
import com.sw300.developmentservice.service.Discipline;
import com.sw300.developmentservice.service.DisciplineRepository;
import com.sw300.developmentservice.service.Industry;
import com.sw300.developmentservice.service.IndustryRepository;
import com.sw300.developmentservice.service.Instructor;
import com.sw300.developmentservice.service.InstructorRepository;
import com.sw300.developmentservice.service.Job;
import com.sw300.developmentservice.service.JobRepository;
import com.sw300.developmentservice.service.LearningObjectRepository;
import com.sw300.developmentservice.service.PracticeRepository;
import com.sw300.developmentservice.service.TheoryRepository;
import com.sw300.developmentservice.service.Topic;
import com.sw300.developmentservice.service.TopicRepository;


@RestController
public class CourseDevelopmentController {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private CoursewareRepository coursewareRepository;
	
	@Autowired
	private DisciplineRepository disciplineRepository;
	
	
	@Autowired
	private InstructorRepository instructorRepository;
	
	@Autowired
	private TopicRepository topicRepository;
	
	//모든 정보 가져오
	@GetMapping("/courses")
	public Iterator<Course> retrieveCourseAll() {
		
		return courseRepository.findAll().iterator();
		
	}
	
	//customer ID에 따른 결과 
	@GetMapping("/courses/{id}")
	public Resource<Course> retrieveCourse (@PathVariable long id) {
		Optional<Course> course = courseRepository.findById(id);
		if (!course.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		Resource<Course> resource = new Resource<Course>(course.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveCourseAll());
		
		resource.add(linkTo.withRel("/all-courses"));
		
		return resource;
		
	}
	
	//Data insert를 위한 부
	@PostMapping("/courses")
	public ResponseEntity<Object> createCourse(@Valid @RequestBody Course course) {
		
		courseRepository.save(course);
	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(course.getId())
			.toUri();
				
		return ResponseEntity.created(location).build();
		
	} 
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable long id) {
		
		Optional<Course> course = courseRepository.findById(id);
		if (!course.isPresent())
			throw new CustomizedNotFoundException ("id - " + id);
		
		courseRepository.delete(course.get());
		
	}
	
	//모든 정보 가져오
	@GetMapping("/coursewares")
	public Iterable<Courseware> retrieveCoursewareAll() {
		
		return coursewareRepository.findAll();
		
	}
	
	//customer ID에 따른 결과 
	@GetMapping("/coursewares/{id}")
	public Resource<Courseware> retrieveCoursewares (@PathVariable long id) {
		Optional<Courseware> coursewares = coursewareRepository.findById(id);
		if (!coursewares.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		Resource<Courseware> resource = new Resource<Courseware>(coursewares.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveCoursewareAll());
		
		resource.add(linkTo.withRel("/all-coursewares"));
		
		return resource;
		
	}
	
	//Data insert를 위한 부
	@PostMapping("/cousesewares")
	public ResponseEntity<Object> createCourseware(@Valid @RequestBody Courseware courseware) {
		
		coursewareRepository.save(courseware);
	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(courseware.getId())
			.toUri();
				
		return ResponseEntity.created(location).build();
		
	} 
	
	@DeleteMapping("/coursewares/{id}")
	public void deleteCourseware(@PathVariable long id) {
		
		Optional<Courseware> courseware = coursewareRepository.findById(id);
		if (!courseware.isPresent())
			throw new CustomizedNotFoundException ("id - " + id);
		
		coursewareRepository.delete(courseware.get());
		
	}
	
	//모든 정보 가져오
	@GetMapping("/disciplines")
	public Iterator<Discipline> retrieveDisciplineAll() {
		
		return disciplineRepository.findAll().iterator();
		
	}
	
	//customer ID에 따른 결과 
	@GetMapping("/disciplines/{id}")
	public Resource<Discipline> retrieveDisciplines (@PathVariable long id) {
		Optional<Discipline> disciplines = disciplineRepository.findById(id);
		if (!disciplines.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		Resource<Discipline> resource = new Resource<Discipline>(disciplines.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveDisciplineAll());
		
		resource.add(linkTo.withRel("/all-disciplines"));
		
		return resource;
		
	}
	
	//Data insert를 위한 부
	@PostMapping("/disciplines")
	public ResponseEntity<Object> createDiscipline(@Valid @RequestBody Discipline discipline) {
		
		disciplineRepository.save(discipline);
	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(discipline.getId())
			.toUri();
				
		return ResponseEntity.created(location).build();
		
	} 
	
	@DeleteMapping("/disciplines/{id}")
	public void deleteDiscipline(@PathVariable long id) {
		
		Optional<Discipline> disciplines = disciplineRepository.findById(id);
		if (!disciplines.isPresent())
			throw new CustomizedNotFoundException ("id - " + id);
		
		disciplineRepository.delete(disciplines.get());
		
	}
	
	

	
	//모든 정보 가져오
	@GetMapping("/instructors")
	public Iterator<Instructor> retrieveInstructorAll() {
		
		return instructorRepository.findAll().iterator();
		
	}
	
	//customer ID에 따른 결과 
	@GetMapping("/instructors/{id}")
	public Resource<Instructor> retrieveInstructors (@PathVariable long id) {
		Optional<Instructor> Instructors = instructorRepository.findById(id);
		if (!Instructors.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		Resource<Instructor> resource = new Resource<Instructor>(Instructors.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveInstructorAll());
		
		resource.add(linkTo.withRel("/all-instructors"));
		
		return resource;
		
	}
	
	//Data insert를 위한 부
	@PostMapping("/instructors")
	public ResponseEntity<Object> createInstructor(@Valid @RequestBody Instructor instructor) {
		
		instructorRepository.save(instructor);
	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(instructor.getId())
			.toUri();
				
		return ResponseEntity.created(location).build();
		
	} 
	
	@DeleteMapping("/instructors/{id}")
	public void deleteinstructor (@PathVariable long id) {
		
		Optional<Instructor> instructors = instructorRepository.findById(id);
		if (!instructors.isPresent())
			throw new CustomizedNotFoundException ("id - " + id);
		
		instructorRepository.delete(instructors.get());
		
	}
	
	//모든 정보 가져오
	@GetMapping("/topics")
	public Iterator<Topic> retrieveTopicAll() {
		
		return topicRepository.findAll().iterator();
		
	}
	
	//customer ID에 따른 결과 
	@GetMapping("/topics/{id}")
	public Resource<Topic> retrieveTopics (@PathVariable long id) {
		Optional<Topic> topics = topicRepository.findById(id);
		if (!topics.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		Resource<Topic> resource = new Resource<Topic>(topics.get());
		
		ControllerLinkBuilder linkTo = 
				linkTo(methodOn(this.getClass()).retrieveTopicAll());
		
		resource.add(linkTo.withRel("/all-topics"));
		
		return resource;
		
	}
	
	//Data insert를 위한 부
	@PostMapping("/topics")
	public ResponseEntity<Object> createTopic(@Valid @RequestBody Topic topic) {
		
		topicRepository.save(topic);
	
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(topic.getId())
			.toUri();
				
		return ResponseEntity.created(location).build();
		
	} 
	
	@DeleteMapping("/topics/{id}")
	public void deleteTopic (@PathVariable long id) {
		
		Optional<Topic> topics = topicRepository.findById(id);
		if (!topics.isPresent())
			throw new CustomizedNotFoundException ("id - " + id);
		
		topicRepository.delete(topics.get());
		
	}
	
	//customer ID에 따른 결과 
	@GetMapping("/courses/{id}/disciplines")
	public List<Discipline> retrieveCourseForDiscipline (@PathVariable long id) {
		Optional<Course> course = courseRepository.findById(id);
		if (!course.isPresent())
			throw new CustomizedNotFoundException("id - " + id);
		
		return course.get().getDisciplineList();
		
	}
	
	//Data insert를 위한 부
	@PostMapping("/courses/{id}/disciplines")
	public ResponseEntity<Object> createPost(@PathVariable long id, @RequestBody Discipline discipline) {
		
		Optional<Course> courses = courseRepository.findById(id);
		if (!courses.isPresent()) {
			throw new CustomizedNotFoundException("id - " + id);
		}
		
		Course course = courses.get();
		
		List<Course> courseList = new ArrayList<Course>();
		
		courseList.add(course);
		
		discipline.setCourseList(courseList);
		
		disciplineRepository.save(discipline);

		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(discipline.getId())
			.toUri();
	
		
		return ResponseEntity.created(location).build();
	}
		
	//courses for disciplines id 
		@GetMapping("/disciplines/{id}/courses")
		public List<Course> retrieveDisciplineForCourse (@PathVariable long id) {
			Optional<Discipline> discipline = disciplineRepository.findById(id);
			if (!discipline.isPresent())
				throw new CustomizedNotFoundException("id - " + id);
			
			return discipline.get().getCourseList();
			
		}
		
		//courses for disciplines id 
		@GetMapping("/disciplines/{id}/topics")
		public List<Topic> retrieveDisciplineForTopic (@PathVariable long id) {
			Optional<Discipline> discipline = disciplineRepository.findById(id);
			if (!discipline.isPresent())
				throw new CustomizedNotFoundException("id - " + id);
			
			return discipline.get().getTopicList();
			
		}
		
		
		//Instructors for classday
		@GetMapping("/classDays/{id}/instructors")
		public List<Instructor> retrieveClassDaysForInstructor (@PathVariable long id) {
			List<Instructor> instructorList = instructorRepository.findByClassDayId(id);
			if (instructorList.isEmpty())
				throw new CustomizedNotFoundException("id - " + id);
			
			return instructorList;
			
		}


	
	  //Data insert를 위한 부
  	@PostMapping("/associate-instructor/{classDayId}")
  	public ResponseEntity<Object> createInstructor (@PathVariable long classDayId, @RequestBody Instructor instructor) {
  		
  		instructor.setClassDayId(classDayId);
  		
  		instructorRepository.save(instructor);
  		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(instructor.getId())
				.toUri();
					
			return ResponseEntity.created(location).build();
  	
  		
  	} 
  	
  	
  	
  	
  	
	
	
	
}
