package com.woniu.pojo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
  @TableName("t_image")
@ApiModel(value = "Image对象", description = "")
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("图id")
        private String id;

      @ApiModelProperty("图片名字")
      private String name;
  @ApiModelProperty("创建时间 ")
  private Date createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  @ApiModelProperty("修改时间")
  private Date updateTime;
}
