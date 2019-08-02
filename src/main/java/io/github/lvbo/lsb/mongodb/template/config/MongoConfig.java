package io.github.lvbo.lsb.mongodb.template.config;

import com.github.mongobee.Mongobee;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

@Configuration
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongodbUri;

    @Primary
    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate() throws Exception {
        MappingMongoConverter converter =
                new MappingMongoConverter(new DefaultDbRefResolver(mongoFactory()), new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        return new MongoTemplate(mongoFactory(), converter);
    }

    @Bean
    @Primary
    public MongoDbFactory mongoFactory() throws Exception {
        MongoClient client = new MongoClient(new MongoClientURI(mongodbUri));
        return new SimpleMongoDbFactory(client, "myDB");
    }

    @Bean
    public Mongobee mongobee(){
        Mongobee runner = new Mongobee(mongodbUri);
        runner.setDbName("myDB");
        runner.setChangeLogsScanPackage("io.github.lvbo.lsb.mongodb.template.changelogs");
        return runner;
    }
}

