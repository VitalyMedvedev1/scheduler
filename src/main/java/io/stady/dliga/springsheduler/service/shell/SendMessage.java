//package io.stady.dliga.springsheduler.service.shell;
//import lombok.RequiredArgsConstructor;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.shell.standard.ShellComponent;
//import org.springframework.shell.standard.ShellMethod;
//import org.springframework.shell.standard.ShellOption;
//
//@ShellComponent
//@RequiredArgsConstructor
//public class SendMessage {
//
//    private final RabbitTemplate rabbitTemplate;
//
//    @ShellMethod("send")
//    public void send(@ShellOption String text){
//        rabbitTemplate.convertAndSend("FANOUT", null, "vemedvedev:" + text);
//    }
//}