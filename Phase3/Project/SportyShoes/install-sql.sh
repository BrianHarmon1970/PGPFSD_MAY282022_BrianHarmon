# not necessary as the sql script is installed to run on mysql instance initialization
# keeping it as it could be useful for resetting the default shchema and data
# (modified to access the init .sql
#mysql --user=root --password=root < createdb_sportyshoes.sql
mysql --user=root --password=root sportyshoes < ./docker-entrypoint-initdb.d/schema_sportyshoes.sql

