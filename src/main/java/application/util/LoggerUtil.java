package application.util;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerUtil {
    @Default
    @Produces
    public Logger getLogger(final InjectionPoint ip) {
        return LogManager.getLogger(ip.getMember().getDeclaringClass());
    }
}
