package com.board.controller;

import javax.servlet.http.HttpServletRequest;


import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;

import com.board.model.BoardDTO;
import com.board.model.BoardMGR;

public class InsertAction extends Action{
	public ActionForward execute(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response)throws Exception{
		
		System.out.println("왔냐 !!!");
	
		// 사용자가 입력한 가져오기
		request.setCharacterEncoding("UTF-8");
		System.out.println("왔냐 1-1");
		
		System.out.println("왔냐 1-2");

		String title = request.getParameter("title");
		System.out.println("왔냐 1-3");

		String writer = request.getParameter("writer");
		System.out.println("왔냐 1-4");

		String content = request.getParameter("content");
		System.out.println("왔냐 1-5");

		String email = request.getParameter("email");
		System.out.println("왔냐 1-6");

		
		System.out.println("insert 1");
		BoardMGR mgr = BoardMGR.getInstance();
		BoardDTO mdto = new BoardDTO( title, writer, content,email);		
		
		System.out.println("insert 2");

		int n = mgr.joinBoard(mdto);
		
		System.out.println("insert 3");

		String msg = "", url="";
		System.out.println("insert 4");

		if(n>0){
			
			msg="게시물 등록 완료 ~~!!!";
			url="bList.do";
		}else{
			System.out.println("insert 3");

			msg="게시물 오류 !!!!!";
			url="join-form.do";
		}
		System.out.println("insert 5");

		request.setAttribute("bMsg", msg);
		
		System.out.println("insert 7");

		request.setAttribute("bUrl", url);
		
		System.out.println("insert 8");

		
		ActionForward forward = mapping.findForward("g-boardMsg");
		return forward;
	}
}
