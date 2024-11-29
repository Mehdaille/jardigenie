-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 29 nov. 2024 à 14:44
-- Version du serveur : 8.3.0
-- Version de PHP : 8.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `db_jardigenie`
--

-- --------------------------------------------------------

--
-- Structure de la table `article`
--

DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `id_article` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `description` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `prix` decimal(10,2) NOT NULL,
  `image` varchar(800) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `CATEGORY_id_category` int NOT NULL,
  PRIMARY KEY (`id_article`),
  KEY `ARTICLE_CATEGORY_FK` (`CATEGORY_id_category`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `article`
--

INSERT INTO `article` (`id_article`, `nom`, `description`, `prix`, `image`, `CATEGORY_id_category`) VALUES
(1, 'Graines de gazon', 'Ces graines feront pousser un gazon très rapidement, en moins de 7 jours vous aurez une pelouse qui fera des jaloux, afin de vous prélasser tout l\'été', 15.90, '../images/grainesgazon.jpg', 3),
(2, 'Tondeuse', 'Si vous souhaitez un jardin à l\'anglaise, cette tondeuse robuste est faite pour vous. Légère et maniable, n\'ayez plus peur de la sortir !! (on parle bien de la tondeuse messieurs)', 475.00, '../images/tondeuse.jpg', 1),
(11, 'Taillehaie', 'Pour tailler les buissons et les haies autour de la maison', 180.00, '../images/taillehaie.jpg', 1),
(3, 'Brouette', 'Transportez tous vos déchets de jardinage avec cette brouette nouvelle génération réalisée en matière totalement naturelle avec un compost 100% bio', 84.00, '../images/brouette.jpg', 2),
(10, 'Pulvérisateur', 'Très simple à déplacer grâce aux roues pneumatiques et aux roues pivotantes du chariot. C\'est un outil parfait pour les petits et moyens travaux de pulvérisation.', 460.00, '../images/pulverisateur.jpg', 1),
(12, 'Composteur', 'Le montage du composteur est facilité grâce aux tiges qui coulissent dans les charnières d\'angles', 120.00, '../images/composteur.jpg', 2);

-- --------------------------------------------------------

--
-- Structure de la table `category`
--

DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `id_category` int NOT NULL,
  `libelle` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_category`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `category`
--

INSERT INTO `category` (`id_category`, `libelle`) VALUES
(1, 'outils'),
(2, 'bacs'),
(3, 'graines');

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE IF NOT EXISTS `role` (
  `id_role` int NOT NULL,
  `libelle` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_role`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id_role`, `libelle`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Structure de la table `role_utilisateur`
--

DROP TABLE IF EXISTS `role_utilisateur`;
CREATE TABLE IF NOT EXISTS `role_utilisateur` (
  `UTILISATEUR_id_utilisateur` int NOT NULL,
  `ROLE_id_role` int NOT NULL,
  PRIMARY KEY (`UTILISATEUR_id_utilisateur`,`ROLE_id_role`),
  KEY `ROLE_UTILISATEUR_ROLE_FK` (`ROLE_id_role`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id_utilisateur` int NOT NULL AUTO_INCREMENT,
  `nom` char(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `prenom` char(50) COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `mot_de_passe` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_utilisateur`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id_utilisateur`, `nom`, `prenom`, `email`, `mot_de_passe`) VALUES
(1, 'Mehdi', 'Mehdi', 'mehdi@mehdi.com', 'mehdi'),
(2, 'Marie', 'Marie', 'marie@marie.com', 'marie');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
