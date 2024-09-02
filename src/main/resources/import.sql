-- Insere usuários
INSERT INTO tb_user ( nome, sobrenome, cpf, telefone, renda) VALUES('João', 'Silva', '12345678900', '123456789', 5000.00);
INSERT INTO tb_user ( nome, sobrenome, cpf, telefone, renda) VALUES('Maria', 'Oliveira', '98765432100', '987654321', 6000.00);
INSERT INTO tb_user ( nome, sobrenome, cpf, telefone, renda) VALUES('Enzo', 'Galati', '51554838835', '945896199', 6000.00);


-- Insere propostas
INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(1500.00, 12, FALSE, 1);
INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(2500.00, 24, FALSE, 1);
INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(1000.00, 6, FALSE, 2);
INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(4000.00, 11, FALSE, 2);
INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(75000.00, 13, FALSE, 3);
INSERT INTO tb_proposta (valor_solicitado, prazo_para_pagamento, aprovado, user_id) VALUES(50000.00, 4, FALSE, 3);

