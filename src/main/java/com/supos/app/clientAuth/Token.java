package com.supos.app.clientAuth;

import com.supos.app.pojo.Vo;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

/**
 * @author chenfei
 * @date 2020年3月11日 上午9:42:33
 */
@Slf4j
@ToString
public class Token extends Vo {
    private static final long serialVersionUID = 6082812816657816459L;

    /**
     * 验证TOKEN
     */
    @Setter
    @Getter
    private String accessToken;
    /**
     * 刷新TOKEN
     */
    @Setter
    @Getter
    private String refreshToken;
    /**
     * 过期时间（毫秒）
     */
    @Setter
    @Getter
    private String expiresIn;

}
