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
    private String employee_id;
    /**
     * 社員名
     */
    private String employee_name;
    /**
     * 誕生日
     */
    private Date birthday;
    /**
     * 入社日
     */
    private Date start_date;
	/**
     * 役職ID
     */
    private String position_id;
    /**
     * 最寄り駅
     */
    private String closest_st;
}