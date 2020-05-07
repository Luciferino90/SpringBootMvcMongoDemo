package it.usuratonkachi.mongomvc.mapper;

import it.usuratonkachi.mongomvc.domain.entity.Company;
import it.usuratonkachi.mongomvc.dto.request.CompanyInsertRequestDto;
import it.usuratonkachi.mongomvc.dto.request.CompanyUpdateRequestDto;
import it.usuratonkachi.mongomvc.dto.response.CompanyResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompanyMapper {
    CompanyResponseDto mapperEntityToResponseDto(Company company);
    Company mapperUpdateDtoToEntity(CompanyUpdateRequestDto company);
    Company mapperInsertDtoToEntity(CompanyInsertRequestDto company);
}
