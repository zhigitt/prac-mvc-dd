package java12.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java12.entity.Company;
import java12.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
@RequiredArgsConstructor

public class CompanyRepoImpl implements CompanyRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public String saveCompany(Company company) {
        entityManager.persist(company);
        return "Company saved";
    }

    @Override
    public Company getById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public String updateCompanyById(Long id, Company newCompany) {
        Company company = getById(id);
        company.setName(newCompany.getName());
        company.setDescription(newCompany.getDescription());
        company.setAddress(newCompany.getAddress());

//        entityManager.merge(company);

        return "Company updated!";
    }

    @Override
    public List<Company> getAll() {
        return entityManager.createQuery("select c from Company c").getResultList();
    }

    @Override
    public void deleteCompanyById(Long id) {
        entityManager.remove(entityManager.find(Company.class, id));
    }
}
