package com.biz.sec.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder


public class DetailDTO {
	private long d_seq;	//number
	private int d_m_seq;	//number
	private String d_subject;	//nvarchar2(1000 char)
	private String d_ok;	//varchar2(1 byte)
}
