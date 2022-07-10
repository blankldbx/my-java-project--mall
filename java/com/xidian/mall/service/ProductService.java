package com.xidian.mall.service;

import com.github.pagehelper.PageInfo;
import com.xidian.mall.model.pojo.Product;
import com.xidian.mall.model.request.AddProductRequest;
import com.xidian.mall.model.request.ProductListRequest;

/**
 * @author LDBX
 * 商品Service
 */
public interface ProductService {

    void add(AddProductRequest addProductRequest);

    void update(Product updateProduct);

    void delete(Integer id);

    void batchUpdateSellStatus(Integer[] ids, Integer sellStatus);

    PageInfo listForAdmin(Integer pageNum, Integer pageSize);

    Product detail(Integer id);

    PageInfo list(ProductListRequest productListRequest);
}
