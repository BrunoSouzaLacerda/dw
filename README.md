# dw

Este repositório contém uma aplicação que oferece uma API para gerenciamento de produtos, pedidos e associação entre produtos e pedidos.

Funcionamento da Aplicação
A aplicação oferece endpoints para realizar as seguintes operações:

Criação: Utilize o método POST e as seguintes URLs para criar produtos, pedidos e associação entre produto e pedido:
http://localhost:8080/produtos
http://localhost:8080/pedidos
http://localhost:8080/pedido_produto

Consulta: Utilize o método GET e as seguintes URLs para buscar produtos, pedidos e associação entre produto e pedido:
http://localhost:8080/produtos
http://localhost:8080/pedidos
http://localhost:8080/pedido_produto

Consulta especifica: Utilize o método GET e as seguintes URLs para buscar produtos, pedidos e associação entre produto e pedido:
http://localhost:8080/produtos/{id_produto}
http://localhost:8080/pedidos/{id_pedido}
http://localhost:8080/pedido_produto/{id_produto}/{id_pedido}

Edição: Utilize o método PUT e as seguintes URLs para editar produtos, pedidos e associação entre produto e pedido:
http://localhost:8080/produtos/{id_produto}
http://localhost:8080/pedidos/{id_pedido}
http://localhost:8080/pedido_produto/{id_produto}/{id_pedido}

Exclusão: Utilize o método DELETE e as seguintes URLs para deletar produtos, pedidos e associação entre produto e pedido:
http://localhost:8080/produtos/{id_produto}
http://localhost:8080/pedidos/{id_pedido}
http://localhost:8080/pedido_produto/{id_produto}/{id_pedido}

Formato dos Dados
A seguir, estão os exemplos dos formatos JSON para criar cada entidade:

Produto:

{
    "codigo": "123456728",
    "descricao": "essa é uma descricao teste",
    "valor_custo": 10.99,
    "valor_venda": 39.99
}

Pedido:

{
    "id_funcionario": 3,
    "id_cliente": 21,
    "data_pedido": "2024-04-10",
    "data_remessa": "2024-04-20"
}

Pedido_Produto:

{
    "id_pedido": 2,
    "id_produto": 2,
    "quantidade": 20,
    "preco_unitario": 29.99,
    "desconto": 10
}

Utilize esses formatos ao enviar requisições para a API.

Execução da Aplicação

Para executar a aplicação localmente, certifique-se de ter todas as dependências instaladas e o arquivo application.properties configurado corretamente para então executar o arquivo principal.


