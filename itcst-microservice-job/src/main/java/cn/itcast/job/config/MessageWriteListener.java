package cn.itcast.job.config;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.springframework.batch.core.ItemWriteListener;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.job.pojo.Message;

public class MessageWriteListener implements ItemWriteListener<Message> {

    @Autowired
    private Writer errorWriter;

    public void beforeWrite(List<? extends Message> items){
        
    }

    public void afterWrite(List<? extends Message> items){
    }

    public void onWriteError(Exception exception, List<? extends Message> items){
        try
        {
            errorWriter.write(format("%s%n", exception.getMessage()));
            for (Message message : items) {
                errorWriter.write(format("Failed writing message id: %s", message.getObjectId()));
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private char[] format(String string, Object obj)
    {
        return string.replace("%s",obj.toString()).toCharArray();
    }
}