package java12.repository;

import java12.entity.Course;

import java.util.List;

public interface CourseRepository {

    void saveCourseByCompanyID(Long companyId, Course course);

    Course getCourseById(Long id);

    void updateCourseById(Long id, Course newCourse);

    List<Course> getAllCoursesByCompanyId(Long companyId);

    void deleteCourseById(Long id);
}
