基于密码模式+Spring Security OAuth2+JWT的最简授权服务器
======

# 操作方式

### 1. 启动jwt-authserver，端口8080

### 2. 启动jwt-resourceserver，端口8081

### 3. 获取JWT令牌

curl -X POST --user clientapp:112233 "http://localhost:8080/oauth/token?grant_type=password&username=bobo&password=xyz&scope=read_userinfo" -H "accept: application/json" -H "content-type: application/x-www-formurlencoded"

响应案例：

```json
{  
   "access_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjgxMTA5MTQsInVzZXJfbmFtZSI6ImJvYm8iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiMDEyMWIwOGYtMDRkOS00ZjIyLTllYzUtYTZlOTM0MDZhNGU4IiwiY2xpZW50X2lkIjoiY2xpZW50YXBwIiwic2NvcGUiOlsicmVhZF91c2VyaW5mbyJdfQ.9kCLwKOxSAQiYJIKFlfaxnzNfoFwt1LizlC5pmX-sso",
   "token_type":"bearer",
   "refresh_token":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJib2JvIiwic2NvcGUiOlsicmVhZF91c2VyaW5mbyJdLCJhdGkiOiIwMTIxYjA4Zi0wNGQ5LTRmMjItOWVjNS1hNmU5MzQwNmE0ZTgiLCJleHAiOjE1MzA2NTk3MTQsImF1dGhvcml0aWVzIjpbIlJPTEVfVVNFUiJdLCJqdGkiOiJiMWE5ZmVmNi1hNTM1LTQ2OTItOTk1Ni0zMzMxZGQyNDdkYmUiLCJjbGllbnRfaWQiOiJjbGllbnRhcHAifQ.BVFb0rBgGaJJWSL_bN8qGCR962RL05TkVrPY-oR6p3Q",
   "expires_in":43199,
   "scope":"read_userinfo",
   "jti":"0121b08f-04d9-4f22-9ec5-a6e93406a4e8"
}
```

### 4. 调用API

curl -X GET http://localhost:8081/api/userinfo -H "authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MjgxMTA5MTQsInVzZXJfbmFtZSI6ImJvYm8iLCJhdXRob3JpdGllcyI6WyJST0xFX1VTRVIiXSwianRpIjoiMDEyMWIwOGYtMDRkOS00ZjIyLTllYzUtYTZlOTM0MDZhNGU4IiwiY2xpZW50X2lkIjoiY2xpZW50YXBwIiwic2NvcGUiOlsicmVhZF91c2VyaW5mbyJdfQ.9kCLwKOxSAQiYJIKFlfaxnzNfoFwt1LizlC5pmX-sso"

案例响应：

```json
{
    "name": "bobo",
    "email": "bobo@spring2go.com"
}
```
