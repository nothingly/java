package com.woniu.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
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
  @TableName("t_brand")
@ApiModel(value = "Brand对象", description = "")
public class Brand implements Serializable {

    private static final long serialVersionUID = 1L;

      @ApiModelProperty("主键")
        private String id;

      @ApiModelProperty("品牌名称")
      private String name;

      @ApiModelProperty("父品牌首字母")
      private String letter;

      @ApiModelProperty("父品牌id")
      private String parentId;

      @ApiModelProperty("父品牌图片")
      private String image;
}
