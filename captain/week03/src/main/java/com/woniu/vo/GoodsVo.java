package com.woniu.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Data;

@Data
@ApiModel("商品查询业务实体对象")
public class GoodsVo {


    @ApiModelProperty("商品名")
    private String name;
    @ApiModelProperty("商品数目")
    private Integer num;
    @ApiModelProperty("商品状态")
    private String status;



}
