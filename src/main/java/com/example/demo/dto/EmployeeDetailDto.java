package com.example.demo.dto;

import lombok.Data;

/**
 * 有給管理ﾃｰﾌﾞﾙ格納用 Entity
 */
@Data
public class EmployeeDetailDto {
	/**
	 * 社員名
	 */
	private String employeeName;
	/**
	 * 年齢
	 */
	private int age;
	/**
	 * 社歴
	 */
	private String serviceYears;
	/**
	 * 役職
	 */
	private String position;
	/**
	 * 基本給
	 */
	private int salary;
	/**
	 * 有給残日数
	 */
	private int paidBalance;
	/**
	 * 最寄り駅
	 */
	private String closestSt;
	/**
	 * 案件名
	 */
	private String PjName;
	/**
	 * 案件ﾒﾝﾊﾞｰ
	 */
	private String pjMember;
	/**
	 * 案件期間
	 */
	private String pjPeriod;

}
