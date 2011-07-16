package uk.co.pc.domain.model;

import uk.co.pc.domain.dao.helper.DaoHelper;

public class ArticleBuilder {

	private DaoHelper daoHelper;
	private Article article;
	
	public ArticleBuilder(DaoHelper daoHelper) {
		this.daoHelper = daoHelper;
		article = new Article();
	}
	public ArticleBuilder withTitle(String title) {
		article.setTitle(title);
		return this;
	}

	public ArticleBuilder withAuthor(String author) {
		article.setAuthor(author);
		return this;
	}

	public Article isInDatabase() {
		daoHelper.insertArticleInDb(article);
		return article;
	}
}
