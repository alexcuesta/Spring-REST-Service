package uk.co.pc.service;

import java.util.List;

import uk.co.pc.domain.model.Article;

/**
 * ArticleService.
 */
public interface ArticleService {

    /**
     * Save an Article;
     * 
     * @param article to save;
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
     */
    Article findById(final Long id);

    /**
     * Find Articles by Title.
     * 
     * @param title of the Article to search for.
     * @return Articles or empty list if none found.
     */
    List<Article> findByTitle(final String title);

    /**
     * Find Articles by Author.
     * 
     * @param title of the Article to search for.
     * @return Articles or empty list if none found.
     */
    List<Article> findByAuthor(final String author);

}
