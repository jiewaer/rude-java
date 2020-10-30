package org.qinjie.entity;

import lombok.Data;
import javax.validation.constraints.NotNull;

/**
 * @author jieqin
 */
@Data
public class User {

    @NotNull(message = "用户名不能为空")
    private String userName;

    @NotNull(message = "密码不能为空")
    private String password;

}
