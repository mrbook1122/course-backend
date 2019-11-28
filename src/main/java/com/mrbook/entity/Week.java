package com.mrbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Week {
    /**
     * 第几周
     */
    private String time;
    /**
     * 月份
     */
    private String month;
    private List<Day> days;
}
