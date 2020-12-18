/*
 * 웹상의 모든 클라이언트의 요청을 받고, 응답을 전담하는 컨트롤러 정의
 */

package com.model2.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DispatcherServlet extends HttpServlet {
   FileReader fr; //커느롤러 매핑 설정파일을 읽이위한 스트림
   JSONObject controllerMap; 
   JSONObject viewMap; 
   
   @Override
   public void init(ServletConfig config) throws ServletException {
      ServletContext context = config.getServletContext();
      String contextConfigLocation = config.getInitParameter("contextConfigLocation");
      String realPath = context.getRealPath(contextConfigLocation);
      
      try {
         fr = new FileReader(realPath);
         JSONParser jsonParser = new JSONParser();
         
         JSONObject json = (JSONObject)jsonParser.parse(fr);
         
         //데이터에접근
         controllerMap = (JSONObject)json.get("controller");
         viewMap =  (JSONObject)json.get("view");
         
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ParseException e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
   }
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doRequest(request, response);
   }
   
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      doRequest(request, response);
   }
   
   public void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
      request.setCharacterEncoding("utf-8");
      
      //2단계 request 분석
      //들어온 uri를 구분할 수 있는 구조화 된 데이터를 선택하자!(xml, json, properties)
      String uri = request.getRequestURI(); //클라이언트가 요청사시아욯나 uri 자체가 요청의 구분값으로 사용될 수 있다.
      String controllerName = (String)controllerMap.get(uri);
      System.out.println("지금 들어온 요청을 처리할 컨트롤러 클래스는 "+controllerName);
      
      Class controllerClass = null;
      Controller controller=null;
      try {
		controllerClass = Class.forName(controllerName);
		controller= (Controller)controllerClass.newInstance();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
      controller.execute(request, response);//3단계 업무
      
      //하위 컨트롤러로부터 넘겨받은 뷰에다한 정보를 이용하여 클라이언트에게 알맞는 뷰를 보여주자
      String resultKey = controller.getResultView();
      String viewPage = (String)viewMap.get(resultKey);
      
      //응답시에 sendRedirect로 처리해야할 경우가 있고,글쓰후 글쓰기 폼으로 리스트,전혀 다른페이지로 재접속을 
     //유도하고싶을때..
      if(controller.isForward()) {//클라이언트로 하여금 새롭게 접속을 시도할 경우
    	  //때로는 forwarding으로 처리해야할때가 있다,데이터를 유지하고싶을때
    	  RequestDispatcher dis = request.getRequestDispatcher(viewPage);
    	  dis.forward(request, response);//응답없이 서버상의 또다른 자원으로 요청전달!!
      }else {
    	  response.sendRedirect(viewPage);//세션믿고 까부는중
      }
      
   }
   
   @Override
   public void destroy() {
      if(fr != null) {
         try {
            fr.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
}

