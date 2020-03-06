package cms.controller;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cms.entity.Article;

@RestController
@RequestMapping("/data")
public class DataController {

	@RequestMapping("/get-article")
	public List<Article> getArticleList() {

		List<Article> mockData = new LinkedList<Article>();

		for (int i = 0; i <= 10; i++) {
			mockData.add(new Article(new BigDecimal(i), "title" + i));
		}

		return mockData;
	}
}
