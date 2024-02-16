package java12.controller;

import java12.entity.Company;
import java12.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/companies")

public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public String getAllCompanies(Model model){
        model.addAttribute("allCompanies", companyService.getAll());
        return "/companies";
    }

    @GetMapping("/new")
    public String createCompany(Model model){
        model.addAttribute("newCompany", new Company());
        return "createNewCompany";
    }

    @PostMapping("/save")
    public String saveCompany(@ModelAttribute("newCompany") Company company){
        companyService.saveCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/delete/{companyId}")
    public String deleteCompany(@PathVariable("companyId") Long companyId){
        companyService.deleteCompanyById(companyId);
        return "redirect:/companies";
    }

    @GetMapping("/update/{companyId}")
    public String updateForm(@PathVariable("companyId")Long companyId, Model model){
        Company company = companyService.getById(companyId);
        model.addAttribute("company", company);
        return "companyForm";
    }

    @PostMapping("/edit/{companyId}")
    public String update(@ModelAttribute("company")Company company, @PathVariable("companyId") Long companyId){
        companyService.updateCompanyById(companyId, company);
        return "redirect:/companies";
    }

    @GetMapping("/find/{companyId}")
    public String find(@PathVariable("companyId")Long companyId, Model model){
        Company byId = companyService.getById(companyId);
        model.addAttribute("courses", byId.getCourses());
        model.addAttribute("currentCompanyId", companyId);
        return "courses";
    }
}
