# Microservicios

## Orden de ejecución
 1. Eureka Server
 2. Los microservicios Empresa y ListaEmpresas
 3. Zuul

## Endpoints

### Empresa

GET, POST: http://localhost:8004/empresa
GET, PUT, DELETE: http://localhost:8004/empresa/{id}

### ListaEmpresas

GET: http://localhost:8005/empresa

### Eureka

http://localhost:8761
