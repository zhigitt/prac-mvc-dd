package java12.service.impl;

import java12.entity.Course;
import java12.repository.CourseRepository;
import java12.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseSerImpl implements CourseService {

    private final CourseRepository courseRepository;

    @Override
    public void saveCourseByCompanyID(Long companyId, Course course) {
        courseRepository.saveCourseByCompanyID(companyId, course);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepository.getCourseById(id);
    }

    @Override
    public void updateCourseById(Long id, Course newCourse) {
        courseRepository.updateCourseById(id, newCourse);
    }

    @Override
    public List<Course> getAllCoursesByCompanyId(Long companyId) {
        return courseRepository.getAllCoursesByCompanyId(companyId);
    }

    @Override
    public void deleteCourseById(Long id) {
        courseRepository.deleteCourseById(id);
    }
}
