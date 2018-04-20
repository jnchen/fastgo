package cn.wellt.common.domain.rest;

import lombok.Data;

/**
 * Created by caojingchen on 2018/4/20.
 * 操作失败返回结果
 */
@Data
public class FailureResult extends Result{
    public FailureResult(String msg){
        this.setMsg(msg);
    }
    /**
     * 结果重载为默认为true
     */
    private Boolean result = false;
}
