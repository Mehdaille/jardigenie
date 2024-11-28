package demo.jardigenie.ihm;


import demo.jardigenie.bll.IArticleManager;
import demo.jardigenie.bo.Article;
import demo.jardigenie.bo.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private IArticleManager articleManager;

    @GetMapping("/list-articles")
    public String showListArticles(Model model) {

        List<Article> articles = articleManager.getAllArticles();

        model.addAttribute("articles", articles);

        return "list/list-articles";
    }

    @GetMapping("/details-article/{id}")
    public String showDetailArticle(@PathVariable Long id, Model model) {

        Article article = articleManager.getArticleById(id);

        if (article == null) {
            return "redirect:/list-articles";
        }

        model.addAttribute("article", article);

        return "details/details-article";
    }

    @GetMapping({"/show-article-form/{id}", "/show-article-form"})
    public String showFormArticle(@PathVariable(required = false) Long id, Model model) {

        if (!model.containsAttribute("article")) {
            Article article = (id != null) ? articleManager.getArticleById(id) : new Article();
            model.addAttribute("article", article);
        }

        List<Category> categories = articleManager.getAllCategories();
        model.addAttribute("categories", categories);

        return "form/form-article";
    }

    @PostMapping("/article-form")
    public String articleForm(@Valid @ModelAttribute Article article, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("flashMessage", new JardigenieFlashMessage(JardigenieFlashMessage.TYPE_FLASH_ERROR, "Veuillez renseigner correctement l'article"));
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.article", bindingResult);
            redirectAttributes.addFlashAttribute("article", article);
            return "redirect:/show-article-form";
        }

        List<Category> categories = articleManager.getAllCategories();
        model.addAttribute("categories", categories);


        if (article.getId() == null) {
            articleManager.saveArticle(article);
            redirectAttributes.addFlashAttribute("flashMessage", new JardigenieFlashMessage(JardigenieFlashMessage.TYPE_FLASH_SUCCES, "L'article a été ajouté à la liste des articles"));
            return "redirect:/list-articles";
        } else {
            articleManager.updateArticle(article);
            redirectAttributes.addFlashAttribute("flashMessage", new JardigenieFlashMessage(JardigenieFlashMessage.TYPE_FLASH_SUCCES, "L'article a été modifié avec succès"));
        }
            return "redirect:/list-articles";
    }

    @GetMapping("/delete-article/{id}")
    public String deleteArticle(@PathVariable Long id) {

        if (articleManager.getArticleById(id) == null) {
            System.out.println("erreur");
        } else {
            articleManager.deleteArticle(articleManager.getArticleById(id));
        }
        return "redirect:/list-articles";
    }

    @GetMapping("/")
    public String home() {
        return "home";
    }
}
