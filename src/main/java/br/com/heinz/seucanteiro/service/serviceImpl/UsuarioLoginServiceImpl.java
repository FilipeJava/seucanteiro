package br.com.heinz.seucanteiro.service.serviceImpl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.heinz.seucanteiro.dto.form.LoginFormDTO;
import br.com.heinz.seucanteiro.dto.form.UsuarioFormDTO;
import br.com.heinz.seucanteiro.dto.resposta.UsuarioRespostaDTO;
import br.com.heinz.seucanteiro.model.Login;
import br.com.heinz.seucanteiro.model.Usuario;
import br.com.heinz.seucanteiro.model.UsuarioLogin;
import br.com.heinz.seucanteiro.service.UsuarioLoginService;


@Service
public class UsuarioLoginServiceImpl implements UsuarioLoginService {

    @Autowired
    LoginServiceImpl loginServiceImpl;

    @Autowired
    UsuarioServiceImpl usuarioServiceImpl;
   
    @Autowired
    CanteiroServiceImpl canteiroServiceImpl;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public UsuarioRespostaDTO salvar (UsuarioLogin usuarioLogin) {

        UsuarioFormDTO usuarioform = usuarioLogin.getUsuario();
        LoginFormDTO loginform = usuarioLogin.getLogin();

        Login login = convertToEntityLogin(loginform);

         
            loginServiceImpl.salvar(login);
   
       

        Usuario usuario = convertToEntityUsuario(usuarioform);
        usuario.setLogin(login);
        Usuario usuarioCanteiro =usuarioServiceImpl.salvar(usuario);
        canteiroServiceImpl.save(usuarioCanteiro);

        return convertToRespostaUsuario(usuario);

    }


   




      // DTO METHODS
    private Usuario convertToEntityUsuario(UsuarioFormDTO usuarioform) {
        return modelMapper.map(usuarioform, Usuario.class);

    }

    private UsuarioRespostaDTO convertToRespostaUsuario(Usuario usuario) {
        return modelMapper.map(usuario, UsuarioRespostaDTO.class);
    }


    private Login convertToEntityLogin(LoginFormDTO loginform) {
        return modelMapper.map(loginform, Login.class);

    }






}