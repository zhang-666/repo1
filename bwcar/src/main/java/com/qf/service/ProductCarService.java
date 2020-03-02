package com.qf.service;

import com.qf.dto.DataGridResult;
import com.qf.dto.QueryDTO;
import com.qf.pojo.ProductWithBLOBs;

public interface ProductCarService {

    public int addProduct(ProductWithBLOBs productWithBLOBs);

    public int delProduct(Integer id);

    public int updateProduct(ProductWithBLOBs productWithBLOBs);

    public ProductWithBLOBs findByID(Integer id);

    public DataGridResult findByPage(QueryDTO queryDTO);


}
