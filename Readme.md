[1] Посмотреть, что внутри токена можно вот ту:: https://jwt.io/

Запуск БД::\
[0] cd /home/source/Документы/SpringSecurity\
[1] sudo docker compose down --remove-orphans\
[2] sudo docker compose up --no-start\
[3] sudo docker compose up\

Разворачиваем backEnd в Докере::\
[1] Maven -> package -> папка "target"           - Упаковать backEnd в jar\
[2] "sudo docker rmi springsecurityimage" - удалить image
    "sudo docker build -t springsecurityimage ." - создать image из Dockerfile\
[3] "sudo docker images"  - список image\
[4] "sudo docker compose down --remove-orphans" - останавливаем и удаляем все контейнеры\
    "sudo docker compose -f docker-compose.prod.yaml up --no-start"\
    "sudo docker compose -f docker-compose.prod.yaml up"\

Заливаем "docker image" на виртуальную машину:\
[1] Выдать права::\
    chmod u+x /home/source/Документы/cloud-ru/myPrivateKey\
[2] Подключение к виртуальной машине::\
    sudo ssh -i /home/source/Документы/cloud-ru/myPrivateKey source@45.155.204.208\
[3] Устанавливаем Докер на виртуальную машину::\
[3.1] Присваиваем тег моему Докер-образу::\
sudo docker tag springsecurityimage:latest spring-security-backend.cr.cloud.ru/my-image:lainer\
[3.2] Проходим аутентификацию::\
sudo docker login <registry_name>.cr.cloud.ru -u <key_id> -p <key_secret>\
[3.3] Загрузите артефакт в репозиторий cloud-ru::\
sudo docker push spring-security-backend.cr.cloud.ru/my-image:lainer\

Локальный запуск контейнера\
[1] sudo docker run -d -p 8080:8080 spring-security-backend.cr.cloud.ru/my-image:lainer\
    "sudo docker ps" - список запущенных контейнеров.\
    "sudo docker stop <container_name_or_id>" - остановить запущенный контейнер\

Публичный URL:: https://spring-security-backend-cnt-app.containers.cloud.ru\

[...] Публичный доступ позволяет скачивать артефакты из реестра без авторизации любому пользователю, 
которому известен URI артефакта. После создания реестра тип доступа изменить нельзя.
Добавить в резюме или сюда - ссылку на скачивание образа докера (чтоб локально развернуть)
    
    



