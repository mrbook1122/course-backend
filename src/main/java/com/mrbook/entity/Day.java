package com.mrbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Day {
    /**
     * 周几
     */
    private String weekNum;
    /**
     * 多少号
     */
    private String date;
    private List<Course> courses;
}
