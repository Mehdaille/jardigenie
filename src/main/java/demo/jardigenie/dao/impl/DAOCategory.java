package demo.jardigenie.dao.impl;

import demo.jardigenie.bo.Category;
import demo.jardigenie.dao.IDAOCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DAOCategory implements IDAOCategory {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private String sqlSelectAllCategories = "SELECT * FROM category";
    private String sqlSelectCategoriesById = "SELECT * FROM category WHERE id = ?";
    private String sqlInsertCategory = "INSERT INTO category (id_category, libelle) VALUES (:id_category, :libelle)";
    private String sqlUppdateCategory = "UPDATE category SET libelle = :libelle WHERE id = :id_category";
    private String sqlDeleteCategory = "DELETE FROM category WHERE id = :id_category";


    private MapSqlParameterSource map(Category category) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue(":id_category", category.getId());
        params.addValue(":libelle", category.getLibelle());
        return params;
    }

    @Override
    public List<Category> findAllCategories() {
        return jdbcTemplate.query(sqlSelectAllCategories, new BeanPropertyRowMapper<>(Category.class));
    }

    @Override
    public Category findCategoryById(Long id) {
        return jdbcTemplate.queryForObject(sqlSelectCategoriesById, new BeanPropertyRowMapper<>(Category.class), id);
    }

    @Override
    public void saveCategory(Category category) {
        namedParameterJdbcTemplate.update(sqlInsertCategory, map(category));
    }

    @Override
    public void updateCategory(Category category) {
        namedParameterJdbcTemplate.update(sqlUppdateCategory, map(category));
    }

    @Override
    public void deleteCategory(Category category) {
        namedParameterJdbcTemplate.update(sqlDeleteCategory, map(category));
    }
}
