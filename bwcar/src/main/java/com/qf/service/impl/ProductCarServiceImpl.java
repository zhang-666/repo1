package com.qf.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.dao.ProductMapper;
import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.ProductExample;
import com.qf.pojo.ProductWithBLOBs;
import com.qf.service.ProductCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class ProductCarServiceImpl implements ProductCarService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public int addProduct(ProductWithBLOBs productWithBLOBs) {
        return productMapper.insertSelective(productWithBLOBs);
    }

    @Override
    public int delProduct(Integer id) {
        return productMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateProduct(ProductWithBLOBs productWithBLOBs) {
        return productMapper.updateByPrimaryKeyWithBLOBs(productWithBLOBs);
    }

    @Override
    public ProductWithBLOBs findByID(Integer id) {
        return productMapper.selectByPrimaryKey(id);
    }

    @Override
    public DataGridResult findByPage(QueryDTO queryDTO) {
        PageHelper.offsetPage(queryDTO.getOffset(),queryDTO.getLimit());
        ProductExample example = new ProductExample();
        String sort = queryDTO.getSort();
        if(!StringUtils.isEmpty(sort)){
            example.setOrderByClause("id");
        }
        List<ProductWithBLOBs> productWithBLOBs = productMapper.selectByExampleWithBLOBs(example);
        PageInfo<ProductWithBLOBs> info = new PageInfo<>(productWithBLOBs);
        long total = info.getTotal();
        DataGridResult result = new DataGridResult(total,productWithBLOBs);
        return result;
    }
}
