package com.woniu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.woniu.entity.PageResult;
import com.woniu.pojo.Brand;
import com.woniu.mapper.BrandMapper;
import com.woniu.service.IBrandService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.woniu.vo.BrandVo;
import jdk.nashorn.internal.ir.IfNode;
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
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Resource
    private BrandMapper brandMapper;

    @Override
    public PageResult search(Integer currentPage, Integer pageSize, BrandVo brandVo) {
        Page<Brand> iPage = new Page<>(currentPage,pageSize);
        QueryWrapper<Brand> wrapper = new QueryWrapper<>();
        if (brandVo !=null){

            if(!StringUtils.isEmpty(brandVo.getName())){
                wrapper.like("name", brandVo.getName());
            }
            if(brandVo.getLetter() != null){
                wrapper.eq("letter", brandVo.getLetter());
            }
            if (brandVo.getParentId()!=null){
                wrapper.eq("parentId",brandVo.getParentId());
            }
        }

        // 调用mapper进行分页查询
        IPage<Brand> brandIPage = brandMapper.selectPage(iPage, wrapper);
        // 封装返回对象
        return new PageResult(brandIPage.getTotal(), brandIPage.getRecords());
    }
}
