-- phpMyAdmin SQL Dump
-- version 4.0.4.1
-- http://www.phpmyadmin.net
--
-- 涓绘満: 127.0.0.1
-- 鐢熸垚鏃ユ湡: 2015 骞?04 鏈?24 鏃?15:28
-- 鏈嶅姟鍣ㄧ増鏈? 5.6.11
-- PHP 鐗堟湰: 5.5.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- 鏁版嵁搴? `restaurantdb`
--
CREATE DATABASE IF NOT EXISTS `restaurantdb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `restaurantdb`;

-- --------------------------------------------------------

--
-- 琛ㄧ殑缁撴瀯 `t_comment`
--

CREATE TABLE IF NOT EXISTS `t_comment` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `title` text NOT NULL,
  `content` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- 杞瓨琛ㄤ腑鐨勬暟鎹?`t_comment`
--

INSERT INTO `t_comment` (`id`, `name`, `title`, `content`) VALUES
(100, 'alix', 'no bad', 'i feel nice'),

(100, 'obama', 'no bad', 'you can improve'),

(10000, 'obama', 'no bad', 'you can improve')

;

-- --------------------------------------------------------

--
-- 琛ㄧ殑缁撴瀯 `t_food`
--

CREATE TABLE IF NOT EXISTS `t_food` (
  `food_Id` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `food_Status` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `food_Name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `food_Available` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `food_Price` float DEFAULT NULL,
  `food_DiscoutPrice` float DEFAULT NULL,
  `food_restaurantId` varchar(50) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=gb2312 ROW_FORMAT=FIXED;

--
-- 杞瓨琛ㄤ腑鐨勬暟鎹?`t_food`
--

INSERT INTO `t_food` (`food_Id`, `food_Status`, `food_Name`, `food_Available`, `food_Price`, `food_DiscoutPrice`, `food_restaurantId`) VALUES
('N003', 'Available', 'Lobby', 'Y', 120, 90, 'A001'),
('N003', 'Available', 'Lobby', 'Y', 120, 90, 'A001');

-- --------------------------------------------------------

--
-- 琛ㄧ殑缁撴瀯 `t_manager`
--

CREATE TABLE IF NOT EXISTS `t_manager` (
  `man_Id` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `man_Password` varchar(50) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=gb2312 ROW_FORMAT=FIXED;

--
-- 杞瓨琛ㄤ腑鐨勬暟鎹?`t_manager`
--

INSERT INTO `t_manager` (`man_Id`, `man_Password`) VALUES

('admin', 'admin'),
('10000', '123456');

-- --------------------------------------------------------

--
-- 琛ㄧ殑缁撴瀯 `t_reserve`
--

CREATE TABLE IF NOT EXISTS `t_reserve` (
  `reserve_Id` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `reserve_foodId` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `reserve_UserId` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `reserve_Price` float DEFAULT NULL,
  `reserve_Total` float DEFAULT NULL,
  `reserve_StartTime` datetime DEFAULT NULL,
  `reserve_OverTime` datetime DEFAULT NULL,
  `reserve_Status` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `reserve_restaurantId` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `reserve_Quantity` int(11) DEFAULT NULL,
  `reserve_People` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=gb2312 ROW_FORMAT=FIXED;

--
-- 杞瓨琛ㄤ腑鐨勬暟鎹?`t_reserve`
--

INSERT INTO `t_reserve` (`reserve_Id`, `reserve_foodId`, `reserve_UserId`, `reserve_Price`, `reserve_Total`, `reserve_StartTime`, `reserve_OverTime`, `reserve_Status`, `reserve_restaurantId`, `reserve_Quantity`, `reserve_People`) VALUES

('R001', 'N001', 'null', 300, 600, '2010-04-28 00:00:00', '2010-04-30 00:00:00', '棰勫畾', 'A001', 1, 20),
('R002', 'N002', 'null', 323, 9367, '2010-04-01 00:00:00', '2010-04-30 00:00:00', '棰勫畾', 'A001', 1, 20);

-- --------------------------------------------------------

--
-- 琛ㄧ殑缁撴瀯 `t_restaurant`
--

CREATE TABLE IF NOT EXISTS `t_restaurant` (
  `restaurant_Id` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `restaurant_Name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `restaurant_Address` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `restaurant_Price` float DEFAULT NULL,
  `restaurant_Quantity` int(11) DEFAULT NULL,
  `restaurant_Star` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `restaurant_Image` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `restaurant_Description` varchar(255) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=gb2312 ROW_FORMAT=FIXED;

--
-- 杞瓨琛ㄤ腑鐨勬暟鎹?`t_restaurant`
--

INSERT INTO `t_restaurant` (`restaurant_Id`, `restaurant_Name`, `restaurant_Address`, `restaurant_Price`, `restaurant_Quantity`, `restaurant_Star`, `restaurant_Image`, `restaurant_Description`) VALUES

('A005', 'WATAMIN', 'TOKYO', 500, 120, '2', 'a.jpg', 'Meat .nice'),
('A006', 'Restaurant 06', 'PARIS', 500, 200, '3', 'h.jpg', '3 star'),
('A003', 'RES-1000', 'NEWYORK', 100, 10000, '1', '5.png', 'goood'),
('A004', 'KFC', 'HAWAII', 100, 56, '1', 'cc.jpg', 'havaii first KFC ,Welcome !'),
('A007', 'Restaurant 07', 'MALILAND', 900, 25, '4', 'g.jpg', '4 star,maliland'),
('A008', 'Restaurant 08', 'HAWAII', 2000, 500, '5', 'f.jpg', 'Hawaii,5 star');

-- --------------------------------------------------------

--
-- 琛ㄧ殑缁撴瀯 `t_user`
--

CREATE TABLE IF NOT EXISTS `t_user` (
  `user_id` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_pwd` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_age` int(11) DEFAULT NULL,
  `user_sex` varchar(11) CHARACTER SET utf8 DEFAULT NULL,
  `user_mobile` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_email` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_certitype` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_certinum` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_address` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `user_level` int(11) DEFAULT NULL,
  `user_point` int(11) DEFAULT NULL,
  `user_birthday` varchar(50) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=gb2312 ROW_FORMAT=FIXED;

--
-- 杞瓨琛ㄤ腑鐨勬暟鎹?`t_user`
--

INSERT INTO `t_user` (`user_id`, `user_pwd`, `user_name`, `user_age`, `user_sex`, `user_mobile`, `user_email`, `user_certitype`, `user_certinum`, `user_address`, `user_level`, `user_point`, `user_birthday`) VALUES

('zhangfei', '123456789', 'zhangfei', 26, 'male', '123456789', 'test@example.com', 'ID CARD', '123456', 'addr', 0, 0, '2015-04-07'),
('david', '123456', 'david', 23, 'male', '123456789', 'david@test.com', 'ID CARD', '123456789', 'tokyo...', 0, 0, '2008-04-01');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
