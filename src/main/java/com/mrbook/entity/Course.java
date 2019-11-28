package com.mrbook.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Course {
    /**
     * 持续时间
     */
    private int num;

    /**
     * 课程名字
     */
    private String name;

    /**
     * 地址
     */
    private String address;
}
