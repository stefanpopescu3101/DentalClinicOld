package com.example.dentalclinic.converters;

import com.example.dentalclinic.Models.News;
import com.example.dentalclinic.dto.NewsDTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NewsConverter {
    public NewsDTO entityToDto(News news)
    {
        NewsDTO dto  = new NewsDTO();
        dto.setId(news.getId());
        dto.setTitle(news.getTitle());
        dto.setDescription(news.getDescription());
        dto.setPostedAt(news.getPostedAt());

        return dto;

    }
    public List<NewsDTO> entityToDto(List<News> news)
    {
        return news.stream().map(this::entityToDto).collect(Collectors.toList());

    }
    public News dtoToEntity(NewsDTO dto)
    {
        News entity = new News();
        entity.setId(dto.getId());
        entity.setTitle(dto.getTitle());
        entity.setDescription(dto.getDescription());
        entity.setPostedAt(dto.getPostedAt());

        return entity;

    }
    public List<News> dtoToEntity(List<NewsDTO> newsDTOS)
    {
        return newsDTOS.stream().map(this::dtoToEntity).collect(Collectors.toList());

    }
}
