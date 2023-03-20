package com.example.demo.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.EmployeeMst;
import com.example.demo.entity.SalaryMst;
/**
 * 一覧表示用 Mapper
 */
@Mapper
public interface SalaryMstMapper {
    /**
     * @return ユーザー情報
     *  SalaryMstMapper.xmlを呼び出しﾃｰﾌﾞﾙの値を取得
     *  SQL分を実行する
     */
    List<SalaryMst> selectAll();
}