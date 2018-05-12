package com.maple.web.carserver.service.impl;

import com.maple.web.carserver.domain.NewsEntity;
import com.maple.web.carserver.mapper.NewsEntityMapper;
import com.maple.web.carserver.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsEntityMapper newsEntityMapper;


    @Override
    public Integer count() {
        return newsEntityMapper.count();
    }

    @Override
    public List<NewsEntity> selectNewsByPageNumber(Integer pageNumber) {
        return newsEntityMapper.selectNewsByPageNumber(pageNumber * 8);
    }

    @Override
    public NewsEntity getNewsDetail(Integer id) {
        return newsEntityMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer addNews(NewsEntity newsEntity) {
        newsEntity.setCreateTime(new Date());
        return newsEntityMapper.insertSelective(newsEntity);
    }

    @Override
    public Integer deleteNews(Integer newsId) {
        return newsEntityMapper.deleteByPrimaryKey(newsId);
    }


    @Override
    public Integer updateNews(NewsEntity newsEntity) {
        return newsEntityMapper.updateByPrimaryKeySelective(newsEntity);
    }


}
