-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1
-- Время создания: Дек 09 2019 г., 11:48
-- Версия сервера: 10.1.35-MariaDB
-- Версия PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `dance_school`
--

-- --------------------------------------------------------

--
-- Структура таблицы `admin`
--

CREATE TABLE `admin` (
  `login` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `name` varchar(500) NOT NULL,
  `income` int(250) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `adult`
--

CREATE TABLE `adult` (
  `id` int(250) NOT NULL,
  `title` varchar(500) CHARACTER SET utf8 NOT NULL,
  `master` varchar(500) CHARACTER SET utf8 NOT NULL,
  `schedule` varchar(500) CHARACTER SET utf8 NOT NULL,
  `price` bigint(255) NOT NULL,
  `sold` bigint(255) DEFAULT '0',
  `style` varchar(500) CHARACTER SET utf8 NOT NULL,
  `gender` varchar(500) CHARACTER SET utf8 NOT NULL,
  `indiv_group` varchar(500) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Структура таблицы `clients`
--

CREATE TABLE `clients` (
  `id` int(250) NOT NULL,
  `login` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `titles in diary` varchar(500) NOT NULL,
  `schedule` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `kids`
--

CREATE TABLE `kids` (
  `id` int(250) NOT NULL,
  `title` varchar(500) CHARACTER SET utf8 NOT NULL,
  `master` varchar(500) CHARACTER SET utf8 NOT NULL,
  `schedule` varchar(500) CHARACTER SET utf8 NOT NULL,
  `price` bigint(255) NOT NULL,
  `sold` bigint(255) NOT NULL DEFAULT '0',
  `age` int(100) NOT NULL,
  `tour` varchar(200) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `adult`
--
ALTER TABLE `adult`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `clients`
--
ALTER TABLE `clients`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `kids`
--
ALTER TABLE `kids`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `adult`
--
ALTER TABLE `adult`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT для таблицы `kids`
--
ALTER TABLE `kids`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
