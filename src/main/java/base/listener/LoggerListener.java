package base.listener;

import org.springframework.web.util.Log4jConfigListener;
import org.slf4j.bridge.SLF4JBridgeHandler;
import javax.servlet.ServletContextEvent;

/**
 * Created by lkq on 2016/12/13.
 */
public class LoggerListener extends Log4jConfigListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        installJulToSlf4jBridge();
        super.contextInitialized(event);
    }
    private void installJulToSlf4jBridge(){
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }
}
