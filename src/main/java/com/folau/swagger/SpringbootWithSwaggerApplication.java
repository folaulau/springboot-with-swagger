package com.folau.swagger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.management.ManagementFactory;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication
public class SpringbootWithSwaggerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWithSwaggerApplication.class, args);
    }

    @Order(Integer.MAX_VALUE)
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {

            // Display Environmental Useful Variables
            try {
                System.out.println("\n");
                Runtime runtime = Runtime.getRuntime();
                double mb = 1048576;// megabtye to byte
                double gb = 1073741824;// gigabyte to byte
                Environment env = ctx.getEnvironment();
                TimeZone timeZone = TimeZone.getDefault();

                System.out.println("******************* Springboo with Springdoc ************************");
                System.out.println("** Active Profile: " + Arrays.toString(env.getActiveProfiles()));
                System.out.println("** Timezone: " + timeZone.getID());
                System.out.println("** TimeStamp: " + new Date().toInstant().toString());

                System.out.println("** Url: http://localhost:8080");
                System.out.println("** Swagger: http://localhost:8080/swagger-ui/index.html");


                System.out.println("************************* Java - JVM *********************************");
                System.out.println("** Number of processors: " + runtime.availableProcessors());
                String processName = ManagementFactory.getRuntimeMXBean().getName();
                System.out.println("** Process ID: " + processName.split("@")[0]);
                System.out.println("** Total memory: " + (runtime.totalMemory() / mb) + " MB = " + (runtime.totalMemory() / gb) + " GB");
                System.out.println("** Max memory: " + (runtime.maxMemory() / mb) + " MB = " + (runtime.maxMemory() / gb) + " GB");
                System.out.println("** Free memory: " + (runtime.freeMemory() / mb) + " MB = " + (runtime.freeMemory() / gb) + " GB");
                System.out.println();
                System.out.println("**********************************************************************");

            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Exception, commandlineRunner -> " + e.getMessage());
            }
            System.out.println("\n");
        };
    }
}
