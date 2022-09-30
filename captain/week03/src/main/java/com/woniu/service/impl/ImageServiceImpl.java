package com.woniu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniu.entity.PageResult;
import com.woniu.pojo.Image;
import com.woniu.mapper.ImageMapper;
import com.woniu.service.IImageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniu.vo.ImageVo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author rsw
 * @since 2022-09-30
 */
@Service
public class ImageServiceImpl extends ServiceImpl<ImageMapper, Image> implements IImageService {

    @Resource
    private ImageMapper imageMapper;


    @Override
    public PageResult searchPage(Integer currentPage, Integer pageSize, ImageVo imageVo) {

        Page<Image> iPage = new Page<>(currentPage, pageSize);

        QueryWrapper<Image> wrapper = new QueryWrapper<>();

        if (imageVo!=null){

            if (!StringUtils.isEmpty(imageVo.getId())){
                wrapper.eq("id",imageVo.getId());
            }
            if (imageVo.getStart()!=null){
                wrapper.gt("start",imageVo.getStart());
            }
            if (imageVo.getEnd()!=null){
                wrapper.lt("end",imageVo.getEnd());
            }

        }

        Page<Image> imagePage = imageMapper.selectPage(iPage, wrapper);

        return new  PageResult(imagePage.getTotal(),imagePage.getRecords());
    }
}
