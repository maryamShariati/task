package ir.chica.task.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public record DateDto(@JsonProperty("date") Date date) {
}
