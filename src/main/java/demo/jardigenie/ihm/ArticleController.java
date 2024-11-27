package demo.jardigenie.ihm;


import demo.jardigenie.bll.IArticleManager;
import demo.jardigenie.bo.Article;
import demo.jardigenie.bo.Category;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

        Article article = new Article();

        if (id != null) {
            article = articleManager.getArticleById(id);
        }

        model.addAttribute("article", article);

        List<Category> categories = articleManager.getAllCategories();

        model.addAttribute("categories", categories);

        return "form/form-article";
    }

    @PostMapping("/article-form")
    public String articleForm(@Valid @ModelAttribute("article") Article article, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model) {

        List<Category> categories = articleManager.getAllCategories();

        model.addAttribute("categories", categories);

        if (bindingResult.hasErrors()) {
            return "form/form-article";
        }

        if (article.getId() == null) {
            articleManager.saveArticle(article);
            return "redirect:/list-articles";
        }

        if (article.getId() != null) {
            articleManager.updateArticle(article);
            return "redirect:/list-articles";
        }

        return "redirect:/";
    }


    @GetMapping("/")
    public String home() {
        return "home";
    }
}
