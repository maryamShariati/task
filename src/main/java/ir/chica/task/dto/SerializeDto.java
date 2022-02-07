package ir.chica.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public record SerializeDto(
        @NotBlank
        @JsonProperty("id") Long id,
        @NotBlank
        @JsonProperty("username") String username ,
        @Size(min = 8,message = "please enter at least 8 characters")
        @JsonProperty("password")String password) {
}
