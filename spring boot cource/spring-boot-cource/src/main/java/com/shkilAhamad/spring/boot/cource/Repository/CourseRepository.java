package com.shkilAhamad.spring.boot.cource.Repository;

import com.shkilAhamad.spring.boot.cource.Entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course,Long> {

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO course (course_fee,first_name, last_name,subject) VALUES (?,?,?,?)", nativeQuery = true)
Integer postAllCoursesByNative(Integer courseFee,String firstName,String LastName,String subject);

    @Query(value = "select * from course where id= :id",nativeQuery = true)
    Course findStudentByIdUsingNative(Long id);

    @Query(value = "select * from course  ",nativeQuery = true)
    List<Course> findAllByNative();

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO course (course_fee,first_name, last_name,subject) VALUES (?,?,?,?)",nativeQuery = true)
    Integer insertAllCoursesByNative(Integer courseFee,String firstName,String LastName,String subject);
//    @Modifying
//    @Transactional
//    @Query(value = "update course set subject=?1,course_fee=?2,first_name=?3,last_name=?4 where id=?5",nativeQuery = true)
//    Integer updateCourseByNaive(@Param("sub") final String subject, @Param("coursefee") final Integer courseFee, @Param("firstname") final String firstName, @Param("lastName") final String LastName, @Param("id") final Long id);

    @Modifying
    @Transactional
    @Query(value = "update course set first_name=:firstname where id=:id", nativeQuery = true)
    Integer updateNameByIdUsingNative(@Param("firstname") final String firstname, @Param("id") Long id);

    @Modifying
    @Transactional
    @Query(value = "update course set subject=?1,course_fee=?2,first_name=?3,last_name=?4 where id=?5",nativeQuery = true)
    Integer updateCourseByNaive(@Param("sub") final String subject, @Param("coursefee") final Integer courseFee, @Param("firstname") final String firstName, @Param("lastName") final String LastName, @Param("id") final Long id);
    @Modifying
    @Transactional
    @Query(value = "update course set subject=:sub,course_fee=:courseFee,first_name=:firstname,last_name=:lastName where id=:id",nativeQuery = true)
    Integer AllCourseUpdateUsingIdNative(@Param("sub") String subject,@Param("courseFee") Integer courseFee ,@Param("firstname") String firstName,@Param("lastName") String LastName,@Param("id") Long id);
@Transactional
@Modifying
    @Query(value = "delete from course where id=:id",nativeQuery = true)
    Integer deleteCourseBiIdNative(Long id);
}

