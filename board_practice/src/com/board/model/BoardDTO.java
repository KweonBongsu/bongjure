package com.board.model;

public class BoardDTO {
	 
	private int seq;
	private String title;
	private String writer;
	private String content;
	private String email;
	
	
	
	
	public BoardDTO(int seq,String title, String writer, String content, String email) {
		super();
		this.seq=seq;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.email = email;
	}
	
	
	public BoardDTO(String title, String writer, String content, String email) {
		this.title=title;
		this.writer=writer;
		this.content=content;
		this.email=email;
	}


	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
	
}
