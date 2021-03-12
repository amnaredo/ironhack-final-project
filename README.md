# Full Stack Web Application with Microservices
### Cryptocurrency Portfolio Manager

This project features a simple application to manage cyrptocurrency portfolios with different positions. 
The backend is based in Java, using the Spring Boot lightweight infrastructure with Spring JPA + Hibernate using MySQL database. The structure of the backend side follows a microservices architecture, meaning that the services offered by the application have been developed and implemented independently of each other, including its databases.
The frontend is based in Typescript with Angular as the development framework.
It also takes advantage of an external REST API provided by [CoinGecko](https://www.coingecko.com/es/api), used to fetch all the live information about cryptocurrency markets.

The application developed here let end users to register new portfolios on their profile, and attach them positions with different cryptocurrencies. It also calculates the total value
of the portfolio with the current market price of these currencies, and keeps records about the updates made by the user on these positions.

 
### API Specification
 
#### Admin only
```
/bank/users
```
 - `GET` Read list of all users
``` 
/bank/users/admins
```
 - `GET` Read list of all admins

 - `POST` Create new admin user 
```
/bank/users/owners
```
 - `GET` Read list of all owners
 ```
/bank/users/owners/ah
``` 
 - `POST` Create new account holder
```
/bank/users/owners/tpu
``` 
 - `POST` Create new third party user
 ```
/bank/users/owners/{id}
``` 
 - `GET` Read owner
 ```
/bank/users/owners/{id}/accounts
``` 
 - `GET` Read accounts of an owner
 ```
/bank/accounts
``` 
 - `GET` Read list of all accounts
 ```
/bank/accounts/{id}
 ``` 
 - `PATCH` Update balance of the account
 ```
/bank/accounts/checking/{id}
 ``` 
 - `POST` Create new checking account with owner
 ```
/bank/accounts/checking/{id}/{id}
 ``` 
 - `POST` Create new checking account with two owners
 ```
/bank/accounts/savings/{id}
 ``` 
 - `POST` Create new savings account with owner
 ```
 /bank/accounts/savings/{id}/{id}
 ```
 - `POST` Create new savings account with two owners
 ```
 /bank/accounts/creditcard/{id}
 ```
 - `POST` Create new credit card account with owner
 ```
 /bank/accounts/creditcard/{id}/{id}
 ```
 - `POST` Create new credit card account with two owners
 ```
 /bank/transactions
 ```
 - `GET`  Read list of all transactions
 
#### Auth owner
 ``` 
 /accounts/{id}
 ``` 
 - `GET`  Read account

 - `POST` Create money transfer from account
 ```
 /accounts/{id}/transactions
 ```
 - `GET`  Read list of all transactions of account