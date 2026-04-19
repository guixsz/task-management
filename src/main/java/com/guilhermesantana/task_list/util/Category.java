package com.guilhermesantana.task_list.util;

public enum Category {
    HEALTH("H", "Saúde"),
    DENTIST("D", "Dentista"),
    EVENTS("E", "Evento");

    private String code;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    Category(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static Category fromDescription(String description) {
        for(Category c : values()) {
            if(c.getDescription().equals(description)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Código inválido");
    }
}
