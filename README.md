# Api Trekker
Solução desenvolvida para servir como um gerenciamento do fluxo de dados entre Mobile (front) e o banco de dados (SQL).

## Arquitetura da Solução
<img src="cg3_api_trekker.png">

## Deploy
### Pré-requisitos:
- Ter criado os recursos: Web App e SQL Azure (PaaS)
- Criar as variáveis de ambiente para `BANCO_USUARIO`, `BANCO_SENHA` e `API_KEY_GPT` no `Painel do Web App` > `Configurações` > `New Application Setting`
- Ou através do `App settings` disponível no momento da configuração do deploy do `Azure App Service deploy`

### Passo a passo
- Para executar o deploy basta linkar o repositório no processo de configuração do `CI` e habilitar o a opção de `Enable continuous integration ` na aba `Triggers`. <br>
- Certifique-se que as credenciais foram adicionadas nas variáveis de ambiente <br>
- Uma vez feito esses passos basta realizar um `commit` para que o CI seja acionado e as etapas deste sendo executadas com sucesso o processo de deploy será feito
de forma automatica


### JSON utilizado em vídeo:
- Usuário: `/usuario` - Exemplo:
```
{
    "nm_usuario": "Carlos Azevedo",
    "ds_email": "carlin3721@dayrep.com",
    "ds_senha": "emoop3keeTh"
}
```
- Destino: `/destino` - Exemplo:
```
{
    "cd_usuario": {
        "cd_usuario": 5
    },
    "nm_destino": "Londres",
    "qt_dias": 8,
    "nm_partida": "SP"
}
```

- Roteiro: `/roteiro` - Exemplo:
```{
    "from": "São Paulo",
    "to": "Recife",
    "days": 4
}
```
### Vídeo de demonstração para a matéria de `DevOps and Cloud Computing`
[![Demonstracao](https://img.youtube.com/vi/O4-YRSMzWVo/maxresdefault.jpg)](https://www.youtube.com/watch?v=O4-YRSMzWVo)
