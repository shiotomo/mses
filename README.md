# mses

## リポジトリについて

[msns](https://github.com/shiotomo/mses)の拡張システムです。
Web上で複数のmsnsを管理することができます。

## 環境構築

**application-dev.yml**

`src/main/resources`配下に`application-dev.yml`を以下の内容で設置してください。
{}内は適宜設定してください。

```
spring:
  datasource:
    url: jdbc:mysql://{host}:33062/mses_develop
    username: {username}
    password: {password}
    driverClassName: com.mysql.cj.jdbc.Driver
```


**Database**

```
create database mses_develop
```

**実行時引数**

```
-Djava.security.egd=file:/dev/./urandom
-Dspring.profiles.active=dev
```

## 本番環境

**application-production.yml**

`src/main/resources`配下に`application-production.yml`を以下の内容で設置してください。
{}内は適宜設定してください。

```
spring:
  datasource:
    url: jdbc:mysql://{host}:33062/mses_develop
    username: {username}
    password: {password}
    driverClassName: com.mysql.cj.jdbc.Driver
```


**Database**

```
create database mses_production
```

**Docker**

build

```
docker-compose build
```

up

```
docker-compose up
```
