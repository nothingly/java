package com.woniu.service;

import com.woniu.entity.PageResult;
import com.woniu.pojo.Brand;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniu.vo.BrandVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rsw
 * @since 2022-09-30
 */
public interface IBrandService extends IService<Brand> {

    PageResult search(Integer currentPage, Integer pageSize, BrandVo brandVo);
}
