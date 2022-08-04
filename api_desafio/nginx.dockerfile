FROM nginx:latest
LABEL maintainer="Alisson"
COPY /nginx/app.conf /etc/nginx/nginx.conf
RUN chmod 755 -R /usr/share/nginx/html
EXPOSE 80 443
ENTRYPOINT ["nginx"]
# Parametros extras para o entrypoint
CMD ["-g", "daemon off;"]