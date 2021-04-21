package study.qi.stream.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import study.qi.stream.service.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @Description 这个业务类不是传统的标注 @Service 注解的业务类，这是和 RabbitMQ 绑定的。定义消息的推送管道
 * @Author qi
 * @Date 2021/4/21 14:42
 * @ClassName MessageProviderImpl
 **/
@EnableBinding(Source.class)
public class MessageProviderImpl implements IMessageProvider {

    /**
     * 消息发送管道
     * 与 RabbitMQ 连接，将消息通过管道发送给 RabbitMQ
     */
    @Resource
    private MessageChannel output;

    @Override
    public String send() {
        // 使用 UUID 模拟要发送的消息
        String serial = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(serial).build());
        System.out.println("***********serial"+serial);

        return null;
    }
}