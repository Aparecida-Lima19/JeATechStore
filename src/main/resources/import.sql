-- Categorias
INSERT INTO tb_categoty(name) VALUES ('Acessorios');
INSERT INTO tb_categoty(name) VALUES ('Celular');
INSERT INTO tb_categoty(name) VALUES ('Computadores');

-- Produtos: Acessórios (1-8)
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Fone Bluetooth', 99.90, 'Fone de ouvido sem fio com alta qualidade de som.', 'https://img.com/fone.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Carregador Portátil', 79.90, 'Power bank de 10.000mAh.', 'https://img.com/powerbank.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Cabo USB-C', 29.90, 'Cabo USB tipo C de alta resistência.', 'https://img.com/cabo.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Suporte Veicular', 39.90, 'Suporte para fixar o celular no carro.', 'https://img.com/suporte.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Mouse Gamer', 149.90, 'Mouse ergonômico com iluminação RGB.', 'https://img.com/mouse.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Teclado Mecânico', 249.90, 'Teclado mecânico com switches azuis.', 'https://img.com/teclado.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Webcam Full HD', 199.90, 'Webcam com resolução Full HD e microfone embutido.', 'https://img.com/webcam.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Hub USB 3.0', 59.90, 'Expansor de portas USB 3.0.', 'https://img.com/hub.jpg');

-- Produtos: Celulares (9-16)
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Smartphone Galaxy S22', 3999.90, 'Celular com câmera tripla e processador octa-core.', 'https://img.com/galaxys22.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('iPhone 14', 6999.90, 'Novo iPhone com tecnologia avançada de câmera.', 'https://img.com/iphone14.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Xiaomi Redmi Note 12', 1899.90, 'Celular com excelente custo-benefício.', 'https://img.com/redmi.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Motorola Edge 30', 2799.90, 'Design sofisticado e ótima performance.', 'https://img.com/edge30.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Samsung Galaxy A54', 2299.90, 'Celular intermediário com ótima bateria.', 'https://img.com/a54.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('iPhone SE 2022', 3499.90, 'Modelo compacto com ótimo desempenho.', 'https://img.com/iphonese.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Realme GT Neo', 2099.90, 'Celular potente com carregamento rápido.', 'https://img.com/realme.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Asus ROG Phone 6', 4999.90, 'Smartphone gamer de alto desempenho.', 'https://img.com/rogphone.jpg');

-- Produtos: Computadores (17-25)
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Notebook Dell Inspiron', 3499.90, 'Notebook com processador Intel i5.', 'https://img.com/dell.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('MacBook Air M2', 7499.90, 'Notebook Apple com chip M2.', 'https://img.com/macbook.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('PC Gamer Ryzen 5', 4599.90, 'Computador gamer com placa de vídeo dedicada.', 'https://img.com/pcgamer.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Monitor LG 27"', 1299.90, 'Monitor Full HD de 27 polegadas.', 'https://img.com/monitor.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('SSD 1TB', 499.90, 'Armazenamento SSD de 1TB.', 'https://img.com/ssd.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Placa de Vídeo RTX 4060', 2299.90, 'GPU potente para jogos.', 'https://img.com/rtx4060.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Memória RAM 16GB', 349.90, 'Memória DDR4 de alta velocidade.', 'https://img.com/ram.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Gabinete Gamer', 399.90, 'Gabinete com LED RGB.', 'https://img.com/gabinete.jpg');
INSERT INTO tb_product(name, price, description, img_url) VALUES ('Fonte 650W', 299.90, 'Fonte de alimentação para PC.', 'https://img.com/fonte.jpg');

-- Acessórios (1-8)
INSERT INTO tb_product_category(product_id, Category_id) VALUES (1, 1);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (2, 1);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (3, 1);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (4, 1);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (5, 1);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (6, 1);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (7, 1);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (8, 1);

-- Celulares (9-16)
INSERT INTO tb_product_category(product_id, Category_id) VALUES (9, 2);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (10, 2);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (11, 2);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (12, 2);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (13, 2);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (14, 2);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (15, 2);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (16, 2);

-- Computadores (17-25)
INSERT INTO tb_product_category(product_id, Category_id) VALUES (17, 3);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (18, 3);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (19, 3);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (20, 3);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (21, 3);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (22, 3);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (23, 3);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (24, 3);
INSERT INTO tb_product_category(product_id, Category_id) VALUES (25, 3);


INSERT INTO tb_user (name, email, phone, password, birth_date) VALUES ('Aparecida Lima', 'Aparecida@gmail.com', '21223254', '123456', '2004-04-09');
INSERT INTO tb_user (name, email, phone, password, birth_date) VALUES ('Juliana Mafra', 'mafra@gmail.com', '91827343', '123456', '1970-05-01');

INSERT INTO tb_order (moment, status, client_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-05-01T13:00:00Z', 1, 1);
INSERT INTO tb_order (moment, status, client_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-05-02T15:50:00Z', 3, 2);
INSERT INTO tb_order (moment, status, client_id) VALUES (TIMESTAMP WITH TIME ZONE '2025-04-30T14:20:00Z', 0, 1);

INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (1, 1, 2, 99.90);
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (1, 9, 1, 3999.90);
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (2, 17, 1, 3499.90);
INSERT INTO tb_order_item (order_id, product_id, quantity, price) VALUES (3, 1, 1, 99.90);

INSERT INTO tb_payment (order_id, moment) VALUES (1, TIMESTAMP WITH TIME ZONE '2025-05-01T15:00:00Z');
INSERT INTO tb_payment (order_id, moment) VALUES (2, TIMESTAMP WITH TIME ZONE '2025-05-02T11:00:00Z');