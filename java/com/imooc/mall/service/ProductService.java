package com.imooc.mall.service;

import com.github.pagehelper.PageInfo;
import com.imooc.mall.model.pojo.Category;
import com.imooc.mall.model.pojo.Product;
import com.imooc.mall.model.request.AddCategoryRequest;
import com.imooc.mall.model.request.AddProductRequest;
import com.imooc.mall.model.request.ProductListRequest;
import com.imooc.mall.model.vo.CategoryVO;

import java.util.List;

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
