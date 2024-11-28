package demo.jardigenie.bo;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class Article {

    private Long id;
    @NotBlank(message = "Le nom doit être renseigné")
    private String nom;
    @NotBlank(message="La description doit être renseigné")
    private String description;
    @NotNull(message = "Le prix doit être renseigné") // Utilisez cette contrainte seulement pour les objets
    @PositiveOrZero(message = "Le prix doit être supérieur ou égal à 0.0 €")
    private Double prix;
    @NotBlank(message = "L''image doit être renseignée")
    private String image;
    private Category category;

    public Article() {
        super();
    }

    public Article(Long id, String nom, String description, Double prix, String image) {
        super();
        this.id = id;
        this.nom = nom;
        this.description = description;
        this.prix = prix;
        this.image = image;
    }

    public Article(Long id, String nom, String description, Double prix, String image, Category category) {
        this(id, nom, description, prix, image);
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", prix=" + prix +
                ", image='" + image + '\'' +
                ", category=" + category +
                '}';
    }
}
