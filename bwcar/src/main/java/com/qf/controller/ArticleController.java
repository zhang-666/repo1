package com.qf.controller;

import com.qf.dto.ArticleDTO;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.Article;
import com.qf.service.ArticleService;
import com.qf.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/sys/article/list")
    @ResponseBody
    public DataGridResult findArtitile(QueryDTO queryDTO){
        return articleService.findByPage(queryDTO);
    }

    @RequestMapping("/sys/article/del")
    @ResponseBody
    public R delArititle(@RequestBody List<Long> ids){
        for (Long id : ids) {
            articleService.delArt(id);
        }
        return R.ok();
    }

    @RequestMapping("/sys/article/info/{id}")
    @ResponseBody
    public R findById(@PathVariable("id") Long id){
        Article byID = articleService.findByID(id);
        return R.ok().put("article",byID);
    }

    @RequestMapping("/sys/article/save")
    @ResponseBody
    public R addArtitle(@RequestBody ArticleDTO articleDTO){
        int i = articleService.addArticle(articleDTO);
        return i>0?R.ok():R.error("添加失败");
    }

    @RequestMapping("/sys/article/update")
    @ResponseBody
    public R updateArtitle(@RequestBody ArticleDTO articleDTO){
        int i = articleService.updateArticle(articleDTO);
        return i>0?R.ok():R.error("修改失败");
    }

    @RequestMapping("/ytupload")
    @ResponseBody
    public R upload(@RequestParam("mypic") MultipartFile multipartFile, HttpServletRequest request){
        //得到文件名称
        String filename = multipartFile.getOriginalFilename();
        //上传的目的地,不做分布式，只是存储在本质,同时不考虑文件名重复的问题
        File dest = new File("D:\\certs\\"+filename);
        try {
            multipartFile.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return R.ok().put("file",filename);
    }

}
