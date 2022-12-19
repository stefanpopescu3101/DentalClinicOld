package com.example.dentalclinic.service;

import com.example.dentalclinic.Models.News;
import com.example.dentalclinic.converters.NewsConverter;
import com.example.dentalclinic.dalInterfaces.INewsDAL;
import com.example.dentalclinic.dto.NewsDTO;
import com.example.dentalclinic.serviceInterfaces.INewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service @Transactional
public class NewsService implements INewsService {
    private final INewsDAL data;
    private final NewsConverter converter;
    @Autowired
    public NewsService(INewsDAL data, NewsConverter converter)
    {
        this.data = data;
        this.converter = converter;
    }

    @Override
    public List<NewsDTO> getAllNews() {
        return converter.entityToDto(data.getAllNews());
    }

    @Override
    public NewsDTO getNewsById(Integer id) {
        return converter.entityToDto(data.getNewsById(id));
    }

    @Override
    public boolean addNews(NewsDTO news) {
        if(news != null)
        {
            News entity = converter.dtoToEntity(news);
            data.addNews(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean editPost(NewsDTO news) {
        if(news != null)
        {
            News entity = converter.dtoToEntity(news);
            data.editNews(entity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deletePost(Integer id) {
        return data.deleteNews(id);
    }
}
