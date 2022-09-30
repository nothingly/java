package com.woniu.controller;

import com.woniu.entity.PageResult;
import com.woniu.entity.Result;
import com.woniu.pojo.Goods;
import com.woniu.service.IGoodsService;
import com.woniu.vo.BrandVo;
import com.woniu.vo.GoodsVo;
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
@Api(tags = "商品管理")
@RequestMapping("/goods")
    public class GoodsController extends BaseController{

        @Autowired
        private IGoodsService goodsService;

        @ApiOperation("查询商品表所有信息")
        @GetMapping
        public Result searchAll(){

            List<Goods> listGoods = goodsService.list();

          return  toDataResult(listGoods,"查询所有成功");

        }

        @ApiOperation("添加商品")
        @PostMapping
        public Result add(@RequestBody Goods goods){
            boolean flag = goodsService.save(goods);
            return new Result(flag,"添加成功");


        }

        @ApiOperation("根据id删除商品")
        @DeleteMapping
        public Result delete(@RequestParam String id){
            boolean flag = goodsService.removeById(id);
            return new Result(flag,"删除成功");
        }


        @ApiOperation("修改商品")
        @PutMapping
        public Result modify(@RequestBody Goods goods){
            boolean flag = goodsService.updateById(goods);
            return new Result(flag,"修改成功");
        }

    @ApiOperation("分页搜索")
    @PostMapping("/search/{currentPage}/{pageSize}")
    public Result search(
            @PathVariable Integer currentPage,
            @PathVariable Integer pageSize,
            @RequestBody GoodsVo goodsVo){
        PageResult pageResult = goodsService.search(currentPage, pageSize, goodsVo);
        return toDataResult(pageResult);
    }

    @ApiOperation("根据id删除商品")
    @GetMapping("/{id}")
    public Result searchById(@PathVariable String id){
        Goods byId = goodsService.getById(id);
        return toDataResult(byId,"查询成功");
    }



}

