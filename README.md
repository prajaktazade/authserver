# authserver

new user signup :

curl -X POST \
  http://localhost:8080/auth/signup \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 52176e42-67f1-41fc-ae89-a9f3adf97451' \
  -H 'cache-control: no-cache' \
  -d '{
"name":"admin1",
"email":"admin2@admin.com",
"password":"password"
}'


Login / get JWT token

curl -X POST \
  http://localhost:8080/auth/login \
  -H 'Content-Type: application/json' \
  -H 'Postman-Token: 1798d0e8-c01b-4eca-b3dc-ff4af69c0db7' \
  -H 'cache-control: no-cache' \
  -d '{
"name":"admin1",
"email":"admin2@admin.com",
"password":"password"
}'


Third party login : 

The OAuth2 login  initiated by the frontend client by sending the user to the endpoint http://localhost:8080/oauth2/authorize/{provider}?redirect_uri=<redirect_uri_after_login>.

The provider path parameter is one of 'google', 'facebook', or 'github'. The redirect_uri_after_login is the URI to which the user will be redirected once the authentication with the OAuth2 provider is successful. provide relay or homepage url here
