/**
 * @description:
 * @author: Andy
 * @time: 2021/03/04 15:26
 */
package com.example.bootdb.bootjdbc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.*;

/**
 * Created by fanyuexin on 2021/03/04
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class User {

    private Long id;

    private String name;

    private Integer age;

    private String email;
}
