package com.woniu.service;

import com.woniu.entity.PageResult;
import com.woniu.pojo.Image;
import com.baomidou.mybatisplus.extension.service.IService;
import com.woniu.vo.ImageVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author rsw
 * @since 2022-09-30
 */
public interface IImageService extends IService<Image> {

    PageResult searchPage(Integer currentPage, Integer pageSize, ImageVo imageVo);
}
