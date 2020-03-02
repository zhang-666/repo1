package com.qf.service;

import com.qf.dto.ArticleDTO;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.Article;

public interface ArticleService {

    public int addArticle(ArticleDTO articleDTO);

    public void delArt(Long id);

    public int updateArticle(ArticleDTO articleDTO);

    public Article findByID(Long id);

    public DataGridResult findByPage(QueryDTO queryDTO);


}
