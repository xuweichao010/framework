package exceptions;

/**
 * 创建人：徐卫超 创建时间：2021/2/22 功能：业务异常,只需要对这类异常进行常规操作,返回到调用者即可
 */
public class SystemException extends BaseExpception {

    public SystemException(String message, String description) {
        super(message, 500, description);
    }

    public SystemException(String message, Throwable cause, String description) {
        super(message, cause, 500, description);
    }
}