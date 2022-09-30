package com.woniu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniu.entity.PageResult;
import com.woniu.pojo.Goods;
import com.woniu.mapper.GoodsMapper;
import com.woniu.service.IGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniu.vo.GoodsVo;
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
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Resource
    private GoodsMapper goodsMapper;


    @Override
    public PageResult search(Integer currentPage, Integer pageSize, GoodsVo goodsVo) {
        Page<Goods> iPage = new Page<>(currentPage,pageSize);

        QueryWrapper<Goods> wrapper = new QueryWrapper<>();

        if (goodsVo !=null){

            if (!StringUtils.isEmpty(goodsVo.getName())){
                    wrapper.like("name", goodsVo.getName());
            }
            if (goodsVo.getNum()!=null){
                wrapper.gt("num",goodsVo.getNum());
            }
            if (goodsVo.getStatus()!=null){
                wrapper.eq("status",goodsVo.getStatus());
            }
        }

        Page<Goods> goodsPage = goodsMapper.selectPage(iPage, wrapper);

        return new PageResult(goodsPage.getTotal(),goodsPage.getRecords());
    }
}
