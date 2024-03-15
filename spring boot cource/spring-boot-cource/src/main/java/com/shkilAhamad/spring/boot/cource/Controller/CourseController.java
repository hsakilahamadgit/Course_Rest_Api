package com.shkilAhamad.spring.boot.cource.Controller;

import com.shkilAhamad.spring.boot.cource.Entity.Course;
import com.shkilAhamad.spring.boot.cource.Service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CourseController {

    //@Autowired
    private CourseService courseService;

    @PostMapping("/postCourse")
    public ResponseEntity<Course> postCourse(@RequestBody Course course){
        Course courses=courseService.postCourses(course);

        return new ResponseEntity<>(course, HttpStatus.CREATED);

    }
    @PostMapping("/postByNative")
    public ResponseEntity<Course> saveOneCourse(@RequestBody Course  course){
        Integer oneCourse=courseService.postCoursesByNative(course);
        System.out.println("oneCourse-->"+oneCourse);
        if (oneCourse>0) {
            return new ResponseEntity<>(course, HttpStatus.CREATED);
        }
        else
            return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @GetMapping("/getCourse/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id){
        Course studentByIdUsingNative = courseService.findStudentByIdUsingNative(id);
        return new ResponseEntity<>(studentByIdUsingNative,HttpStatus.OK);
    }
    @GetMapping("/findAll")
    public  ResponseEntity<List<Course>> findAll(){
        List<Course> courseList=courseService.findAllCourse();

        return new   ResponseEntity<>(courseList,HttpStatus.OK);
    }
    @PostMapping("/postAllCourses")
    public  ResponseEntity<String> insertAllCourses(@RequestBody List<Course> courseList){
    int msg= courseService.insertAllcourses(courseList);
    if (msg<1){
        return new ResponseEntity<>(" No record inserted successfully",HttpStatus.OK);
    } else {
        return new ResponseEntity<>(msg + " record inserted successfully", HttpStatus.OK);
    }
    }
    @PutMapping("/updateById/{id}")
    public  ResponseEntity<String> updateCourse(@PathVariable Long id,@RequestBody Course course){
        Integer updateCourseById=courseService.updateCourseById(id,course);

        return  new ResponseEntity<>( updateCourseById+"row updeted sucessfully",HttpStatus.CREATED);
    }

    @PutMapping("/updateCourseFeeById/{id}")
    public  ResponseEntity<String> updateCoursefee(@PathVariable Long id,@RequestBody Course course) {
        Integer updateCourseById = courseService.updateNameById(id, course);

        return new ResponseEntity<>(updateCourseById + "row updeted sucessfully", HttpStatus.CREATED);
    }

    @PutMapping("/updatingAllCourses/{id}")
    public ResponseEntity<String> allCourseUpdateById(@RequestBody Course course,@PathVariable Long id){
        Integer gotResponse=courseService.AllCourseUpdateUsingId(course,id);
        return  new ResponseEntity<>( gotResponse +"sucessfully updated",HttpStatus.OK);
    }

    @DeleteMapping("/deleteCourses/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        Integer gotResponse=courseService.deleteCourseById(id);

        return  new ResponseEntity<>(gotResponse+"row deleted",HttpStatus.OK);
    }
}
