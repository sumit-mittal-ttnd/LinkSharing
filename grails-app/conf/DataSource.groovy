dataSourGrailsTestAppce {
    pooled = true
    jmxExport = true
    driverClassName = "com.mysql.jdbc.Driver"
    username = "root"
    password = "Sumit@123"
    url = "jdbc:mysql://localhost:3306/LinkSharing"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
//    cache.region.factory_class = 'org.hibernate.cache.SingletonEhCacheRegionFactory' // Hibernate 3
    cache.region.factory_class = 'org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory' // Hibernate 4
    singleSession = true // configure OSIV singleSession mode
    flush.mode = 'manual' // OSIV session flush mode outside of transactional context
}

// environment specific settings
environments {
    development {
        dataSource {
            driverClassName = "com.mysql.jdbc.Driver"
            username = "root"
            password = "Sumit@123"
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/LinkSharing"
            //url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
	    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
        }
    }
    qa {
        dataSource {
            driverClassName = "com.mysql.jdbc.Driver"
            username = "Sumit-Mittal"
            password = "igdefault"
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/Sumit-Mittal_qa"
            //url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
            dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
        }
    }
    production {
        dataSource {
            driverClassName = "com.mysql.jdbc.Driver"
            username = "root"
            password = "igdefault"
            dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost:3306/Sumit-Mittal_qa"
            //url = "jdbc:h2:mem:devDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
            dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
        }
    }
}
