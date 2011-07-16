package uk.co.pc.domain.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import uk.co.pc.domain.dao.ArticleDao;
import uk.co.pc.domain.model.Article;

/**
 * ArticleDao.
 * 
 * This class must implement persistence logic for the Article.
 * 
 * Assume happy path with no exceptions.
 */
public class ArticleDaoImpl implements ArticleDao {

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
