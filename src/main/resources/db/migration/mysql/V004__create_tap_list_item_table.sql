CREATE TABLE tap_list_item (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    version INT NOT NULL DEFAULT 1,
    beer_id BIGINT NOT NULL,
    glass_size_id BIGINT NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_beer FOREIGN KEY (beer_id) REFERENCES beer(id),
    CONSTRAINT fk_glass_size FOREIGN KEY (glass_size_id) REFERENCES glass_size(id)
);

-- Populate tap list items
-- MOSAIC
INSERT INTO tap_list_item (version, beer_id, glass_size_id, price) VALUES
(1, 1, 1, 0.00),  -- HALF
(1, 1, 2, 0.00),  -- PINT
(1, 1, 3, 0.00);  -- GROWLER

-- KATANA
INSERT INTO tap_list_item (version, beer_id, glass_size_id, price) VALUES
(1, 2, 1, 18.00),
(1, 2, 2, 22.00),
(1, 2, 3, 42.00);

-- LEAVE IT TO BEAVER
INSERT INTO tap_list_item (version, beer_id, glass_size_id, price) VALUES
(1, 3, 1, 0.00),
(1, 3, 2, 0.00),
(1, 3, 3, 0.00);

-- PILSEN
INSERT INTO tap_list_item (version, beer_id, glass_size_id, price) VALUES
(1, 4, 1, 10.00),
(1, 4, 2, 15.00),
(1, 4, 3, 29.00);

-- GUEIXA
INSERT INTO tap_list_item (version, beer_id, glass_size_id, price) VALUES
(1, 5, 1, 16.00),
(1, 5, 2, 21.00),
(1, 5, 3, 38.00);

-- JUREMA
INSERT INTO tap_list_item (version, beer_id, glass_size_id, price) VALUES
(1, 6, 1, 0.00),
(1, 6, 2, 0.00),
(1, 6, 3, 0.00);

-- SLINGSHOT
INSERT INTO tap_list_item (version, beer_id, glass_size_id, price) VALUES
(1, 7, 1, 17.00),
(1, 7, 2, 22.00),
(1, 7, 3, 41.00);

-- AUSSIE
INSERT INTO tap_list_item (version, beer_id, glass_size_id, price) VALUES
(1, 8, 1, 14.00),
(1, 8, 2, 18.00),
(1, 8, 3, 33.00);

-- MADAME SATÃ
INSERT INTO tap_list_item (version, beer_id, glass_size_id, price) VALUES
(1, 9, 1, 24.00),
(1, 9, 2, 30.00),
(1, 9, 3, 57.00);
