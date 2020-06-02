# stage 1
FROM node:latest as builder
WORKDIR /app
COPY . .
RUN npm install
RUN npm run ng build --prod

# stage 2
FROM nginx:alpine

## Remove default nginx index page
RUN rm -rf /usr/share/nginx/html/*
COPY --from=builder /app/dist/ /usr/share/nginx/html/
RUN chmod -R 755 /usr/share/nginx/html/
EXPOSE 8088 80
ENTRYPOINT ["nginx", "-g", "daemon off;"]