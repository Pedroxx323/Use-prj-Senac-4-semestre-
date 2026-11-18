# USE-SP — Backend
Java 17, Spring Boot 4.1.1 e MySQL. API em `useService/useService`.

## Funcionalidades
Cadastro/listagem de usuários, centros, tipos de pagamento, contas, recebimentos e histórico filtrado por centro e período. Contas podem ser marcadas como pagas e vencimentos podem ser verificados pelo endpoint.

## Configuração
Configure a variável de ambiente `DB_PASSWORD` localmente, e opcionalmente `DB_URL` e `DB_USER`. Não publique senhas no repositório. O banco de dados `use_sp` deve conter o esquema atualizado, inclusive `conta.id_conta`, `conta.data_vencimento` e `recebimento.id_conta`; o projeto usa `ddl-auto=validate`.

## Observações
O endpoint /login atualmente apenas procura um usuário por e-mail, **não autentica por senha**. Não utilizar como autenticação em produção. O histórico inclui recebimentos como entradas e contas pagas como saídas. Este projeto ainda requer testes completos e integração com o frontend.

Fontes: arquivos Java enviados no ZIP de novembro de 2026.
