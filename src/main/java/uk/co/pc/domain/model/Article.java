package uk.co.pc.domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * The Article Entity.
 */
@Entity
@XmlRootElement(name = "article")
@XmlAccessorType(XmlAccessType.NONE)
public class Article {

    @Id
    @XmlElement
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @XmlElement
    @Length(max = 20)
    private String title;

    @NotEmpty
    @XmlElement
    @Length(max = 20)
    private String author;

    public static Article create() {
        final Article article = new Article();
        article.setTitle("default title");
        article.setAuthor("default author");
        return article;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(final String author) {
        this.author = author;
    }

}
