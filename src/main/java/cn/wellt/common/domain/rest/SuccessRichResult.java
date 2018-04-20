package cn.wellt.common.domain.rest;

import lombok.Data;

/**
 * Created by caojingchen on 2018/4/20.
 * 默认成功的富文本执行结果
 */
@Data
public class SuccessRichResult extends RichResult {
    public SuccessRichResult(String msg,Object content){
        this.setMsg(msg);
        this.setContent(content);
    }
    public SuccessRichResult(Object content){
        this.setContent(content);
    }
    private Boolean result = true;
}
