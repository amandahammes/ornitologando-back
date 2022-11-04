package com.example.apiornitologando.servico;

import java.util.List;

import com.example.apiornitologando.model.Passaro;

public interface PassaroServico {
    public Passaro criarNovoPassaro(Passaro p);
    public Passaro alterarPassaro(Passaro p);
    public List<Passaro> listarTodos();
    public Passaro buscarPorId(Integer id);
}
