package com.woniu.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("培训师查询条件的业务实体对象")
public class BrandVo {
    @ApiModelProperty("品牌名称")
    private String name;
    @ApiModelProperty("品牌首字母")
    private String letter;
    @ApiModelProperty("父品牌id")
    private String parentId;

}
