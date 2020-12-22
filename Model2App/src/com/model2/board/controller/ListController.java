package com.model2.board.controller;
/*
 * 
 */

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model2.board.model.BoardDAO;
import com.model2.controller.Controller;

public class ListController implements Controller {
   BoardDAO dao = new BoardDAO();

   @Override
   public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      System.out.println("코멘트 게시판 목록 요청을 처리합니다.");
      List boardList = dao.selectAll();
      
      //저장할것이 있기때문에 request에 저장
      request.setAttribute("boardList", boardList);
   }

   @Override
   public String getResultView() {
      return "/view/board/list";
   }

   @Override
   public boolean isForward() {
      return true;
   }

}