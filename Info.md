Данный BackEnd развернут в облаке и принимает запросы только на два URL. 

[1] POST-запрос на URL = https://lainer.containers.cloud.ru/auth/signUpJWT \
c "body"(raw) в виде вот такого "JSON" \
   {\
   "login" : "test-usr",\
   "password" : "test-pwd",\
   "roles": ["USER", "ADMIN"]\
   }\
Данный запрос возвращает токен. 

[2] POST-запрос на URL = https://lainer.containers.cloud.ru/auth/signInJWT \
при этом надо задать "Auth Type" = "Bearer Token" и указать токен из первого запроса.