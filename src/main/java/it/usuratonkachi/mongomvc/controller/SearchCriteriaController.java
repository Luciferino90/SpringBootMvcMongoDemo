package it.usuratonkachi.mongomvc.controller;

import it.usuratonkachi.mongomvc.domain.entity.Company;
import it.usuratonkachi.mongomvc.domain.entity.User;
import it.usuratonkachi.mongomvc.dto.request.SearchCriteriaRequestDto;
import it.usuratonkachi.mongomvc.dto.response.CompanyResponseDto;
import it.usuratonkachi.mongomvc.dto.response.UserResponseDto;
import it.usuratonkachi.mongomvc.mapper.CompanyMapper;
import it.usuratonkachi.mongomvc.mapper.UserMapper;
import it.usuratonkachi.mongomvc.service.SearchCriteriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class SearchCriteriaController {

    private final MongoTemplate mongoTemplate;
    private final UserMapper userMapper;
    private final CompanyMapper companyMapper;

    @Bean
    @Lazy
    private SearchCriteriaService<User> userSearchCriteriaService(){
        return new SearchCriteriaService<>(mongoTemplate);
    }

    @Bean
    @Lazy
    private SearchCriteriaService<Company> companySearchCriteriaService(){
        return new SearchCriteriaService<>(mongoTemplate);
    }

    @PostMapping(value = "/search/user", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Page<UserResponseDto> searchUser(@Valid @RequestBody SearchCriteriaRequestDto req, Pageable pageable) {
        Page<User> userPage = userSearchCriteriaService().search(req.getSearchCriteriaList(), User.class, pageable);
        return userPage.map(userMapper::mapperEntityToResponseDto);
    }

    @PostMapping(value = "/search/company", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Page<CompanyResponseDto> searchCompany(@Valid @RequestBody SearchCriteriaRequestDto req, Pageable pageable) {
        Page<Company> companyPage = companySearchCriteriaService().search(req.getSearchCriteriaList(), Company.class, pageable);
        return companyPage.map(companyMapper::mapperEntityToResponseDto);
    }

}
