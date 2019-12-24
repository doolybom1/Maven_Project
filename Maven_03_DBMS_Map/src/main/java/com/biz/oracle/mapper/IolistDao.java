package com.biz.oracle.mapper;

import java.util.List;
import java.util.Map;

public interface IolistDao {

	// List<Dto> selectAll()
	// String 에 해당하는 값이 mapper에서 설정한 property 값
	// resultMap으로 설정된 형태는 Map<String,Object> 형식의 DTO가 만들어 진것으로 본다.
	public List<Map<String,Object>> selectAll();
}
