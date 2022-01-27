# Microservice product

### Endpoints:

#### save Custom Product

````
POST /api/product/custom HTTP/1.1
Host: localhost:3333
Authorization: Basic  base64(username:password)
Content-Type: application/json
Content-Length: 50

{
"name":"gucci",
"price":4000,
"typeOf": "BETA"
}
````
#### Update Product

````
PUT /api/product HTTP/1.1
Host: localhost:3333
Authorization: Basic Basic  base64(username:password)
Content-Type: application/json
Content-Length: 76

{ 
    "id":1,
    "name":"gucci",
    "price":3000,
    "typeOf": "ALPHA"
}
````

#### Get Product By ID

````
GET /api/product/getProduct/1 HTTP/1.1
Host: localhost:3333
Authorization: Basic  base64(username:password)
````

#### Get All Product

````
GET /api/product HTTP/1.1
Host: localhost:3333
Authorization: Basic base64(username:password)
````

#### Delete Product By ID

````
DELETE /api/product/2 HTTP/1.1
Host: localhost:3333
Authorization: Basic Basic base64(username:password)
````
