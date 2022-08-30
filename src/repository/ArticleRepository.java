package repository;

import data.Article;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ArticleRepository {

    private int articleId = 0;

    private List<Article> store = new ArrayList<>();

    public int write(String title, String body, String author) {
        articleId += 1;

        Article article = new Article(articleId ,title, body, author);
        store.add(article);

        return articleId;
    }

    public Article getById(int articleId) {
        for(Article article : store){
            if(article.getId() == articleId){
                return article;
            }
        }
        return null;
    }


    public void delete(Article article) {
        store.remove(article);
    }

    public List<Article> getArticles() {
        return store;
    }
}
