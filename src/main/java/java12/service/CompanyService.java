package java12.service;

import java12.entity.Company;

import java.util.List;

public interface CompanyService {
    String saveCompany(Company company);

    Company getById(Long id);

    String updateCompanyById(Long id, Company newCompany);

    List<Company> getAll();

    void deleteCompanyById(Long id);
}
