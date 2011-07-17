package uk.co.pc.domain.dao.exception;


public class ArticleNotFoundException extends Exception {

	private String searchTerm;

	public ArticleNotFoundException(String searchTerm) {
		this.searchTerm = searchTerm;
	}
	
	
}
