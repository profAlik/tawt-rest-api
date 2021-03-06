package ru.textanalysis.tawt.rest.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.textanalysis.tawt.rest.client.services.*;

@SpringBootApplication
public class TawtRestClientApplication {
    private static final Logger logger = LoggerFactory.getLogger(TawtRestClientApplication.class);

//    public static void main(String[] args) {
//        SpringApplication.run(TawtRestClientApplication.class, args);
//    }

    public static void main(String[] args) {
        try {
            RemoteServiceFactory factory = new RemoteServiceFactory("http://localhost:30002");
            JMorfSdkRemoteService jMorfSdkRemoteService = factory.getJMorfSdkRemoteService();
            GraphematicParserRemoteService graphematicParserRemoteService = factory.getGraphematicParserRemoteService();
            GamaRemoteService gamaRemoteService = factory.getGamaRemoteService();
            SyntaxParserRemoteService syntaxParserRemoteService = factory.getSyntaxParserRemoteService();

            System.out.println(syntaxParserRemoteService.getTreeSentence("я ходил сегодня гулять").getResult());
            /*System.out.println(jMorfSdkRemoteService.getRefOmoFormList("село").getResult());
            System.out.println(graphematicParserRemoteService.parserSentence("я ходил гулять").getResult());
            System.out.println(gamaRemoteService.getMorphSentence("мама мыла раму").getResult());*/
        } catch (Exception ex) {
            logger.warn("Ошибка!", ex);
        }
    }
}
