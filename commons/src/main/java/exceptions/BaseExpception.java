package exceptions;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * 创建人：徐卫超 创建时间：2018/8/15  15:57 功能：整个系统处理异常的基类,发现系统中的异常不属于该基类的，需要对异常进行统一处理
 */
@SuppressWarnings("all")
public abstract class BaseExpception extends RuntimeException {
    private int code;

    private String description;

    public BaseExpception(String message, int code, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    public BaseExpception(String message, Throwable cause, int code, String description) {
        super(message, cause);
        this.code = code;
        this.description = description;
    }

    public String convertString() throws IOException {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        String message = sw.toString();
        if (null != sw) { sw.close(); }
        if (null != pw) { pw.close(); }
        return message;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCode() {
        return code;
    }
}
