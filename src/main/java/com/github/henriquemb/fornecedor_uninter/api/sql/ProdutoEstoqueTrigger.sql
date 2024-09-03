-- Cria um estoque com 0 ao criar um novo produto

CREATE TRIGGER TRG_I_PRODUTO AFTER INSERT ON produto
FOR EACH ROW
BEGIN
    INSERT INTO produto_estoque (produto_id, quantidade) VALUES (NEW.id, 0);
END;

-- Atualiza a quantidade do estoque ao adicionar um novo item na nota de entrada

CREATE TRIGGER TRG_I_NOTA_ENTRADA_ITEM AFTER INSERT ON nota_entrada_item
FOR EACH ROW
BEGIN
    UPDATE produto_estoque
    SET quantidade = quantidade + NEW.quantidade
    WHERE produto_id = NEW.produto_id;
END;

-- Atualiza a quantidade do estoque ao deletar um item da nota de entrada

CREATE TRIGGER TRG_D_NOTA_ENTRADA_ITEM AFTER DELETE ON nota_entrada_item
    FOR EACH ROW
BEGIN
    UPDATE produto_estoque
    SET quantidade = quantidade - OLD.quantidade
    WHERE produto_id = OLD.produto_id;
END;

-- Atualiza a quantidade do estoque ao atualizar um item da nota de entrada

CREATE TRIGGER TRG_U_NOTA_ENTRADA_ITEM AFTER DELETE ON nota_entrada_item
    FOR EACH ROW
BEGIN
    UPDATE produto_estoque
    SET quantidade = quantidade - (OLD.quantidade - NEW.quantidade)
    WHERE produto_id = NEW.produto_id;
END;