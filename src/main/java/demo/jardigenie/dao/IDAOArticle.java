package demo.jardigenie.dao;

import demo.jardigenie.bo.Article;

import java.util.List;

public interface IDAOArticle {

    List<Article> findAllArticles();

    Article findArticleById(Long id);

    List<Article> findArticlesByCategoryId(Long idCategory);

    void saveArticle (Article article);

    void updateArticle (Article article);

    void deleteArticle (Article article);
}
