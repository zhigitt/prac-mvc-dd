package java12.service.impl;

import jakarta.transaction.Transactional;
import java12.entity.Company;
import java12.repository.CompanyRepository;
import java12.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanySerImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    @Override
    public String saveCompany(Company company) {
        return companyRepository.saveCompany(company);
    }

    @Override
    public Company getById(Long id) {
        return companyRepository.getById(id);
    }

    @Override
    public String updateCompanyById(Long id, Company newCompany) {
        return companyRepository.updateCompanyById(id, newCompany);
    }

    @Override
    public List<Company> getAll() {
        return companyRepository.getAll();
    }

    @Override
    public void deleteCompanyById(Long id) {
        companyRepository.deleteCompanyById(id);
    }
}
