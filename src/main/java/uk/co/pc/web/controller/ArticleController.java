package uk.co.pc.web.controller;

import uk.co.pc.domain.model.Article;
import uk.co.pc.web.bean.ArticleList;

/**
 * ArticleController.
 */
public interface ArticleController {

    /**
     * Save an Article;
     * 
     * @param article to save
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
     */
    Article getArticleById(final Long id);

    /**
     * Find an Article by Title.
     * 
     * @param title of the Article to search for.
     * @return Article or null if not found.
     */
    ArticleList getArticlesByTitle(final String title);

    /**
     * Find an Article by Author.
     * 
     * @param title of the Article to search for.
     * @return Article or null if not found.
     */
    ArticleList getArticlesByAuthor(final String author);

}
