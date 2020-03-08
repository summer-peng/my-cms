package cms.controller;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cms.entity.Article;
import cms.entity.PageRequest;
import cms.entity.PageResult;

@RestController
@RequestMapping("/data")
public class DataController {

	@RequestMapping("/get-article")
	public List<Article> getArticleList() {

		List<Article> mockData = new LinkedList<Article>();

		Calendar cal = Calendar.getInstance();

		for (int i = 1; i <= 10; i++) {
			cal.add(Calendar.DATE, -1);
			mockData.add(new Article(new BigDecimal(i), "title" + i, "description" + i, cal.getTime()));
		}

		return mockData;
	}

	@RequestMapping("/get-paged-article")
	public PageResult<Article> getPagedArticle(@RequestBody PageRequest pageRequest) {
		int currentPage = pageRequest.getCurrentPage();
		int size = pageRequest.getSize();

		List<Article> mockData = new LinkedList<Article>();

		Calendar cal = Calendar.getInstance();

		int start = (currentPage - 1) * size + 1;
		int end = currentPage * size;
		for (int i = start; i <= end; i++) {
			cal.add(Calendar.DATE, -1);
			mockData.add(new Article(new BigDecimal(i), "title" + i, "description" + i, cal.getTime()));
		}
		
		PageResult<Article> pageResult = new PageResult<>(mockData, currentPage, size, 200);
		return pageResult;
	}
}
