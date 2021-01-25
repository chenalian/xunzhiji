package Bao;

import java.util.List;

public class Page {
	int totalNus;// ��������
	int pageSize;// ҳ���С
	int totalPage;// ��ҳ��
	int currentPage;// ��ǰҳ��
	List <Job> jobs;// ��ǰҳ�����ļ���
	public Page() {}
	public Page(int totalNus, int pageSize, int totalPage, int currentPage, List<Job> jobs) {
		super();
		this.totalNus = totalNus;
		this.pageSize = pageSize;
		this.totalPage = totalPage;
		this.currentPage = currentPage;
		this.jobs = jobs;
	}
	public int getTotalNus() {
		return totalNus;
	}
	public void setTotalNus(int totalNus) {
		this.totalNus = totalNus;
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
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public List<Job> getJobs() {
		return jobs;
	}
	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
}
