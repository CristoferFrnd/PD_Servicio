package com.distribuida.config;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.ConfigProvider;
import org.jdbi.v3.core.Jdbi;
import org.jdbi.v3.sqlobject.SqlObjectPlugin;

public class Postgres {
    public Jdbi getJdbi() {
        Config config = ConfigProvider.getConfig();
        String dbUser = config.getValue("db.user",String.class);
        String dbPassword = config.getValue("db.password",String.class);
        String dbUrl = config.getValue("db.url",String.class);
        Jdbi jdbi = Jdbi.create(dbUrl, dbUser, dbPassword);
        jdbi.installPlugin(new SqlObjectPlugin());
        return jdbi;
    }
}
