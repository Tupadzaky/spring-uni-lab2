package lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ThymeleafController {

    @RequestMapping("/index")
    ModelAndView getPibOfCreators() {
        ModelAndView index = new ModelAndView("index");
        index.addObject("student1", "Кохан Валерія");
        index.addObject("student2", "Хижнях Валерія");
        index.addObject("student3", "Крутиус Владислав");
        index.addObject("student4", "Запотоцький Іван");
        return index;
    }

    @RequestMapping("/")
    String thymeleafView() {
        return "index";
    }
}
