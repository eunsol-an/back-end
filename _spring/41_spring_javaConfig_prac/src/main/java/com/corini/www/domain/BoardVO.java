package com.corini.www.domain;

public class BoardVO {
	private long bno;
	private String title;
	private String content;
	private String writer;
	private String regAt;
	private String modAt;
	private int readCount;
	
	public BoardVO() {}

	// write
	public BoardVO(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
	
	// modify
	public BoardVO(long bno, String title, String content) {
		this.bno = bno;
		this.title = title;
		this.content = content;
	}

	// list
	public BoardVO(long bno, String title, String content, String writer, String modAt, int readCount) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.modAt = modAt;
		this.readCount = readCount;
	}

	// detail
	public BoardVO(long bno, String title, String content, String writer, String regAt, String modAt, int readCount) {
		this.bno = bno;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.regAt = regAt;
		this.modAt = modAt;
		this.readCount = readCount;
	}

	public long getBno() {
		return bno;
	}

	public void setBno(long bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegAt() {
		return regAt;
	}

	public void setRegAt(String regAt) {
		this.regAt = regAt;
	}

	public String getModAt() {
		return modAt;
	}

	public void setModAt(String modAt) {
		this.modAt = modAt;
	}

	public int getReadCount() {
		return readCount;
	}

	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", writer=" + writer + ", regAt="
				+ regAt + ", modAt=" + modAt + ", readCount=" + readCount + "]";
	}

}
