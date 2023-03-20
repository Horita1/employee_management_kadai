package com.example.demo.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.EmployeeMst;
import com.example.demo.entity.SalaryMgmtTbl;
/**
 * 一覧表示用 Mapper
 */
@Mapper
public interface SalaryMgmtTblMapper {
    /**
     * @return ユーザー情報
     *  SalaryMgmtMapper.xmlを呼び出しﾃｰﾌﾞﾙの値を取得
     *  SQL分を実行する
     */
    List<SalaryMgmtTbl> selectAll();
}