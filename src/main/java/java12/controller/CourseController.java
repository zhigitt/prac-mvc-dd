package java12.controller;

import java12.entity.Course;
import java12.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/newCourseSave/{companyId}")
    public String addCourse(Model model,
                            @PathVariable Long companyId) {
        model.addAttribute("newCourse", new Course());
        model.addAttribute("companyId", companyId);
        return "/createNewCourse";
    }

    @PostMapping("/saveCourse/{companyId}")
    public String saveCourse(@ModelAttribute("newCourse") Course course,
                             @PathVariable Long companyId) {

        courseService.saveCourseByCompanyID(companyId, course);
        return "redirect:/companies/find/" + companyId;
    }

    @GetMapping("/courses/{companyId}")
    public String getAllCourses(@PathVariable("companyId") Long companyId, Model model) {
        model.addAttribute("allCourses", courseService.getAllCoursesByCompanyId(companyId));
        return "redirect:/courses{companyId}";
    }

    @GetMapping("/delete/{courseId}")
    private String deleteCourse(@PathVariable("courseId") Long courseId) {
        Long id = courseService.getCourseById(courseId).getCompany().getId();
        courseService.deleteCourseById(courseId);
        return "redirect:/companies/find/" + id;
    }

    @GetMapping("/updateCourse/{courseId}")
    public String updateCourseForm(@PathVariable("courseId") Long courseId, Model model) {
        Course course = courseService.getCourseById(courseId);
        model.addAttribute("course", course);
        return "courseForm";
    }

    @PostMapping("/editCourse/{courseId}")
    public String updateCourse(@ModelAttribute("course") Course course, @PathVariable("courseId") Long courseId) {
        courseService.updateCourseById(courseId, course);
        Long id = courseService.getCourseById(courseId).getCompany().getId();
        return "redirect:/companies/find/" + id;
    }

}
