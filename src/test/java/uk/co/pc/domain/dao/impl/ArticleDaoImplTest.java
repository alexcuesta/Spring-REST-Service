package uk.co.pc.domain.dao.impl;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import uk.co.pc.domain.dao.ArticleDao;
import uk.co.pc.domain.model.Article;

@Transactional
@TransactionConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-testing.xml")
public class ArticleDaoImplTest {

    private ArticleDao articleDao;
    private Article article;

    @Before
    public void setUp() {
        article = Article.create();
        articleDao.save(article);
    }

    @Test
    public void saveShouldSaveAnArticle() {
        fail("tbd");
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
}
