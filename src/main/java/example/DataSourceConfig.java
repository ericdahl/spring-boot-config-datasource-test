package example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@RefreshScope
@Configuration
public class DataSourceConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);

    @RefreshScope
    @Bean
    public DataSource customDataSource() {
        final String url = "jdbc:h2:mem:customDb;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE";

        LOGGER.info("Creating in-memory h2 database with jdbc url [{}]", url);
        return DataSourceBuilder
                .create()
                .driverClassName(EmbeddedDatabaseConnection.H2.getDriverClassName())
                .url(url)
                .username("sa")
                .password("")
                .build();

    }
}
