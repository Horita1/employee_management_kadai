package com.example.demo.entity;
import java.util.Date;

import lombok.Data;
/**
 * 案件ﾏｽﾀｰ格納用 Entity
 */
@Data
public class PjMst {
    /**
     * 案件ID
     */
    private String pjId;
    /**
     * 案件名
     */
    private String pjName;
    /**
     * 案件参画日
     */
    private Date pjStartDate;
    /**
     * 案件終了日
     */
    private Date pjEndDate;
}