package com.board.controller;


import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;

import com.board.model.BoardMGR;

public class RemoveAction extends Action{
	public ActionForward execute(
			ActionMapping mapping, ActionForm form,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		String email = request.getParameter("email");
		BoardMGR mgr = BoardMGR.getInstance();
		int n = mgr.remove(email);
		String msg="", url="";
		if(n>0){
			msg="삭제되었습니다!!";
			url="bList.do";
		}else{
			msg="삭제시 오류가 발생하였습니다!!!!";
			url="bList.do";
		}
		request.setAttribute("bMsg", msg);
		request.setAttribute("bUrl", url);
		
		
		return mapping.findForward("g-boardMsg"); 
		
	}//execute()
}
