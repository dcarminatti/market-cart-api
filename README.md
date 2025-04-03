# 🛒 MarketCart

Este projeto é uma aplicação desenvolvida para auxiliar mercados no **cadastro e venda de produtos**, com foco em **operação simples e eficiente para pequenos comerciantes**.

> ⚠️ **Nota:** Esta é uma **versão genérica** da aplicação. A versão final utilizada pelo cliente **não foi publicada** para preservar informações sensíveis e personalizações específicas.

## 📌 Sobre o Projeto

Desenvolvido como um projeto **freelancer**, este sistema tem como objetivo principal permitir que mercados realizem:

- Cadastro e gestão de produtos;
- Registro de vendas vinculadas a clientes;
- Acompanhamento básico de estoque.

A versão presente neste repositório é voltada para fins **educacionais e demonstrativos**, servindo como **exemplo técnico** da solução desenvolvida.

## ⚙️ Tecnologias Utilizadas

Este projeto utiliza um stack moderno com as seguintes tecnologias:

- **Java 21** – Linguagem principal da aplicação.
- **Spring Boot** – Framework para criação de APIs REST robustas.
- **PostgreSQL** – Banco de dados relacional.
- **Docker** – Containerização da aplicação e do banco de dados.

## 🖥️ Funcionalidades Principais

- ✅ Cadastro de produtos
- ✅ Registro de vendas
- ✅ Consulta de histórico de vendas
- ✅ API RESTful com autenticação básica
- ✅ Persistência com PostgreSQL
- ✅ Docker para facilitar a execução

## 🚀 Como Executar o Projeto

> Pré-requisitos: Ter o **Docker** instalado na máquina.

1. Clone o repositório:
   ```bash
   git clone https://github.com/dcarminatti/MarketCart
   cd MarketCart
   ```

2. Suba os containers com Docker:
   ```bash
   docker-compose up --build
   ```

3. A aplicação estará disponível em:
    - Backend (API): http://localhost:8080
    - Banco de dados: PostgreSQL na porta 5432

## 🧑‍💻 Autor

Desenvolvido por **Diogo** como projeto freelancer.  
Para contato profissional ou oportunidades: https://www.linkedin.com/in/dcarminatti/

## 📄 Licença

Este projeto está licenciado sob a licença MIT - veja o arquivo [LICENSE](LICENSE) para mais detalhes.
