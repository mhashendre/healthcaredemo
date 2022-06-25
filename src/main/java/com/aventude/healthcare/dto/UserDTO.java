package com.aventude.healthcare.dto;

import com.aventude.healthcare.domain.Audit;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "userId")
public class UserDTO extends Audit {
    private Long userId;
    private String username;
    private String password;
}
