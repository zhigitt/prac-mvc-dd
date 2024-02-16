package java12.service;

import java12.entity.Course;

import java.util.List;

public interface CourseService {

    void saveCourseByCompanyID(Long companyId, Course course);

    Course getCourseById(Long id);

    void updateCourseById(Long id, Course newCourse);

    List<Course> getAllCoursesByCompanyId(Long companyId);

    void deleteCourseById(Long id);
}
