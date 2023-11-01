# Api Trekker
Solução desenvolvida para servir como um gerenciamento do fluxo de dados entre Mobile (front) e o banco de dados (SQL).

## Arquitetura da Solução
<img src="cg3_api_trekker.png">

## Vídeo sobre a aplicação funcionando
### Matéria - Digital Business
[Sprint 3 - Digital Business](https://youtu.be/viJYBkT7Ulo)

## Documentação Trekker 
### Matéria - Enterprise Application
[Sprint 3 - Enterprise Application](https://github.com/cecilianeves22/digital-sprint3-trekker/blob/088c9acbcf22d6501b31f0e6d1fce1480f99a3a0/Challenge3-Enterprise-Trekker.pdf.pdf)

## Deploy
### Pré-requisitos:
- Ter instalado o Gradle (Para buildar projeto)
- Editar o arquivo `application.properties` em `src\main\resources\application.properties` com as credenciais do banco

### Passo a passo
Clone o repositório:
```bash
git clone https://github.com/cecilianeves22/digital-sprint3-trekker.git
```
Acesse a pasta:
```bash
cd digital-sprint3-trekker
```
Após editar as credenciais do arquivo `application.properties` faça o build:
```bash
gradle build
```
Será gerado um `Sprint-0.0.1-SNAPSHOT.jar` em `/build/libs/.`. Realize o deploy desse arquivo para o Web App do Azure através do VScode (ou outro programa).
### JSON utilizado em vídeo:
- Usuário: `/usuario` - Exemplo:
```
{
    "nm_usuario": "Carla Fernandes",
    "ds_email": "cacafernan@gmail.com",
    "ds_senha": "EN&Kpk3f"
}
```
- Destino: `/destino` - Exemplo:
```
{
    "cd_usuario": {
        "cd_usuario": 5
    },
    "nm_destino": "Paris",
    "qt_dias": 10,
    "nm_partida": "RJ"
}
```
### Vídeo de demonstração para a matéria de `DevOps and Cloud Computing`
[![Demo](https://img.youtube.com/vi/oMwFXzfBf9s/maxresdefault.jpg)](https://www.youtube.com/watch?v=oMwFXzfBf9s)
