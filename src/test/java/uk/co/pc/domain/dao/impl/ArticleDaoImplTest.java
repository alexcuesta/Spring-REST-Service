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
import uk.co.pc.domain.dao.helper.DaoHelper;
import uk.co.pc.domain.model.Article;
import uk.co.pc.domain.model.ArticleBuilder;

/**
 * DAO Integration tests
 * 
 * If we were testing a non in-memory database, we might want to move out this test from unit tests because they are executed slower
 * @author alex
 *
 */
@Transactional
@TransactionConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {	"classpath:applicationContext-properties.xml",
									"classpath:applicationContext-hibernate.xml", 
									"classpath:applicationContext-dao.xml",
									"classpath:applicationContext-testing-helper.xml"})
public class ArticleDaoImplTest {

    private ArticleDao articleDao;
    private Article article;
    private ArticleBuilder givenArticle;
    
    @Autowired
    private DaoHelper daoHelper;
    
    @Before
    public void setup() {
    	givenArticle = new ArticleBuilder(daoHelper);
    }
    
    @Test
    public void saveShouldSaveAnArticle() {
    	// given an article
    	article = Article.create();
    	
    	// when I save it
    	Article savedArticle = articleDao.save(article);
    	
    	// then id is populated
    	assertThat("id is populated", savedArticle.getId(), is(notNullValue()));
    	
    	// and article is actually saved in database
    	Article articleInDb = daoHelper.getArticleFromDb(savedArticle.getId());
    	assertThat(articleInDb, is(savedArticle));
    }

	@Test
    public void findByIdShouldReturnAnArticle() {
		// given an article in db
		Article articleInDb = givenArticle.withTitle("Clean code")
										  .withAuthor("Uncle Bob")
										  .isInDatabase();
		// when I find it by id
		Article foundArticle = articleDao.findById(articleInDb.getId());
		
		// then
		assertThat(foundArticle, is(articleInDb));
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
    
 
}
