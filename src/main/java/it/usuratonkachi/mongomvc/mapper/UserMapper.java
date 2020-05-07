package it.usuratonkachi.mongomvc.mapper;

import it.usuratonkachi.mongomvc.domain.entity.User;
import it.usuratonkachi.mongomvc.dto.request.UserInsertRequestDto;
import it.usuratonkachi.mongomvc.dto.request.UserUpdateRequestDto;
import it.usuratonkachi.mongomvc.dto.response.UserResponseDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDto mapperEntityToResponseDto(User user);
    User mapperUpdateDtoToEntity(UserUpdateRequestDto user);
    User mapperInsertDtoToEntity(UserInsertRequestDto user);
}
