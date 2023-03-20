package com.example.demo.entity;
import lombok.Data;
/**
 * 案件管理ﾃｰﾌﾞﾙ格納用 Entity
 */
@Data
public class PjMgmtTbl {
    /**
     * 案件管理ID
     */
    private String pjMgmtId;
    /**
     * 社員ID
     */
    private String employeeId;
    /**
     * 案件ID
     */
    private String pjId;
}