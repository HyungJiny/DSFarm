FROM ubuntu:18.04

WORKDIR /root

RUN apt update
RUN apt upgrade -y
RUN apt install -y wget vim
RUN wget https://nodejs.org/dist/v12.18.3/node-v12.18.3-linux-x64.tar.xz
RUN tar -xvf node-v12.18.3-linux-x64.tar.xz

WORKDIR /root/node-v12.18.3-linux-x64
RUN cp -R . /usr/local/ 

WORKDIR /usr/src/app

RUN npm install express
RUN npm install onoff
RUN npm install body-parser

EXPOSE 8080
CMD ["node", "server.js"]
