Запуск БД::\
[0] cd /home/source/Документы/SpringSecurity\
[1] sudo docker compose down --remove-orphans\
[2] sudo docker compose up --no-start\
[3] sudo docker compose up\

Разворачиваем backEnd в Докере::\
[1] Maven -> package -> папка "target"           - Упаковать backEnd в jar\
[2] "sudo docker rmi springsecurityimage" - удалить image
    "sudo docker build -t springsecurityimage ." - создать image из Dockerfile\
[3] "sudo docker images"  - список image
[4] "sudo docker compose down --remove-orphans" - останавливаем и удаляем все контейнеры
    "sudo docker compose -f docker-compose.prod.yaml up --no-start"
    "sudo docker compose -f docker-compose.prod.yaml up"

[1] https://jwt.io/



