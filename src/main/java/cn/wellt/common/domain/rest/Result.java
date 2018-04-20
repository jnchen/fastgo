package cn.wellt.common.domain.rest;

import lombok.Data;

/**
 * Created by caojingchen on 2018/4/20.
 * REST接口调用结果基类
 */
@Data
public class Result {
    /**
     * 执行结果 true/false
     */
    private Boolean result;
    /**
     * 结果消息
     */
    private String msg;
}
