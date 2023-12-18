package bg.softuni.regular_exam.controllers;

import bg.softuni.regular_exam.models.dto.NewsDTO;
import bg.softuni.regular_exam.models.entity.NewsEntity;
import bg.softuni.regular_exam.schedule.Theme;
import bg.softuni.regular_exam.services.ImageService;
import bg.softuni.regular_exam.services.NewsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class NewsController {
    private final ImageService imageService;
    private final NewsService newsService;

    public NewsController(ImageService imageService, NewsService newsService) {
        this.imageService = imageService;
        this.newsService = newsService;
    }

    @GetMapping("/news")

    public String news(Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);


        List<NewsEntity> news = newsService.GetAllNews();
        if (!model.containsAttribute("news")) {
            model.addAttribute("news", news);
        }
        return "news";
    }
    @GetMapping("/add-news")

    public String addNews(Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);


        if(!model.containsAttribute("newsDTO")){
            model.addAttribute("newsDTO",
                    new NewsDTO());
        }



        return "add-news";
    }
    @PostMapping("/add-news")
    private ModelAndView addNewsPost(
            @Valid NewsDTO newsDTO,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes

    ) throws IOException {

        newsService.saveNews(newsDTO);


        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("newsDTO", newsDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.newsDTO", bindingResult);

            return new ModelAndView("redirect:/add-news");
        }

        return new ModelAndView("redirect:/news");
    }

    @GetMapping("/news-page")

    public String newsPage(Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);

        return "news-page";
    }
    @GetMapping("/news-page/{id}")

    public String newsPage1(@PathVariable Long id,Model model){
        model.addAttribute("darkTheme", Theme.darkTheme);


        System.out.println("the News id is: "+id);
        NewsEntity news = newsService.getNewsById(id);

        if(!model.containsAttribute("news")){
            model.addAttribute("news",
                    news);
        }
        return "news-page";
    }

}
