package br.com.estudoSpring.controller;

import br.com.estudoSpring.model.UsuarioModel;
import br.com.estudoSpring.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/buscaid{id}")
    private UsuarioModel buscaUsuarioPorId(@PathVariable("id") Long id){
        Optional<UsuarioModel> usuarioEncontrado = usuarioRepository.findById(id);

        if(usuarioEncontrado.isPresent()){
            return usuarioEncontrado.get();
        }
        return null;
    }

    @PostMapping("/salvar")
    private UsuarioModel salvarUsuario(@RequestBody UsuarioModel usuario){
        usuarioRepository.save(usuario);
        return usuario;
    }

    @GetMapping("/lista")
    private List<UsuarioModel> listaUsuarios(){
        return usuarioRepository.findAll();
    }
}
