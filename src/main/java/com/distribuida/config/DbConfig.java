package com.distribuida.config;

import com.distribuida.db.Book;
import com.distribuida.repository.BookDao;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;
import org.postgresql.ds.PGSimpleDataSource;

import java.util.List;

@ApplicationScoped
public class DbConfig {
    @Inject
    @ConfigProperty(name="db.url")
    String dbUrl;
    @Inject
    @ConfigProperty(name="db.user")
    String dbUser;

    @Inject
    @ConfigProperty(name="db.password")
    String dbPassword;
   @Inject
    @PostConstruct
    public void init(){

    }

    public void test(){
        init();
    }
}

