package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import com.example.demo.Answer;
import com.example.demo.Answer1;
import com.example.demo.Question;
@Mapper
public interface QuestionMapper {
	/**
	 * 添加一个测试题
	 * @param question
	 */
	@Insert("insert into question(subject,item1,item2,item3,item4,answer)"
			+ " value(#{subject},"
			+ "#{item1},#{item2},#{item3},#{item4},#{answer})")
	void add(Question question);
	
	/**
	 * 分页查找
	 * @param size  数据的大小 (数量)
 	 * @param start  起始位置
	 * @return
	 */
	@Select("select id,subject,item1,item2,item3,item4 from question limit #{size} offset #{start}")
	List<Question> list(
			@Param("size")int size,
			@Param("start")int start);
	@Select("select * from question")
	List<Question> ans();
	
}