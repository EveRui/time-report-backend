package com.gev.timesheet.dto;

public interface DTO<T> {
    void convertToDTO(T t);
    void convertToEntity(T t);
}
