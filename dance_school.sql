-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Дек 11 2019 г., 07:00
-- Версия сервера: 10.1.13-MariaDB
-- Версия PHP: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
  `id` int(11) NOT NULL,
  `login` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `name` varchar(500) NOT NULL,
  `income` int(250) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `admin`
--

INSERT INTO `admin` (`id`, `login`, `password`, `name`, `income`) VALUES
(1, 'admin', 'admin', 'Erlan', 0);

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

--
-- Дамп данных таблицы `adult`
--

INSERT INTO `adult` (`id`, `title`, `master`, `schedule`, `price`, `sold`, `style`, `gender`, `indiv_group`) VALUES
(1, 'Valse', 'Trevor', 'Tuesday', 15000, 0, 'Ballroom dance', 'Woman', 'Group');

-- --------------------------------------------------------

--
-- Структура таблицы `clients`
--

CREATE TABLE `clients` (
  `id` int(250) NOT NULL,
  `login` varchar(200) NOT NULL,
  `name` varchar(200) NOT NULL,
  `password` varchar(200) NOT NULL,
  `titles` varchar(500) NOT NULL DEFAULT '',
  `schedule` varchar(500) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `clients`
--

INSERT INTO `clients` (`id`, `login`, `name`, `password`, `titles`, `schedule`) VALUES
(1, 'client', 'Alihan', 'client', '', ''),
(2, 'fresh', 'Alina', 'fresh', '', '');

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
-- Дамп данных таблицы `kids`
--

INSERT INTO `kids` (`id`, `title`, `master`, `schedule`, `price`, `sold`, `age`, `tour`) VALUES
(1, 'Balet', 'Lebedeva', 'Monday', 15000, 0, 10, 'no');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

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
-- AUTO_INCREMENT для таблицы `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT для таблицы `adult`
--
ALTER TABLE `adult`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT для таблицы `clients`
--
ALTER TABLE `clients`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT для таблицы `kids`
--
ALTER TABLE `kids`
  MODIFY `id` int(250) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
