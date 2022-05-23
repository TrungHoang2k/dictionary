package controllers;

import dictionary.model.Word;
import dictionary.service.impl.DictionaryImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import dictionary.service.Dictionary;

@Controller
public class TranslatorController {
    @GetMapping("/translator")
    public ModelAndView showTranslator() {
        ModelAndView modelAndView = new ModelAndView("view/translator.jsp");
        return modelAndView;
    }

    @PostMapping("/result")
    public ModelAndView showResult(@ModelAttribute("eng") String eng) {
        ModelAndView modelAndView = new ModelAndView("view/result.jsp");
        Dictionary dictionary = new DictionaryImpl();
        Word word = dictionary.translate(eng);
        if (word != null) {
            modelAndView.addObject("word", word.getVie());
            return modelAndView;
        }
        modelAndView.addObject("word", "khong tim duoc tu!");
        return modelAndView;
    }
}