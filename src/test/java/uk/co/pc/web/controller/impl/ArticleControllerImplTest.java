package uk.co.pc.web.controller.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import javax.annotation.Resource;
import javax.xml.transform.Source;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import uk.co.pc.domain.dao.helper.DaoHelper;
import uk.co.pc.domain.model.Article;
import uk.co.pc.domain.model.ArticleBuilder;

/**
 * Please run this test AFTER you have deployed the application into a web container (jetty, tomcat...)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext-testing.xml", "classpath:applicationContext-testing-helper.xml"})
public class ArticleControllerImplTest {

    private static final String BASEURL = "http://localhost:8080/article";
    private RestTemplate restTemplate;
    private ArticleBuilder givenArticle;
    
    @Autowired
    private DaoHelper daoHelper;
    
    @Before
    public void setup() {
    	givenArticle = new ArticleBuilder(daoHelper);
    }

    @Test
    public void getArticleById() {
    	// given    	
    	Article articleInDb = givenArticle.withTitle("title")
    								  .withAuthor("author")
    								  .isInDatabase();
    	// when
    	final String articleByIdUrl = BASEURL + "/" + articleInDb.getId();
    	Article returnedArticle = restTemplate.getForObject(articleByIdUrl, Article.class);

    	// then
    	assertThat(returnedArticle, is(articleInDb));
    }

    @Test
    public void getArticlesByTitle() {
        fail("tbd");
    }

    @Test
    public void getArticlesByAuthor() {
        fail("tbd");
    }

    /* ADD MORE TESTS HERE */
    
    /* Spring Injected Values/Collaborators */

    @Resource
    public void setRestTemplate(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
