package demo.jardigenie.dao.impl;

import demo.jardigenie.bo.Article;
import demo.jardigenie.bo.Category;
import demo.jardigenie.dao.IDAOArticle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class DAOArticle implements IDAOArticle {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    static final RowMapper<Article> ARTICLE_RAW_MAPPER = new RowMapper<Article>() {
        @Override
        public Article mapRow(ResultSet rs, int rowNum) throws SQLException {

            Article article = new Article();
            article.setId(rs.getLong("id_article"));
            article.setNom(rs.getString("nom"));
            article.setDescription(rs.getString("description"));
            article.setPrix(rs.getDouble("prix"));
            article.setImage(rs.getString("image"));

            Category category = new Category();
            category.setId(rs.getLong("id_category"));
            category.setLibelle(rs.getString("libelle"));

            article.setCategory(category);

            return article;
        }
    };

    private MapSqlParameterSource map(Article article) {
        MapSqlParameterSource params = new MapSqlParameterSource();
        params.addValue("idArticle", article.getId());
        params.addValue("nom", article.getNom());
        params.addValue("description", article.getDescription());
        params.addValue("prix", article.getPrix());
        params.addValue("image", article.getImage());
        params.addValue("category", article.getCategory().getId());
        return params;
    }

    private String sqlSelectAllArticles = "SELECT a.id_article, a.nom, a.description, a.prix, a.image, c.id_category AS id_category, c.libelle FROM article a JOIN category c ON a.CATEGORY_id_category = c.id_category";
    private String sqlSelectArticleById = "SELECT a.id_article, a.nom, a.description, a.prix, a.image, c.id_category AS id_category, c.libelle FROM article a JOIN category c ON a.CATEGORY_id_category = c.id_category WHERE a.id_article = ?";
    private String sqlInsertArticle = "INSERT INTO article(id_article, nom, description, prix, image, id_category) VALUES (:idArticle, :nom, :description, :prix, :image, :category)";
    private String sqlUpdateArticle = "UPDATE article SET nom = :nom, description = :description, prix = :prix, image = :image, CATEGORY_id_category = :category WHERE id_article = :idArticle";
    private String sqlDeleteArticle = "DELETE FROM article WHERE id_article = :idArticle";

    @Override
    public List<Article> findAllArticles() {
        return jdbcTemplate.query(sqlSelectAllArticles, ARTICLE_RAW_MAPPER);
    }

    @Override
    public Article findArticleById(Long id) {
        return jdbcTemplate.queryForObject(sqlSelectArticleById, ARTICLE_RAW_MAPPER, id);
    }

    @Override
    public void saveArticle(Article article) {
        namedParameterJdbcTemplate.update(sqlInsertArticle, map(article));
    }

    @Override
    public void updateArticle(Article article) {
        namedParameterJdbcTemplate.update(sqlUpdateArticle, map(article));
    }

    @Override
    public void deleteArticle(Article article) {
        namedParameterJdbcTemplate.update(sqlDeleteArticle, map(article));
    }
}
