package com.example.demo.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.PositionMst;
/**
 * 一覧表示用 Mapper
 */
@Mapper
public interface PositionMstMapper {
    /**
     * @return ユーザー情報
     *  PositionMstMapper.xmlを呼び出しﾃｰﾌﾞﾙの値を取得
     *  SQL分を実行する
     */
    List<PositionMst> selectAll();
}