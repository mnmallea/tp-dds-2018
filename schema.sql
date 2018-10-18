
    create table Actuador (
        tipoActuador varchar(31) not null,
        id bigint not null auto_increment,
        gradosQueBaja integer,
        luxQueSube double precision,
        primary key (id)
    )

    create table Categoria (
        id bigint not null auto_increment,
        cargoFijo float,
        cargoVariable float,
        topeInferior float,
        topeSuperior float,
        primary key (id)
    )

    create table Cliente (
        id bigint not null,
        apellido varchar(255),
        x double precision,
        y double precision,
        domicilio varchar(255),
        efectoSimplex varchar(255),
        fechaAlta tinyblob,
        nombre varchar(255),
        nroDocumento integer not null,
        nroTelefono integer,
        puntos integer not null,
        tipoDocumento varchar(255),
        categoria_id bigint,
        zona_id bigint,
        transformador bigint,
        primary key (id)
    )

    create table Condicion (
        tipoCondicion varchar(31) not null,
        id bigint not null auto_increment,
        temperatura double precision,
        primary key (id)
    )

    create table DispositivoEstandar (
        id bigint not null auto_increment,
        consumoPorHora float,
        horasDeUsoDiarias float,
        horasMaximas float,
        horasMinimas float,
        nombre varchar(255),
        numeroDeSerie bigint,
        cliente bigint,
        primary key (id)
    )

    create table DispositivoInteligente (
        tipoDI varchar(31) not null,
        idDeFabrica bigint not null,
        consumoPorHora float,
        estado varchar(255),
        horasMaximas float,
        horasMinimas float,
        horasUsoMes float,
        nombre varchar(255),
        ultimaHoraDeEncendido tinyblob,
        cliente bigint,
        primary key (idDeFabrica)
    )

    create table HistorialEncendidos (
        id bigint not null auto_increment,
        fin tinyblob,
        inicio tinyblob,
        dispositivo bigint,
        primary key (id)
    )

    create table Regla (
        tipoRegla varchar(31) not null,
        id bigint not null,
        condicion_id bigint,
        dispositivo bigint,
        primary key (id)
    )

    create table Regla_Actuador (
        Regla_id bigint not null,
        actuadores_id bigint not null
    )

    create table Sensor (
        tipoSensor varchar(31) not null,
        id bigint not null auto_increment,
        primary key (id)
    )

    create table Sensor_Regla (
        Sensor_id bigint not null,
        reglas_id bigint not null
    )

    create table Transformador (
        id bigint not null,
        x double precision,
        y double precision,
        zona_id bigint,
        primary key (id)
    )

    create table Zona (
        id bigint not null,
        x double precision,
        y double precision,
        radio double precision,
        primary key (id)
    )

    alter table Cliente 
        add constraint FK_svhhh7o13efkdj194w94ppex7 
        foreign key (categoria_id) 
        references Categoria (id)

    alter table Cliente 
        add constraint FK_d7umpdkxv8ljfkkmp0fujp7d6 
        foreign key (zona_id) 
        references Zona (id)

    alter table Cliente 
        add constraint FK_8bjdkubjjqqqi2jc4tj7i35p3 
        foreign key (transformador) 
        references Transformador (id)

    alter table DispositivoEstandar 
        add constraint FK_cyn91dsfephquocsrp2udtj3a 
        foreign key (cliente) 
        references Cliente (id)

    alter table DispositivoInteligente 
        add constraint FK_6pl8ujr8w3xswpkwshwfj09ng 
        foreign key (cliente) 
        references Cliente (id)

    alter table HistorialEncendidos 
        add constraint FK_fsui0v47tjp4tv4sbhaweenqd 
        foreign key (dispositivo) 
        references DispositivoInteligente (idDeFabrica)

    alter table Regla 
        add constraint FK_e71t5krwygex1gsj8b9d6s3my 
        foreign key (condicion_id) 
        references Condicion (id)

    alter table Regla 
        add constraint FK_cdfc8fvmhangeqfvo9tvl2rc 
        foreign key (dispositivo) 
        references DispositivoInteligente (idDeFabrica)

    alter table Regla_Actuador 
        add constraint FK_587v6ydb46mj6nptnkhauo4ih 
        foreign key (actuadores_id) 
        references Actuador (id)

    alter table Regla_Actuador 
        add constraint FK_ebuqgyi40ganqaic4lr1x4ptr 
        foreign key (Regla_id) 
        references Regla (id)

    alter table Sensor_Regla 
        add constraint FK_tg1vda1bhnu6suxwf8kx3trr5 
        foreign key (reglas_id) 
        references Regla (id)

    alter table Sensor_Regla 
        add constraint FK_qbccgm8f79fo1dx0jqt4a5owk 
        foreign key (Sensor_id) 
        references Sensor (id)

    alter table Transformador 
        add constraint FK_mntokwxf4e0tv4rx6778cxr2c 
        foreign key (zona_id) 
        references Zona (id)
