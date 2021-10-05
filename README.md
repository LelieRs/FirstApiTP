# API TP

### Utilidad de la app

Nos brinda información con respecto a las personas almacenadas en la base de datos (h2); a su vez, consume otro microservicio
para obtener el cuerpo del libro a través del isbn.

No es necesario estar conectado a alguna VPN y/o base de datos para levantar el programa, pero es nesesario utilizar el postman
para realizar las pegadas a los endpoints.


## Generar una persona:

#### POST: http://localhost:8080/api/persons

##### Ejemplo de body:

```
{
   "name":"Shreek", 
    "lastName":"DelPantano", 
    "dni":12679026,
    "age":35,
    "movies": [
        {
            "name": "Holocausto Canibal",
            "director": "Pepito Pérez", 
            "category": "Horror",
            "price": 4563
        }
    ],
    "isbn":"0307951189"
}

```

```
{
   "name":"Edna", 
    "lastName":"Moda", 
    "dni":86970475,
    "age":42,
    "movies": [
        {
            "name": "White chicks",
            "director": "Jane Doe", 
            "category": "Comedy",
            "price": 10000
        }
    ],
    "isbn":"9781501182099"
}
```

## Obtener a todas las personas:

#### GET: http://localhost:8080/api/persons

##### Ejemplo de bodyResponse:

```
{
    "name": "Shreek",
    "lastName": "DelPantano",
    "dni": 12679026,
    "age": 35,
    "movies": [
        {
            "name": "Holocausto Canibal",
            "director": "Pepito Pérez",
            "category": "Horror",
            "price": 4563,
            "id": 1
        }
    ],
    "book": {
        "isbn": "0307951189",
        "title": "George R. R. Martin",
        "authors": "Originally published as: A game of thrones, 1996.",
        "publisher": "Vintage Espanol",
        "publishedDate": "2012",
        "category": "Juego de Tronos = A Game of Thrones"
    }
}
```


## Obtener personas por parámetro definido:

#### GET: http://localhost:8080/api/persons? -> definir clave-valor del parámetro por el cual realizar la búsqueda. Por ejemplo:

#### http://localhost:8080/api/persons?AgeFrom=25&ageTo=30


## Obtener una persona por dni:

#### GET: http://localhost:8080/api/persons/{dni}

##### Ejemplo de body response:

```
{
    "name": "Shreek",
    "lastName": "DelPantano",
    "dni": 12679026,
    "age": 35,
    "movies": [
        {
            "name": "Holocausto Canibal",
            "director": "Pepito Pérez",
            "category": "Horror",
            "price": 4563,
            "id": 1
        }
    ],
    "book": {
        "isbn": "0307951189",
        "title": "George R. R. Martin",
        "authors": "Originally published as: A game of thrones, 1996.",
        "publisher": "Vintage Espanol",
        "publishedDate": "2012",
        "category": "Juego de Tronos = A Game of Thrones"
    }
}
```
## Actualizar una persona:

#### PUT: http://localhost:8080/api/persons

+
##### Ejemplo de body:

```
"name": "Burro",
    "lastName": "MuyBurro",
    "dni": 12679026,
    "age": 32,
    "movies": [
        {
            "name": "Holocausto Canibal",
            "director": "Pepito Pérez",
            "category": "Horror",
            "price": 4563,
            "id": 1
        }
    ],
    "book": {
        "isbn": "0307951189",
        "title": "George R. R. Martin",
        "authors": "Originally published as: A game of thrones, 1996.",
        "publisher": "Vintage Espanol",
        "publishedDate": "2012",
        "category": "Juego de Tronos = A Game of Thrones"
    }
}
```
## Eliminar una persona:

#### DELETE: http://localhost:8080/api/persons/{dni} 


