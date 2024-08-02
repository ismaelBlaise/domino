DROP DATABASE dominos;

CREATE DATABASE dominos WITH OWNER postgres;

\c dominos;

CREATE TABLE administrateurs (
    admin_id SERIAL PRIMARY KEY,
    pseudo VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    mot_de_passe VARCHAR(255) NOT NULL,
    cree_le TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);


CREATE TABLE joueurs (
    joueur_id SERIAL PRIMARY KEY,
    pseudo VARCHAR(50) NOT NULL UNIQUE,
    email VARCHAR(100) NOT NULL UNIQUE,
    contact VARCHAR(100) NOT NULL UNIQUE,
    mot_de_passe VARCHAR(255) NOT NULL,
    cree_le TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE type_transactions(
    type_transaction_id SERIAL PRIMARY KEY,
    type_transaction VARCHAR(255) CHECK (type_transaction IN ('retrait', 'depot')) NOT NULL
);

CREATE TABLE transactions(
    transaction_id SERIAL PRIMARY KEY,
    joueur_id INT REFERENCES joueurs(joueur_id) NOT NULL ON DELETE CASCADE,
    type_transaction_id INT REFERENCES type_transactions(type_transaction_id) NOT NULL ON DELETE CASCADE,
    montant DECIMAL(10,2) NOT NULL,
    statut VARCHAR(20) CHECK (statut IN ('en_attente', 'terminee')) NOT NULL,
    effectuer_le TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE bannissements (
    bannissement_id SERIAL PRIMARY KEY,
    joueur_id INT REFERENCES joueurs(joueur_id) ON DELETE CASCADE,
    admin_id INT REFERENCES administrateurs(admin_id) ON DELETE SET NULL,
    date_bannissement TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    raison TEXT,
    date_retablissement TIMESTAMP
);

CREATE TABLE parties (
    partie_id SERIAL PRIMARY KEY,
    statut VARCHAR(20) CHECK (statut IN ('en_attente', 'en_cours', 'terminee')) NOT NULL,
    nombre_joueur INT NOT NULL,
    cree_le TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    terminee_le TIMESTAMP
);

CREATE TABLE dominos (
    domino_id SERIAL PRIMARY KEY,
    valeur1 INT CHECK (valeur1 BETWEEN 0 AND 6) NOT NULL,
    valeur2 INT CHECK (valeur2 BETWEEN 0 AND 6) NOT NULL,
    UNIQUE (valeur1, valeur2)
);

CREATE TABLE mains_joueurs (
    main_id SERIAL PRIMARY KEY,
    joueur_id INT REFERENCES joueurs(joueur_id) ON DELETE CASCADE,
    partie_id INT REFERENCES parties(partie_id) ON DELETE CASCADE,
    domino_id INT REFERENCES dominos(domino_id) ON DELETE CASCADE,
    UNIQUE (joueur_id, partie_id, domino_id)
);

CREATE TABLE partie_joueurs (
    partie_joueur_id SERIAL PRIMARY KEY,
    partie_id INT REFERENCES parties(partie_id) ON DELETE CASCADE,
    joueur_id INT REFERENCES joueurs(joueur_id) ON DELETE CASCADE,
    score INT DEFAULT 0,
    tour BOOLEAN DEFAULT FALSE
);

CREATE TABLE coups (
    coup_id SERIAL PRIMARY KEY,
    partie_id INT REFERENCES parties(partie_id) ON DELETE CASCADE,
    joueur_id INT REFERENCES joueurs(joueur_id) ON DELETE CASCADE,
    domino_id INT REFERENCES dominos(domino_id) ON DELETE CASCADE,
    position INT NOT NULL,
    joue_le TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (partie_id, position)
);

CREATE TABLE etat_parties (
    etat_partie_id SERIAL PRIMARY KEY,
    partie_id INT REFERENCES parties(partie_id) ON DELETE CASCADE,
    domino_id INT REFERENCES dominos(domino_id) ON DELETE CASCADE,
    position INT NOT NULL,
    ajoute_le TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE (partie_id, position)
);

CREATE TABLE discussions (
    discussion_id SERIAL PRIMARY KEY,
    partie_id INT REFERENCES parties(partie_id) ON DELETE CASCADE,
    joueur_id INT REFERENCES joueurs(joueur_id) ON DELETE CASCADE,
    message TEXT NOT NULL,
    envoye_le TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE mises_joueurs (
    mise_id SERIAL PRIMARY KEY,
    partie_id INT REFERENCES parties(partie_id) ON DELETE CASCADE,
    joueur_id INT REFERENCES joueurs(joueur_id) ON DELETE CASCADE,
    montant DECIMAL(10, 2) NOT NULL,
    mise_le TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
