package com.myweb.board.domain.dto;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("bdto")
public class BoardDTO {
	private int bno;
	private String title;
	private String content;
	private int readcount;
	private String regdate;
	private String regid;
	private String moddate;
	private String modid;
	private char isremoved;
}
