package service;


import infra.Container;
import repository.ArticleRepository;

public class ArticleService {

    public int write(String title, String body, String author){
        return articleRepository.write(title,body,author);
    };
    private ArticleRepository articleRepository;

    public ArticleService(){
        this.articleRepository = Container.articleRepository;
    }
}