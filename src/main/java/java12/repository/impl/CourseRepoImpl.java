package java12.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java12.entity.Company;
import java12.entity.Course;
import java12.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor

public class CourseRepoImpl implements CourseRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public void saveCourseByCompanyID(Long companyId, Course course) {

        Company company = entityManager.find(Company.class, companyId);
        course.setCompany(company);
        company.getCourses().add(course);

        entityManager.persist(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public void updateCourseById(Long id, Course newCourse) {
        Course course = getCourseById(id);

        course.setCourseName(newCourse.getCourseName());
        course.setDescription(newCourse.getDescription());
        course.setImageLink(newCourse.getImageLink());
        course.setPrice(newCourse.getPrice());

        entityManager.persist(course);
    }

    @Override
    public List<Course> getAllCoursesByCompanyId(Long companyId) {
        Company company = entityManager.find(Company.class, companyId);
        List<Course> courses = company.getCourses();
        return courses;
    }

    @Override
    public void deleteCourseById(Long id) {
        entityManager.createQuery("delete from Course c where c.id = :q")
                .setParameter("q", id)
                .executeUpdate();
    }
}
