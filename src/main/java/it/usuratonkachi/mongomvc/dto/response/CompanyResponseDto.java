package it.usuratonkachi.mongomvc.dto.response;

import it.usuratonkachi.mongomvc.dto.CompanyBaseDto;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CompanyResponseDto extends CompanyBaseDto implements Serializable {

    private final static long serialVersionUID = 20200507_2143L;

    @NotNull @NotEmpty @NotBlank
    private String companyid;

}
