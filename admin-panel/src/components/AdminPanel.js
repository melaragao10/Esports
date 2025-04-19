import React, { useEffect, useState } from "react";

const AdminPanel = () => {
  // Estado para criação de usuário
  const [newUser, setNewUser] = useState({
    email: "",
    login: "",
    senha: "",
    perfil: "Administrador",
  });

  // Estado para gerenciamento de permissões
  const [perfilSelecionado, setPerfilSelecionado] = useState(1);
  const [permissoes, setPermissoes] = useState([]);
  const [funcoes, setFuncoes] = useState([]);

  // Buscar permissões e funções do perfil selecionado
  useEffect(() => {
    if (!perfilSelecionado) return;

    fetch(`http://localhost:8080/admin/permissoes?codPerfil=${perfilSelecionado}`)
      .then(response => response.json())
      .then(data => setPermissoes(data));

    fetch("http://localhost:8080/admin/funcoes")
      .then(response => response.json())
      .then(data => setFuncoes(data));
  }, [perfilSelecionado]);

  // Atualizar permissões ao clicar em "Confirmar"
  const atualizarPermissoes = () => {
    const codFuncoesSelecionadas = permissoes.map(p => p.funcao.codigo);

    fetch(`http://localhost:8080/admin/atualizar-permissoes?codPerfil=${perfilSelecionado}`, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(codFuncoesSelecionadas),
    })
      .then(() => alert("Permissões atualizadas com sucesso!"))
      .catch(error => console.error("Erro ao atualizar permissões:", error));
  };

  // Manipular checkbox para adicionar/remover permissões localmente
  const togglePermissao = (codFuncao) => {
    setPermissoes(prevPermissoes => {
      const jaTemPermissao = prevPermissoes.some(p => p.funcao.codigo === codFuncao);

      if (jaTemPermissao) {
        return prevPermissoes.filter(p => p.funcao.codigo !== codFuncao);
      } else {
        return [...prevPermissoes, { funcao: { codigo: codFuncao } }];
      }
    });
  };

  // Capturar mudanças no formulário de criação de usuário
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setNewUser({ ...newUser, [name]: value });
  };

  // Criar usuário no sistema
  const handleCreateUser = async () => {
    try {
      const response = await fetch("http://localhost:8080/api/usuarios/criar", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({
          email: newUser.email,
          login: newUser.login,
          senha: newUser.senha,
          perfil: { nome: newUser.perfil },
        }),
      });

      const data = await response.text();

      if (response.ok) {
        alert(data);
        setNewUser({ email: "", login: "", senha: "", perfil: "Administrador" });
      } else {
        alert("Erro: " + data);
      }
    } catch (error) {
      alert("Erro ao conectar ao servidor.");
    }
  };

  return (
    <div>
      <h2>Painel Administrativo</h2>

      {/* Seção de criação de usuários */}
      <div style={{ display: "flex", gap: "10px", marginBottom: "20px" }}>
        <input type="email" name="email" placeholder="Email" value={newUser.email} onChange={handleInputChange} />
        <input type="text" name="login" placeholder="Login" value={newUser.login} onChange={handleInputChange} />
        <input type="password" name="senha" placeholder="Senha" value={newUser.senha} onChange={handleInputChange} />
        <select name="perfil" value={newUser.perfil} onChange={handleInputChange}>
          <option value="Administrador">Administrador</option>
          <option value="Jogador">Jogador</option>
        </select>
        <button onClick={handleCreateUser}>Criar Usuário</button>
      </div>

      {/* Seção de gerenciamento de permissões */}
      <label>Perfil: </label>
      <select onChange={(e) => setPerfilSelecionado(e.target.value)} value={perfilSelecionado}>
        <option value="1">Administrador</option>
        <option value="2">Jogador</option>
      </select>

      <h3>Permissões do {perfilSelecionado === "1" ? "Administrador" : "Jogador"}</h3>

      <table border="1">
        <thead>
          <tr>
            <th>Função</th>
            <th>Permissão</th>
          </tr>
        </thead>
        <tbody>
          {funcoes.map(funcao => (
            <tr key={funcao.codigo}>
              <td>{funcao.descricao}</td>
              <td>
                <input
                  type="checkbox"
                  checked={permissoes.some(p => p.funcao.codigo === funcao.codigo)}
                  onChange={() => togglePermissao(funcao.codigo)}
                />
              </td>
            </tr>
          ))}
        </tbody>
      </table>

      <button onClick={atualizarPermissoes}>Confirmar Permissões</button>
    </div>
  );
};

export default AdminPanel;
