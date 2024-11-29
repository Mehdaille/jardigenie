package demo.jardigenie.bll.impl;

import demo.jardigenie.bll.IArticleManager;
import demo.jardigenie.bo.Article;
import demo.jardigenie.bo.Category;
import demo.jardigenie.dao.IDAOArticle;
import demo.jardigenie.dao.IDAOCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleManager implements IArticleManager {

    @Autowired
    IDAOArticle articleDao;

    @Autowired
    IDAOCategory categoryDao;

    @Override
    public List<Article> getAllArticles() {
        return articleDao.findAllArticles();
    }

    @Override
    public Article getArticleById(Long id) {
        return articleDao.findArticleById(id);
    }

    @Override
    public List<Article> getArticlesByCategoryId(Long idCategory) {
        return articleDao.findArticlesByCategoryId(idCategory);
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryDao.findAllCategories();
    }

    @Override
    public Category getCategoryById(Long id) {
        return categoryDao.findCategoryById(id);
    }

    @Override
    public void saveArticle(Article article) {
        articleDao.saveArticle(article);
    }

    @Override
    public void updateArticle(Article article) {
        articleDao.updateArticle(article);
    }

    @Override
    public void deleteArticle(Article article) {
        articleDao.deleteArticle(article);
    }

    @Override
    public void saveCategory(Category category) {
        categoryDao.saveCategory(category);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDao.updateCategory(category);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryDao.deleteCategory(category);
    }
}
