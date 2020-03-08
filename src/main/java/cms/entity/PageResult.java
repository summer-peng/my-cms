package cms.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PageResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	protected int totalPage;
	protected int currentPage;
	protected long totalRecord;
	protected int start;
	protected int end;
	protected int size;
	protected List<T> rows;

	public PageResult() {
		super();
		rows = new ArrayList<T>();
	}

	public PageResult(List<T> result) {
		this.currentPage = 1;
		this.totalPage = 1;
		this.totalRecord = result.size();
		this.size = result.size();
		this.rows = result;
		this.start = this.size * (this.currentPage - 1) + 1;
		this.end = this.size * (currentPage - 1) + rows.size();
	}

	public PageResult(List<T> rows, int currpage, int rangeSize) {

		this.currentPage = currpage + 1; // 目前分頁數 (0 - n)
		this.totalRecord = rows.size();// 總筆數
		this.totalPage = (int) Math.ceil(new BigDecimal(this.totalRecord)
				.divide(new BigDecimal(this.size), 3, BigDecimal.ROUND_UP).doubleValue()); // 總頁數
		this.size = rangeSize; // 每頁筆數
		this.start = rangeSize * (this.currentPage - 1) + 1;
		this.end = Math.min(rangeSize * (this.currentPage - 1) + rangeSize, rows.size());

		this.rows = new ArrayList<T>();
		if (this.currentPage == this.totalPage) {
			int lastIdx = (int) this.totalRecord - 1;
			if (this.totalRecord == this.start) {
				this.rows.add(rows.get(lastIdx));
			} else {
				for (int i = (start - 1); i <= lastIdx; i++) {
					this.rows.add(rows.get(i));
				}
			}
		} else {
			if (rows != null && rows.size() > 0) {
				for (int i = (start - 1); i <= (end - 1); i++) {
					this.rows.add(rows.get(i));
				}
			}
		}
	}
	
	public PageResult(List<T> rows, int currentPage, int size, long totalRecord){
		this.rows = rows;
		this.currentPage = currentPage;
		this.totalRecord = totalRecord; // 總筆數
		this.size = size; // 每頁筆數
		if(totalRecord > 0){
			this.totalPage = (int)Math.ceil(new BigDecimal(totalRecord).divide(new BigDecimal(this.size), 3 , BigDecimal.ROUND_UP).doubleValue()); // 總頁數
			this.start = size * (currentPage - 1) + 1;
			this.end = rows.size() > 0 ? start + rows.size() -1 : start;
		}else{
			this.totalPage = 0;
			this.start = 0;
			this.end = 0;
		}
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

	public long getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
