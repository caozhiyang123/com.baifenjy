package cn.itcast.job.config;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.core.ItemReadListener;

import cn.itcast.job.pojo.Message;

public class MessageItemReadListener implements ItemReadListener<Message> {
    private Writer errorWriter;

    public MessageItemReadListener(Writer errorWriter) {
        this.errorWriter = errorWriter;
    }

    public void beforeRead() {
    }

    public void afterRead(Message item) {
    }

    public void onReadError(Exception ex) {
         try
        {
            errorWriter.write(format("%s%n", ex.getMessage()));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private char[] format(String string, String message)
    {
        return string.replace("%s", message).toCharArray();
    }
}