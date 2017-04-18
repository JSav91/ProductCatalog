CREATE DATABASE `mysqldb` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*PRODUCT table*/
CREATE TABLE `mysqldb`.`product` (
  `PRD_ID` INT NOT NULL AUTO_INCREMENT,
  `PRD_NAME` VARCHAR(100) NOT NULL,
  `PRD_PRICE` DOUBLE NOT NULL DEFAULT 0.00,
  `PRD_STOCK` INT NOT NULL DEFAULT 0,
  `PRD_COMMENTS` VARCHAR(255) NULL,
  PRIMARY KEY (`PRD_ID`));
  
/*ATTENDANT table*/
CREATE TABLE `mysqldb`.`attendant` (
  `ATT_ID` INT NOT NULL AUTO_INCREMENT,
  `ATT_NAME` VARCHAR(100) NOT NULL,
  `ATT_ADDRESS` VARCHAR(255) NULL,
  `ATT_MOBILENUM` VARCHAR(20) NULL,
  `ATT_COMMENTS` VARCHAR(255) NULL,
  PRIMARY KEY (`ATT_ID`));
  
INSERT INTO `mysqldb`.`product` (`PRD_ID`, `PRD_NAME`, `PRD_PRICE`, `PRD_STOCK`, `PRD_COMMENTS`) VALUES ('1', 'Guitar', '10000.00', '2', 'Electric');
INSERT INTO `mysqldb`.`product` (`PRD_ID`, `PRD_NAME`, `PRD_PRICE`, `PRD_STOCK`, `PRD_COMMENTS`) VALUES ('2', 'Piano', '20000.00', '7', 'Yamaha');
INSERT INTO `mysqldb`.`product` (`PRD_ID`, `PRD_NAME`, `PRD_PRICE`, `PRD_STOCK`, `PRD_COMMENTS`) VALUES ('3', 'Drums', '3000.00', '1', 'LP');
INSERT INTO `mysqldb`.`product` (`PRD_ID`, `PRD_NAME`, `PRD_PRICE`, `PRD_STOCK`, `PRD_COMMENTS`) VALUES ('4', 'Harp', '70000.00', '2', 'Stoddard and Sons');

INSERT INTO `mysqldb`.`attendant` (`ATT_ID`, `ATT_NAME`, `ATT_ADDRESS`, `ATT_MOBILENUM`, `ATT_COMMENTS`) VALUES ('1', 'Joel Savio', 'Mount Wellington', '0226120699', 'Group 1');
INSERT INTO `mysqldb`.`attendant` (`ATT_ID`, `ATT_NAME`, `ATT_ADDRESS`, `ATT_MOBILENUM`, `ATT_COMMENTS`) VALUES ('2', 'Sharun John', 'New Lynn', '0226786767', 'Group 5');
INSERT INTO `mysqldb`.`attendant` (`ATT_ID`, `ATT_NAME`, `ATT_ADDRESS`, `ATT_MOBILENUM`, `ATT_COMMENTS`) VALUES ('3', 'Ravi Bhatt', 'Avondale', '0224545345', 'Group 2');
