package com.woniu.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 *
 * </p>
 *
 * @author rsw
 * @since 2022-09-30
 */
@Getter
@Setter
  @TableName("t_goods")
@ApiModel(value = "Goods对象", description = "")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("主键")
        private String id;

      @ApiModelProperty("商品名称")
      private String name;

      @ApiModelProperty("商品价格")
      private BigDecimal price;

      @ApiModelProperty("库存数量")
      private Integer num;
      @TableField(fill = FieldFill.INSERT)
      @ApiModelProperty("创建时间 ")
      private Date createTime;
      @TableField(fill = FieldFill.INSERT_UPDATE)
      @ApiModelProperty("修改时间")
      private Date updateTime;

      @ApiModelProperty("是否删除：0：未删除 1：已删除")
      private String status;

      @ApiModelProperty("是否删除0删除1未删除")
      private String isDelete;

      @ApiModelProperty("商品主图片（列表页）")
      private String image;

       @ApiModelProperty("所属品牌")
       private String brandId;

       @ApiModelProperty("所属品牌的父品牌")
       private String brandParentId;
}
