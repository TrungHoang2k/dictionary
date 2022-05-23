package controllers;

import dictionary.model.Word;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import dictionary.service.Dictionary;
import dictionary.service.DictionaryFactory;

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
        Dictionary customerService = DictionaryFactory.getInstance();
        Word word = customerService.translate(eng);
        if (word != null) modelAndView.addObject("word", word.getVie());
        else modelAndView.addObject("word", "khong tim duoc tu!");
        return modelAndView;
    }
}