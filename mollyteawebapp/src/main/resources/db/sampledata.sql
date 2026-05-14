-- ============================================================
-- MollyTea Web App - Sample Data
-- ============================================================
 
USE mollytea;
 
-- ------------------------------------------------------------
-- category (3)
-- ------------------------------------------------------------
INSERT INTO category (code, name, description) VALUES
('DRINK',     'Drink',     'All kinds of beverages including milk tea, juice and more'),
('FOOD',      'Food',      'Snacks and light meals to go with your drink'),
('ICE_CREAM', 'Ice Cream', 'Creamy handcrafted ice cream in various flavours');
 
-- ------------------------------------------------------------
-- account (5)
-- ------------------------------------------------------------
INSERT INTO account (phone, password) VALUES
('0412345678', 'hashed_password_1'),
('0423456789', 'hashed_password_2'),
('0434567890', 'hashed_password_3'),
('0445678901', 'hashed_password_4'),
('0456789012', 'hashed_password_5');
 
-- ------------------------------------------------------------
-- address (5)  →  account.phone
-- ------------------------------------------------------------
INSERT INTO address (phone, address_line1, address_line2, postcode) VALUES
('0412345678', '12 Harbour St',    'Apt 3A',    '2000'),
('0423456789', '88 Collins St',    'Level 5',   '3000'),
('0434567890', '5 Queen St',        NULL,        '4000'),
('0445678901', '200 Adelaide St',  'Suite 10',  '5000'),
('0456789012', '33 Murray St',      NULL,        '6000');
 
-- ------------------------------------------------------------
-- product (5)  →  category.id
-- ------------------------------------------------------------
INSERT INTO product (name, price, category_id) VALUES
('Brown Sugar Milk Tea',   6.50, 1),   -- Drink
('Taro Milk Tea',          6.00, 1),   -- Drink
('Waffles',                8.50, 2),   -- Food
('Takoyaki',               9.00, 2),   -- Food
('Matcha Ice Cream',       5.50, 3);   -- Ice Cream
 