package it.usuratonkachi.mongomvc.controller;

import it.usuratonkachi.mongomvc.domain.entity.Company;
import it.usuratonkachi.mongomvc.domain.entity.User;
import it.usuratonkachi.mongomvc.dto.request.CompanyInsertRequestDto;
import it.usuratonkachi.mongomvc.dto.request.CompanyUpdateRequestDto;
import it.usuratonkachi.mongomvc.dto.request.UserInsertRequestDto;
import it.usuratonkachi.mongomvc.dto.request.UserUpdateRequestDto;
import it.usuratonkachi.mongomvc.dto.response.CompanyResponseDto;
import it.usuratonkachi.mongomvc.dto.response.UserResponseDto;
import it.usuratonkachi.mongomvc.mapper.CompanyMapper;
import it.usuratonkachi.mongomvc.mapper.UserMapper;
import it.usuratonkachi.mongomvc.service.CompanyService;
import it.usuratonkachi.mongomvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
//@RequiredArgsConstructor
public class CrudController {

    @Autowired private UserService userService;
    @Autowired private CompanyService companyService;
    @Autowired private UserMapper userMapper;
    @Autowired private CompanyMapper companyMapper;

    @PostMapping(value = "/user/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto insertUser(@RequestBody UserInsertRequestDto req) {
        User user = userMapper.mapperInsertDtoToEntity(req);
        user = userService.create(user);
        UserResponseDto userResponseDto = userMapper.mapperEntityToResponseDto(user);
        return userResponseDto;
    }

    @PostMapping(value = "/user/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public UserResponseDto updateUser(@Valid @RequestBody UserUpdateRequestDto req) {
        User user = userMapper.mapperUpdateDtoToEntity(req);
        user = userService.update(user);
        UserResponseDto userResponseDto = userMapper.mapperEntityToResponseDto(user);
        return userResponseDto;
    }

    @PostMapping(value = "/company/insert", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CompanyResponseDto insertCompany(@Valid @RequestBody CompanyInsertRequestDto req) {
        Company company = companyMapper.mapperInsertDtoToEntity(req);
        company = companyService.create(company);
        CompanyResponseDto companyResponseDto = companyMapper.mapperEntityToResponseDto(company);
        return companyResponseDto;
    }

    @PostMapping(value = "/company/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public CompanyResponseDto updateCompany(@Valid @RequestBody CompanyUpdateRequestDto req) {
        Company company = companyMapper.mapperUpdateDtoToEntity(req);
        company = companyService.update(company);
        CompanyResponseDto companyResponseDto = companyMapper.mapperEntityToResponseDto(company);
        return companyResponseDto;
    }

    @GetMapping("/user/{userid}")
    public UserResponseDto getUser(@PathVariable("userid") String userid) {
        User user = userService.findByUserId(userid);
        UserResponseDto userResponseDto = userMapper.mapperEntityToResponseDto(user);
        return userResponseDto;
    }

    @GetMapping("/company/{companyid}")
    public CompanyResponseDto getCompany(@PathVariable("companyid") String companyid) {
        Company company = companyService.findByCompanyId(companyid);
        CompanyResponseDto companyResponseDto = companyMapper.mapperEntityToResponseDto(company);
        return companyResponseDto;
    }

}
