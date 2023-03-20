package com.example.demo.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.PjMst;
/**
 * 一覧表示用 Mapper
 */
@Mapper
public interface PjMstMapper {
    /**
     * @return ユーザー情報
     *  PjMstMapper.xmlを呼び出しﾃｰﾌﾞﾙの値を取得
     *  SQL分を実行する
     */
    List<PjMst> selectAll();
}