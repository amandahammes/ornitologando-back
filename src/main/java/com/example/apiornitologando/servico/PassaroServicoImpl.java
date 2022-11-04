package com.example.apiornitologando.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.apiornitologando.model.Passaro;
import com.example.apiornitologando.repositorio.PassaroRepositorio;

@Component
public class PassaroServicoImpl implements PassaroServico{
    
    @Autowired
    private PassaroRepositorio passaroRepositorio;
    
    @Override
    public Passaro criarNovoPassaro(Passaro passaro) {
        // TODO Auto-generated method stub
        if (passaro.getNomeCientifico() == null || passaro.getNomeCientifico().length() == 0)
            return null;
        return passaroRepositorio.save(passaro);
    }

    @Override
    public Passaro alterarPassaro(Passaro pass) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Passaro> listarTodos() {
        // TODO Auto-generated method stub
        return (List<Passaro>)passaroRepositorio.findAll();
    }

    @Override
    public Passaro buscarPorId(Integer id) {
        // TODO Auto-generated method stub
        return passaroRepositorio.findById(id).orElse(null);
    }

}
