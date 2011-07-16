package uk.co.pc.web.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import uk.co.pc.domain.model.Article;
import uk.co.pc.service.ArticleService;
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

	private final ArticleService articleService;
	
	@Autowired
	public ArticleControllerImpl(ArticleService articleService) {
		this.articleService = articleService;
	}

	/**
	 * We are creating a new resource in system, therefore POST
	 */
	@Override
	@RequestMapping(value="/article", method=RequestMethod.POST)
	public Article save(Article article) {
		return articleService.save(article);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RequestMapping("/article/{id}")
	public Article getArticleById(@PathVariable Long id) {
		return articleService.findById(id);
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
