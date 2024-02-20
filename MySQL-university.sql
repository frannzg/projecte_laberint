-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-01-2024 a las 19:32:01
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `universitat`
--
DROP DATABASE IF EXISTS `db_university`;
CREATE DATABASE IF NOT EXISTS `db_university` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `db_university`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `students_enroll_subjects`
--

CREATE TABLE `students_enroll_subjects` (
  `student_id` int(10) UNSIGNED NOT NULL,
  `subject_id` int(10) UNSIGNED NOT NULL,
  `school_year_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `students_enroll_subjects`
--

INSERT INTO `students_enroll_subjects` (`student_id`, `subject_id`, `school_year_id`) VALUES
(1, 1, 1),
(1, 2, 1),
(1, 3, 1),
(2, 1, 1),
(2, 2, 1),
(2, 3, 1),
(4, 1, 1),
(4, 2, 1),
(4, 3, 1),
(19, 1, 5),
(19, 2, 5),
(19, 3, 5),
(19, 4, 5),
(19, 5, 5),
(19, 6, 5),
(19, 7, 5),
(19, 8, 5),
(19, 9, 5),
(19, 10, 5),
(23, 1, 5),
(23, 2, 5),
(23, 3, 5),
(23, 4, 5),
(23, 5, 5),
(23, 6, 5),
(23, 7, 5),
(23, 8, 5),
(23, 9, 5),
(23, 10, 5),
(24, 1, 5),
(24, 2, 5),
(24, 3, 5),
(24, 4, 5),
(24, 5, 5),
(24, 6, 5),
(24, 7, 5),
(24, 8, 5),
(24, 9, 5),
(24, 10, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `subjects`
--

CREATE TABLE `subjects` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL,
  `credits` float UNSIGNED NOT NULL,
  `type` enum('basic','compulsory','optional') NOT NULL,
  `year` tinyint(3) UNSIGNED NOT NULL,
  `quadrimester` tinyint(3) UNSIGNED NOT NULL,
  `professor_id` int(10) UNSIGNED DEFAULT NULL,
  `degree_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `subjects`
--

INSERT INTO `subjects` (`id`, `name`, `credits`, `type`, `year`, `quadrimester`, `professor_id`, `degree_id`) VALUES
(1, 'Linear algebra and discrete mathematics', 6, 'basic', 1, 1, 3, 4),
(2, 'Calculus', 6, 'basic', 1, 1, 14, 4),
(3, 'Computer science physics', 6, 'basic', 1, 1, 3, 4),
(4, 'Introduction to programming', 6, 'basic', 1, 1, 14, 4),
(5, 'Business management and organization', 6, 'basic', 1, 1, 3, 4),
(6, 'Statistics', 6, 'basic', 1, 2, 14, 4),
(7, 'Computer sctructure and technology', 6, 'basic', 1, 2, 3, 4),
(8, 'Fundaments of Electronics', 6, 'basic', 1, 2, 14, 4),
(9, 'Logic and arithmetic', 6, 'basic', 1, 2, 3, 4),
(10, 'Programming methodology', 6, 'basic', 1, 2, 14, 4),
(11, 'Computer Architecture', 6, 'basic', 2, 1, 3, 4),
(12, 'Data structure and Algorithms I', 6, 'compulsory', 2, 1, 3, 4),
(13, 'Software engineering', 6, 'compulsory', 2, 1, 14, 4),
(14, 'Intelligent systems', 6, 'compulsory', 2, 1, 3, 4),
(15, 'Operating systems', 6, 'compulsory', 2, 1, 14, 4),
(16, 'Databases', 6, 'basic', 2, 2, 14, 4),
(17, 'Data structure and Algorithms II', 6, 'compulsory', 2, 2, 14, 4),
(18, 'Fundament of Computer Networks', 6, 'compulsory', 2, 2, 3, 4),
(19, 'Computer Science Projects Planning and Management', 6, 'compulsory', 2, 2, 3, 4),
(20, 'Software Services Programming', 6, 'compulsory', 2, 2, 14, 4),
(21, 'User Interfaces Deployment Development', 6, 'compulsory', 3, 1, 14, 4),
(22, 'Requisite Engineering', 6, 'optional', 3, 1, NULL, 4),
(23, 'Information Technology Integration in Organizations', 6, 'optional', 3, 1, NULL, 4),
(24, 'Software Design and Modelling 1', 6, 'optional', 3, 1, NULL, 4),
(25, 'Multiprocessors', 6, 'optional', 3, 1, NULL, 4),
(26, 'Normative Compliance and Security', 6, 'optional', 3, 1, NULL, 4),
(27, 'Information Systems in Organizations', 6, 'optional', 3, 1, NULL, 4),
(28, 'Web Technologies', 6, 'optional', 3, 1, NULL, 4),
(29, 'Code Theory and Cryptography', 6, 'optional', 3, 1, NULL, 4),
(30, 'Database Management', 6, 'optional', 3, 2, NULL, 4),
(31, 'Sofware Engineering Methods and Tools', 6, 'optional', 3, 2, NULL, 4),
(32, 'Industrial Computer Science and Robotics', 6, 'optional', 3, 2, NULL, 4),
(33, 'Information System Engineering', 6, 'optional', 3, 2, NULL, 4),
(34, 'Software Design and Modelling 2', 6, 'optional', 3, 2, NULL, 4),
(35, 'Electronic Business', 6, 'optional', 3, 2, NULL, 4),
(36, 'Interfaces and Peripherals', 6, 'optional', 3, 2, NULL, 4),
(37, 'Real-time Systems', 6, 'optional', 3, 2, NULL, 4),
(38, 'Network Access Technologies', 6, 'optional', 3, 2, NULL, 4),
(39, 'Digital Image Processing', 6, 'optional', 3, 2, NULL, 4),
(40, 'Network Management and Operating Systems', 6, 'optional', 4, 1, NULL, 4),
(41, 'Data Warehouses', 6, 'optional', 4, 1, NULL, 4),
(42, 'Threat Reliability and Management', 6, 'optional', 4, 1, NULL, 4),
(43, 'Software Product Lines', 6, 'optional', 4, 1, NULL, 4),
(44, 'Software Engineering Processes 1', 6, 'optional', 4, 1, NULL, 4),
(45, 'Multimedia Technologies', 6, 'optional', 4, 1, NULL, 4),
(46, 'IT Analysis and Planning', 6, 'optional', 4, 2, NULL, 4),
(47, 'Quick Application Development', 6, 'optional', 4, 2, NULL, 4),
(48, 'Technologic Quality and Innovation Management', 6, 'optional', 4, 2, NULL, 4),
(49, 'Business Intelligence', 6, 'optional', 4, 2, NULL, 4),
(50, 'Software Engineering Processes 2', 6, 'optional', 4, 2, NULL, 4),
(51, 'Computer Science Security', 6, 'optional', 4, 2, NULL, 4),
(52, 'Cellular Biology', 6, 'basic', 1, 1, NULL, 7),
(53, 'Physics', 6, 'basic', 1, 1, NULL, 7),
(54, 'Mathematics I', 6, 'basic', 1, 1, NULL, 7),
(55, 'General Chemistry', 6, 'basic', 1, 1, NULL, 7),
(56, 'Organic Chemistry', 6, 'basic', 1, 1, NULL, 7),
(57, 'Animal and Vegetable Biology', 6, 'basic', 1, 2, NULL, 7),
(58, 'Biochemistry', 6, 'basic', 1, 2, NULL, 7),
(59, 'Genetics', 6, 'basic', 1, 2, NULL, 7),
(60, 'Mathematics II', 6, 'basic', 1, 2, NULL, 7),
(61, 'Microbiology', 6, 'basic', 1, 2, NULL, 7),
(62, 'Farming Botany', 6, 'compulsory', 2, 1, NULL, 7),
(63, 'Vegetable Physiology', 6, 'compulsory', 2, 1, NULL, 7),
(64, 'Molecular Genetics', 6, 'compulsory', 2, 1, NULL, 7),
(65, 'Biochemistry Engineering', 6, 'compulsory', 2, 1, NULL, 7),
(66, 'Thermodynamics and Applied Chemical Kinetics', 6, 'compulsory', 2, 1, NULL, 7),
(67, 'Bioreactors', 6, 'compulsory', 2, 2, NULL, 7),
(68, 'Microbial Biotechnology', 6, 'compulsory', 2, 2, NULL, 7),
(69, 'Genetic Engineering', 6, 'compulsory', 2, 2, NULL, 7),
(70, 'Immunology', 6, 'compulsory', 2, 2, NULL, 7),
(71, 'Virology', 6, 'compulsory', 2, 2, NULL, 7),
(72, 'Molecular Fundament and Vegetable Development', 4.5, 'compulsory', 3, 1, NULL, 7),
(73, 'Animal Physiology', 4.5, 'compulsory', 3, 1, NULL, 7),
(74, 'Biomolecule Metabolism and Biosynthesis', 6, 'compulsory', 3, 1, NULL, 7),
(75, 'Separation Operations', 6, 'compulsory', 3, 1, NULL, 7),
(76, 'Plant molecular pathology', 4.5, 'compulsory', 3, 1, NULL, 7),
(77, 'Basic Tool Techniques', 4.5, 'compulsory', 3, 1, NULL, 7),
(78, 'Biocomputing', 4.5, 'compulsory', 3, 2, NULL, 7),
(79, 'Fruit and vegetable Product Biotechnology', 4.5, 'compulsory', 3, 2, NULL, 7),
(80, 'Vegetable Biotechnology', 6, 'compulsory', 3, 2, NULL, 7),
(81, 'Genomics and Proteomics', 4.5, 'compulsory', 3, 2, NULL, 7),
(82, 'Biotechnological Processes', 6, 'compulsory', 3, 2, NULL, 7),
(83, 'Advanced Tool Techniques', 4.5, 'compulsory', 3, 2, NULL, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `school_years`
--

CREATE TABLE `school_years` (
  `id` int(10) UNSIGNED NOT NULL,
  `start_year` year(4) NOT NULL,
  `end_year` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `school_years`
--

INSERT INTO `school_years` (`id`, `start_year`, `end_year`) VALUES
(1, 2017, 2018),
(2, 2018, 2019),
(3, 2019, 2020),
(4, 2020, 2021),
(5, 2021, 2022);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departments`
--

CREATE TABLE `departments` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `departments`
--

INSERT INTO `departments` (`id`, `name`) VALUES
(1, 'Computer Sience'),
(2, 'Mathematics'),
(3, 'Economy and Business'),
(4, 'Education'),
(5, 'Agronomy'),
(6, 'Physics and Chemistry'),
(7, 'Philology'),
(8, 'Law'),
(9, 'Biology and Geology');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `degrees`
--

CREATE TABLE `degrees` (
  `id` int(10) UNSIGNED NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `degrees`
--

INSERT INTO `degrees` (`id`, `name`) VALUES
(1, 'Farming Engineering Degree (2015 Plan)'),
(2, 'Electric Engineering Degree (2014 Plan)'),
(3, 'Industrial Electronics Engineering Degree (2010 Plan)'),
(4, 'Computer Science Engineering Degree (2015 Plan)'),
(5, 'Mechanics Engineering Degree (2010 Plan)'),
(6, 'Industrial Chemistry Engineering Degree (2010 Plan)'),
(7, 'Biotechnology Degree (2015 Plan)'),
(8, 'Environmental Science Degree (2009 Plan)'),
(9, 'Mathematics Degree (2010 Plan)'),
(10, 'Chemistry Degree (2009 Plan)');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `professors`
--

CREATE TABLE `professors` (
  `professor_id` int(10) UNSIGNED NOT NULL,
  `department_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `professors`
--

INSERT INTO `professors` (`professor_id`, `department_id`) VALUES
(3, 1),
(14, 1),
(5, 2),
(15, 2),
(8, 3),
(16, 3),
(10, 4),
(12, 4),
(17, 4),
(18, 5),
(13, 6),
(20, 6);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `nif` varchar(9) DEFAULT NULL,
  `name` varchar(25) NOT NULL,
  `surname1` varchar(50) NOT NULL,
  `surname2` varchar(50) DEFAULT NULL,
  `city` varchar(25) NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` varchar(9) DEFAULT NULL,
  `birth_date` date NOT NULL,
  `gender` enum('M','F','NB') NOT NULL,
  `type` enum('professor','student') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `users`
--

INSERT INTO `users` (`id`, `nif`, `name`, `surname1`, `surname2`, `city`, `address`, `phone`, `birth_date`, `gender`, `type`) VALUES
(1, '26902806M', 'Salvador', 'Sánchez', 'Pérez', 'Almería', 'C/ Real del barrio alto', '950254837', '1991-03-28', 'M', 'student'),
(2, '89542419S', 'Juan', 'Saez', 'Vega', 'Almería', 'C/ Mercurio', '618253876', '1992-08-08', 'M', 'student'),
(3, '11105554G', 'Zoe', 'Ramirez', 'Gea', 'Almería', 'C/ Marte', '618223876', '1979-08-19', 'F', 'professor'),
(4, '17105885A', 'Pedro', 'Heller', 'Pagac', 'Almería', 'C/ Estrella fugaz', NULL, '2000-10-05', 'M', 'student'),
(5, '38223286T', 'David', 'Schmidt', 'Fisher', 'Almería', 'C/ Venus', '678516294', '1978-01-19', 'M', 'professor'),
(6, '04233869Y', 'José', 'Koss', 'Bayer', 'Almería', 'C/ Júpiter', '628349590', '1998-01-28', 'M', 'student'),
(7, '97258166K', 'Ismael', 'Strosin', 'Turcotte', 'Almería', 'C/ Neptuno', NULL, '1999-05-24', 'M', 'student'),
(8, '79503962T', 'Cristina', 'Lemke', 'Rutherford', 'Almería', 'C/ Saturno', '669162534', '1977-08-21', 'NB', 'professor'),
(9, '82842571K', 'Ramón', 'Herzog', 'Tremblay', 'Almería', 'C/ Urano', '626351429', '1996-11-21', 'M', 'student'),
(10, '61142000L', 'Esther', 'Spencer', 'Lakin', 'Almería', 'C/ Plutón', NULL, '1977-05-19', 'F', 'professor'),
(11, '46900725E', 'Daniel', 'Herman', 'Pacocha', 'Almería', 'C/ Andarax', '679837625', '1997-04-26', 'M', 'student'),
(12, '85366986W', 'Carmen', 'Streich', 'Hirthe', 'Almería', 'C/ Almanzora', NULL, '1971-04-29', 'F', 'professor'),
(13, '73571384L', 'Alfredo', 'Stiedemann', 'Morissette', 'Almería', 'C/ Guadalquivir', '950896725', '1980-02-01', 'M', 'professor'),
(14, '82937751G', 'Manolo', 'Hamill', 'Kozey', 'Almería', 'C/ Duero', '950263514', '1977-01-02', 'M', 'professor'),
(15, '80502866Z', 'Alejandro', 'Kohler', 'Schoen', 'Almería', 'C/ Tajo', '668726354', '1980-03-14', 'NB', 'professor'),
(16, '10485008K', 'Antonio', 'Fahey', 'Considine', 'Almería', 'C/ Sierra de los Filabres', NULL, '1982-03-18', 'M', 'professor'),
(17, '85869555K', 'Guillermo', 'Ruecker', 'Upton', 'Almería', 'C/ Sierra de Gádor', NULL, '1973-05-05', 'M', 'professor'),
(18, '04326833G', 'Micaela', 'Monahan', 'Murray', 'Almería', 'C/ Veleta', '662765413', '1976-02-25', 'M', 'professor'),
(19, '11578526G', 'Inma', 'Lakin', 'Yundt', 'Almería', 'C/ Picos de Europa', '678652431', '1998-09-01', 'F', 'student'),
(20, '79221403L', 'Francesca', 'Schowalter', 'Muller', 'Almería', 'C/ Quinto pino', NULL, '1980-10-31', 'M', 'professor'),
(21, '79089577Y', 'Juan', 'Gutiérrez', 'López', 'Almería', 'C/ Los pinos', '678652431', '1998-01-01', 'M', 'student'),
(22, '41491230N', 'Antonio', 'Domínguez', 'Guerrero', 'Almería', 'C/ Cabo de Gata', '626652498', '1999-02-11', 'M', 'student'),
(23, '64753215G', 'Irene', 'Hernández', 'Martínez', 'Almería', 'C/ Zapillo', '628452384', '1996-03-12', 'F', 'student'),
(24, '85135690V', 'Sonia', 'Gea', 'Ruiz', 'Almería', 'C/ Mercurio', '678812017', '1995-04-13', 'NB', 'student');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `students_enroll_subjects`
--
ALTER TABLE `students_enroll_subjects`
  ADD PRIMARY KEY (`student_id`,`subject_id`,`school_year_id`),
  ADD KEY `subject_id` (`subject_id`),
  ADD KEY `school_year_id` (`school_year_id`);

--
-- Indices de la tabla `subjects`
--
ALTER TABLE `subjects`
  ADD PRIMARY KEY (`id`),
  ADD KEY `professor_id` (`professor_id`),
  ADD KEY `degree_id` (`degree_id`);

--
-- Indices de la tabla `school_years`
--
ALTER TABLE `school_years`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `departments`
--
ALTER TABLE `departments`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `degrees`
--
ALTER TABLE `degrees`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `professors`
--
ALTER TABLE `professors`
  ADD PRIMARY KEY (`professor_id`),
  ADD KEY `department_id` (`department_id`);

--
-- Indices de la tabla `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nif` (`nif`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `subjects`
--
ALTER TABLE `subjects`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT de la tabla `school_years`
--
ALTER TABLE `school_years`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `departments`
--
ALTER TABLE `departments`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `degrees`
--
ALTER TABLE `degrees`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `students_enroll_subjects`
--
ALTER TABLE `students_enroll_subjects`
  ADD CONSTRAINT `students_enroll_subjects_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `students_enroll_subjects_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`id`),
  ADD CONSTRAINT `students_enroll_subjects_ibfk_3` FOREIGN KEY (`school_year_id`) REFERENCES `school_years` (`id`);

--
-- Filtros para la tabla `subjects`
--
ALTER TABLE `subjects`
  ADD CONSTRAINT `subjects_ibfk_1` FOREIGN KEY (`professor_id`) REFERENCES `professors` (`professor_id`),
  ADD CONSTRAINT `subjects_ibfk_2` FOREIGN KEY (`degree_id`) REFERENCES `degrees` (`id`);

--
-- Filtros para la tabla `professors`
--
ALTER TABLE `professors`
  ADD CONSTRAINT `professors_ibfk_1` FOREIGN KEY (`professor_id`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `professors_ibfk_2` FOREIGN KEY (`department_id`) REFERENCES `departments` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
