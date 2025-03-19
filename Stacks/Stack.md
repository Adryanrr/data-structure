# 📚 Pilha (Stack)

Uma **pilha** é uma estrutura de dados linear que segue o princípio **LIFO** – _Last In, First Out_ (Último a Entrar, Primeiro a Sair). Isso significa que o último elemento inserido na pilha será o primeiro a ser removido.

## 🧱 Estrutura Básica

A pilha funciona de forma similar a uma pilha de pratos: você só pode adicionar ou remover o prato que está no topo da pilha.

## 🔧 Métodos Comuns

Abaixo estão os principais métodos utilizados em uma estrutura de pilha:

### `push(elemento)`

- **Descrição**: Adiciona um elemento ao topo da pilha.
- **Exemplo**:
  ```python
  pilha.push(5)
  ```

### `pop()`

- **Descrição**: Remove e retorna o elemento que está no topo da pilha.
- **Observação**: Pode gerar erro se a pilha estiver vazia.
- **Exemplo**:
  ```python
  topo = pilha.pop()
  ```

### `peek()` ou `top()`

- **Descrição**: Retorna o elemento do topo da pilha **sem removê-lo**.
- **Exemplo**:
  ```python
  topo = pilha.peek()
  ```

### `is_empty()`

- **Descrição**: Retorna `True` se a pilha estiver vazia, senão retorna `False`.
- **Exemplo**:
  ```python
  if pilha.is_empty():
      print("Pilha vazia!")
  ```

### `size()`

- **Descrição**: Retorna o número de elementos atualmente na pilha.
- **Exemplo**:
  ```python
  print(pilha.size())
  ```

---

## 📝 Aplicações Comuns

- Algoritmos de **recursão** (controle de chamadas)
- **Navegadores** (botão de voltar/avançar)
- Avaliação de expressões matemáticas
- **Undo/Redo** em editores de texto
- Conversão de expressões infixas para pós-fixas (notação polonesa reversa)

---

## 📌 Conclusão

Pilhas são estruturas simples, porém poderosas, fundamentais no estudo de algoritmos e estruturas de dados. Entender seu funcionamento ajuda a resolver diversos problemas computacionais de forma eficiente.

---
