-- Insere usuários
INSERT INTO tb_user ( nome, sobrenome, cpf, telefone, renda) VALUES('João', 'Silva', '12345678900', '123456789', 5000.00);
INSERT INTO tb_user ( nome, sobrenome, cpf, telefone, renda) VALUES('Maria', 'Oliveira', '98765432100', '987654321', 6000.00);
INSERT INTO tb_user ( nome, sobrenome, cpf, telefone, renda) VALUES('Enzo', 'Galati', '98765432100', '987654321', 6000.00);


-- Insere propostas
INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(1500.00, 12, FALSE, 1);
INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(2500.00, 24, FALSE, 1);
INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(1000.00, 6, FALSE, 2);


