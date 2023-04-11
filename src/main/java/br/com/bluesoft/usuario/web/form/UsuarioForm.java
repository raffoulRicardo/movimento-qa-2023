package br.com.bluesoft.usuario.web.form;

import br.com.bluesoft.usuario.domain.Usuario;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString
public class UsuarioForm {

    private String nome;
    private String cpf;
    private String celular;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    public Usuario toEntity() {
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setCpf(cpf);
        usuario.setCelular(celular);
        usuario.setDataNascimento(dataNascimento);

        return usuario;
    }

}
