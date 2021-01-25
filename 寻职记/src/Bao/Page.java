package Bao;

import java.util.List;

public class Page {
	int totalNus;// 数据总数
	int pageSize;// 页面大小
	int totalPage;// 总页数
	int currentPage;// 当前页面
	List <Job> jobs;// 当前页面对象的集合
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
