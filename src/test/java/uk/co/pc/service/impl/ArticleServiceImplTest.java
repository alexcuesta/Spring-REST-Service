package uk.co.pc.service.impl;

import static org.junit.Assert.fail;

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

    @Test
    public void saveShouldSaveAnArticle() {
        fail("tbd");
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
