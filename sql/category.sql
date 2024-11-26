create table category
(
    id_category int                         not null
        primary key,
    libelle     varchar(50) charset utf8mb3 not null
);

INSERT INTO db_jardigenie.category (id_category, libelle) VALUES (1, 'outils');
INSERT INTO db_jardigenie.category (id_category, libelle) VALUES (2, 'bacs');
INSERT INTO db_jardigenie.category (id_category, libelle) VALUES (3, 'graines');
