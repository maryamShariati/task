package ir.chica.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public record TaskDto(
        @NotBlank
        @JsonProperty("name")String name,
        @NotBlank
        @JsonProperty("createAt")Date createAt) {
}
