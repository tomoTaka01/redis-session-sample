## Spring Boot Session Sample
  * As of 2018-01-07: Srping Boot version 2.0.0.M7

  * The error occurs
    * The same code works find , if I use Spring Boot version 1.5.9?

```
Whitelabel Error Page
This application has no explicit mapping for /error, so you are seeing this as a fallback.

Sun Jan 07 22:13:13 JST 2018
There was an unexpected error (type=Internal Server Error, status=500).
Failed to convert value of type 'com.example.redissessionsample.domain.User' to required type 'com.example.redissessionsample.domain.User'; nested exception is java.lang.IllegalStateException: Cannot convert value of type 'com.example.redissessionsample.domain.User' to required type 'com.example.redissessionsample.domain.User': no matching editors or conversion strategy found
```

