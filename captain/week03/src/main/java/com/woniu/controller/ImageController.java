package com.woniu.controller;

import com.woniu.entity.PageResult;
import com.woniu.entity.Result;
import com.woniu.pojo.Image;
import com.woniu.service.IImageService;
import com.woniu.vo.ImageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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
@Api(tags = "图片管理")
@RequestMapping("/image")
    public class ImageController extends BaseController{

        @Autowired
        private IImageService imageService;

        @ApiOperation("查询所有图片")
        @GetMapping
        public Result searchAll(){
            List<Image> listImage = imageService.list();

          return toDataResult(listImage,"查询成功") ;

        }
        @ApiOperation("新增图片")
        @PostMapping
        public Result add(@RequestBody Image image){
            boolean flag = imageService.save(image);

            return new Result(flag,"添加成功");

        }
        @ApiOperation("根据id删除图片")
        @DeleteMapping
        public Result delete(@RequestParam String id){
            boolean flag = imageService.removeById(id);
            return new Result(flag,"删除成功");
        }
        @ApiOperation("修改图片")
        @PutMapping
        public Result modify(@RequestBody Image image){
            boolean flag = imageService.updateById(image);
            return new Result(flag,"修改成功");
        }
        @ApiOperation("根据id查询图片")
        @GetMapping ("/{id}")
        public Result searchById(@RequestParam String id){
            Image byId = imageService.getById(id);
            return  toDataResult(byId,"删除成功");
        }

        @ApiOperation("分页查询")
        @PostMapping("search/{currentPage}/{pageSize}")
        public Result searchPage(
                @PathVariable Integer currentPage,
                @PathVariable Integer pageSize,
                @RequestBody ImageVo imageVo
                ){

            PageResult pageResult = imageService.searchPage(currentPage,pageSize,imageVo);

            return toDataResult(pageResult,"查询成功");

        }





        }

