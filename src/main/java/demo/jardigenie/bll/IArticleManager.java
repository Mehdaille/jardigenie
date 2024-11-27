package demo.jardigenie.bll;

import demo.jardigenie.bo.Article;
import demo.jardigenie.bo.Category;

import java.util.List;

public interface IArticleManager {

    List<Article> getAllArticles();

    Article getArticleById(Long id);

    List<Category> getAllCategories();

    Category getCategoryById(Long id);

    void saveArticle(Article article);

    void updateArticle(Article article);

    void deleteArticle(Article article);

    void saveCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Category category);


}
