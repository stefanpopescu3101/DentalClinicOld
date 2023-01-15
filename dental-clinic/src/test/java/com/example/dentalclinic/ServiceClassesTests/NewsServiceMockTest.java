package com.example.dentalclinic.ServiceClassesTests;

import com.example.dentalclinic.Models.News;
import com.example.dentalclinic.converters.NewsConverter;
import com.example.dentalclinic.dalInterfaces.INewsDAL;
import com.example.dentalclinic.dto.NewsDTO;
import com.example.dentalclinic.service.NewsService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ActiveProfiles("test")
@SpringBootTest
public class NewsServiceMockTest {

    @Mock
    private INewsDAL newsDAL;

    @BeforeEach
    public void setUp()
    {
        List<News> news = List.of(
                new News(1,"test1","test","10/01/2023"),
                new News(2,"test2","test","10/01/2023"),
                new News(3,"test3","test","10/01/2023")

        );


        when(newsDAL.getNewsById(1)).thenReturn(news.get(0));
        when(newsDAL.deleteNews(1)).thenReturn(true);
        when(newsDAL.getAllNews()).thenReturn(news);
    }

    @Test
    public void getAllNewsTest_ReturnList()
    {
        //arrange
        NewsService service = new NewsService(newsDAL,new NewsConverter());

        //act
        List<NewsDTO> news = service.getAllNews();

        //assert
        Assertions.assertEquals(1, news.get(0).getId());
        Assertions.assertEquals(2, news.get(1).getId());
        Assertions.assertEquals(3, news.get(2).getId());
    }

    @Test
    public void getNewsById()
    {
        //arrange
        NewsService service = new NewsService(newsDAL,new NewsConverter());
        News news =  new News(4,"test3","test","10/01/2023");

        //act
        when(newsDAL.getNewsById(4)).thenReturn(news);
        NewsDTO postToBeCheck =service.getNewsById(4);

        //assert
        Assertions.assertEquals("test3", postToBeCheck.getTitle());
    }

    @Test
    public void deletePost()
    {

        //arrange
        NewsService service = new NewsService(newsDAL,new NewsConverter());

        //act
        List<NewsDTO> news = service.getAllNews();
        var result = service.deletePost(news.get(0).getId());

        //assert
        Assertions.assertEquals(result,true);
    }

    @Test
    public void addPost()
    {
        //arrange
        NewsService service = new NewsService(newsDAL,new NewsConverter());

        //act
        NewsDTO news =  new NewsDTO(4,"test3","test", "10/01/2023");
        service.addNews(news);

        //assert
        ArgumentCaptor<News> newsArgumentCaptor = ArgumentCaptor.forClass(News.class);
        verify(newsDAL).addNews(newsArgumentCaptor.capture());
        News capturePost = newsArgumentCaptor.getValue();
        Assertions.assertEquals(news.getTitle(), capturePost.getTitle());
    }

    @Test
    public void updatePost() {
        //arrange
        NewsService service = new NewsService(newsDAL, new NewsConverter());

        //act
        NewsDTO news = new NewsDTO(4, "test3", "test", "10/01/2023");
        service.addNews(news);

        news.setTitle("Test");
        service.editPost(news);

        //assert
        ArgumentCaptor<News> newsArgumentCaptor = ArgumentCaptor.forClass(News.class);
        verify(newsDAL).editNews(newsArgumentCaptor.capture());
        News capturePost = newsArgumentCaptor.getValue();
        Assertions.assertEquals(news.getTitle(), capturePost.getTitle());
    }
}
