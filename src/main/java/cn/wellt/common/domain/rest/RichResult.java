package cn.wellt.common.domain.rest;

import lombok.Data;

/**
 * Created by caojingchen on 2018/4/20.
 * Rest调用结果 - 富内容
 */
@Data
public class RichResult extends Result {
    /**
     * 结果的详细内容
     */
    private Object content;
}
