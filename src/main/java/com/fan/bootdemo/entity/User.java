/**
 * @description:
 * @author: Andy
 * @time: 2021/03/04 15:26
 */
package com.fan.bootdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.*;

/**
 * Created by fanyuexin on 2021/03/04
 */
@ApiModel(value = "User", description="用户实体")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    @ApiModelProperty(value = "用户编号", example = "137")
    private Long id;

    @NotNull
    @Size(min = 2, max = 5)
    @ApiModelProperty(value = "用户姓名", example = "fanyuexin")
    private String name;

    @NotNull
    @Max(100)
    @Min(10)
    @ApiModelProperty(value = "用户年龄",example = "17")
    private Integer age;

    @NotNull
    @Email
    @ApiModelProperty(value = "用户邮箱", example = "123@mail.com")
    private String email;
}
