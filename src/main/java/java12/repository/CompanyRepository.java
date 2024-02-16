package java12.repository;

import java12.entity.Company;

import java.util.List;

public interface CompanyRepository {

    String saveCompany(Company company);

    Company getById(Long id);

    String updateCompanyById(Long id, Company newCompany);

    List<Company> getAll();

    void deleteCompanyById(Long id);
}
