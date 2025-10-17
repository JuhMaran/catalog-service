-- V001__create_brewery_table.sql
CREATE TABLE brewery (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    version INT NOT NULL DEFAULT 1,
    name VARCHAR(100) NOT NULL,
    city VARCHAR(100),
    state VARCHAR(50),
    description VARCHAR(255),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Populate breweries
INSERT INTO brewery (version, name, city, state, description) VALUES
(1, 'MOSAIC', NULL, NULL, 'Craft brewery'),
(1, 'KOHZAN', 'Curitiba', 'PR', 'Cervejaria artesanal independente'),
(1, 'Irônica', NULL, NULL, 'Independent craft brewery'),
(1, 'SWAMP', NULL, NULL, 'Craft brewery'),
(1, 'Ignorus', NULL, NULL, 'Independent brewery');
