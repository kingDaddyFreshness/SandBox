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