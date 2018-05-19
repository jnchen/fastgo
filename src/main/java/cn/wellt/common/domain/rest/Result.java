package cn.wellt.common.domain.rest;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created by caojingchen on 2018/4/20.
 * REST接口调用结果基类
 */
@Data
@ApiModel(description = "返回结果")
public class Result {
    /**
     * 执行结果 true/false
     */
    @ApiModelProperty("是否成功: true or false")
    private Boolean result;
    /**
     * 结果消息
     */
    @ApiModelProperty("结果描述信息")
    private String msg;
}
