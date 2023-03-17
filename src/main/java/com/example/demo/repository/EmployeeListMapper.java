package com.example.demo.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.EmployeeMst;
/**
 * 一覧表示用 Mapper
 */
@Mapper
public interface EmployeeListMapper {
    /**
     * ユーザー情報検索
     * @param user 検索用リクエストデータ
     * @return ユーザー情報
     *  UserMapper.xmlを呼び出しUserSearchRequestの値を渡す
     *  SQL分を実行する
     *  一致したユーザーを取得
     */
    List<EmployeeMst> selectAll();
}