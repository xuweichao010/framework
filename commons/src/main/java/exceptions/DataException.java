package exceptions;

/**
 * 创建人：徐卫超
 * 创建时间：2021/2/22
 * 功能：业务异常,只需要对这类异常进行常规操作,返回到调用者即可
 */
public class DataException extends BaseExpception {
    public DataException(String message) {
        super(message, 501, null);
    }
}