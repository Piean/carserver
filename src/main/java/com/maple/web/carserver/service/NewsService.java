package com.maple.web.carserver.service;

import com.maple.web.carserver.domain.NewsEntity;

import java.util.List;

public interface NewsService {

    Integer count();

    List<NewsEntity> selectNewsByPageNumber(Integer pageNumber);

    NewsEntity getNewsDetail(Integer id);

    Integer addNews(NewsEntity newsEntity);

    Integer deleteNews(Integer newsId);


    Integer updateNews(NewsEntity newsEntity);
}
