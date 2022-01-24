package ir.chica.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDto(@JsonProperty("username")String username , @JsonProperty("password")String password) {
}
