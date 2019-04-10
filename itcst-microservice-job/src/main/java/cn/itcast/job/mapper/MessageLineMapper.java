package cn.itcast.job.mapper;


import java.util.Date;

import org.springframework.batch.item.file.LineMapper;

import com.fasterxml.jackson.databind.MappingJsonFactory;

import cn.itcast.job.pojo.Message;
import cn.itcast.job.util.TimeUtils;

public class MessageLineMapper implements LineMapper<Message> {
    private MappingJsonFactory factory = new MappingJsonFactory();

    public Message mapLine(String line, int lineNumber) throws Exception
    {
        Message message = new Message();
        /*JsonParser parser = factory.createParser(line);
        Map<String, Object> map = (Map) parser.readValueAs(Map.class);
        for (Map.Entry<String, Object> maps : map.entrySet())
        {
        }*/
        message.setContent(line);
        message.setCreatedTime(TimeUtils.getSimpleDateFormat().format(new Date()));
        message.setLastModifiedTime(TimeUtils.getSimpleDateFormat().format(new Date()));
        return message;
    }
}