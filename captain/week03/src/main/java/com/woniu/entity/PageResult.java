package com.woniu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor // 无参构造方法
@AllArgsConstructor // 全参的构造方法
@ApiModel("分页数据封装对象")
public class PageResult {
    @ApiModelProperty("总记录数")
    private Long total;
    @ApiModelProperty("分页查询数据")
    private Object data;
}
