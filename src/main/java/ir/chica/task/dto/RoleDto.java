package ir.chica.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ir.chica.task.enumTest.CategoryEnum;
import ir.chica.task.enumTest.RoleEnum;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record RoleDto(@NotBlank
                      @NotNull
                      @JsonProperty("main")
                      RoleEnum main,
                      @NotBlank
                      @NotNull
                      @JsonProperty("category")
                      CategoryEnum category,
                      @NotBlank
                      @NotNull
                      @JsonProperty("name")
                      String name) {

}
