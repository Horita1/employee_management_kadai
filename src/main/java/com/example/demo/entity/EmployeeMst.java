package com.example.demo.entity;
import java.util.Date;
import lombok.Data;
/**
 * 社員ﾏｽﾀｰ格納用 Entity
 */
@Data
public class EmployeeMst {
    /**
     * 社員ID
     */
    private String employeeId;
    /**
     * 社員名
     */
    private String employeeName;
    /**
     * 誕生日
     */
    private Date birthday;
    /**
     * 入社日
     */
    private Date startDate;
	/**
     * 役職ID
     */
    private String positionId;
    /**
     * 最寄り駅
     */
    private String closestSt;
}