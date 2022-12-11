# docker build -t brianharmon1970/sporty-shoes .
docker build -t ss-ubuntu -f Dockerfile-ubuntu .
docker-compose -f sporty-shoes.yml build
