package ru.lainer.springsecurity.shared.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts.SIG;
import io.jsonwebtoken.security.SignatureAlgorithm;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import ru.lainer.springsecurity.shared.entity.MyUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.io.Decoders;

@Service
@Profile("profileJWT")
public class ServiceJwt {

  @Value("${token.signing.key}")
  private String jwtSigningKey;
  private String loginFromJWT = null;
  private Date expirationDate = null;
  private String passwordFromJWT = null;

  /**
   * @param myUser данные пользователя
   * @return токен из трех частей
   */
  public String generateToken(MyUser myUser)
      throws NoSuchAlgorithmException, InvalidKeySpecException {
    //Извлекаем дополнительные данные для генерации токена
    Map<String, Object> someData = new HashMap<>();
    someData.put("id", myUser.getId());
    /*
     * При генерации используем пароль из myUser, указанный при регистрации нового пользователя
     * Тогда при проведении аутентификации можно будет использовать не только логины (совпадают ли),
     * но и пароли (совпадают ли). Но JWT токен тогда более огромный.
     */
    someData.put("user_pwd", myUser.getPassword());
    someData.put("listRoles", myUser.getListRoles());

    //Генерация токена
    //Для RSA
    SignatureAlgorithm alg = SIG.RS256;
    KeyPair pair = alg.keyPair().build();

    return Jwts.builder().claims(someData).subject(myUser.getUsername())
        .issuedAt(new Date(System.currentTimeMillis()))
        .expiration(new Date(System.currentTimeMillis() + 100000 * 60 * 24))
        .signWith(getSigningKey()).compact(); //Вариант 1
    //.signWith(getSigningKey(), Jwts.SIG.HS256).compact(); //Вариант 2
    //.signWith(pair.getPrivate(), alg).compact(); //Вариант 3 - RSA
  }

  /**
   * Получение ключа для подписи токена
   *
   * @return ключ
   */

  //Вариант 1:: создаем SecretKey на основе ключевого слова
  private SecretKey getSigningKey() {
    byte[] keyBytes = Decoders.BASE64.decode(jwtSigningKey); //HS384
    SecretKey key = Keys.hmacShaKeyFor(keyBytes);
    return key;
  }

  //Вариант 2:: автоматически генерируем SecretKey (без использования ключевого слова)
  /*private SecretKey getSigningKey() {
  SecretKey secretKey = SIG.HS256.key().build();
    System.out.println("SecretKey = " + secretKey.toString());
    return secretKey;
  }*/

  public String extractUserName(String token) {
     /*
     1) метод parser: создаем JwtParserBuilder
     2) метод verifyWith: для JwtParserBuilder устанавливаем SecretKey(для верификации "signature-ы"
        из JWT). Сигнатура - это третья часть токена (после второй точки)
     3) метод build: создаем JwtParser из JwtParserBuilder
     4) метод parseSignedClaims из "token"-а извлекает Claims (Claims-это например:: iat(Issued At),
     exp(Expiration Time))
     5) метод getPayload: извлекает "Payload" из Claims. "Payload" будет тоже типа Claims
     */

    Claims claims = Jwts.parser().verifyWith(getSigningKey()).build().parseSignedClaims(token)
        .getPayload();

    //Извлекаем, на будущее:: время истечения срока службы токена
    expirationDate = claims.getExpiration();

    //Извлекаем пароль из токена, на будущее:: используем при аутентификации
    passwordFromJWT = claims.get("user_pwd", String.class);

    //Если через Bearer Token
    loginFromJWT = claims.getSubject();

    //Если через JWT Bearer
    //login = claims.get("login", String.class);
    return loginFromJWT;
  }

  public boolean isTokenNotExpired(String token) {
    boolean notExpired = false;
    if (loginFromJWT != null) {
      notExpired = expirationDate.after(new Date());
    }
    return notExpired;
  }

  /*
   * Проверяем, совпадают ли логины\пароли из запроса и из БД:: т.е. вручную проводим
   * аутентификацию, так как сам Spring не знает как извлекать userName\password из JWT токена
   * При аутентификации типа FormLogin, Basic:: Spring умеет самостоятельно извлекать логин\пароль
   * из запроса.
   */
  public boolean isLoginAndPwdMatch(String loginFromDB, String passwordFromDB) {
    return loginFromJWT.equals(loginFromDB) && passwordFromJWT.equals(passwordFromDB);
  }

}
