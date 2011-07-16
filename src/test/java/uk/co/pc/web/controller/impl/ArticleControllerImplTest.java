package uk.co.pc.web.controller.impl;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

/**
 * Please run this test AFTER you have deployed the application into a web container (jetty, tomcat...)
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-testing.xml")
public class ArticleControllerImplTest {

    private static final String BASEURL = "http://localhost:8080/article";
    private RestTemplate restTemplate;

    @Test
    public void getArticleById() {
        fail("tbd");
    }

    @Test
    public void getArticlesByTitle() {
        fail("tbd");
    }

    @Test
    public void getArticlesByAuthor() {
        fail("tbd");
    }

    /* ADD MORE TESTS HERE */
    
    /* Spring Injected Values/Collaborators */

    @Resource
    public void setRestTemplate(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

}
