insert into Produto (id, nome, valor, descricao) values (1, 'Kindle', 499.0, 'Conheça o novo Kindle, agora com iluminação embutida ajustável, que permite que você leia em ambientes abertos ou fechados, a qualquer hora do dia.');
insert into Produto (id, nome, valor, descricao) values (3, 'Câmera GoPro Hero 7', 1400.0, 'Desempenho 2x melhor.');

insert into Cliente (id, nome) values (2, 'Paulo Ricardo');
insert into Cliente (id, nome) values (3, 'Felipe da Silva');
insert into Cliente (id, nome) values (4, 'Maria Fernanda');

insert into Pedido (id, cliente_id, data_pedido, total, status) values (1, 2, DATE('2020-12-18'), 1000.0, 'AGUARDANDO');

insert into Item_Pedido (id, pedido_id, produto_id, preco_produto, quantidade) values (1, 1, 1, 1000.0, 1);

insert into categoria (id, nome) values (1, 'Eletrônicos');