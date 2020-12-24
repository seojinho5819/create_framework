package com.springmvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.model2.board.model.BoardDAO;

public class DeleteController implements Controller {
	private BoardDAO boardDAO;

	public void setBoardDAO(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_id = Integer.parseInt(request.getParameter("board_id"));
		int result = boardDAO.delete(board_id);
		
		ModelAndView mav = new ModelAndView();
		
		if(result!=0) {
		mav.setViewName("redirect:/board/list");
		}else {
			mav.addObject("msg", "삭제 실패");
			mav.setViewName("error/result");
		}
		
		return mav;
	}

}
