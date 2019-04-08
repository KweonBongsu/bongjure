package com.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.board.model.BoardDTO;
import com.board.model.BoardMGR;

public class UpdateAction extends Action{
	public ActionForward execute(
			ActionMapping mapping, ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response
			)
	throws Exception{
		request.setCharacterEncoding("euc-kr");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		String email = request.getParameter("email");
		
	
		BoardDTO mdto = new BoardDTO(title,writer,content,email);
		
		BoardMGR mgr = BoardMGR.getInstance();
		int n = mgr.updateDB(mdto);
		String msg = "", url="";
		if(n > 0){
			msg ="�Խñ� ���� ó���Ǿ����ϴ�!!!!";
			url ="bList.do";
		}else{
			msg="������ ������ �߻��Ͽ����ϴ�!!!";
			url="javascript:history.back()";
		}
		
		request.setAttribute("bMsg", msg);
		request.setAttribute("bUrl", url);
		
		return mapping.findForward("g-boardMsg");
	}
			
}
