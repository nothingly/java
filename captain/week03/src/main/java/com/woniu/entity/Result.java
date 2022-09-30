package com.woniu.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("通用的响应对象")
public class Result {
    @ApiModelProperty("响应状态 true: 表示成功 false: 表示失败")
    private Boolean flag;
    @ApiModelProperty("响应的提示信息")
    private String message;
    @ApiModelProperty("响应的数据")
    private Object data;

    public Result(){

    }

    public Result(Boolean flag, String message){
        this.flag = flag;
        this.message = message;
    }

    public Result(Boolean flag, String message, Object data){
        this.flag = flag;
        this.message = message;
        this.data = data;
    }

}
