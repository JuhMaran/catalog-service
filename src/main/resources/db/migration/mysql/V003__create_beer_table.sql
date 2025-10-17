-- V003__create_beer_table.sql
CREATE TABLE beer (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    version INT NOT NULL DEFAULT 1,
    beer_name VARCHAR(100) NOT NULL,
    beer_style VARCHAR(50) NOT NULL,
    ibu INT,
    abv DOUBLE,
    brewery_id BIGINT,
    active BOOLEAN DEFAULT TRUE,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT fk_brewery FOREIGN KEY (brewery_id) REFERENCES brewery(id)
);

-- Populate beers
INSERT INTO beer (version, beer_name, beer_style, ibu, abv, brewery_id, active) VALUES
(1, 'MOSAIC', 'IPA', 60, 6.4, 1, TRUE),
(1, 'KATANA', 'IPA', 71, 7.3, 2, TRUE),
(1, 'LEAVE IT TO BEAVER', 'HAZY_IPA', 25, 6.0, 1, TRUE),
(1, 'PILSEN', 'AMERICAN_LAGER', 14, 4.5, 3, TRUE),
(1, 'GUEIXA', 'SESSION_IPA', 47, 4.7, 2, TRUE),
(1, 'JUREMA', 'APA', 45, 5.2, 1, TRUE),
(1, 'SLINGSHOT', 'HAZY_PALE_ALE', 55, 5.3, 4, TRUE),
(1, 'AUSSIE', 'APA', 35, 4.6, 3, TRUE),
(1, 'MADAME_SATA', 'TRIPLE_IPA', 100, 10.0, 5, TRUE);
