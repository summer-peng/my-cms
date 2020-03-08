package cms.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Article {
	public Article(BigDecimal id, String title, String description, Date postDate) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.postDate = postDate;
	}

	private BigDecimal id;

	private String title;

	private String description;

	private String author = "Summer";

	private Date postDate;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

}
