package teamup.p2backend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.log4j.Logger;

@SpringBootApplication
public class P2BackendApplication {
    static Logger log = Logger.getLogger(P2BackendApplication.class.getName());
    public static void main(String[] args) {
        log.info("Initiating Backend Logs");
        SpringApplication.run(P2BackendApplication.class, args);
    }

}
