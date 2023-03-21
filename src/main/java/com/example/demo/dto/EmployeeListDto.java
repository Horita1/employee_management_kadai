package com.example.demo.dto;
import java.time.LocalDate;

import lombok.Data;

/**
 * 有給管理ﾃｰﾌﾞﾙ格納用 Entity
 */
@Data
public class EmployeeListDto {
	/**
	 * 社員ID
	 */
	private String employeeId;
	/**
	 * 社員名
	 */
	private String employeeName;
	/**
	 * 年齢
	 */
	private int age;
	/**
	 * 案件名
	 */
	private String PjName;
	/**
	 * 参画日
	 */
	private LocalDate pjStartDate;
}