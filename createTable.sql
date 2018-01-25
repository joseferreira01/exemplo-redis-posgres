CREATE TABLE produto(
codigo serial PRIMARY KEY,
descricao VARCHAR(100),
preco NUMERIC(8,2) NOT NULL DEFAULT 0
);
CREATE TABLE itenPedido(
	id serial PRIMARY KEY,
	quantidade INT,
	codigoProduto INT NOT NULL UNIQUE,
	FOREIGN KEY (codigoProduto) REFERENCES produto(codigo) ON DELETE SET NULL
);
CREATE TABLE Pedido(
	codigo INT,
	DATA DATE, 
	codigoItem INT,
	FOREIGN KEY (codigoItem) REFERENCES itenPedido(id) ON DELETE SET NULL,
	PRIMAIRY KEY(codigo,codigoItem)
);
