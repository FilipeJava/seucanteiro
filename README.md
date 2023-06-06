# Seucanteiro

O Seu Canteiro foi projetado para ajudar as pessoas que vivem em áreas urbanas a cultivarem seus próprios alimentos em casa, fornecendo informações e orientações sobre agricultura urbana. A solução idealizada visa aumentar a segurança e o controle administrativo sobre as atividades relacionadas ao cultivo de alimentos, além de garantir a segurança no uso e consumo dos produtos da agricultura. 

 
Orientações detalhadas sobre o cultivo: O aplicativo fornece informações abrangentes sobre como plantar diferentes tipos de alimentos em ambientes urbanos. Ele orienta os usuários sobre o preparo do solo, a escolha das sementes adequadas, a quantidade de água necessária, a adubação. Essas orientações permitem que os usuários administrem melhor os processos produtivos, maximizando a produtividade e a qualidade dos alimentos cultivados. 

 
Acompanhamento personalizado: O aplicativo permite que os usuários registrem e acompanhem suas atividades de cultivo, como datas de plantio, irrigação e colheita. Essa funcionalidade proporciona um maior controle administrativo, permitindo que os usuários monitorem seu progresso e tomem decisões informadas com base nos dados coletados. Eles podem registrar e rastrear o desempenho de suas plantações ao longo do tempo, identificando áreas de melhoria e otimizando suas práticas agrícolas. 

 
Através dessas funcionalidades, o aplicativo Seu Canteiro permite que os usuários administrem melhor os processos produtivos e distributivos de alimentos, garantindo uma abordagem mais segura e controlada para a agricultura urbana. Ele capacita os usuários a cultivarem seus próprios alimentos com confiança, fornecendo informações atualizadas, orientações personalizadas nos. Isso resulta em uma maior segurança alimentar, uma melhor gestão dos recursos disponíveis e uma maior autonomia para as pessoas nas áreas urbanas. 


- Link de videos :
    - Picth de negocio [aqui]
    - Funcionamento [aqui]
    - Mobile [aqui]
    - VM Devops [aqui]
 
--------------------------

### ENDPOINTS


- Usuario Controller 
    - salvar ( Metodo faz a persistência tanto de Usuario quanto de Login  e cria tbm um canteiro para o usuario)

    - buscar por id (Apenas os Dados do Usuario)

    - deletar ( metodo Deleta Usuario , Login e Canteiro por Cascade, pelo ID Usuario)

    - atulizaUsuario (Atualiza usuario isoladamente)

--------------------------

- Login Controller
   - login (Metodo de autenticação com JWT) `Ultiliza JPQL no Repository[requisito GS de ENTERPRISE APPLICATION DEVELOPMENT ]`

   - atualizar(Atualiza Login isoladamente)
--------------------------
- Planta Controller
    - salva (Cria Planta e plantio e associa um  ID canteiro )

    - atualiza (Atualiza Planta e Plantio ao mesmo tempo pelo ID planta)
    
    - buscaId (Busca Planta Plantio por id Planta)

    - deletar (Deleta planta e Plantio que por cascade são deletados juntos , pelo id do Plantio )

    - buscarTodos ( para retornar todos os planta plantio ) `Ultiliza JPQL no Repository[requisito GS de ENTERPRISE APPLICATION DEVELOPMENT ]`

    - index (Paginação e Busca pelo nome)  `Ultiliza JPQL no Repository[requisito GS de ENTERPRISE APPLICATION DEVELOPMENT ]` 
--------------------------
- Canteiro Controller
    - buscar todas as Plantas e Plantio pelo id canteiro
--------------------------

---------------------------


### Usuario Controller


`POST` /api/v1/usuario -não requer autenticação

**Campos da Requisição**

- Usuario

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|valor | decimal | sim | o valor da despesa, deve ser maior que zero


- Login

| campo | tipo | obrigatório | descrição 
|-------|------|:-------------:|---
|valor | decimal | sim | o valor da despesa, deve ser maior que zero


**Exemplo de corpo de requisição**

```js
{
    "valor": 100.00,
    "data": "2023-02-27",
    "conta_id": 1,
    "categoria_id": 1,
    "{% base64 'encode', 'normal', '' %}scricao": "cinema - homem aranha"
}
```

**Códigos de Respostas**

| código | descrição
|-|-
| 201 | despesa cadastrada com sucesso
| 400 | campos inválidos

----
