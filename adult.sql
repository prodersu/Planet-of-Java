-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Дек 09 2019 г., 08:51
-- Версия сервера: 10.1.13-MariaDB
-- Версия PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `dance-school`
--

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
  `sold` bigint(255) NOT NULL,
  `count` int(255) NOT NULL,
  `style` varchar(500) CHARACTER SET utf8 NOT NULL,
  `gender` varchar(500) CHARACTER SET utf8 NOT NULL,
  `indiv_group` varchar(500) CHARACTER SET utf8 NOT NULL
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
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `adult`
--
ALTER TABLE `adult`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
