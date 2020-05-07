package it.usuratonkachi.mongomvc.domain.repository;

import it.usuratonkachi.mongomvc.domain.entity.Company;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends MongoRepository<Company, String> {

    Optional<Company> findByCompanyid(String companyid);

}
