package com.niuma.huijia.model.vo;

import com.niuma.huijia.model.domain.Im;
import lombok.Data;

/**
 * @author niuma
 * @create 2023-02-10 17:21
 */
@Data
public class ImMessageVo {

    /**
     * 消息类型
     */
    private Integer type;

    /**
     * 消息
     */
    private Im im;

}
