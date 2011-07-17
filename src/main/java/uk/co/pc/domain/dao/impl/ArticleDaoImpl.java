package uk.co.pc.domain.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uk.co.pc.domain.dao.ArticleDao;
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
	public Article findById(Long id) {
		return (Article) sessionFactory.getCurrentSession()
				.createQuery("from Article where id=:id")
				.setParameter("id", id)
				.uniqueResult();
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
		// TODO Auto-generated method stub
		return null;
	}
   
}
