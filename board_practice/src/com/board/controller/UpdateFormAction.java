package com.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.*;

import com.board.model.BoardDTO;
import com.board.model.BoardMGR;

public class UpdateFormAction extends Action{
	
	public ActionForward execute(
			ActionMapping mapping, ActionForm form,
			HttpServletRequest request, 
			HttpServletResponse response)
			throws Exception{
		String email = request.getParameter("email");
		BoardMGR mgr = BoardMGR.getInstance();
		BoardDTO mdto = mgr.selectBoard(email);
		request.setAttribute("board", mdto);
		return mapping.findForward("fw-bUpdateForm");
	}
}
