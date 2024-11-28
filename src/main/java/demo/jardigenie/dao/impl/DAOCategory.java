package demo.jardigenie.dao.impl;

import demo.jardigenie.bo.Category;
import demo.jardigenie.dao.IDAOCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DAOCategory implements IDAOCategory {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    static final RowMapper<Category> CATEGORY_ROW_MAPPER = new RowMapper<Category>() {
        @Override
        public Category mapRow(ResultSet rs, int rowNum) throws SQLException {

            Category category = new Category();
            category.setId(rs.getLong("id_category"));
            category.setLibelle(rs.getString("libelle"));
            return category;
        }
    };

    private String sqlSelectAllCategories = "SELECT id_category, libelle FROM category";
    private String sqlSelectCategoriesById = "SELECT id_category, libelle FROM category WHERE id_category = ?";
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
        return jdbcTemplate.query(sqlSelectAllCategories, CATEGORY_ROW_MAPPER);
    }

    @Override
    public Category findCategoryById(Long id) {
        return jdbcTemplate.queryForObject(sqlSelectCategoriesById, CATEGORY_ROW_MAPPER, id);
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
