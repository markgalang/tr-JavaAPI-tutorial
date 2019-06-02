package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;

@Embeddable
@Data
public class Name {

    @NotBlank(message = "first name is required")
    @JsonProperty(value = "first_name")
    private String firstName;

    @NotBlank(message = "middle name is required")
    @JsonProperty(value = "middle_name")
    private String middleName;

    @NotBlank(message = "last name is required")
    @JsonProperty(value = "last_name")
    private String lastName;
    private String suffix;
}

