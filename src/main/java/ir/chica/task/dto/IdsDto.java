package ir.chica.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record IdsDto(@JsonProperty("ids") List<Long> ids) {
}

