package uk.co.pc.domain.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uk.co.pc.domain.dao.ArticleDao;
import uk.co.pc.domain.dao.exception.ArticleNotFoundException;
import uk.co.pc.domain.model.Article;

/**
 * ArticleDao.
 * 
 * This class must implement persistence logic for the Article.
 * 
 * Assume happy path with no exceptions.
 */
@Transactional
public class ArticleDaoImpl implements ArticleDao {

	private SessionFactory sessionFactory;

	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Article save(Article article) {
		sessionFactory.getCurrentSession().save(article);
		return article;
	}

	@Override
	public void delete(Long id) {
		sessionFactory.getCurrentSession()
						.createQuery("delete from Article where id=:id")
				        .setLong("id", id)
				        .executeUpdate();
	}

	@Override
	public Article findById(Long id) throws ArticleNotFoundException {
		Article article = (Article) sessionFactory.getCurrentSession()
										.createQuery("from Article where id=:id")
										.setParameter("id", id)
										.uniqueResult();
		throwExceptionIfArticleNotFound(article, id.toString());
		return article;
	}

	/*
	 * I place private methods following  the step-down rule recommended by Uncle Bob
	 * so reader don't have to jump around to read nested functions details
	 */
	private void throwExceptionIfArticleNotFound(Article article, String searchTerm) throws ArticleNotFoundException {
		if (article == null) {
			throw new ArticleNotFoundException(searchTerm);
		}
	}

	@Override
	public List<Article> findByTitle(String title) {
		return (List<Article>) sessionFactory.getCurrentSession()
				.createQuery("from Article where title=:title")
				.setParameter("title", title)
				.list();
	}

	@Override
	public List<Article> findByAuthor(String author) {
		return (List<Article>) sessionFactory.getCurrentSession()
				.createQuery("from Article where author=:author")
				.setParameter("author", author)
				.list();
	}
   
}
