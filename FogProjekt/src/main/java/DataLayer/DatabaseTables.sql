USE `jfog`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

insert into `user`(`id`, `email`, `password`) values
(1, 'user@mail.dk', 'user');

DROP TABLE IF EXISTS `useradmin`;
CREATE TABLE `useradmin` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `email` varchar(90) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

insert into `useradmin`(`id`, `email`, `password`) values
(1, 'admin@mail.dk', 'admin');

-- DROP TABLE IF EXISTS `odetails`;
-- CREATE TABLE `odetails` (
-- `ordernumber` int(30) NOT NULL AUTO_INCREMENT, 
-- Tilføj Materialelisten / pris
-- Tilføj mængden af materialer
-- 
-- PRIMARY KEY (`ordernumber`),
-- UNIQUE KEY `lol` (`ordernumber`)
-- ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `products`;
CREATE TABLE `products` (
    `id` int(30) NOT NULL,
    `name` varchar(90) NOT NULL,
    `length` int(30) NOT NULL,
    `unit` varchar(90) NOT NULL,
    `description` varchar(90) NOT NULL,
    `price` int(30) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

insert into `products`(`id`, `name`, `length`, `unit`, `description`, `price`) values 
(1, '25x200 mm. trykimp. Brædt', 360, 'Stk', 'understernbrædder til for & bagende', 180),
(2, '25x200 mm. trykimp. Brædt', 540, 'Stk', 'understenbræder til siderne', 275),
(3, '25x125 mm. trykimp. Brædt', 360, 'Stk', 'overstærnbrædder til forenden', 108),
(4, '25x125 mm. trykimp. Brædt', 540, 'Stk', 'overstærnbrædder til siderne', 162),
(5, '38x73 mm. Lægte ubh.', 420, 'Stk', 'til z på bagside af dør', 88),
(6, '45x95. mm. Reglar ub.', 270, 'Stk', 'løsholter til skur gavle', 48),
(7, '45x95. mm. Reglar ub.', 240, 'Stk', 'løsholter til skur sider', 41),
(8, '45x195 mm. spærtræ ubh', 600, 'Stk', 'Remme i sider, sadles ned i stolper', 420),
(9, '45x195 mm. spærtræ ubh.', 480, 'Stk', 'Remme i sider, sadles ned i stolper(skur del, deles)', 336),
(10, '45x195 mm. spærtræ ubh.', 600, 'Stk', 'Spær, monteres på rem', 420),
(11, '97x97. mm. trykimp. Stolpe', 300, 'Stk',  'Stolper nedgraves 90 cm. i jord', 84),
(12, '19x100 mm. trykimp. Brædt', 210, 'Stk', 'til beklædning af skur 1 på 2', 15),
(13, '19x100 mm. trykimp. Brædt', 540, 'Stk', 'vandbrædt på stern i sider', 35),
(14, '19x100 mm. trykimp. Brædt', 360, 'Stk', 'vandbrædt på stern i forende', 25),
(15, 'Plastmo Ecolite blåtonet', 600, 'Stk', 'tagplader monteres på spær', 330),
(16, 'Plastmo Ecolite blåtonet', 360, 'Stk', 'tagplader monteres på spær', 139),
(17, 'plastmo bundskruer 200 stk', 0, 'Pakke', 'Skruer til tagplader', 589),
(18, 'hulbånd 1x20 mm. 10 mtr.', 0, 'Rulle', 'Til vindkryds på spær', 190),
(19, 'universal 190 mm. højre', 0, 'Stk', 'Til montering af spær på rem', 70),
(20, 'universal 190 mm. venstre', 0, 'Stk', 'Til montering af spær på rem', 70),
(21, '4,5 x 60 mm. skruer 200stk.', 0, 'Pakke', 'Til montering af stern&vandbrædt', 419),
(22, '4,0 x 50 mm. beslagskruer 250 stk.', 0, 'Pakke', 'Til montering af universalbeslag + hulbånd', 350),
(23, 'bræddebolt 10 x 120 mm.', 0, 'Stk', 'Til montering af rem på stolper', 190),
(24, 'firkantskiver 40x40x11 mm.', 0, 'Stk', 'Til montyering af rem på stolper', 610),
(25, '4,5 x 70 mm. Skruer 400 stk.', 0, 'Pakke', 'Til montering af yderste beklædning', 480),
(26, '4,5 x 50 mm. Skruer 300 stk.', 0, 'Pakke', 'Til montering af inderste beklædning', 189),
(27, 'stalddørsgreb 50x75', 0, 'Sæt', 'Til lås på dør i skur', 189),
(28, 't hængsel 390 mm', 0, 'Stk', 'Til skurdør', 55),
(29, 'vinkelbeslag 35', 0, 'Stk', 'Til montering af løsholter i skur', 27);
