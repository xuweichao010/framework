package exceptions;

public class ExceptionUtils {

    /**
     * 创建业务异常
     *
     * @param message 异常提示
     */
    public static void throwBusinessException(String message) {
        throw new BusinessException(message);
    }

    /**
     * 创建数据约束异常
     */
    public static void throwDataException(String message) {
        throw new DataException(message);
    }

    public static void throwSystemException(String message, Throwable throwable) {
        throw new SystemException(message, throwable.getMessage());
    }
}
