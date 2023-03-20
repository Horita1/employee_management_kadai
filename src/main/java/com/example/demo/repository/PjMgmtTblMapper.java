package com.example.demo.repository;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.PjMgmtTbl;
/**
 * 一覧表示用 Mapper
 */
@Mapper
public interface PjMgmtTblMapper {
    /**
     * @return　案件管理情報
     *  PjMgmtTbl.xmlを呼び出しﾃｰﾌﾞﾙの値を取得
     *  SQL分を実行する
     */
    List<PjMgmtTbl> selectAll();
}