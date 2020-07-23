# DSFarm
(주)대승바이오팜 배수 펌프 제어 모델

## 환경 설정

### 구동 환경

- Ubuntu 18.04 or Raspberry Pi
- node.js 12.18.3
- npm 6.14.6

### Docker 이용하기

```bash
# Dockerfile build
$ docker build -t dsbiofarm_server .
# docker container create and run
$ docker run -d -p 8080:8080 -v {CURRENT_PATH}:/usr/src/app --name ds_node_server dsbiofarm_server
# server container bash start
$ docker exec -it ds_node_server /bin/bash
```

## 실행하기

```bash
$ node server.js
```