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
