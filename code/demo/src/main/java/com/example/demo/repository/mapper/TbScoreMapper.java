package com.example.demo.repository.mapper;

import com.example.demo.repository.model.TbScore;
import com.example.demo.repository.model.TbScoreExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface TbScoreMapper {
    int countByExample(TbScoreExample example);

    int deleteByExample(TbScoreExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TbScore record);

    int insertSelective(TbScore record);

    List<TbScore> selectByExampleWithRowbounds(TbScoreExample example, RowBounds rowBounds);

    List<TbScore> selectByExample(TbScoreExample example);

    TbScore selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TbScore record, @Param("example") TbScoreExample example);

    int updateByExample(@Param("record") TbScore record, @Param("example") TbScoreExample example);

    int updateByPrimaryKeySelective(TbScore record);

    int updateByPrimaryKey(TbScore record);
}