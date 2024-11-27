package demo.jardigenie.ihm;


import demo.jardigenie.bll.IArticleManager;
import demo.jardigenie.bo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private IArticleManager articleManager;

    @GetMapping("/list-articles")
    public String showListArticles (Model model) {

        List<Article> articles = articleManager.getAllArticles();

        model.addAttribute("articles", articles);

        return "list/list-articles";
    }

    @GetMapping("/details-article/{id}")
    public String showDetailArticle (@PathVariable Long id, Model model) {

        Article article = articleManager.getArticleById(id);

        if (article == null) {
            return "redirect:/list-articles";
        }

        model.addAttribute("article", article);

        return "details/details-article";
    }

    @GetMapping("/")
    public String home () {
        return "base";
    }
}
