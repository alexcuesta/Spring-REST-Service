package uk.co.pc.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import uk.co.pc.domain.dao.ArticleDao;
import uk.co.pc.domain.model.Article;
import uk.co.pc.service.ArticleService;

/**
 * ArticleService.
 * 
 * Assume happy path with no exceptions.
 */
public class ArticleServiceImpl implements ArticleService {

	private final ArticleDao articleDao;
	
	public ArticleServiceImpl(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}

	@Override
	public Article save(Article article) {
		return articleDao.save(article);
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Article findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Article> findByAuthor(String author) {
		// TODO Auto-generated method stub
		return null;
	}
   
}
