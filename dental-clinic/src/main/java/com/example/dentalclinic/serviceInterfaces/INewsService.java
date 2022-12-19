package com.example.dentalclinic.serviceInterfaces;

import com.example.dentalclinic.dto.NewsDTO;

import java.util.List;

public interface INewsService {
    List<NewsDTO> getAllNews();
    NewsDTO getNewsById(Integer id);
    boolean addNews(NewsDTO news);
    boolean editPost(NewsDTO news);
    boolean deletePost(Integer id);
}
