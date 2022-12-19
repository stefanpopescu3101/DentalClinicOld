package com.example.dentalclinic.controllers;

import com.example.dentalclinic.dto.NewsDTO;
import com.example.dentalclinic.serviceInterfaces.INewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/news")
@Controller
public class NewsController {
    private final INewsService service;

    @Autowired
    public NewsController(INewsService service)
    {
        this.service=service;
    }

    //GET at /news
    @GetMapping
    public ResponseEntity<List<NewsDTO>> getAllNews()
    {
        List<NewsDTO> newsList = service.getAllNews();

        if(newsList != null)
        {
            return ResponseEntity.ok().body(newsList);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }

    }
    //GET at news/1 e…g
    @GetMapping("{id}")
    public ResponseEntity<NewsDTO> getNewsById(@PathVariable(value = "id")  Integer id) {
        NewsDTO news = service.getNewsById(id);

        if(news != null) {
            return ResponseEntity.ok().body(news);
        } else {
            return ResponseEntity.notFound().build();
        }

    }

    //POST at http://localhost:8080/news
    @PostMapping()
    public ResponseEntity<NewsDTO> addNews(@RequestBody NewsDTO news) {
        if (news == null) {
            return ResponseEntity.notFound().build();
        } else {
            service.addNews(news);
            return ResponseEntity.ok().body(news);
        }

    }
    //DELETE at http://localhost:XXXX/news/
    @DeleteMapping("{id}")
    public ResponseEntity<NewsDTO> deleteNews(@PathVariable("id") Integer id) {
        service.deletePost(id);
        return ResponseEntity.ok().build();

    }

    //PUT at http://localhost:XXXX/news/
    @PutMapping()
    public ResponseEntity<NewsDTO> editNews(@RequestBody NewsDTO news)
    {
        if(service.editPost(news))
        {
            return ResponseEntity.ok().body(news);
        }
        else
        {
            return ResponseEntity.notFound().build();
        }
    }
}
