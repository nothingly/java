package com.woniu.service;

import com.woniu.entity.PageResult;
import com.woniu.pojo.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniu.vo.GoodsVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rsw
 * @since 2022-09-30
 */
public interface IGoodsService extends IService<Goods> {

    PageResult search(Integer currentPage, Integer pageSize, GoodsVo goodsVo);
}
