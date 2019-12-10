-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Хост: localhost
-- Время создания: Дек 10 2019 г., 06:33
-- Версия сервера: 5.5.8
-- Версия PHP: 5.3.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `dance_school`
--

-- --------------------------------------------------------

--
-- Структура таблицы `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `login` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `name` varchar(500) NOT NULL,
  `income` int(250) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `admin`
--

INSERT INTO `admin` (`login`, `password`, `name`, `income`) VALUES
('admin', 'admin', 'Erlan', 0);

-- --------------------------------------------------------

--
-- Структура таблицы `adult`
--

CREATE TABLE IF NOT EXISTS `adult` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) CHARACTER SET utf8 NOT NULL,
  `master` varchar(500) CHARACTER SET utf8 NOT NULL,
  `schedule` varchar(500) CHARACTER SET utf8 NOT NULL,
  `price` bigint(255) NOT NULL,
  `sold` bigint(255) DEFAULT '0',
  `style` varchar(500) CHARACTER SET utf8 NOT NULL,
  `gender` varchar(500) CHARACTER SET utf8 NOT NULL,
  `indiv_group` varchar(500) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

--
-- Дамп данных таблицы `adult`
--


-- --------------------------------------------------------

--
-- Структура таблицы `clients`
--

CREATE TABLE IF NOT EXISTS `clients` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `login` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `titles in diary` varchar(500) NOT NULL,
  `schedule` varchar(500) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

--
-- Дамп данных таблицы `clients`
--


-- --------------------------------------------------------

--
-- Структура таблицы `kids`
--

CREATE TABLE IF NOT EXISTS `kids` (
  `id` int(250) NOT NULL AUTO_INCREMENT,
  `title` varchar(500) CHARACTER SET utf8 NOT NULL,
  `master` varchar(500) CHARACTER SET utf8 NOT NULL,
  `schedule` varchar(500) CHARACTER SET utf8 NOT NULL,
  `price` bigint(255) NOT NULL,
  `sold` bigint(255) NOT NULL DEFAULT '0',
  `age` int(100) NOT NULL,
  `tour` varchar(200) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=1 ;

--
-- Дамп данных таблицы `kids`
--

