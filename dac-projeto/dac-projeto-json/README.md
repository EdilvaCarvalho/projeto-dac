Com o terminal aberto no diretório do projeto, execute os comandos abaixo:

docker build -t projetojson/banco ./postgres

docker build -t projetojson/app .

docker run -p 5433:5432 -d --name bancojs projetojson/banco

docker run --name appjs --link bancojs:bancohost projetojson/app

docker exec -it bancojs psql -U postgres


