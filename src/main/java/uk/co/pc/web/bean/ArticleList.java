package uk.co.pc.web.bean;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import uk.co.pc.domain.model.Article;

import com.google.common.collect.Lists;

/**
 * ArticleList.
 */
@XmlRootElement(name = "articles")
@XmlAccessorType(XmlAccessType.NONE)
public class ArticleList {

    @XmlElement(name = "article")
    private List<Article> articles;

    public ArticleList() {
    }

    public ArticleList(final List<Article> articles) {
        this.articles = articles;
    }

    public void setArticles(final List<Article> articles) {
        this.articles = articles;
    }

    public List<Article> getArticles() {
        if (articles == null) {
            return Lists.newArrayList();
        }
        return articles;
    }

}