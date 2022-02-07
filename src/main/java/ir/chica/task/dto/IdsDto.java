package ir.chica.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotBlank;
import java.util.List;

public record IdsDto(
        @NotBlank
        @JsonProperty("ids") List<Long> ids) {
}

