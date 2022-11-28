package com.example.dentalclinic.Interfaces;

import com.example.dentalclinic.Models.News;

import java.util.List;

public interface INews {
    List<News> getAllNews();
    News getNewsById(Integer id);
    boolean createNewPost(News news);
    boolean editPost(News news);
    boolean deletePost(Integer id);


}
