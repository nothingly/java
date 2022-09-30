package com.woniu.controller;

import com.woniu.entity.PageResult;
import com.woniu.entity.Result;
import com.woniu.pojo.Brand;
import com.woniu.pojo.Goods;
import com.woniu.service.IBrandService;
import com.woniu.vo.BrandVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author rsw
 * @since 2022-09-30
 */
@RestController
@Api(tags = "品牌表")
@RequestMapping("/brand")
    public class BrandController extends BaseController{

        @Autowired
        private IBrandService brandService;

    @ApiOperation("查询品牌表所有信息")
    @GetMapping
    public Result searchAll(){

        List<Brand> listBrands = brandService.list();

        return toDataResult(listBrands,"查询所有成功");

    }

    @ApiOperation("添加品牌")
    @PostMapping
    public Result add(@RequestBody Brand brands){
        boolean flag = brandService.save(brands);
        return new Result(flag,"添加成功");


    }

    @ApiOperation("根据id删除品牌")
    @DeleteMapping
    public Result delete(@RequestParam String id){
        boolean flag = brandService.removeById(id);
        return new Result(flag,"删除成功");
    }


    @ApiOperation("根据id修改品牌表中得品牌")
    @PutMapping
    public Result modify(@RequestBody Brand brands){
        boolean flag = brandService.updateById(brands);
        return new Result(flag,"修改成功");
    }


    @ApiOperation("分页搜索")
    @PostMapping("/search/{currentPage}/{pageSize}")
    public Result search(
            @PathVariable Integer currentPage,
            @PathVariable Integer pageSize,
            @RequestBody BrandVo brandVo){
        PageResult pageResult = brandService.search(currentPage, pageSize, brandVo);
        return toDataResult(pageResult);
    }

    @ApiOperation("根据id查询")
    @GetMapping("/{id}")
    public Result searchById(@PathVariable String id){
        Brand brand = brandService.getById(id);
        return toDataResult(brand,"删除成功");
    }






}

