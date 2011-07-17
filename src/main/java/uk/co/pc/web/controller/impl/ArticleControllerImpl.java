package uk.co.pc.web.controller.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

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
    private static Logger log = LoggerFactory.getLogger(ArticleControllerImpl.class);

	private final ArticleService articleService;
	
	@Autowired
	public ArticleControllerImpl(ArticleService articleService) {
		this.articleService = articleService;
	}

	/**
	 * We are creating a new resource in system, therefore POST
	 */
	@Override
	@ResponseStatus(HttpStatus.CREATED)
	@RequestMapping(value="/article", method=RequestMethod.POST)
	public Article save(Article article) {
		log.info("Saving article {}", article.getId());
		return articleService.save(article);
	}

	@Override
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value="/article/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		log.info("Deleting article {}", id);
		articleService.delete(id);
	}

	@Override
	@RequestMapping("/article/{id}")
	public Article getArticleById(@PathVariable Long id) {
		log.info("Getting article by id {}", id);
		return articleService.findById(id);
	}

	@Override
	@RequestMapping(value="/article", method=RequestMethod.GET)
	public ArticleList getArticlesByTitle(String title) {
		log.info("Getting articles by title '{}'", title);
		List<Article> articles = articleService.findByTitle(title);
		return new ArticleList(articles);
	}

	@Override
	public ArticleList getArticlesByAuthor(String author) {
		log.info("Getting articles by author '{}'", author);
		// TODO Auto-generated method stub
		return null;
	}


}
