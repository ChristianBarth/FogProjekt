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

DROP TABLE IF EXISTS `woodandroof`;
CREATE TABLE `woodandroof` (
    `name` varchar(90) NOT NULL,
    `length` int(30) NOT NULL,
    `amount` int(30) NOT NULL,
    `unit` varchar(90) NOT NULL,
    `description` varchar(90) NOT NULL
-- PRIMARY KEY (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

insert into `woodandroof`(`name`, `length`, `amount`, `unit`, `description`) values 
('25x200 mm. trykimp. Brædt', 360, 0, 'Stk', 'understernbrædder til for & bagende'),
('25x200 mm. trykimp. Brædt', 540, 0, 'Stk', 'understenbræder til siderne'),
('25x125 mm. trykimp. Brædt', 360, 0,  'Stk', 'overstærnbrædder til forenden'),
('25x125 mm. trykimp. Brædt', 540, 0, 'Stk', 'overstærnbrædder til siderne'),
('38x73 mm. Lægte ubh.', 420, 0, 'Stk', 'til z på bagside af dør'),
('45x95. mm. Reglar ub.', 270, 0, 'Stk', 'løsholter til skur gavle'),
('45x95. mm. Reglar ub.', 240, 0, 'Stk', 'løsholter til skur sider'),
('45x195 mm. spærtræ ubh', 600, 0, 'Stk', 'Remme i sider, sadles ned i stolper'),
('45x195 mm. spærtræ ubh.', 480, 0, 'Stk', 'Remme i sider, sadles ned i stolper(skur del, deles)'),
('45x195 mm. spærtræ ubh.', 600, 0, 'Stk', 'Spær, monteres på rem'),
('97x97. mm. trykimp. Stolpe', 300, 0,'Stk',  'Stolper nedgraves 90 cm. i jord'),
('19x100 mm. trykimp. Brødt', 210, 0, 'Stk', 'til beklædning af skur 1 på 2'),
('19x100 mm. trykimp. Brædt', 540, 0, 'Stk', 'vandbrædt på stern i sider'),
('19x100 mm. trykimp. Brædt', 360, 0, 'Stk', 'vandbrædt på stern i forende'),
('Plastmo Ecolite blåtonet', 600, 0, 'Stk', 'tagplader monteres på spær'),
('Plastmo Ecolite blåtonet', 360, 0, 'Stk', 'tagplader monteres på spær');



DROP TABLE IF EXISTS `fittingandscrews`;
CREATE TABLE `fittingandscrews` (
    `name` varchar(90) NOT NULL,
    `amount` int(30) NOT NULL,
    `unit` varchar(90) NOT NULL,
    `description` varchar(90) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

insert into `fittingandscrews`(`name`, `amount`, `unit`, `description`) values 
('plastmo bundskruer 200 stk', 0, 'Pakke', 'Skruer til tagplader'),
('hulbånd 1x20 mm. 10 mtr.', 0, 'Rulle', 'Til vindkryds på spær'),
('universal 190 mm. højre', 0, 'Stk', 'Til montering af spær på rem'),
('universal 190 mm. venstre', 0, 'Stk', 'Til montering af spær på rem'),
('4,5 x 60 mm. skruer 200stk.', 0, 'Pakke', 'Til montering af stern&vandbrædt'),
('4,0 x 50 mm. beslagskruer 250 stk.', 0, 'Pakke', 'Til montering af universalbeslag + hulbånd'),
('bræddebolt 10 x 120 mm.', 'Stk', 0, 'Til montering af rem på stolper'),
('firkantskiver 40x40x11 mm.', 0, 'Stk', 'Til montyering af rem på stolper'),
('4,5 x 70 mm. Skruer 400 stk.', 0, 'Pakke', 'Til montering af yderste beklædning'),
('4,5 x 50 mm. Skruer 300 stk.', 0, 'Pakke', 'Til montering af inderste beklædning'),
('stalddørsgreb 50x75', 'Sæt', 0, 'Til lås på dør i skur'),
('t hængsel 390 mm', 'Stk', 0, 'Til skurdør'),
('vinkelbeslag 35', 'Stk', 0, 'Til montering af løsholter i skur');
