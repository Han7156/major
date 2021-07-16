package majordb.com.tools;

import java.io.Serializable;

/**
 * Created by Hunter on 2021-05-20.
 */
public class CommonResult implements Serializable{
    //标识请求成功与否，如：true（成功）、false（失败）
    private boolean success = true;
    //错误码，如果异常的话则为明确错误码，从而更好的对应业务异常。如果请求成功该值可为空或者“0000”
    private int code = CommonCode.SUCCESS.code;
    //错误消息，与错误码相对应，更具体的描述异常信息。
    private String message = "";
    //返回结果，通常是 Bean 对象对应的 JSON 数据，通常为了应对不同返回值类型，将其声明为泛型类型
    private Object data;

    public CommonResult(boolean success, int code, String message, Object data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    //返回正确结果
    public static CommonResult ok() {
        return new CommonResult(true, CommonCode.SUCCESS.code, "", "");
    }

    public static CommonResult ok(Object data) {
        return new CommonResult(true, CommonCode.SUCCESS.code, "", data);
    }

    public static CommonResult ok(Object data, String message) {
        return new CommonResult(true, CommonCode.SUCCESS.code, message, data);
    }

    //返回错误结果
    public static CommonResult error(String message) {
        return new CommonResult(false, CommonCode.FAIL.code, message, "");
    }

    public static CommonResult error(CommonCode code, String message) {
        return new CommonResult(false, code.code, message, "");
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
