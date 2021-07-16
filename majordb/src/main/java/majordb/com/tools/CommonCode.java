package majordb.com.tools;

/**
 * Created by Hunter on 2021-05-20.
 */
public enum  CommonCode {

    // 成功
    SUCCESS(200),

    // 失败
    FAIL(400),

    // 未认证（签名错误）
    UNAUTHORIZED(401),

    // 接口不存在
    NOT_FOUND(404),

    // 服务器内部错误
    INTERNAL_SERVER_ERROR(500);

    public int code;

    CommonCode(int code) {
        this.code = code;
    }

}
