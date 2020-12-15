package com.dev.timesheet.dto;

public interface DTO<T> {
    void convertToDTO(T t);
    void convertToEntity(T t);
}
