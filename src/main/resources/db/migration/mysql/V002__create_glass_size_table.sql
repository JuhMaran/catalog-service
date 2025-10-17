CREATE TABLE glass_size (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    version INT NOT NULL,
    name VARCHAR(50) NOT NULL,
    volume_ml INT NOT NULL,
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Populate initial data
INSERT INTO glass_size (version, name, volume_ml) VALUES
(1, 'HALF', 250),
(1, 'PINT', 473),
(1, 'GROWLER', 1000);
