package com.example.demo.entity;
import lombok.Data;
/**
 * 役職格納用 Entity
 */
@Data
public class PositionMst {
    /**
     * 役職ID
     */
    private String positionId;
    /**
     * 社員名
     */
    private String position;
}