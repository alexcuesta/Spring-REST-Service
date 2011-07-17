package uk.co.pc.domain.dao.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import uk.co.pc.domain.dao.ArticleDao;
import uk.co.pc.domain.dao.exception.ArticleNotFoundException;
import uk.co.pc.domain.dao.helper.DaoHelper;
import uk.co.pc.domain.model.Article;
import uk.co.pc.domain.model.ArticleBuilder;

/**
 * DAO Integration tests
 * 
 * Testing with an embedded database
 * @see http://static.springsource.org/spring/docs/3.0.x/reference/jdbc.html#jdbc-embedded-database-support
 * @author alex
 *
 */
@Transactional
@TransactionConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {	"classpath:applicationContext-testing-dao.xml",
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
    public void findByIdShouldReturnAnArticle() throws ArticleNotFoundException {
		// given an article in db
		Article articleInDb = givenArticle.withTitle("Clean code")
										  .withAuthor("Uncle Bob")
										  .isInDatabase();
		// when I find it by id
		Article articleFound = articleDao.findById(articleInDb.getId());
		
		// then
		assertThat(articleFound, is(articleInDb));
	}

    @Test(expected=ArticleNotFoundException.class)
    public void findByInvalidIdShouldNotReturnAnArticle() throws ArticleNotFoundException {
    	// given an invalid id
    	Long invalidId = -1L;
    	
    	// when
    	articleDao.findById(invalidId);
    	
    	// then an ArticleNotFoundException should be thrown
    	// because we don't want to deal with null objects in our domain
    	
    }

    @Test
    public void findByTitleShouldReturnAnArticle() {
		// given an article in db
		Article articleInDb = givenArticle.withTitle("Clean code")
										  .withAuthor("Uncle Bob")
										  .isInDatabase();
		// when
		List<Article> foundArticles = articleDao.findByTitle("Clean code");
		
		// then
		List<Article> expectedArticles = Arrays.asList(articleInDb);
		assertThat(foundArticles, is(expectedArticles));    
	}

    @Test
    public void findByInvalidTitleShouldNotReturnAnArticle() throws ArticleNotFoundException {
		// given an invalid title in db
    	String invalidTitle = "invalid title";
    	
    	// when I find it by id
    	List<Article>  foundArticles = articleDao.findByTitle(invalidTitle);
		
	   	// then 
    	assertThat(foundArticles.isEmpty(), is(true));
 		   
	}

    @Test
    public void findByAuthorShouldReturnAnArticle() {
		// given an article in db
		Article articleInDb = givenArticle.withTitle("Clean code")
										  .withAuthor("Uncle Bob")
										  .isInDatabase();
		// when
		List<Article> foundArticles = articleDao.findByAuthor("Uncle Bob");
		
		// then
		List<Article> expectedArticles = Arrays.asList(articleInDb);
		assertThat(foundArticles, is(expectedArticles));     }

    @Test
    public void findByInvalidAuthorShouldNotReturnAnArticle() {
		// given an invalid title in db
    	String invalidAuthor = "invalid author";
    	
    	// when I find it by id
    	List<Article>  foundArticles = articleDao.findByAuthor(invalidAuthor);
		
	   	// then 
    	assertThat(foundArticles.isEmpty(), is(true));    
    }
    
    /* ADD MORE TESTS HERE */

    @Test
	public void shouldDeleteArticle() throws Exception {
		// given 
		Article articleInDb = givenArticle.withTitle("Clean code")
										  .withAuthor("Uncle Bob")
										  .isInDatabase();
    	
    	// when
		articleDao.delete(articleInDb.getId());
		
    	// then 
    	Article articleNotFound = daoHelper.getArticleFromDb(articleInDb.getId());
    	assertThat(articleNotFound, is(nullValue()));
	}
    
    /* Spring Injected Values/Collaborators */

    @Resource
    public void setArticleDao(final ArticleDao articleDao) {
        this.articleDao = articleDao;
    }
    
 
}
