package uk.co.pc.service.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willThrow;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import uk.co.pc.domain.dao.ArticleDao;
import uk.co.pc.domain.dao.exception.ArticleNotFoundException;
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
    	// given dao stores and returns an article successfully
    	Article articleReturnedByDao = Article.create();
    	given(articleDao.save(article)).willReturn(articleReturnedByDao);
    	
    	// when
    	Article returnedArticle = articleService.save(article);
    	
    	// then 
    	assertThat(returnedArticle, is(sameInstance(articleReturnedByDao)));
    }

    @Test
    public void deleteShouldDeleteAnArticle() {
        // given
    	Long id = 1L;
    	
    	// when
    	articleService.delete(id);
    	
    	// then
    	verify(articleDao).delete(id);
    }

    @Test
    public void findByIdShouldReturnAnArticle() throws ArticleNotFoundException {
    	// given an id
    	Long id = 1L;
    	// and dao successfully finds article by id
    	Article articleReturnedByDao = Article.create();
    	given(articleDao.findById(id)).willReturn(articleReturnedByDao);
    	
    	// when
    	Article returnedArticle = articleService.findById(id);
    	
    	// then
    	assertThat(returnedArticle, is(sameInstance(articleReturnedByDao)));
    }

    @Test(expected=ArticleNotFoundException.class)
    public void findByInvalidIdShouldNotReturnAnArticle() throws ArticleNotFoundException {
        // given an invalid id
    	Long invalidId = -1L;
    	// and the dao throws an ArticleNotFoundException
    	willThrow(new ArticleNotFoundException(invalidId.toString()))
    		.given(articleDao).findById(invalidId);
    	
    	// when 
    	articleService.findById(invalidId);
    	
    	// then it should throw an InvalidIdException because I don't want problems with null objects
    }

    @Test
    public void findByTitleShouldReturnAnArticle() {
    	// given a title
    	String title = "Domain Driven Design";
    	// and the dao sucessfully returns an article
    	List<Article> articlesFound = Arrays.asList(new Article());
    	given(articleDao.findByTitle(title)).willReturn(articlesFound);
    	
    	// when
    	List<Article> actualArticles = articleService.findByTitle(title);
    	
    	// then
    	assertThat(actualArticles, is(articlesFound));
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
