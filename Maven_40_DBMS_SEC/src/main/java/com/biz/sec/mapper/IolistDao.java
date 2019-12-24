package com.biz.sec.mapper;

import java.util.List;
import java.util.Map;

import com.biz.sec.persistence.IolistDTO;

public interface IolistDao {
	
	public List<Map<String,Object>> selectAllMap();
	
	public List<IolistDTO> selectAll();
}
