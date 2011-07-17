package uk.co.pc.web.controller.impl;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import uk.co.pc.domain.model.Article;
import uk.co.pc.service.ArticleService;
import uk.co.pc.web.bean.ArticleList;

@RunWith(MockitoJUnitRunner.class)
public class ArticleControllerImplTest {
	
	private ArticleControllerImpl controller;
	
	@Mock
	private ArticleService articleService;
	
	@Before
	public void setup() {
		controller = new ArticleControllerImpl(articleService);
	}
	

	@Test
	public void shouldSaveArticle() throws Exception {
		// given an article
		Article articleToSave = new Article();
		// and the service successfully saves and returns it back with an id
		Article savedArticle = new Article();
		given(articleService.save(articleToSave)).willReturn(savedArticle);
		
		// when
		Article actualArticle = controller.save(articleToSave);
				
		// then 
		assertThat(actualArticle, is(sameInstance(savedArticle)));
	}
	
	@Test
	public void shouldGetArticleById() throws Exception {
		// given an id
		Long id = 1L;
		// and the service successfully returns the article from database
		Article articleInDb = new Article();
		given(articleService.findById(id)).willReturn(articleInDb);
		
		// when
		Article actualArticle = controller.getArticleById(id);
		
		// then 
		assertThat(actualArticle, is(sameInstance(articleInDb)));
	}
	
	@Test
	public void shouldGetArticlesByTitle() throws Exception {
		// given a title
		String title = "Clean Code";
		// and the service successfully returns a list of articles from database
		Article articleFound = new Article();
		List<Article> articlesFound = Arrays.asList(articleFound);
		given(articleService.findByTitle(title)).willReturn(articlesFound);
		
		// when
		ArticleList actualArticles = controller.getArticlesByTitle(title);
		
		// then
		assertThat(actualArticles.getArticles(), is(sameInstance(articlesFound)));
	}
}
