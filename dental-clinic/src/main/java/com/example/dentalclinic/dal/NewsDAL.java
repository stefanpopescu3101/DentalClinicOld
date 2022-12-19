package com.example.dentalclinic.dal;

import com.example.dentalclinic.Models.News;
import com.example.dentalclinic.dalInterfaces.INewsDAL;
import com.example.dentalclinic.repoInterfaces.INewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository @Transactional
public class NewsDAL implements INewsDAL {

    private INewsRepository repo;
    @Autowired
    public NewsDAL(INewsRepository repo)
    {
        this.repo=repo;
    }

    @Override
    public List<News> getAllNews() {
        return repo.findAll();
    }

    @Override
    public News getNewsById(Integer id) {
        return repo.findById(id).get();
    }

    @Override
    public boolean addNews(News news) {
        if(news != null)
        {
            repo.save(news);
            return true;
        }
        return  false;
    }

    @Override
    public boolean editNews(News news) {
        News updatedNewsArticle= this.getNewsById(news.getId());
        if(updatedNewsArticle != null) {
            updatedNewsArticle.setPostedAt(news.getPostedAt());
            updatedNewsArticle.setDescription(news.getDescription());
            updatedNewsArticle.setTitle(news.getTitle());
            repo.save(updatedNewsArticle);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteNews(Integer id) {
        if(getNewsById(id).getId() == id)
        {
            repo.delete(getNewsById(id));
            return true;
        }
        return false;
    }
}
