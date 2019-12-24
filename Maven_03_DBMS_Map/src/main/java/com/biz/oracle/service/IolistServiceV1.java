package com.biz.oracle.service;

import java.util.List;
import java.util.Map;

import com.biz.oracle.config.DBConnection;
import com.biz.oracle.mapper.IolistDao;

public class IolistServiceV1 {
	IolistDao ioDao = null;
	
	public IolistServiceV1() {
		ioDao = DBConnection.getSqlSessionFactory().openSession(true).getMapper(IolistDao.class);
	}
	
	public void selectMapListView() {
		List<Map<String,Object>> iolist = ioDao.selectAll();
		
		for(Map<String,Object> io : iolist) {
			System.out.print(io.get("IO_SEQ") + "\t");
			System.out.print(io.get("IO_DATE") + "\t");
			System.out.print(io.get("IO_INOUT") + "\t");
			System.out.print(io.get("IO_QTY") + "\t");
			System.out.print(io.get("IO_PRICE") + "\t");
			System.out.print(io.get("IO_PCODE") + "\t");
			System.out.print(io.get("IO_DCODE") + "\n");
		}
	}
}
