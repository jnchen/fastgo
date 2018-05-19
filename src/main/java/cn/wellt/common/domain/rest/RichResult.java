package cn.wellt.common.domain.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by caojingchen on 2018/4/20.
 * Rest调用结果 - 富内容
 */
@Data
@ApiModel(description = "返回结果")
public class RichResult extends Result {
    /**
     * 结果的详细内容
     */
    @ApiModelProperty("结果内容")
    private Object content;
}
