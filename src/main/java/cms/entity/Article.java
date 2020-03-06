package cms.entity;

import java.math.BigDecimal;

public class Article {
	public Article(BigDecimal id, String title) {
		super();
		this.id = id;
		this.title = title;
	}

	private BigDecimal id;

	private String title;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
