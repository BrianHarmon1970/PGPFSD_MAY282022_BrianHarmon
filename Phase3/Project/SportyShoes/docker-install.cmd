# connect to the mysql container and run the previously installed script to
# create schema and initial (sample) data
docker-compose -f sporty-shoes.yml exec mysql  /bin/bash install-sql.sh


