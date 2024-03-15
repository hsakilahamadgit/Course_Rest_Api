package com.shkilAhamad.spring.boot.cource.Service;

import com.shkilAhamad.spring.boot.cource.Entity.Course;

import java.util.List;

public interface CourseService {
    Course postCourses (Course course);

    Integer postCoursesByNative(Course courses);

    Course findStudentByIdUsingNative(Long id);

    List<Course> findAllCourse();

    int insertAllcourses(List<Course> courseList);
    Integer updateCourseById (Long id,Course course);

    Integer updateNameById(Long id,Course course);

    Integer AllCourseUpdateUsingId(Course course,Long id);

    Integer deleteCourseById(Long id);
}
