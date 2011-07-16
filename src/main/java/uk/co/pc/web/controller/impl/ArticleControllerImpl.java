package uk.co.pc.web.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import uk.co.pc.domain.model.Article;
import uk.co.pc.web.bean.ArticleList;
import uk.co.pc.web.controller.ArticleController;

/**
 * ArticleController.
 * 
 * This class must respond to RESTful requests for articles given
 * the methods below.
 * 
 * Assume happy path with no exceptions.
 */
@Controller
public class ArticleControllerImpl implements ArticleController {

	@Override
	public Article save(Article article) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RequestMapping("/article/{id}")
	public Article getArticleById(@PathVariable Long id) {
		return Article.create();
	}

	@Override
	public ArticleList getArticlesByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArticleList getArticlesByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}


}
