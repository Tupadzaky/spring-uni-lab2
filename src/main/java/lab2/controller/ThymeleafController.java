package lab2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    @RequestMapping("/index")
    ModelAndView getPibOfCreators() {
        ModelAndView index = new ModelAndView("index");
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Кохан Валерія"));
        students.add(new Student(2, "Хижнях Валерія"));
        students.add(new Student(3, "Крутиус Владислав"));
        students.add(new Student(4, "Запотоцький Іван"));
        index.addObject("students", students);
        return index;
    }

    class Student {
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        int id;
        String name;

        public Student(int i, String name) {
            this.id = i;
            this.name = name;
        }
    }
}
