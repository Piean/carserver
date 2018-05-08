package com.maple.web.carserver.module;

import com.maple.web.carserver.domain.GoodsEntity;
import com.maple.web.carserver.service.GoodsService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;


    /**
     * 商品总数
     * @return
     */
    @RequestMapping("/count")
    public Integer count() {
        return goodsService.count();
    }

    @RequestMapping("/getAll")
    public List<GoodsEntity>getAll(){
        return goodsService.getAll();
    }

    /**
     * 分页获取商品信息
     * @param pageNumber
     * @return
     */
    @RequestMapping("/selectByPageNumber")
    public List<GoodsEntity> selectByPageNumber(Integer pageNumber) {
        return goodsService.selectByPageNumber(pageNumber);
    }

    /**
     * 商城某个商品
     * @param id
     * @return
     */
    @RequestMapping("/delete")
    public Integer delete(Integer id) {
        return goodsService.deleteByPrimaryKey(id);
    }

    /**
     * 添加一个商品
     * @param goodsEntity
     * @return
     */
    @RequestMapping("/insert")
    public Integer insert(GoodsEntity goodsEntity) {
        return goodsService.insert(goodsEntity);
    }

    /**
     * 修改商品信息
     * @param goodsEntity
     * @return
     */
    @RequestMapping("/update")
    public Integer update(GoodsEntity goodsEntity) {
        return goodsService.update(goodsEntity);
    }

    /**
     * 图片本地上传
     * @param pic
     * @param request
     * @return
     */
    @RequestMapping("/uploadImage")
    public String uploadImage(MultipartFile pic, HttpServletRequest request) {
        if (!pic.isEmpty() && pic.getContentType().contains("image")) {
            try {
                // 获取图片的文件名
                String fileName = pic.getOriginalFilename();
                // 获取图片的扩展名
                String extensionName = StringUtils.substringAfter(fileName, ".");
                // 新的图片文件名 = 获取时间戳+"."图片扩展名
                String newFileName = String.valueOf(System.currentTimeMillis()) + "." + extensionName;

                // 文件绝对路径
                ApplicationHome home = new ApplicationHome(getClass());
                File jarFile = home.getSource();
                String filePath = jarFile.getPath();
                filePath += "/static/images/";
//                String filePath = request.getSession().getServletContext().getRealPath("/images/");

                File dest = new File(filePath, newFileName);
                if (!dest.getParentFile().exists()) {
                    dest.getParentFile().mkdirs();
                }
                // 上传到指定目录
                pic.transferTo(dest);
                // 将反斜杠转换为正斜杠
                String data = "/static/images/" + newFileName;
                return data;

            } catch (Exception e) {
                e.printStackTrace();
                return "";
            }
        } else {
            return "";
        }
    }
}
