ALTER TABLE item ADD CONSTRAINT fk_item_pedido FOREIGN KEY (pedido_id) REFERENCES pedido(id);
