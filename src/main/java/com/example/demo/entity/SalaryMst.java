package com.example.demo.entity;
import lombok.Data;
/**
 * 給料ﾏｽﾀｰ格納用 Entity
 */
@Data
public class SalaryMst {
    /**
     * 給料ID
     */
    private String salaryId;
    /**
     * 給料
     */
    private int salary;
}
