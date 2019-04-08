package com.board.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.boardDB.Dbconn;

public class BoardDAO {
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	
	
	public int joinBoard(BoardDTO mdto) throws SQLException{
		try{
			
			System.out.println("InsertAction 에 왔냐 !!");
			System.out.println("DAO 1-1");
			conn=Dbconn.getConnection();
			System.out.println("DAO 1-2");

			
			//시퀀스 .nextval
			String sql = "insert into BOARD values(BOARD_SEQ.nextval,?,?,?,?)";
			System.out.println("DAO 1-3");

			ps=conn.prepareStatement(sql);
			System.out.println("DAO 1-4");

			ps.setString(1, mdto.getTitle());
			System.out.println("DAO 1-5");

			ps.setString(2, mdto.getWriter());
			ps.setString(3, mdto.getContent());
			ps.setString(4, mdto.getEmail());
			System.out.println("DAO 1-6");

			int n = ps.executeUpdate();
			System.out.println("DAO 1-7");

			return n;
		}finally{
			if(ps !=null) ps.close();
			if(conn !=null) conn.close();
		}
	}//join()
	
	public ArrayList<BoardDTO> selectAll() throws SQLException{
		try{
			conn = Dbconn.getConnection();
			String sql="select * from board";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ArrayList<BoardDTO> mdtos = new ArrayList<BoardDTO>();
			
			while(rs.next()){
				int seq = rs.getInt("seq");
				String title = rs.getString(1);
				String writer = rs.getString(2);
				String content = rs.getString(3);
				String email = rs.getString(4);
				
				BoardDTO mdto = new BoardDTO(seq,title,writer,content,email);
				mdtos.add(mdto);
			}
			
			return mdtos;
		}finally{
			if(rs !=null) rs.close();
			if(ps !=null) ps.close();
			if(conn !=null) conn.close();
		}
	}//selectAll()
	
	public int remove(String email)throws SQLException{
		try{
			conn = Dbconn.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("delete from board ")
			.append("where email=?");
			String sql=sb.toString();
			
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			return ps.executeUpdate();
		}finally{
			if(ps !=null) ps.close();
			if(conn !=null) conn.close();
		}
	}//remove()
	
	public BoardDTO selectBoard(String email) throws Exception{
		try{
			conn = Dbconn.getConnection();
			StringBuffer sb= new StringBuffer();
			sb.append("select * from board ")
			.append("where email = ?");
			String sql = sb.toString();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			rs = ps.executeQuery();
			
			if(rs.next()){
				int seq = rs.getInt("seq");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				BoardDTO mdto = new BoardDTO(seq,title, writer, content, email);
				return mdto;
			}else{
				return null;
			}			
		}finally{
			if(rs !=null) rs.close();
			if(ps!=null) ps.close();
			if(conn !=null) conn.close();
		}
	}//select()
	
	public int updateDB(BoardDTO mdto)throws SQLException{
		try{
			conn=Dbconn.getConnection();
			StringBuffer sb = new StringBuffer();
			sb.append("update board ")
			.append("set title=?, writer = ?, content=? ")
			.append("where email=?");
			
			String sql = sb.toString();
			ps=conn.prepareStatement(sql);
			ps.setString(1, mdto.getTitle());
			ps.setString(2, mdto.getWriter());
			ps.setString(3, mdto.getContent());
			ps.setString(4, mdto.getEmail());
			
			return ps.executeUpdate();
		}finally{
			if(ps !=null) ps.close();
			if(conn !=null) conn.close();
		}
	}//updateDB()
}
