package com.example.dentalclinic.dalInterfaces;

import com.example.dentalclinic.Models.News;

import java.util.List;

public interface INewsDAL {
    List<News> getAllNews();
    News getNewsById(Integer id);
    boolean addNews(News news);
    boolean editNews(News news);
    boolean deleteNews(Integer id);
}
