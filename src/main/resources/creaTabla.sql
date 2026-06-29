-- Seleccion
CREATE DATABASE IF NOT EXISTS techshop_db;
USE techshop_db;

CREATE USER IF NOT EXISTS 'mateo31'@'%' IDENTIFIED BY '113490257';
ALTER USER 'mateo31'@'%' IDENTIFIED BY '113490257';

GRANT ALL PRIVILEGES ON techshop_db.* TO 'mateo31'@'%';
FLUSH PRIVILEGES;

-- Est y datos de tabla producto
DROP TABLE IF EXISTS producto;

CREATE TABLE producto (
    id_producto INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    marca VARCHAR(50) NOT NULL,
    precio DOUBLE NOT NULL,
    cantidad_inventario INT NOT NULL
);

INSERT INTO producto (nombre, marca, precio, cantidad_inventario) VALUES ('Monitor Gamer 24"', 'ASUS', 125000.00, 15);
INSERT INTO producto (nombre, marca, precio, cantidad_inventario) VALUES ('Teclado Mecánico RGB', 'Corsair', 45000.00, 20);
INSERT INTO producto (nombre, marca, precio, cantidad_inventario) VALUES ('Mouse Óptico Inalámbrico', 'Logitech', 25000.00, 35);
INSERT INTO producto (nombre, marca, precio, cantidad_inventario) VALUES ('Auriculares Surround 7.1', 'HyperX', 60000.00, 12);

-- ====================================================
-- Est y datos de tabla bike
-- ====================================================
DROP TABLE IF EXISTS bike;

CREATE TABLE bike (
    id_bike INT AUTO_INCREMENT PRIMARY KEY,
    marca VARCHAR(30),
    velocidades DOUBLE,
    cilindrada_bike INT,
    imagen_bike VARCHAR(1024)
);

INSERT INTO bike (marca, velocidades, cilindrada_bike, imagen_bike) VALUES ('Yamaha', 6.0, 600, 'https://ejemplo.com/yamaha.jpg');
INSERT INTO bike (marca, velocidades, cilindrada_bike, imagen_bike) VALUES ('Honda', 6.0, 1000, 'https://ejemplo.com/honda.jpg');
INSERT INTO bike (marca, velocidades, cilindrada_bike, imagen_bike) VALUES ('Kawasaki', 5.0, 400, 'https://ejemplo.com/kawasaki.jpg');
INSERT INTO bike (marca, velocidades, cilindrada_bike, imagen_bike) VALUES ('Suzuki', 6.0, 750, 'https://ejemplo.com/suzuki.jpg');
