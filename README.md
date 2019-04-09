# teacup-java-protocol-http
Java **Te**sting Fr**a**mework for **C**omm**u**nication **P**rotocols and Web Services with HTTP

[![Build Status](https://travis-ci.com/HenryssonDaniel/teacup-java-protocol-http.svg?branch=master)](https://travis-ci.com/HenryssonDaniel/teacup-java-protocol-http) [![Coverage](https://sonarcloud.io/api/project_badges/measure?project=HenryssonDaniel_teacup-java-protocol-http&metric=coverage)](https://sonarcloud.io/dashboard?id=HenryssonDaniel_teacup-java-protocol-http)
## What ##
HTTP version 1.1 and 2 support.  

The framework supports asynchronously and synchronously requests.  

There is also support for an HTTP/HTTPS server.
## Why ##
This makes it possible to test HTTP with the framework, both the client and the server.
## How ##
Add this repository as a dependency.  

The Simple interface holds all the functionality that the HTTP client can do.  
New clients can be created with the Factory class in the client package.

The Simple interface holds all the functionality that the HTTP server can do.  
New servers can be created with the Factory class in the server package.