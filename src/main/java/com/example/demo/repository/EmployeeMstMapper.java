package com.example.demo.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.EmployeeMst;
/**
 * 一覧表示用 Mapper
 */
@Mapper
public interface EmployeeMstMapper {
    /**
     * @return ユーザー情報
     *  EmployeeMapper.xmlを呼び出しﾃｰﾌﾞﾙの値を取得
     *  SQL分を実行する
     */
    List<EmployeeMst> selectAll();
}