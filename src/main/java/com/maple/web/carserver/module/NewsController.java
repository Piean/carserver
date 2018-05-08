package com.maple.web.carserver.module;

import com.maple.web.carserver.domain.NewsEntity;
import com.maple.web.carserver.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private NewsService newsService;

    /**
     * 新闻总数
     *
     * @return
     */
    @RequestMapping("/count")
    public Integer count() {
        return newsService.count();
    }

    /**
     * 分页获取新闻
     *
     * @param pageNumber
     * @return
     */
    @RequestMapping("/selectNewsByPageNumber")
    public List<NewsEntity> selectNewsByPageNumber(Integer pageNumber) {
        return newsService.selectNewsByPageNumber(pageNumber);
    }

    @RequestMapping("/getNewsDetail")
    public NewsEntity getNewsDetail(Integer id) {
        return newsService.getNewsDetail(id);
    }

    /**
     * 添加一条新闻
     *
     * @param newsEntity
     * @return
     */
    @RequestMapping("/addNews")
    public Integer addNews(NewsEntity newsEntity) {
        return newsService.addNews(newsEntity);
    }

    /**
     * 删除一条新闻
     *
     * @param newsId
     * @return
     */
    @RequestMapping("/deleteNews")
    public Integer deleteNews(Integer newsId) {
        return newsService.deleteNews(newsId);
    }

    /**
     * 修改一条新闻
     *
     * @param newsEntity
     * @return
     */
    @RequestMapping("/updateNews")
    public Integer updateNews(NewsEntity newsEntity) {
        return newsService.updateNews(newsEntity);
    }

}
