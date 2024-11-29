package demo.jardigenie.dao;

import demo.jardigenie.bo.Article;
import demo.jardigenie.bo.Category;

import java.util.List;

public interface IDAOCategory {

    List<Category> findAllCategories();

    Category findCategoryById(Long id);

    void saveCategory(Category category);

    void updateCategory(Category category);

    void deleteCategory(Category category);
}
