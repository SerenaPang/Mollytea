-- ============================================================
-- MollyTea Web App - MySQL Database Schema
-- ============================================================

CREATE DATABASE IF NOT EXISTS mollytea;
USE mollytea;

-- ------------------------------------------------------------
-- 1. account
-- ------------------------------------------------------------
CREATE TABLE account (
    phone       VARCHAR(20)     NOT NULL,
    password    VARCHAR(255)    NOT NULL,
    PRIMARY KEY (phone)
);

-- ------------------------------------------------------------
-- 2. address
--    phone → account.phone (1to1)
-- ------------------------------------------------------------
CREATE TABLE address (
    phone           VARCHAR(20)     NOT NULL,
    address_line1   VARCHAR(255)    NOT NULL,
    address_line2   VARCHAR(255),
    postcode        VARCHAR(20)     NOT NULL,
    PRIMARY KEY (phone),
    CONSTRAINT fk_address_account
        FOREIGN KEY (phone) REFERENCES account(phone)
        ON UPDATE CASCADE ON DELETE CASCADE
);

-- ------------------------------------------------------------
-- 3. category
-- ------------------------------------------------------------
CREATE TABLE category (
    id          BIGINT          NOT NULL AUTO_INCREMENT,
    code        VARCHAR(50),
    name        VARCHAR(100),
    description TEXT,
    PRIMARY KEY (id)
);

-- ------------------------------------------------------------
-- 4. product
--    category_id → category.id (many to one)
-- ------------------------------------------------------------
CREATE TABLE product (
    id          BIGINT              NOT NULL AUTO_INCREMENT,
    name        VARCHAR(255),
    price       DECIMAL(10, 2),
    category_id BIGINT,
    PRIMARY KEY (id),
    CONSTRAINT fk_product_category
        FOREIGN KEY (category_id) REFERENCES category(id)
        ON UPDATE CASCADE ON DELETE SET NULL
);

-- ------------------------------------------------------------
-- 5. orders
--    user_id → account.phone (many to one)
-- ------------------------------------------------------------
CREATE TABLE orders (
    id          BIGINT              NOT NULL AUTO_INCREMENT,
    user_id     VARCHAR(20),
    total_price DECIMAL(10, 2),
    status      VARCHAR(50),
    PRIMARY KEY (id),
    CONSTRAINT fk_orders_account
        FOREIGN KEY (user_id) REFERENCES account(phone)
        ON UPDATE CASCADE ON DELETE SET NULL
);

-- ------------------------------------------------------------
-- 6. order_item
--    order_id → orders.id  (many to one)
--    product_id → product.id (many to one)
-- ------------------------------------------------------------
CREATE TABLE order_item (
    id          BIGINT              NOT NULL AUTO_INCREMENT,
    order_id    BIGINT,
    product_id  BIGINT,
    quantity    INT,
    price       DECIMAL(10, 2),
    PRIMARY KEY (id),
    CONSTRAINT fk_orderitem_order
        FOREIGN KEY (order_id) REFERENCES orders(id)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_orderitem_product
        FOREIGN KEY (product_id) REFERENCES product(id)
        ON UPDATE CASCADE ON DELETE SET NULL
);

-- ------------------------------------------------------------
-- 7. cart_item
--    user_id → account.phone (many to one)
--    product_id → product.id (many to one)
-- ------------------------------------------------------------
CREATE TABLE cart_item (
    id          BIGINT              NOT NULL AUTO_INCREMENT,
    user_id     VARCHAR(20),
    product_id  BIGINT,
    quantity    INT,
    PRIMARY KEY (id),
    CONSTRAINT fk_cartitem_account
        FOREIGN KEY (user_id) REFERENCES account(phone)
        ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT fk_cartitem_product
        FOREIGN KEY (product_id) REFERENCES product(id)
        ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE SPRING_SESSION (
    PRIMARY_ID CHAR(36) NOT NULL,
    SESSION_ID CHAR(36) NOT NULL,
    CREATION_TIME BIGINT NOT NULL,
    LAST_ACCESS_TIME BIGINT NOT NULL,
    MAX_INACTIVE_INTERVAL INT NOT NULL,
    EXPIRY_TIME BIGINT NOT NULL,
    PRINCIPAL_NAME VARCHAR(100),
    CONSTRAINT SPRING_SESSION_PK PRIMARY KEY (PRIMARY_ID)
);

CREATE UNIQUE INDEX SPRING_SESSION_IX1 ON SPRING_SESSION (SESSION_ID);
CREATE INDEX SPRING_SESSION_IX2 ON SPRING_SESSION (EXPIRY_TIME);
CREATE INDEX SPRING_SESSION_IX3 ON SPRING_SESSION (PRINCIPAL_NAME);

CREATE TABLE SPRING_SESSION_ATTRIBUTES (
    SESSION_PRIMARY_ID CHAR(36) NOT NULL,
    ATTRIBUTE_NAME VARCHAR(200) NOT NULL,
    ATTRIBUTE_BYTES BLOB NOT NULL,
    CONSTRAINT SPRING_SESSION_ATTRIBUTES_PK PRIMARY KEY (SESSION_PRIMARY_ID, ATTRIBUTE_NAME),
    CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION (PRIMARY_ID) ON DELETE CASCADE
);