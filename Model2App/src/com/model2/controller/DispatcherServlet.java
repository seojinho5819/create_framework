/*
 * ������ ��� Ŭ���̾�Ʈ�� ��û�� �ް�, ������ �����ϴ� ��Ʈ�ѷ� ����
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
   FileReader fr; //Ŀ���ѷ� ���� ���������� �������� ��Ʈ��
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
         
         //�����Ϳ�����
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
      
      //2�ܰ� request �м�
      //���� uri�� ������ �� �ִ� ����ȭ �� �����͸� ��������!(xml, json, properties)
      String uri = request.getRequestURI(); //Ŭ���̾�Ʈ�� ��û��þƟG�� uri ��ü�� ��û�� ���а����� ���� �� �ִ�.
      String controllerName = (String)controllerMap.get(uri);
      System.out.println("���� ���� ��û�� ó���� ��Ʈ�ѷ� Ŭ������ "+controllerName);
      
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
      controller.execute(request, response);//3�ܰ� ����
      
      //���� ��Ʈ�ѷ��κ��� �Ѱܹ��� �信���� ������ �̿��Ͽ� Ŭ���̾�Ʈ���� �˸´� �並 ��������
      String resultKey = controller.getResultView();
      String viewPage = (String)viewMap.get(resultKey);
      
      //����ÿ� sendRedirect�� ó���ؾ��� ��찡 �ְ�,�۾��� �۾��� ������ ����Ʈ,���� �ٸ��������� �������� 
     //�����ϰ������..
      if(controller.isForward()) {//Ŭ���̾�Ʈ�� �Ͽ��� ���Ӱ� ������ �õ��� ���
    	  //���δ� forwarding���� ó���ؾ��Ҷ��� �ִ�,�����͸� �����ϰ������
    	  RequestDispatcher dis = request.getRequestDispatcher(viewPage);
    	  dis.forward(request, response);//������� �������� �Ǵٸ� �ڿ����� ��û����!!
      }else {
    	  response.sendRedirect(viewPage);//���ǹϰ� ��δ���
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

