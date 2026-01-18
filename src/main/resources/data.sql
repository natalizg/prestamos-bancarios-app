INSERT INTO solicitud_prestamo
(nombre_solicitante, importe_solicitado, divisa, documento_identidad, fecha_creacion, estado)
VALUES
('Juan Pérez', 10000.00, 'EUR', '12345678A', CURRENT_TIMESTAMP, 'PENDIENTE');

INSERT INTO solicitud_prestamo
(nombre_solicitante, importe_solicitado, divisa, documento_identidad, fecha_creacion, estado)
VALUES
('María López', 5000.00, 'EUR', '87654321B', CURRENT_TIMESTAMP, 'APROBADA');

INSERT INTO solicitud_prestamo
(nombre_solicitante, importe_solicitado, divisa, documento_identidad, fecha_creacion, estado)
VALUES
('Carlos Gómez', 15000.00, 'USD', 'X1234567C', CURRENT_TIMESTAMP, 'RECHAZADA');

INSERT INTO solicitud_prestamo
(nombre_solicitante, importe_solicitado, divisa, documento_identidad, fecha_creacion, estado)
VALUES
('Ana Martínez', 7000.00, 'EUR', 'Y7654321D', CURRENT_TIMESTAMP, 'CANCELADA');
