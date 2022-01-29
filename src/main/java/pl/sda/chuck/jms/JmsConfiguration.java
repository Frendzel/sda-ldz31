//package pl.sda.chuck.jms;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.jms.core.JmsTemplate;
//
//import java.util.Arrays;
//import java.util.List;
//
//import static org.apache.activemq.ActiveMQConnection.DEFAULT_BROKER_URL;
//
//@Configuration
//public class JmsConfiguration {
//
//    @Bean
//    public ActiveMQConnectionFactory connectionFactory(){
//        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
//        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
//        connectionFactory.setTrustedPackages(List.of("pl.sda.chuck"));
//        return connectionFactory;
//    }
//
//    @Bean
//    public JmsTemplate jmsTemplate(){
//        JmsTemplate template = new JmsTemplate();
//        template.setConnectionFactory(connectionFactory());
//        template.setDefaultDestinationName("messageBox");
//        return template;
//    }
//}
