package com.example.demo.entity;
import lombok.Data;
/**
 * 給料管理ﾃｰﾌﾞﾙ格納用 Entity
 */
@Data
public class SalaryMgmtTbl {
    /**
     * 給料管理ID
     */
    private String salaryMgmtId;
    /**
     * 社員ID
     */
    private String employeeId;
    /**
     * 給料ID
     */
    private String salaryId;
}