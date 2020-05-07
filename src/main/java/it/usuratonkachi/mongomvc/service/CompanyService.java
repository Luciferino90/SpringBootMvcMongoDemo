package it.usuratonkachi.mongomvc.service;

import it.usuratonkachi.mongomvc.domain.entity.Company;
import it.usuratonkachi.mongomvc.domain.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company findByCompanyId(String companyid) {
        return companyRepository.findByCompanyid(companyid)
                .orElseThrow(() -> new RuntimeException("Company not found for id " + companyid));
    }

    public Company create(Company company) {
        company.setCompanyid(UUID.randomUUID().toString());
        return companyRepository.save(company);
    }

    public Company update(Company company) {
        Company oldcompany = findByCompanyId(company.getCompanyid());
        oldcompany
                .setAddress(company.getAddress())
                .setBusinessname(company.getBusinessname())
                .setCap(company.getCap())
                .setPiva(company.getPiva());
        return companyRepository.save(oldcompany);
    }

}
