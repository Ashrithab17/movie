package com.example.movieCrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.movieCrud.entity.Movie;
import com.example.movieCrud.repository.MovieRepository;

import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    private MovieRepository repository;

    @GetMapping
    public String loadMain(ModelMap map) {
        List<Movie> movies = repository.findAll();
        if (!movies.isEmpty())
            map.put("movies", movies);
        return "main";
    }

    @GetMapping("/add")
    public String loadAdd(ModelMap map) {
        map.put("movie", new Movie());
        return "add";
    }

    @PostMapping("/add")
    public String add(Movie movie, RedirectAttributes attributes) {
        repository.save(movie);
        attributes.addFlashAttribute("message", "Movie Record Added Successfully!");
        return "redirect:/movie";
    }    

//   @GetMapping("/")
//   public String delete(@PathVariable Long id, RedirectAttributes attributes) {
//        repository.deleteById(id);
//       attributes.addFlashAttribute("message", "Movie Record Deleted Successfully!");
//       return "redirect:/movie";
//   }
   @PostMapping("/delete/{id}")
   public String deleteMovie(@PathVariable Long id) {
	   repository.deleteById(id);
	   return "redirect:/movie";
   }


  @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, ModelMap map, RedirectAttributes attributes) {
        Movie movie = repository.findById(id).orElse(null);
        if (movie == null) {
            attributes.addFlashAttribute("message", "Movie Not Found!");
            return "redirect:/movie";
        }
        map.put("movie", movie);
        return "edit";
    }


    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Long id, @ModelAttribute Movie movie, RedirectAttributes attributes) {
        // No setId() needed—form binds it
        repository.save(movie);
        attributes.addFlashAttribute("message", "Movie Record Updated Successfully!");
        return "redirect:/movie";
    }


}

//frontend to back  value one one request param, all at one time @model attribute
//backend to frontend modelmap
//redirectattributes to create alert  messages
//
//@GetMapping("/edit/{id}")
//public String edit(@PathVariable Long id, ModelMap map) {
//  Movie movie = repository.findById(id).orElseThrow();
// map.put("movie", movie);
//  return "edit.html";
//}


