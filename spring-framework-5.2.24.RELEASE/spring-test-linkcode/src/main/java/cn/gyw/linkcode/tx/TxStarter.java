package cn.gyw.linkcode.tx;

import cn.gyw.linkcode.tx.service.OneService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * @date 2023/4/18
 */
public class TxStarter {

    private static ApplicationContext context;

    public void executeOne() {
        OneService oneService = context.getBean(OneService.class);
        oneService.add();
    }


    public static void start() throws IOException {
        context = new AnnotationConfigApplicationContext(TransactionConfig.class);
        System.in.read();
    }
}
