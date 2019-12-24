package com.biz.sec.service;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import com.biz.sec.config.DBConnection;
import com.biz.sec.mapper.MDDao;
import com.biz.sec.persistence.DetailDTO;
import com.biz.sec.persistence.MasterDTO;
import com.biz.sec.persistence.MasterDetailVO;

public class MasterService {
	protected MDDao mdDao;
	protected Scanner scanner;
	
	{
		mdDao = DBConnection.getSqlSessionFactory().openSession(true).getMapper(MDDao.class);
		scanner = new Scanner(System.in);
	}

	public void insertMaster() {
		System.out.println("문제입력");
		System.out.println(">>");
		String strQ = scanner.nextLine();
		if(strQ.equals("-Q"))return;
		
		MasterDTO mDTO = MasterDTO.builder()
				.m_subject(strQ).build();
		
		
		int ret = mdDao.insertMaster(mDTO);
		if(ret > 0) {
			System.out.println("삽입완료");
		}else {
			System.out.println("삽입실패");
		}
		
	}
	
	
	
	public void masterAndDetail() {
		
		List<MasterDetailVO> mdList = mdDao.selectAll();
		for (MasterDetailVO mVO : mdList) {
			System.out.print(mVO.getM_seq() + " : ");
			System.out.println(mVO.getM_subject());
			
			List<DetailDTO> deList = mVO.getDeList();
			if(deList != null) {
				Collections.shuffle(deList);
				int nNum = 1;
				for (DetailDTO dto : deList) {
					System.out.printf("%d\t",nNum++);
					System.out.printf("%s\t",dto.getD_subject());
					System.out.printf("%s\n",dto.getD_ok());
				}
			}
		}
	}
	

}
