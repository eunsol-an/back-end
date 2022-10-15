package com.myweb.board.domain.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "board") // 생략하면 엔터티 클래스의 이름으로 테이블 생성
@NoArgsConstructor
@Data
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bno;
	
	@Column(nullable = false)
	private String title;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private int readcount = 0;
	
	@Column(nullable = false)
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime regdate = LocalDateTime.now();
	
	@Column(nullable = false)
	private String regid;
	
	@JsonFormat(shape = Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private LocalDateTime moddate = null;
	
	private String modid;
	
	@Column(nullable = false)
	private char isremoved = 'N';
}
