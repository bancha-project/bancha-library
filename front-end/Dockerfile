FROM node:12-alpine
ENV APP_ROOT /app/
WORKDIR $APP_ROOT
COPY package*.json $APP_ROOT
RUN apk update && \
    apk add git && \
    npm install -g npm && \
    npm install -g npm install react-admin
COPY src $APP_ROOT
COPY public $APP_ROOT