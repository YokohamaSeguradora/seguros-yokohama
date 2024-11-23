DROP TABLE automovel CASCADE CONSTRAINTS;

DROP TABLE fatura CASCADE CONSTRAINTS;

DROP TABLE seguro CASCADE CONSTRAINTS;

DROP TABLE usuario CASCADE CONSTRAINTS;

-- predefined type, no DDL - MDSYS.SDO_GEOMETRY

-- predefined type, no DDL - XMLTYPE

CREATE TABLE automovel (
    id_automovel              INTEGER NOT NULL,
    tipo_automovel            VARCHAR2(50 CHAR) NOT NULL,
    placa_automovel           CHAR(7 CHAR) NOT NULL,
    renavam_automovel         CHAR(11 CHAR) NOT NULL,
    modelo_automovel          VARCHAR2(50 CHAR) NOT NULL,
    data_modelo_automovel     DATE NOT NULL,
    data_fabricacao_automovel DATE NOT NULL,
    cep_pernoite_automovel    CHAR(8 CHAR) NOT NULL
);

COMMENT ON COLUMN automovel.tipo_automovel IS
    'Carro ou Moto';

ALTER TABLE automovel ADD CONSTRAINT automovel_pk PRIMARY KEY ( id_automovel );

ALTER TABLE automovel ADD CONSTRAINT automovel_placa_automovel_un UNIQUE ( placa_automovel );

ALTER TABLE automovel ADD CONSTRAINT automovel_renavam_automovel_un UNIQUE ( renavam_automovel );

CREATE TABLE fatura (
    id_fatura              INTEGER NOT NULL,
    data_vencimento_fatura DATE NOT NULL,
    status_fatura          VARCHAR2(50 CHAR) NOT NULL,
    valor_fatura           NUMBER NOT NULL,
    id_seguro              INTEGER NOT NULL
);

COMMENT ON COLUMN fatura.status_fatura IS
    'Pago ou Pendente';

COMMENT ON COLUMN fatura.valor_fatura IS
    'Valor da fatura em reais.';

ALTER TABLE fatura ADD CONSTRAINT fatura_pk PRIMARY KEY ( id_fatura );

CREATE TABLE seguro (
    id_seguro     INTEGER NOT NULL,
    tipo_seguro   VARCHAR2(50 CHAR) NOT NULL,
    id_usuario    INTEGER NOT NULL,
    id_automovel  INTEGER NOT NULL
);

COMMENT ON COLUMN seguro.tipo_seguro IS
    'Carro, Moto, Caminhão ou Bicicleta';

CREATE UNIQUE INDEX seguro__idx ON
    seguro (
        id_automovel
    ASC );

ALTER TABLE seguro ADD CONSTRAINT seguro_pk PRIMARY KEY ( id_seguro );

CREATE TABLE usuario (
    id_usuario            INTEGER NOT NULL,
    tipo_usuario          VARCHAR2(50 CHAR) NOT NULL,
    nome_completo_usuario VARCHAR2(255 CHAR) NOT NULL,
    cpf_usuario           CHAR(11 CHAR) NOT NULL,
    email_usuario         VARCHAR2(50 CHAR) NOT NULL,
    telefone_usuario      CHAR(11 CHAR) NOT NULL,
    senha_usuario         VARCHAR2(100 CHAR) NOT NULL,
    endereco_usuario      VARCHAR2(50 CHAR) NOT NULL,
    cnh_segurado          CHAR(9 CHAR)
);

COMMENT ON COLUMN usuario.tipo_usuario IS
    '(Segurado ou Corretor)';

ALTER TABLE usuario ADD CONSTRAINT usuario_pk PRIMARY KEY ( id_usuario );

ALTER TABLE usuario ADD CONSTRAINT usuario_cpf_usuario_un UNIQUE ( cpf_usuario );

ALTER TABLE usuario ADD CONSTRAINT usuario_email_usuario_un UNIQUE ( email_usuario );

ALTER TABLE usuario ADD CONSTRAINT usuario_telefone_usuario_un UNIQUE ( telefone_usuario );

ALTER TABLE usuario ADD CONSTRAINT usuario_cnh_segurado_un UNIQUE ( cnh_segurado );

ALTER TABLE fatura
    ADD CONSTRAINT fatura_seguro_fk FOREIGN KEY ( id_seguro )
        REFERENCES seguro ( id_seguro );

ALTER TABLE seguro
    ADD CONSTRAINT seguro_automovel_fk FOREIGN KEY ( id_automovel )
        REFERENCES automovel ( id_automovel );

ALTER TABLE seguro
    ADD CONSTRAINT seguro_usuario_fk FOREIGN KEY ( id_usuario )
        REFERENCES usuario ( id_usuario );


CREATE SEQUENCE SEQ_ID_USUARIO START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_USUARIO
BEFORE INSERT ON USUARIO FOR EACH ROW
BEGIN
	SELECT SEQ_ID_USUARIO.nextval
	INTO :NEW.id_usuario
	FROM DUAL;
END;
/


CREATE SEQUENCE SEQ_ID_SEGURO START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_SEGURO
BEFORE INSERT ON SEGURO FOR EACH ROW
BEGIN
	SELECT SEQ_ID_SEGURO.nextval
	INTO :NEW.id_seguro
	FROM DUAL;
END;
/


CREATE SEQUENCE SEQ_ID_AUTOMOVEL START WITH 1 INCREMENT BY 1;

CREATE OR REPLACE TRIGGER TR_INSERT_AUTOMOVEL
BEFORE INSERT ON AUTOMOVEL FOR EACH ROW
BEGIN
	SELECT SEQ_ID_AUTOMOVEL.nextval
	INTO :NEW.id_automovel
	FROM DUAL;
END;
/

COMMIT;