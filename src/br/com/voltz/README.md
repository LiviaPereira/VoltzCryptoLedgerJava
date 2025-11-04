# 📘 Voltz Crypto Ledger – Fase 3 (Java)

**Aluno:** Lívia Pereira Dias Correa  
**Turma:** 2ESOR-2025  
**RM:** 559414

---

## 🧭 Visão geral do projeto

O **Voltz Crypto Ledger** é um sistema desenvolvido para a **empresa VOLTZ**, a pedido do **Tio Patinhas**, com o objetivo de permitir o controle de **investimentos em criptoativos** de diferentes empresas de forma **segura, simples e acessível via web** (simulado aqui em Java console).

Nas fases anteriores foram definidos:
- **Fase 1:** Escopo do produto (problema, público-alvo e solução).
- **Fase 2:** Implementação das classes baseadas no diagrama UML.
- **Fase 3:** Ampliação do modelo com **herança, polimorfismo, entidades associativas e testes com tratamento de exceções**.

---

## ⚙️ Estrutura do projeto

src/
└─ br/com/voltz/
├─ model/
│ ├─ EntidadeBase.java
│ ├─ Imprimivel.java
│ ├─ Empresa.java
│ ├─ Ativo.java
│ ├─ Aporte.java
│ ├─ CotacaoDiaria.java
│ ├─ Favorito.java
│ └─ PortfolioItem.java
│
├─ repository/
│ ├─ RepositorioEmpresas.java
│ ├─ RepositorioAtivos.java
│ ├─ RepositorioAportes.java
│ ├─ RepositorioCotacoes.java
│ └─ RepositorioFavoritos.java
│
├─ service/
│ └─ PortfolioService.java
│
└─ App.java

---

## 🧩 Entidades principais

| Entidade | Tipo | Descrição |
|-----------|------|------------|
| **Empresa** | Principal | Representa uma empresa investidora. |
| **Ativo** | Principal | Representa um criptoativo (ex: BTC, ETH). |
| **Aporte** | Associativa | Relaciona uma empresa e um ativo, com data, quantidade, preço e taxa. |
| **CotacaoDiaria** | Apoio | Guarda o preço de fechamento diário de um ativo. |
| **Favorito** | Associativa (PK composta) | Liga empresa e ativo para criar uma “watchlist”. |
| **PortfolioItem** | DTO (derivado) | Calcula valores consolidados, preço médio e P/L. |

---

## 🧬 Conceitos aplicados (requisitos da Fase 3)

| Conceito | Onde foi aplicado |
|-----------|------------------|
| **Herança** | Classes `Empresa`, `Ativo`, `Aporte` herdam de `EntidadeBase`. |
| **Interface** | `Imprimivel` define o método `descrever()` (implementado em várias classes). |
| **Polimorfismo Dinâmico (override)** | `descrever()` e `toString()` são sobrescritos nas classes filhas. |
| **Polimorfismo Estático (overload)** | `PortfolioService.consolidarPorEmpresa()` possui 3 versões; `RepositorioAportes` tem `porEmpresa()` e `porEmpresaEAtivo()`. |
| **Entidades Associativas** | `Aporte` (com atributos próprios e FKs) e `Favorito` (PK composta empresaId + ativoId). |
| **Getters e Setters** | Presentes em todas as classes. |
| **Tratamento de Exceções** | `App.java` contém bloco `try/catch` envolvendo toda a execução. |

---

## 🧠 Fluxo geral do programa

1. Criação dos repositórios em memória (HashMap e List).
2. Cadastro de empresa e ativos (BTC, ETH).
3. Criação de favoritos (entidade associativa `Favorito`).
4. Registro de aportes (`Aporte`) com data, preço e quantidade.
5. Registro de cotações diárias (`CotacaoDiaria`).
6. Consolidação da carteira (`PortfolioService`):
    - Agrupa aportes por ativo;
    - Calcula preço médio, quantidade e P/L;
    - Permite sobrescrever preços de mercado (overload).
7. Impressão dos resultados no console.
8. Caso ocorra erro, o `try/catch` exibe a mensagem.

---

## 🧮 Exemplo de saída

--- Carteira (sem override) ---
PortfolioItem{empresaId=1, ativoId=1, qtd=0.07, precoMedio=307142.86, precoMercado=315000.0, PL=550.00}
PortfolioItem{empresaId=1, ativoId=2, qtd=0.7, precoMedio=15000.0, precoMercado=15500.0, PL=350.00}

--- Carteira (override BTC=310k) ---
PortfolioItem{empresaId=1, ativoId=1, qtd=0.07, precoMedio=307142.86, precoMercado=310000.0, PL=200.00}
PortfolioItem{empresaId=1, ativoId=2, qtd=0.7, precoMedio=15000.0, precoMercado=15500.0, PL=350.00}

--- Carteira (preço padrão=200k) ---
PortfolioItem{empresaId=1, ativoId=1, qtd=0.07, precoMedio=307142.86, precoMercado=200000.0, PL=-7500.00}
PortfolioItem{empresaId=1, ativoId=2, qtd=0.7, precoMedio=15000.0, precoMercado=200000.0, PL=129500.00}


---

## 🧪 Como executar o projeto

### ✅ No IntelliJ IDEA
1. Abra a pasta `VoltzCryptoLedgerJava_Fase3`.
2. Vá em **File → Project Structure → SDK**, e selecione **JDK 17 ou 21**.
3. Abra `App.java` e clique em ▶️ **Run ‘App.main()’**.

### ✅ Via terminal (Linux / Mac)
```bash
cd VoltzCryptoLedgerJava_Fase3
javac -d out $(find src -name "*.java")
java -cp out br.com.voltz.App

✅ Via terminal (Windows PowerShell)
cd VoltzCryptoLedgerJava_Fase3
Get-ChildItem -Recurse -Filter *.java | ForEach-Object { $_.FullName } | javac -d out -cp .
java -cp out br.com.voltz.App
