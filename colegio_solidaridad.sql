/*
 Navicat Premium Data Transfer

 Source Server         : deymar
 Source Server Type    : MySQL
 Source Server Version : 100421
 Source Host           : localhost:3306
 Source Schema         : colegio_solidaridad

 Target Server Type    : MySQL
 Target Server Version : 100421
 File Encoding         : 65001

 Date: 28/06/2022 16:03:45
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for alumno
-- ----------------------------
DROP TABLE IF EXISTS `alumno`;
CREATE TABLE `alumno`  (
  `Id_alumno` int NOT NULL AUTO_INCREMENT,
  `Rude` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Patologias` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Id_tutor_FK` int NOT NULL,
  `Id_curso_FK` int NOT NULL,
  `Id_persona_FK` int NOT NULL,
  PRIMARY KEY (`Id_alumno`) USING BTREE,
  INDEX `Id_persona_FK`(`Id_persona_FK`) USING BTREE,
  INDEX `Id_tutor_FK`(`Id_tutor_FK`) USING BTREE,
  INDEX `Id_curso_FK`(`Id_curso_FK`) USING BTREE,
  CONSTRAINT `alumno_ibfk_1` FOREIGN KEY (`Id_persona_FK`) REFERENCES `persona` (`Id_persona`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `alumno_ibfk_2` FOREIGN KEY (`Id_tutor_FK`) REFERENCES `tutor` (`Id_tutor`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `alumno_ibfk_3` FOREIGN KEY (`Id_curso_FK`) REFERENCES `curso` (`Id_curso`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of alumno
-- ----------------------------
INSERT INTO `alumno` VALUES (1, '78945612345A', 'ninguna', 1, 1, 3);

-- ----------------------------
-- Table structure for asignatura
-- ----------------------------
DROP TABLE IF EXISTS `asignatura`;
CREATE TABLE `asignatura`  (
  `Id_asignatura` int NOT NULL AUTO_INCREMENT,
  `Materia` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id_asignatura`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of asignatura
-- ----------------------------
INSERT INTO `asignatura` VALUES (1, 'Matematicas');

-- ----------------------------
-- Table structure for curso
-- ----------------------------
DROP TABLE IF EXISTS `curso`;
CREATE TABLE `curso`  (
  `Id_curso` int NOT NULL AUTO_INCREMENT,
  `Grado` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Paralelo` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Id_profesor_FK` int NOT NULL,
  PRIMARY KEY (`Id_curso`) USING BTREE,
  INDEX `Id_profesor_FK`(`Id_profesor_FK`) USING BTREE,
  CONSTRAINT `curso_ibfk_1` FOREIGN KEY (`Id_profesor_FK`) REFERENCES `profesor` (`Id_profesor`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of curso
-- ----------------------------
INSERT INTO `curso` VALUES (1, '5° de sec', 'A', 1);
INSERT INTO `curso` VALUES (2, 'cuarto de sec', 'A', 1);

-- ----------------------------
-- Table structure for persona
-- ----------------------------
DROP TABLE IF EXISTS `persona`;
CREATE TABLE `persona`  (
  `Id_persona` int NOT NULL AUTO_INCREMENT,
  `CI` int NOT NULL,
  `Nombres` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Apellidos` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Fecha_nacimiento` date NULL DEFAULT NULL,
  `Edad` int NOT NULL,
  `Celular` int NULL DEFAULT NULL,
  `Direccion` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Id_usuario_FK` int NULL DEFAULT NULL,
  PRIMARY KEY (`Id_persona`) USING BTREE,
  INDEX `Id_usuario_FK`(`Id_usuario_FK`) USING BTREE,
  CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`Id_usuario_FK`) REFERENCES `usuario` (`Id_usuario`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of persona
-- ----------------------------
INSERT INTO `persona` VALUES (1, 11545268, 'Deymar', 'Huanca Arcani', '2000-11-24', 21, 76293199, 'C:Colombia 4741', 1);
INSERT INTO `persona` VALUES (2, 4306223, 'Maxima', 'Arcani Arcani', '1950-11-08', 71, 77236346, 'C: ecuador 4444', 1);
INSERT INTO `persona` VALUES (3, 100451635, 'Estrella Belen', 'Huanca Arcani', '2005-11-18', 16, 78451236, 'Av. Salvador 4578', 1);

-- ----------------------------
-- Table structure for profesor
-- ----------------------------
DROP TABLE IF EXISTS `profesor`;
CREATE TABLE `profesor`  (
  `Id_profesor` int NOT NULL AUTO_INCREMENT,
  `Id_asignatura_FK` int NOT NULL,
  `Id_persona_FK` int NOT NULL,
  PRIMARY KEY (`Id_profesor`) USING BTREE,
  INDEX `Id_asignatura_FK`(`Id_asignatura_FK`) USING BTREE,
  INDEX `Id_persona_FK`(`Id_persona_FK`) USING BTREE,
  CONSTRAINT `profesor_ibfk_1` FOREIGN KEY (`Id_asignatura_FK`) REFERENCES `asignatura` (`Id_asignatura`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `profesor_ibfk_2` FOREIGN KEY (`Id_persona_FK`) REFERENCES `persona` (`Id_persona`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of profesor
-- ----------------------------
INSERT INTO `profesor` VALUES (1, 1, 1);

-- ----------------------------
-- Table structure for tutor
-- ----------------------------
DROP TABLE IF EXISTS `tutor`;
CREATE TABLE `tutor`  (
  `Id_tutor` int NOT NULL AUTO_INCREMENT,
  `Oficio` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `Parentesco` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Id_persona_FK` int NOT NULL,
  PRIMARY KEY (`Id_tutor`) USING BTREE,
  INDEX `Id_persona_FK`(`Id_persona_FK`) USING BTREE,
  CONSTRAINT `tutor_ibfk_1` FOREIGN KEY (`Id_persona_FK`) REFERENCES `persona` (`Id_persona`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of tutor
-- ----------------------------
INSERT INTO `tutor` VALUES (1, 'Ama de casa', 'Mama', 2);

-- ----------------------------
-- Table structure for usuario
-- ----------------------------
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario`  (
  `Id_usuario` int NOT NULL AUTO_INCREMENT,
  `Nombres` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Nombre_usuario` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `Contrasena` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `rol` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`Id_usuario`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of usuario
-- ----------------------------
INSERT INTO `usuario` VALUES (1, 'Deymar', 'deymar', '123', 'admin');
INSERT INTO `usuario` VALUES (2, 'Cristian', 'chichico', '123', 'admin');
INSERT INTO `usuario` VALUES (3, 'Milenka Quisbert', 'mile', '123', 'admin');

SET FOREIGN_KEY_CHECKS = 1;
