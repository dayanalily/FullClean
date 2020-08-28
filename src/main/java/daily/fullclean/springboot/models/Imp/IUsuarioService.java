package daily.fullclean.springboot.models.Imp;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import daily.fullclean.springboot.models.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String email);
	public List<Usuario> findall();
    public Page<Usuario> findall(Pageable pegeable);
	public Usuario save(Usuario usuario);
	public Usuario finById(Long id);
	public void findByDelete(Long id);

}
