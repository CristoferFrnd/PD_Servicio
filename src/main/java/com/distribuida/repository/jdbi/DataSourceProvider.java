package com.distribuida.repository.jdbi;

import javax.sql.DataSource;

public interface DataSourceProvider {
    DataSource getDataSource();
}
