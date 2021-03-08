/**
 * @description:
 * @author: Andy
 * @time: 2021/03/05 13:28
 */
package com.example.bootapi.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * Created by fanyuexin on 2021/03/05
 */
@ApiModel(value = "Info", description="信息实体")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Info {

    @ApiModelProperty(value = "信息编号", example = "137")
    private Long id;

    @NotNull
    @ApiModelProperty(value = "信息类型", example = "HTML")
    private String type;

    @NotNull
    @ApiModelProperty(value = "信息内容", example = "我是一只小小鸟")
    private String content;
}
