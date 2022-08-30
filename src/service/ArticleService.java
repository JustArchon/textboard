package service;


import data.Article;
import infra.Container;
import repository.ArticleRepository;

import java.time.LocalDateTime;

public class ArticleService {

    public int write(String title, String body, String author){
        return articleRepository.write(title,body,author);
    };
    private ArticleRepository articleRepository;

    public ArticleService(){
        this.articleRepository = Container.articleRepository;
    }

    public Article getById(int articleId) {
        return articleRepository.getById(articleId);
    }

    public void delete(Article article) {
        articleRepository.delete(article);
    }

    public void modify(Article article,String newtitle, String newbody, LocalDateTime newtime) {
        articleRepository.modify(article, newtitle, newbody, newtime);
    }
}
