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
      System.out.println("�ڸ�Ʈ �Խ��� ��� ��û�� ó���մϴ�.");
      List boardList = dao.selectAll();
      
      //�����Ұ��� �ֱ⶧���� request�� ����
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