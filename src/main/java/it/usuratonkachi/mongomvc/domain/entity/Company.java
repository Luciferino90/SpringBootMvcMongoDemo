package it.usuratonkachi.mongomvc.domain.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@Document(value = "company")
public class Company implements Serializable {

    private final static long serialVersionUID = 20200507_2146L;

    @Id
    private String id;
    private String companyid;
    private String piva;
    private String businessname;
    private String address;
    private String cap;

}
