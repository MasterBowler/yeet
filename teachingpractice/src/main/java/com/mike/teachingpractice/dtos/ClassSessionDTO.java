package com.mike.teachingpractice.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

import com.mike.teachingpractice.models.User;

public class ClassSessionDTO {
    private Integer groupId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer availableSeats;
    private String name;
    private String description;

    public ClassSessionDTO() {
    }

    public ClassSessionDTO(Integer groupId, LocalDate date, LocalTime startTime, LocalTime endTime,
            Integer availableSeats,
            String name, String description) {
        this.groupId = groupId;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.availableSeats = availableSeats;
        this.name = name;
        this.description = description;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
