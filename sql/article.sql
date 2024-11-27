create table article
(
    id_article           int auto_increment
        primary key,
    nom                  varchar(50) charset utf8mb3  not null,
    description          varchar(200) charset utf8mb3 not null,
    prix                 decimal(10, 2)               not null,
    image                varchar(800)                 null,
    CATEGORY_id_category int                          not null
);

create index ARTICLE_CATEGORY_FK
    on article (CATEGORY_id_category);

INSERT INTO db_jardigenie.article (id_article, nom, description, prix, image, CATEGORY_id_category) VALUES (1, 'Graines de gazon', 'Ces graines feront pousser un gazon très rapidement, en moins de 7 jours vous aurez une pelouse qui fera des jaloux, afin de vous prélasser tout l\'été', 15.90, '../images/grainesgazon.jpg', 3);
INSERT INTO db_jardigenie.article (id_article, nom, description, prix, image, CATEGORY_id_category) VALUES (2, 'Tondeuse', 'Si vous souhaitez un jardin à l\'anglaise, cette tondeuse robuste est faite pour vous. Légère et maniable, n\'ayez plus peur de la sortir !! (on parle bien de la tondeuse messieurs)', 475.00, '../images/tondeuse.jpg', 1);
INSERT INTO db_jardigenie.article (id_article, nom, description, prix, image, CATEGORY_id_category) VALUES (3, 'Brouette', 'Transportez tous vos déchets de jardinage avec cette brouette nouvelle génération réalisée en matière totalement naturelle avec un compost 100% bio', 84.00, '../images/brouette.jpg', 2);
