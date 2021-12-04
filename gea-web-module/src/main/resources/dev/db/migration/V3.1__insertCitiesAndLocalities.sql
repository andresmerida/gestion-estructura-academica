DELETE FROM country where name='Bolivia' or name='Peru';
INSERT INTO country (id, name, initials, active, newattribute) values (1, 'Bolivia', 'BOL', TRUE, 'TEST'), (2, 'Peru', 'PER', TRUE, 'TEST');

INSERT INTO city (id, name, initials, active, countryId)
VALUES (1, 'La Paz', 'LPZ', true, 1), (2, 'Cochabamba', 'CBB', true, 1),(3, 'Santa Cruz', 'STC', true, 1);

INSERT INTO locality (localityId, cityId, name, initials, active)
VALUES (1, 2, 'Cercado', 'COCHA', TRUE), (2, 2, 'Sacaba', 'SACABA', TRUE), (3, 2, 'Quillacollo', 'QUILL', TRUE),
       (1, 1, 'La Paz', 'LA PAZ', TRUE), (2, 1, 'El Alto', 'ALTO', TRUE), (3, 1, 'Caracollo', 'CARA', TRUE),
       (1, 3, 'Santa Cruz', 'STA', TRUE), (2, 3, 'Warnes', 'WARNES', TRUE), (3, 3, 'Montero', 'MONTERO', TRUE);
