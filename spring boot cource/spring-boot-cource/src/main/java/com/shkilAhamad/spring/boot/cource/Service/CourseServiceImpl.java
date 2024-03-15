package com.shkilAhamad.spring.boot.cource.Service;

import com.shkilAhamad.spring.boot.cource.Entity.Course;
import com.shkilAhamad.spring.boot.cource.Repository.CourseRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CourseServiceImpl implements CourseService {
    //@Autowired
    private CourseRepository courseRepository;

    @Override
    public Course postCourses(Course course) {

        Course course1 = courseRepository.save(course);

        return course1;
    }


    @Override
    public Integer postCoursesByNative(Course course) {
        System.out.println("course-->" + course);
        Integer oneCourse = courseRepository.postAllCoursesByNative(course.getCourseFee(), course.getFirstName(), course.getLastName(), course.getSubject());
        //  course.getSubject()

        return oneCourse;
    }

    @Override
    public Course findStudentByIdUsingNative(Long id) {
        //  return courseRepository.findStudentByIdUsingNative(id);
        return courseRepository.findStudentByIdUsingNative(id);
    }

    @Override
    public List<Course> findAllCourse() {
        List<Course> courseList=courseRepository.findAllByNative();

        return courseList;
    }

    @Override
    public int insertAllcourses(List<Course> courseList) {
        int count=0;
        for (Course singleCourse:courseList){
          Integer integer=  courseRepository.postAllCoursesByNative(singleCourse.getCourseFee(),singleCourse.getFirstName(),singleCourse.getLastName(),singleCourse.getSubject());
           count+=integer;
        }

        return count ;
    }

    @Override
    public   Integer updateCourseById(Long id, Course course) {
        //Course courseByNaive =courseRepository.updateCourseByNaive(id);
        /*Course existingCourse=optionalCourse.orElseThrow();
        existingCourse.setSubject(course.getSubject());
        existingCourse.setCourseFee(course.getCourseFee());
        existingCourse.setFirstName(course.getFirstName());
        existingCourse.setLastName(course.getLastName());*/
     // return courseRepository.save(existingCourse);
      Integer updatedCourse = courseRepository.updateCourseByNaive(course.getSubject(),course.getCourseFee(),course.getFirstName(),course.getLastName(),id);
        return 1;
    }

    @Override
    public Integer updateNameById(Long id, Course course) {
        courseRepository.updateNameByIdUsingNative(course.getFirstName(),id);
        return 1;
    }

    @Override
    public Integer AllCourseUpdateUsingId(Course course, Long id) {
         Integer response=courseRepository.AllCourseUpdateUsingIdNative(course.getSubject(),course.getCourseFee(),course.getFirstName(),course.getLastName(),id);

        return response;
    }

    @Override
    public Integer deleteCourseById(Long id) {
        Integer receiveResponse=courseRepository.deleteCourseBiIdNative(id);

        return receiveResponse;
    }


}
