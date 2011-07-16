package uk.co.pc.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import uk.co.pc.domain.dao.ArticleDao;
import uk.co.pc.domain.model.Article;

@RunWith(MockitoJUnitRunner.class)
public class ArticleServiceImplTest {

    private ArticleServiceImpl articleService;
    private Article article;

    @Mock
    private ArticleDao articleDao;
    
    @Before
    public void setup() {
    	articleService = new ArticleServiceImpl(articleDao);
    }

    @Test
    public void saveShouldSaveAnArticle() {
    	// given the dao stores and returns an article successfully
    	Article storedArticle = Article.create();
    	given(articleDao.save(article)).willReturn(storedArticle);
    	
    	// when
    	Article returnedArticle = articleService.save(article);
    	
    	// then 
    	assertThat(returnedArticle, is(sameInstance(storedArticle)));
    }

    @Test
    public void deleteShouldDeleteAnArticle() {
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

}
