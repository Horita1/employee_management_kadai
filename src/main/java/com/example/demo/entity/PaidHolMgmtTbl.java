package com.example.demo.entity;
import lombok.Data;
/**
 * 有給管理ﾃｰﾌﾞﾙ格納用 Entity
 */
@Data
public class PaidHolMgmtTbl {
    /**
     * 有給管理ID
     */
    private String paidHolMgmtId;
    /**
     * 社員ID
     */
    private String employeeId;
    /**
     * 有給総計
     */
    private int paidHolsTotal;
    /**
     * 有給使用数
     */
    private int idHolsUsed;
}