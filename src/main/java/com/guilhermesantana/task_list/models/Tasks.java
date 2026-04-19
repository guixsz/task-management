package com.guilhermesantana.task_list.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.guilhermesantana.task_list.util.Category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class Tasks {

    private Integer id;

    @NotBlank(message = "Título obrigatório")
    private String title;

    @NotBlank(message = "Descrição obrigatório")
    private String description;

    @NotNull(message = "Categoria obrigatória")
    private Category category;

    @NotNull(message = "Data obrigatório")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime date;
    private boolean isFinished;

    public Tasks() {}

    public Tasks(String title, String description, LocalDateTime date, Category category) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.category = category;
        this.isFinished = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
