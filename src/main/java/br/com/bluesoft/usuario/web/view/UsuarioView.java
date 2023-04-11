package br.com.bluesoft.usuario.web.view;

import br.com.bluesoft.usuario.domain.Usuario;
import lombok.Getter;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UsuarioView {

    private int id;
    private String nome;
    private String cpf;
    private String celular;
    private String dataNascimento;

    public UsuarioView(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.cpf = usuario.getCpf();
        this.celular = usuario.getCelular();
        this.dataNascimento = usuario.getDataNascimento() != null ? usuario.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
    }

    public static List<UsuarioView> toView(List<Usuario> usuarios) {
        return usuarios.stream().map(UsuarioView::new).collect(Collectors.toList());
    }

}
