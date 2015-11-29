
    create table Consultation (
        ID bigint not null,
        compteRendu varchar(255),
        dateDebut datetime,
        dateFin datetime,
        id_medecin bigint,
        id_patient bigint,
        primary key (ID)
    );

    create table Interaction (
        ID bigint not null,
        precautions varchar(255),
        risques varchar(255),
        severite varchar(255),
        id_produitA integer,
        id_produitB integer,
        id_consultation bigint,
        primary key (ID)
    );

    create table Medecin (
        RPPS varchar(255),
        compte varchar(255),
        ID bigint not null,
        primary key (ID)
    );

    create table Patient (
        dateNaissance datetime,
        sexe varchar(255),
        ID bigint not null,
        primary key (ID)
    );

    create table Personne (
        type_personne varchar(31) not null,
        ID bigint not null,
        nom varchar(255),
        prenom varchar(255),
        primary key (ID)
    );

    create table Produit (
        ID integer not null,
        cis varchar(255),
        nom varchar(255),
        primary key (ID)
    );

    create table Traitement (
        ID integer not null,
        posologie varchar(255),
        id_consultation bigint,
        primary key (ID)
    );

    create table Utilisateur (
        compte varchar(255),
        ID bigint not null,
        primary key (ID)
    );

    alter table Consultation 
        add constraint FK_15yjpjm0830vtq2edccr58r9 
        foreign key (id_medecin) 
        references Medecin (ID);

    alter table Consultation 
        add constraint FK_5k9riq9248pixulj7d4fo983w 
        foreign key (id_patient) 
        references Patient (ID);

    alter table Interaction 
        add constraint FK_3lpon96k0vps6x6odwr68k2j2 
        foreign key (id_produitA) 
        references Produit (ID);

    alter table Interaction 
        add constraint FK_b3gbknffperdhqrxp5tj44qeh 
        foreign key (id_produitB) 
        references Produit (ID);

    alter table Interaction 
        add constraint FK_nk8y5iipuwiso000yi0xug5wk 
        foreign key (id_consultation) 
        references Consultation (ID);

    alter table Medecin 
        add constraint FK_pqake284pgj9pkrfo0dluralx 
        foreign key (ID) 
        references Personne (ID);

    alter table Patient 
        add constraint FK_rkf9qfuaej34eru8j5unddm81 
        foreign key (ID) 
        references Personne (ID);

    alter table Traitement 
        add constraint FK_ecy08gsmxl9eafral0tppxte7 
        foreign key (id_consultation) 
        references Consultation (ID);

    alter table Utilisateur 
        add constraint FK_doqpsq498obfbbuolkb0i0vm5 
        foreign key (ID) 
        references Personne (ID);
