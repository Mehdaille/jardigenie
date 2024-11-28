package demo.jardigenie.ihm.converter;

import demo.jardigenie.bll.IArticleManager;
import demo.jardigenie.bo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToCategoryConverter implements Converter<String, Category> {

    @Autowired
    IArticleManager articleManager;

    @Override
    public Category convert(String id) {
        return articleManager.getCategoryById(Long.parseLong(id));
    }
}
