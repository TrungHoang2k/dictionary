package controllers;


import dictionary.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import dictionary.service.Dictionary;
import dictionary.service.DictionaryFactory;
import dictionary.model.Word;


import java.util.List;

@Controller
public class TranslatorController {
    @GetMapping("/translator")
    public ModelAndView showTranslator() {
        ModelAndView modelAndView = new ModelAndView("view/translator.jsp");
        return modelAndView;
    }

    @GetMapping("/result")
    public ModelAndView showResult(@ModelAttribute("eng") String eng) {
        ModelAndView modelAndView = new ModelAndView("view/result.jsp");
        Dictionary customerService = DictionaryFactory.getInstance();
        Word word = customerService.translate(eng);
        if (word != null) modelAndView.addObject("string", word.getVie());
        else modelAndView.addObject("string", "khong tim duoc tu!");
        return modelAndView;
    }
}