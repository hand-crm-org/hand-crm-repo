package com.hand.frame.model;

/**
 * 定义非查询操作返回体
 * @author nan.yao@hand-china.com 2019/9/16 17:07
 */
public class ResultDTO {
    private final static int SUCCESS = 200;
    private final static int ERROR = 500;
    private Integer code;
    private String msg;
    private Boolean success;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public static ResultDTO success(String msg){
        ResultDTO dto = new ResultDTO();
        dto.setCode(SUCCESS);
        dto.setSuccess(true);
        dto.setMsg(msg);
        return dto;
    }
    public static ResultDTO success(){
        ResultDTO dto = new ResultDTO();
        dto.setCode(SUCCESS);
        dto.setSuccess(true);
        return dto;
    }
    public static ResultDTO error(String msg){
        ResultDTO dto = new ResultDTO();
        dto.setCode(ERROR);
        dto.setSuccess(false);
        dto.setMsg(msg);
        return dto;
    }

    @Override
    public String toString() {
        return "ResultDTO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }
}
