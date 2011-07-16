package uk.co.pc.domain.dao.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import uk.co.pc.domain.dao.ArticleDao;
import uk.co.pc.domain.model.Article;

@Transactional
@TransactionConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-properties.xml","classpath:applicationContext-hibernate.xml", "classpath:applicationContext-dao.xml"})
public class ArticleDaoImplTest {

    private ArticleDao articleDao;
    private Article article;
    
    @Autowired
    private SessionFactory sessionFactory;

    @Test
    public void saveShouldSaveAnArticle() {
    	// given an article
    	article = Article.create();
    	
    	// when I save it
    	Article savedArticle = articleDao.save(article);
    	
    	// then id is populated
    	assertThat("id is populated", savedArticle.getId(), is(notNullValue()));
    	
    	// and article is actually saved in database
    	Article articleInDb = getArticleFromDb(savedArticle.getId());
    	assertThat(articleInDb, is(savedArticle));
    }

	@Test
    public void findByIdShouldReturnAnArticle() {
        fail("tbd");
    }

    @Test
    public void findByInvalidIdShouldNotReturnAnArticle() {
        fail("tbd");
    }

    @Test
    public void findByTitleShouldReturnAnArticle() {
        fail("tbd");
    }

    @Test
    public void findByInvalidTitleShouldNotReturnAnArticle() {
        fail("tbd");
    }

    @Test
    public void findByAuthorShouldReturnAnArticle() {
        fail("tbd");
    }

    @Test
    public void findByInvalidAuthorShouldNotReturnAnArticle() {
        fail("tbd");
    }
    
    /* ADD MORE TESTS HERE */
    
    /* Spring Injected Values/Collaborators */

    @Resource
    public void setArticleDao(final ArticleDao articleDao) {
        this.articleDao = articleDao;
    }
    
    private Article getArticleFromDb(Long id) {
		return (Article) sessionFactory.getCurrentSession()
				.createQuery("from Article where id=:id")
				.setParameter("id", id)
				.uniqueResult();
	}
}
