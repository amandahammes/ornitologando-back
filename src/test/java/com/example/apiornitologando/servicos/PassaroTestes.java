package com.example.apiornitologando.servicos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.example.apiornitologando.model.Passaro;
import com.example.apiornitologando.repositorio.PassaroRepositorio;
import com.example.apiornitologando.servico.PassaroServicoImpl;

@SpringBootTest
@ActiveProfiles("test")
public class PassaroTestes {
    
    @InjectMocks
    private PassaroServicoImpl servico;
    
    @Mock
    private PassaroRepositorio repositorio;
    
    private Integer idExistente = 1;
    private Integer idInexistente = 100;
    private Passaro novoPassaro;
    private Passaro criadoPassaro;    
    
    @BeforeEach
    public void setup() throws Exception{
       novoPassaro = new Passaro();
       novoPassaro.setNomeCientifico("Psittacara leucophthalmus");
       novoPassaro.setNomePopular("periquitão");
       novoPassaro.setColoracao("verde");
       novoPassaro.setImg("\"https://s3.amazonaws.com/media.wikiaves.com.br/images/7142/2417838_f3f4406f1f4e54665cc93c718a9e216c.jpg\"");
    
       criadoPassaro = new Passaro();
       criadoPassaro.setId(1);
       criadoPassaro.setNomeCientifico("Psittacara leucophthalmus");
       criadoPassaro.setNomePopular("periquitão");
       criadoPassaro.setColoracao("verde");
       criadoPassaro.setImg("https://s3.amazonaws.com/media.wikiaves.com.br/images/7142/2417838_f3f4406f1f4e54665cc93c718a9e216c.jpg");
      
       Mockito.when(repositorio.save(novoPassaro)).thenReturn(criadoPassaro);
       Mockito.when(repositorio.findById(idExistente)).thenReturn(Optional.of(criadoPassaro));
       Mockito.when(repositorio.findById(idInexistente)).thenReturn(Optional.ofNullable(null));
       
    }
    
    @Test
    public void deveriaCadastrarPassaro() {
        assertEquals(servico.criarNovoPassaro(novoPassaro), criadoPassaro);
    }
    
    @Test
    public void deveriaRetornarPeloId() {
        assertNotNull(servico.buscarPorId(idExistente));
    }
    
    @Test
    public void deveriaNaoEncontrarId() {
        assertNull(servico.buscarPorId(idInexistente));
    }
    
    
}
