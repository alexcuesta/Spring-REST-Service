package uk.co.pc.domain.dao;

import java.util.List;

import uk.co.pc.domain.dao.exception.ArticleNotFoundException;
import uk.co.pc.domain.model.Article;

/**
 * ArticleDao.
 */
public interface ArticleDao {

    /**
     * Save an article.
     * 
     * @param article to save.
     * @return Article saved.
     */
    Article save(final Article article);

    /**
     * Delete an Article.
     * 
     * @param id of the Article to delete
     */
    void delete(final Long id);

    /**
     * Find Article by Id.
     * 
     * @param id of the Article to search for.
     * @return Article or null if not found.
     * @throws ArticleNotFoundException If article is not found
     */
    Article findById(final Long id) throws ArticleNotFoundException;

    /**
     * Find Articles by Title.
     * 
     * @param title of the Article to search for.
     * @return Article or empty list if not found.
     */
    List<Article> findByTitle(final String title);

    /**
     * Find Articles by Author.
     * 
     * @param title of the Article to search for.
     * @return Article or empty list if not found.
     */
    List<Article> findByAuthor(final String author);

}
