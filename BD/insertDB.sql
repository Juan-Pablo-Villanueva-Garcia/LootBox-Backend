USE `ecommercelb` ;

-- Insertar elementos en Productos-------------------------------

INSERT INTO productos (name, imagen, descripcion, category, price, json, sku, stock, costo)
VALUES
('LootBox Común', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1747185374/Lootbox-C2_tffytg.webp', '¡Tu LootBox gamer está lista! Sorpresas épicas, coleccionables y productos que te harán subir de nivel.', 0, 2500.00, '{"rate": 4.7, "count": 1850}', 1100, 250, 2250.00),
('LootBox Épica', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1747185373/Lootbox-M2_ahrznc.webp', 'Sorpresas épicas en cada caja. ¿Estás listo para el drop?', 0, 4000.00, '{"rate": 4.9, "count": 860}', 1110, 98, 3600.00),
('LootBox Legendaria', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1747185375/Lootbox-G_nwkhoc.webp', 'solo para los que se atreven a todo. El drop más épico, con ítems sorpresa de otro nivel.', 0, 6000.00, '{"rate": 4.9, "count": 1300}', 1120, 349, 5400.00),
('PlayStation 5', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963956/619BkvKW35L._AC_SL1500__oj8efg.jpg', 'Consola de nueva generación con soporte para 4K y SSD ultrarrápido.', 1, 9999.99, '{"rate": 4.8, "count": 852}', 2384, 112, 8999.99),
('Xbox Series X', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963956/61JGKhqxHxL._AC_SL1500__dyv4k2.jpg', 'La consola más potente de Microsoft con 1TB SSD y 12 teraflops.', 1, 8499.99, '{"rate": 4.7, "count": 713}', 2591, 74, 7649.99),
('Nintendo Switch OLED', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963948/71Q54HnKxwS._AC_SX522__cou4wb.jpg', 'Consola híbrida con pantalla OLED de 7 pulgadas y mejor audio.', 1, 6899.99, '{"rate": 4.6, "count": 631}', 2723, 186, 6209.99),
('Steam Deck', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963953/images_wp8jdt.jpg', 'Consola portátil de Valve para juegos de PC en cualquier lugar.', 1, 7549.00, '{"rate": 4.5, "count": 298}', 2944, 37, 6794.10),
('PlayStation 5 Digital Edition', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963953/41xe0HXlgML_vusrqn.jpg', 'Versión sin lector de discos con el mismo poder gráfico de PS5.', 1, 8499.99, '{"rate": 4.7, "count": 401}', 2175, 91, 7649.99),
('Funko Pop! Master Chief', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963952/images_1_rh9a10.jpg', 'Figura coleccionable de Halo para fanáticos de la saga.', 2, 650.00, '{"rate": 4.9, "count": 587}', 1894, 53, 585.00),
('Tayto', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963952/images_2_a85vw4.jpg', 'Cheese & Onion Chips, el snack favorito de gamers irlandeses.', 2, 99.00, '{"rate": 4.3, "count": 126}', 1637, 117, 89.10),
('Taza The Legend of Zelda', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963952/images_3_zmqjzk.jpg', 'Taza mágica que revela mapa de Hyrule con calor.', 2, 245.00, '{"rate": 4.6, "count": 342}', 1548, 200, 220.50),
('Playera ROG Limited Edition', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963952/images_4_pdyibp.jpg', 'Camiseta oficial ASUS Republic of Gamers para entusiastas.', 2, 599.00, '{"rate": 4.4, "count": 229}', 1472, 14, 539.10),
('Almohada Among Us', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963952/81ulVFK1AwL_iq3ld8.jpg', 'Cojín con forma del tripulante más sospechoso del espacio.', 2, 349.50, '{"rate": 4.7, "count": 312}', 1349, 78, 314.55),
('Logitech G Pro X Superlight', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963949/images_5_vadrey.jpg', 'Mouse inalámbrico ultraligero con sensor HERO.', 3, 2300.00, '{"rate": 4.8, "count": 764}', 3594, 132, 2070.00),
('SteelSeries Arctis Nova Pro', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963950/images_6_x8drx0.jpg', 'Audífonos con DAC para audio envolvente y precisión.', 3, 4590.00, '{"rate": 4.6, "count": 421}', 3187, 56, 4131.00),
('Razer BlackWidow V4', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963949/images_7_hoqfed.jpg', 'Teclado mecánico RGB con switches verdes.', 3, 2850.00, '{"rate": 4.7, "count": 536}', 3751, 107, 2565.00),
('Elgato Stream Deck Mini', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963948/sd-mini-01_xwmagf_w9fktc.avif', 'Controlador compacto con 6 teclas LCD programables.', 3, 1500.00, '{"rate": 4.8, "count": 389}', 3416, 92, 1350.00),
('Corsair MM300 PRO', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963948/61n4oNwr_iL_qxbgv7.jpg', 'Alfombrilla de gran tamaño con superficie resistente a salpicaduras.', 3, 499.99, '{"rate": 4.5, "count": 185}', 3062, 23, 449.99),
('God of War Ragnarök', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963948/883929794867-portada-hogwarts-legacy-nsw-510x630_brp2rx.jpg', 'Kratos y Atreus enfrentan el fin del mundo nórdico en esta épica secuela.', 4, 1250.00, '{"rate": 4.9, "count": 972}', 4285, 65, 1125.00),
('The Legend of Zelda: Tears of the Kingdom', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963948/045496599331-portada-tears-of-the-kingdom-nsw-510x630_vhktzz.jpg', 'La nueva aventura de Link por los cielos de Hyrule.', 4, 999.00, '{"rate": 4.9, "count": 891}', 4123, 173, 899.10),
('Call of Duty: Modern Warfare II', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963948/047875103603-COD-MW2-XONEXSX-1-510x630_urlzpm.jpg', 'Shooter táctico con multijugador renovado y campaña intensa.', 4, 1225.00, '{"rate": 4.6, "count": 647}', 4672, 104, 1102.50),
('Elden Ring', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963948/elden_xbox_1-510x630_hoajbw.jpg', 'RPG de mundo abierto de los creadores de Dark Souls.', 4, 999.00, '{"rate": 4.8, "count": 739}', 4921, 142, 899.10),
('Hogwarts Legacy', 'https://res.cloudinary.com/dsjcemt6v/image/upload/v1745963948/883929794867-portada-hogwarts-legacy-nsw-510x630_brp2rx.jpg', 'Explora el mundo mágico como un estudiante de Hogwarts en 1800.', 4, 1350.49, '{"rate": 4.7, "count": 693}', 4456, 49, 1215.44);


-- iNSERTAR USUARIOS
INSERT INTO usuario (idUsuario, nombre, email, telefono, contraseña) 
VALUES 
(null,'Aurora Vargas', 'aurora.vargas@gmail.com', '5598765432', 'Au1#bcdE'),
(null,'Benito Pérez', 'benito.perez@gmail.com', '5611223344', 'Be2@fghi'),
(null,'Carla Soto', 'carla.soto@gmail.com', '5755555555', 'Cs3$jklM'),
(null,'Daniel Ríos', 'daniel.rios@gmail.com', '5812341234', 'Dr4%nopQ'),
(null,'Elena Jiménez', 'elena.jimenez@gmail.com', '5967896789', 'Ej5#rstU'),
(null,'Fernando Castro', 'fernando.castro@gmail.com', '5544332211', 'Fc6@vwxY'),
(null,'Gabriela López', 'gabriela.lopez@gmail.com', '5699887766', 'Gl7$yzaB'),
(null,'Héctor Ruiz', 'hector.ruiz@gmail.com', '5721212121', 'Hr8%cdeF'),
(null,'Isabel Núñez', 'isabel.nunez@gmail.com', '5801010101', 'In9#fghI'),
(null,'Javier Torres', 'javier.torres@gmail.com', '5945454545', 'Jt0@jklM');

-- Insertar PEDIDOS

INSERT INTO pedido (idPedido, pedido_at, idUsuario_fk, precioTotal, status) VALUES
(null, '2025-05-01 14:30:00', 1, 2500.00, 'Enviado'),
(null, '2025-05-02 09:15:00', 2, 8499.99, 'Pendiente'),
(null, '2025-05-03 16:00:00', 1, 1350.49, 'Entregado'),
(null, '2025-05-04 11:45:00', 3, 245.00, 'Cancelado'),
(null, '2025-05-05 17:10:00', 4, 9999.99, 'En proceso'),
(null, '2025-05-06 13:20:00', 2, 999.00, 'Enviado'),
(null, '2025-05-07 10:05:00', 5, 4590.00, 'Pendiente'),
(null, '2025-05-08 18:40:00', 3, 7549.00, 'Entregado'),
(null, '2025-05-09 15:30:00', 4, 8499.99, 'Cancelado'),
(null, '2025-05-10 12:00:00', 4, 3750.00, 'En proceso');

-- Insertar pedidos con productos

INSERT INTO pedido_has_productos (Pedido_idPedido, Productos_idProductos) VALUES
(1,2),
(1,3),
(1,4),
(1,5),
(2,3);

SELECT * FROM pedido_has_productos;
