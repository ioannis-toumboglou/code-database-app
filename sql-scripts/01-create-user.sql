CREATE USER 'dbuser'@'localhost' IDENTIFIED BY 'dbuser';

GRANT ALL PRIVILEGES ON * . * TO 'dbuser'@'localhost';

ALTER USER 'dbuser'@'localhost' IDENTIFIED WITH mysql_native_password BY 'dbuser';