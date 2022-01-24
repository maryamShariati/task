package ir.chica.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record TaskDto(@JsonProperty("name")String name, @JsonProperty("createAt")Date createAt) {
}
