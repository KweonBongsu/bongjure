package com.board.model;

import java.sql.SQLException;

import java.util.ArrayList;

public class BoardMGR {
	private static BoardMGR insMgr = new BoardMGR();
	
	private BoardMGR(){}
	
	public static BoardMGR getInstance(){
		return insMgr;
	}
	public int joinBoard(BoardDTO mdto) throws SQLException{
		BoardDAO mdao = new BoardDAO();
		return mdao.joinBoard(mdto);
	} 
	
	public ArrayList<BoardDTO> selectAll() throws SQLException{
		BoardDAO mdao = new BoardDAO();
		return mdao.selectAll();
	}
	
	
	public int remove(String email) throws SQLException{
		BoardDAO mdao = new BoardDAO();
		return mdao.remove(email);
	}
	
	public BoardDTO selectBoard(String email)throws Exception{
		return new BoardDAO().selectBoard(email);
	}	
	
	public int updateDB(BoardDTO mdto)throws Exception{
		return new BoardDAO().updateDB(mdto);
	}
}
