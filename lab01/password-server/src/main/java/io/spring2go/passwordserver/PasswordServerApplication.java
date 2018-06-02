package io.spring2go.passwordserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PasswordServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordServerApplication.class, args);
	}
}


//curl -X POST --user clientapp:112233 "http://localhost:8080/oauth/token?grant_type=password&username=bobo&password=xyz&scope=read_userinfo" -H "accept: application/json" -H "content-type: application/x-www-formurlencoded"
//curl -X GET http://localhost:8080/api/userinfo -H "authorization: Bearer 5f2be12e-8114-4370-a713-37b58e7c8753"