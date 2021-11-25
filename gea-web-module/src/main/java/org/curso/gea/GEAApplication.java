package org.curso.gea;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class GEAApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(GEAApplication.class);

    public static void main(String[] args) {
        var springApplication = new SpringApplication(GEAApplication.class);
        Environment environment = springApplication.run(args).getEnvironment();
        logApplicationStarup(environment);
    }

    private static void logApplicationStarup(Environment env) {
        var protocol = Optional.ofNullable(env.getProperty("server.ssl.key-store"))
                .map(key -> "https")
                .orElse("http");
        var serverPort = env.getProperty("server.port");
        var contextPath = Optional
                .ofNullable(env.getProperty("server.servlet.context-path"))
                .filter(StringUtils::isNotBlank)
                .orElse("/");
        var hostAddress = "localhost";

        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            LOGGER.warn("The host name could not be determined, using 'localhost' as fallback");
        }

        var textBlock = """
                
                ----------------------------------------------------------
                    Application "%s" is running! Access URLs:
                    Local:              %s://localhost:%s%s
                    External:           %s://%s:%s%s
                    Active Profile(s):  %s
                    Default Profile(s): %s
                ----------------------------------------------------------
                """.formatted(env.getProperty("spring.application.name"),
                            protocol,
                            serverPort,
                            contextPath,
                            protocol,
                            hostAddress,
                            serverPort,
                            contextPath,
                            Arrays.toString(env.getActiveProfiles()),
                            Arrays.toString(env.getDefaultProfiles()));
        LOGGER.info(textBlock);
    }
}
