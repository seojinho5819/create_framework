/*
 * jsp만으로 개발했던 방식이서 regist.jsp가 담당하는 업무를 
 * 서블릿으로 구현해본다
 */
package board.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import board.model.Board;
import board.model.BoardDAO;
import common.file.FileManager;

public class RegistServlet extends HttpServlet{
	BoardDAO boardDAO=new BoardDAO();

	//클라이언트가 get요청:doGet() post요청:dePost
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//출력 스트림 뽑아놓기
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//클라이언트 요청에 multipart/form-data방식이 초함될 경우 텍스트가 아닌 바이너리 형식의 파일로 전송되는 것이다
		//따라서 업로드 컴포넌트를 사용해야한다
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletContext context =request.getServletContext();//어플리케이션과 관련된 정보를 담는 객체인 ServletContext를 얻자
		//ServletContext는 jsp에서는 application내장객체로 접근해야 한다
		String saveDir = context.getRealPath("/data");
		factory.setRepository(new File("saveDir"));//임시파일의 경로
		factory.setSizeThreshold(2*1024*1024);//크기제한
		factory.setDefaultCharset("utf-8");//인코딩
		
		
		ServletFileUpload upload=new ServletFileUpload(factory);
		//업로드 된 정보 분석하자!!
		try {
			//업로드된 컴포넌트들을 item리스트로 받아놓자!!
			List<FileItem> items = upload.parseRequest(request);
			Board board = new Board();//empty 보드 준비
			boolean flag = false;//파일 업로드 성공여부 알수있는 변수
			for(FileItem item: items) {
				if(item.isFormField()) {//일반 텍스트 컴포넌트라면 작성자 제목 내용 등..
					//vo에 알맞게 담자
					if(item.getFieldName().equals("title")) {
						board.setTitle(item.getString());
					}else if(item.getFieldName().equals("writer")) {
						board.setWriter(item.getString());
					}else if(item.getFieldName().equals("content")){
						board.setContent(item.getString());
					}
				}else {//파일 컴포넌트라면
					long time = System.currentTimeMillis();
					String newName = time+"."+FileManager.getExtend(item.getName());
					board.setFilename(newName);//새로 만들어진 이름을 Vo에 담아야 insert문에 들어감
					//파일 물리적으로 저장
					item.write(new File(saveDir+"/"+newName));
					flag=true;
					
				}
			}
			System.out.println(board);
			//db에 isnert
			if(flag) {
				int result = boardDAO.insert(board);
				if(result==0) {
					out.print("<script>");
					out.print("alert('등록실패');");
					out.print("history.back();");
					out.print("</script>");
				}else {
					out.print("<script>");
					out.print("alert('등록성공');");
					out.print("location.href='/board/list.jsp';");
					out.print("</script>");
				}
			}
		} catch (FileUploadException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
