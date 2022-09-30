package com.woniu.vo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("图片业务实体")
public class ImageVo {

    @ApiModelProperty("图片id")
    private String id;

    @ApiModelProperty("开始时间")
    private Date start;

    @ApiModelProperty("结束时间")
    private Date end;

}
