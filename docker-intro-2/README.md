# # build the web service

mvn clean package

# build the docker image

docker build -t kingdaddyfreshness/docker-intro-2:latest -f src/main/docker/Dockerfile .

# push it to a repo

docker push kingdaddyfreshness/docker-intro-2:latest

# run the image

docker run -d -p 9008:8080 kingdaddyfreshness/docker-intro-2:latest

# hit the image with a browser

http://localhost:9008/docker-intro-2-1.0-SNAPSHOT/myresource

# if you want intro-2 and intro-3 to "talk to each other" then do the following

docker network create --driver bridge jmh
docker run -d --expose=8080 -p 9008:8080 --net=jmh --name=SERVER-2 kingdaddyfreshness/docker-intro-2:latest
docker run -d --expose=8080 -p 9009:8080 --net=jmh --name=SERVER-3 kingdaddyfreshness/docker-intro-3:latest
http://localhost:9008/docker-intro-2-1.0-SNAPSHOT/calling
http://localhost:9009/docker-intro-3-1.0-SNAPSHOT/calling