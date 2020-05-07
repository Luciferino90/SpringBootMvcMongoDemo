package it.usuratonkachi.mongomvc.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CompanyBaseDto extends UserBaseDto implements Serializable {

    private final static long serialVersionUID = 20200507_2143L;
    @NotNull @NotBlank @NotEmpty
    private String piva;
    @NotNull @NotBlank @NotEmpty
    private String businessname;
    @NotNull @NotBlank @NotEmpty
    private String address;
    @NotNull @NotBlank @NotEmpty
    private String cap;

}
