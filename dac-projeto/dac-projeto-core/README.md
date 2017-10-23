Com o terminal aberto no diretório do projeto, execute os comandos abaixo:

docker build -t projetocore/app .

docker run -p 8080:8080 --name appcore --link bancodac:bancohost projetocore/app



