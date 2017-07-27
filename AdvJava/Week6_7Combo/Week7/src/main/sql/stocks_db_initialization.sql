DROP Database if exists stocks;
CREATE DATABASE stocks;

DROP TABLE IF EXISTS stocks.stock CASCADE;
CREATE TABLE stocks.stock
(
  id        INT          NOT NULL AUTO_INCREMENT,
  symbol VARCHAR(20) NOT NULL,
  price VARCHAR(20) NOT NULL,
  time VARCHAR(20) NOT NULL,
  PRIMARY KEY (id)
);