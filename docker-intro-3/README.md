# build the web service

mvn clean package

# build the docker image

docker build -t kingdaddyfreshness/docker-intro-3:latest -f src/main/docker/Dockerfile .

# push it to a repo

docker push kingdaddyfreshness/docker-intro-3:latest

# run the image

docker run -d -p 9009:8080 kingdaddyfreshness/docker-intro-3:latest

# hit the image with a browser

http://localhost:9009/docker-intro-3-1.0-SNAPSHOT/myresource