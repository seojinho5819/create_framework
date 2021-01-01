/*
 * paging ó���� ���뼺�� ���� Ŭ���� ����
 */
package com.koreait.fashionmall.common;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class Pager {
	private int totalRecord;//��ü ���ڵ��
	private int pageSize=10;//�������� ���ڵ� ��
	private int totalPage;
	private int blocksize=10;//���� ������ ������ ��
	private int currentPage =1;
	private int firstPage;
	private int lastPage;
	private int curPos;//�������� List�������� ����index
	private int num;//�������� ���� ��ȣ
	
	//����� ������ ���� �ʱ�ȭ
	public void init(HttpServletRequest request,List list) {
		totalRecord =list.size();
		totalPage =(int)Math.ceil((float)totalRecord/pageSize);
		
		
		//�������� ������ ��쿣 �� ���õ� �������� ��ü
		if(request.getParameter("currentPage")!=null){
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		firstPage = currentPage-(currentPage-1)%blocksize;
		lastPage =firstPage+(blocksize-1);
		curPos = (currentPage-1)*pageSize ;
		num =totalRecord-curPos;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getBlocksize() {
		return blocksize;
	}

	public void setBlocksize(int blocksize) {
		this.blocksize = blocksize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getCurPos() {
		return curPos;
	}

	public void setCurPos(int curPos) {
		this.curPos = curPos;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
