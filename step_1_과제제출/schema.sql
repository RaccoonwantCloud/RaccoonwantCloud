DROP TABLE IF EXISTS BOARD;

CREATE TABLE BOARD (
    ID BIGINT NOT NULL AUTO_INCREMENT,
    TITLE VARCHAR(50) NOT NULL,
    CONTENTS TEXT NOT NULL,
    REG_DT DATETIME NOT NULL,
    UPD_DT DATETIME,
    PRIMARY KEY (id)
);

select * from BOARD;