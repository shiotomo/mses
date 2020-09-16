FROM adoptopenjdk/openjdk11:alpine-slim

ENV LANG=ja_JP.UTF-8

RUN mkdir /app
WORKDIR /app

COPY . /app

RUN apk --update add tzdata && \
    cp /usr/share/zoneinfo/Asia/Tokyo /etc/localtime && \
    apk del tzdata && \
    rm -rf /var/cache/apk/*
RUN apk add gradle
RUN apk add bash
RUN ./gradlew build

CMD java -Xmx256M -Xms256M -jar -Djava.security.egd=file:/dev/./urandom -Dspring.profiles.active=production build/libs/mses.jar
