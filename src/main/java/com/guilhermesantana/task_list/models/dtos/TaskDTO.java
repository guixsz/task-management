package com.guilhermesantana.task_list.models.dtos;

import com.guilhermesantana.task_list.models.enums.Category;

public record TaskDTO(String title, String description, String date, String location, String hour, Category category) {
}
