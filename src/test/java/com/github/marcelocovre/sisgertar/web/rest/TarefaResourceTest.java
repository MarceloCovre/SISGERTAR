package com.github.marcelocovre.sisgertar.web.rest;

import com.github.marcelocovre.sisgertar.Util.BaseIntTest;
import com.github.marcelocovre.sisgertar.Util.TestUtil;
import com.github.marcelocovre.sisgertar.builder.TarefaBuilder;
import com.github.marcelocovre.sisgertar.service.dto.TarefaDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Transactional
public class TarefaResourceTest extends BaseIntTest {

    @Autowired
    private TarefaBuilder tarefaBuilder;

    @Test
    public void listarTarefasComSucesso() throws Exception {
        tarefaBuilder.persistirTarefa(tarefaBuilder.createTarefaDTO());

        mockMvc
                .perform(get("/api/tarefas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[*]", hasSize(1)));
    }

    @Test
    public void inserirTarefaComSucesso() throws Exception {
        TarefaDTO tarefaDTO = tarefaBuilder.createTarefaDTO();

        mockMvc
                .perform(post("/api/tarefas")
                        .content(TestUtil.convertObjectToJsonBytes(tarefaDTO))
                        .contentType(TestUtil.APPLICATION_JSON_UTF8)
                )
                .andExpect(status().isOk());
    }

    @Test
    public void inserirTarefaComResponsavelInexistente() throws Exception {
        TarefaDTO tarefaDTO = tarefaBuilder.createTarefaDTO();
        tarefaDTO.setIdResponsavel(Long.MAX_VALUE);

        ResultActions resultActions = mockMvc
                .perform(post("/api/tarefas")
                        .content(TestUtil.convertObjectToJsonBytes(tarefaDTO))
                        .contentType(TestUtil.APPLICATION_JSON_UTF8));
        resultActions.andExpect(status().isBadRequest());
        Assertions.assertEquals(resultActions.andReturn().getResponse().getErrorMessage(), "O usuário não existe");
    }

    @Test
    public void encontrarTarefaComSucesso() throws Exception {
        TarefaDTO tarefaDTO = tarefaBuilder.persistirTarefa(tarefaBuilder.createTarefaDTO());

        mockMvc
                .perform(get("/api/tarefas/" + tarefaDTO.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void encontrarTarefaSemSucesso() throws Exception {
        mockMvc
                .perform(get("/api/tarefas/" + Long.MAX_VALUE))
                .andExpect(status().isNotFound());
    }
}
