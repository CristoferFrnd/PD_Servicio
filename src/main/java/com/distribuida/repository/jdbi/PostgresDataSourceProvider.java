package com.distribuida.repository.jdbi;

import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class PostgresDataSourceProvider implements DataSourceProvider {
    @Override
    public DataSource getDataSource() {
        PGSimpleDataSource dataSource = new PGSimpleDataSource();
        dataSource.setDatabaseName("helidon");
        dataSource.setUser("postgres");

        return null;
    }
}
