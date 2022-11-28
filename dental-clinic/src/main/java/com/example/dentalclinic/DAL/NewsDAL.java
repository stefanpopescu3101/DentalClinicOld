package com.example.dentalclinic.DAL;

import com.example.dentalclinic.Interfaces.INews;
import com.example.dentalclinic.Models.News;
import com.example.dentalclinic.repoInterfaces.INewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NewsDAL implements INews {

    @Autowired
    INewsRepository repo;

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
    public boolean createNewPost(News news) {
        if(news==null)
        {
            repo.save(news);
            return true;
        }
        return  false;
    }

    @Override
    public boolean editPost(News news) {
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
    public boolean deletePost(Integer id) {
        if(getNewsById(id).getId() == id)
        {
            repo.delete(getNewsById(id));
            return true;
        }
        return false;
    }
}
