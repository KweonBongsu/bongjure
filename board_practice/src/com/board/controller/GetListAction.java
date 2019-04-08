package com.board.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.board.model.BoardDTO;
import com.board.model.BoardMGR;

public class GetListAction extends Action {
	public ActionForward execute(ActionMapping mapping,
			ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		
		BoardMGR mgr = BoardMGR.getInstance();
		ArrayList<BoardDTO> mdtos = mgr.selectAll(); 
		
		request.setAttribute("bList", mdtos);
		
		return mapping.findForward("fw-boardList");
	}
}

