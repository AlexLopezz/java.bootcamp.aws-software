package com.ar.alexdev.cxfspringbootws_CRUD.models.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.*;

import java.util.Date;

@XmlRootElement
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
public class UserDTO {
    private String dni;

    private String name;

    private String lastName;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date dateBirth;

    private String profession;
}
