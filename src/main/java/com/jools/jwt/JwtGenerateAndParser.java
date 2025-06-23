package com.jools.jwt;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.cron.CronUtil;
import cn.hutool.crypto.asymmetric.RSA;
import io.jsonwebtoken.*;
import org.jose4j.jwk.JsonWebKey;
import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.lang.JoseException;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

/**
 * @author Jools He
 * @version 1.0
 * @date 2025/2/14 9:56
 * @description: TODO
 */
public class JwtGenerateAndParser {

    private String signature;
    private static final int EXPIRE_TIME = 60 * 60 * 1000;

    @Before
    public void init() throws JoseException {
        this.signature = "signature";
    }

    @Test
    public void JwtGenAndParse() {

        JwtBuilder jwtBuilder = Jwts.builder();
        Date now = new Date(System.currentTimeMillis());
        String jwtStr = jwtBuilder
                // header
                .setHeaderParam("alg", "RS2048")
                .setHeaderParam("typ", "JWT")
                // payload
                .claim("scope", "[admin, user]")
                .claim("username", "Jools He")
                .claim("role", "admin")
                .setSubject("test-admin-Jwt")
                // 设置过期时间，当前时间 + 一天
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_TIME))
                // 设置唯一标识符 id
                .setId(UUID.randomUUID().toString().substring(0, 11))
                // 设置签名和算法
                .signWith(SignatureAlgorithm.HS256, signature)
                .compact();

        System.out.println("生成的 JWT 字符串:" + jwtStr);
        /*
         输出:
         生成的 JWT 字符串:
         eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.
         eyJzdWIiOiJ0ZXN0LWFkbWluLUp3dCIsInVzZXJuYW1lIjoiSm9vbHMgSGUiLCJyb2xlIjoiYWRtaW4iLCJleHAiOjE3Mzk1MDMwNTYsImp0aSI6ImUxMjA4YjhjLTgyIn0.
         5OmozOGIJCUhLQO1wf-FY8wxcBGVUpEiuCJGAQdV8uQ
        */

        // 解密
        JwtParser parser = Jwts.parser();
        Jws<Claims> claimsJws = parser.setSigningKey(this.signature).parseClaimsJws(jwtStr);
        Claims claims = claimsJws.getBody();
        // 取出数据
        System.out.println(claims.getSubject());    // test-admin-Jwt
        System.out.println(claims.get("username")); // Jools He
        System.out.println(claims.get("role"));     // admin
        System.out.println(claims.get("scope"));    // [admin, user]
        System.out.println(claims.getId());
        System.out.println(claims.getExpiration()); //
    }
}
