package com.xidian.mall.controller;

import com.github.pagehelper.PageInfo;
import com.xidian.mall.common.ApiRestResponse;
import com.xidian.mall.common.Constant;
import com.xidian.mall.exception.XidianMallExceptionEnum;
import com.xidian.mall.model.pojo.Category;
import com.xidian.mall.model.pojo.User;
import com.xidian.mall.model.request.AddCategoryRequest;
import com.xidian.mall.model.request.UpdateCategoryRequest;
import com.xidian.mall.model.vo.CategoryVO;
import com.xidian.mall.service.CategoryService;
import com.xidian.mall.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

/**
 * @author LDBX
 * 目录Controller
 */

@Controller
public class CategoryController {
    @Autowired
    UserService userService;

    @Autowired
    CategoryService categoryService;

    @ApiOperation("后台添加目录")
    @PostMapping("admin/category/add")
    @ResponseBody
    public ApiRestResponse addCategory(HttpSession session, @Valid @RequestBody AddCategoryRequest addCategoryRequest) {
        User currentUser = (User) session.getAttribute(Constant.XIDIAN_MALL_USER);
        if (currentUser == null) {
            return ApiRestResponse.error(XidianMallExceptionEnum.NEED_LOGIN);
        }
        //校验是否是管理员
        boolean adminRole = userService.checkAdminRole(currentUser);
        if (adminRole) {
            //是管理员，执行操作
            categoryService.add(addCategoryRequest);
            return ApiRestResponse.success();
        } else {
            return ApiRestResponse.error(XidianMallExceptionEnum.NEED_ADMIN);
        }
    }

    @ApiOperation("后台更新目录")
    @PostMapping("admin/category/update")
    @ResponseBody
    public ApiRestResponse updateCategory(@Valid @RequestBody UpdateCategoryRequest updateCategoryRequest, HttpSession session) {
        User currentUser = (User) session.getAttribute(Constant.XIDIAN_MALL_USER);
        if (currentUser == null) {
            return ApiRestResponse.error(XidianMallExceptionEnum.NEED_LOGIN);
        }
        //校验是否是管理员
        boolean adminRole = userService.checkAdminRole(currentUser);
        if (adminRole) {
            //是管理员，执行操作
            Category category = new Category();
            BeanUtils.copyProperties(updateCategoryRequest, category);
            categoryService.update(category);
            return ApiRestResponse.success();
        } else {
            return ApiRestResponse.error(XidianMallExceptionEnum.NEED_ADMIN);
        }
    }

    @ApiOperation("后台删除目录")
    @PostMapping("admin/category/delete")
    @ResponseBody
    public ApiRestResponse deleteCategory(@RequestParam Integer id) {
        categoryService.delete(id);
        return ApiRestResponse.success();
    }

    @ApiOperation("后台目录列表")
    @GetMapping("admin/category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForAdmin(@RequestParam Integer pageNum, @RequestParam Integer pageSize) {
        PageInfo pageInfo = categoryService.listForAdmin(pageNum, pageSize);
        return ApiRestResponse.success(pageInfo);
    }

    @ApiOperation("前台目录列表")
    @GetMapping("category/list")
    @ResponseBody
    public ApiRestResponse listCategoryForCustomer() {
        List<CategoryVO> categoryVOS = categoryService.listCategoryForCustomer(0);
        return ApiRestResponse.success(categoryVOS);
    }
}
