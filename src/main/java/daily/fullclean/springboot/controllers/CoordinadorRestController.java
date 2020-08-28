package daily.fullclean.springboot.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import daily.fullclean.springboot.models.Imp.ICoordinadorServiceImp;
import daily.fullclean.springboot.models.entity.Coordinador;


@CrossOrigin(origins = { "*" })
//@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class CoordinadorRestController {
	@Autowired
	private ICoordinadorServiceImp coordinadorService;

	/**
	 * LISTAR
	 */
	@GetMapping("/coodinador")
	public List<Coordinador> index() {
		return coordinadorService.findall();
	}
	
	/**
	 * LISTAR PAGINACION
	 */
	@GetMapping("/coodinador/page/{page}")
	public Page<Coordinador> index(@PathVariable Integer page) {
		return coordinadorService.findall(PageRequest.of(page, 4));
	}
	/**
	 * LISTAR POR ID
	 */
	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping("/coodinador/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> show(@PathVariable Long id) {

		Coordinador coordinadorServiceImp = null;
		Map<String, Object> response = new HashMap<>();
		try {

			coordinadorServiceImp = coordinadorService.finById(id);

		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (coordinadorServiceImp == null) {
			response.put("mensaje", "el registro ID: ".concat(id.toString().concat(" no Existe en la Base de Datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Coordinador>(coordinadorServiceImp, HttpStatus.OK);
	}
	
	/**
	 * CREAR
	 */
	// @RequestBody para recibir un json
	@PostMapping("/coodinador")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> create(@Valid @RequestBody Coordinador coordinador, BindingResult result) {
		// registro.setCreateAt(new Date());
		// return registroService.save(registro);

		Coordinador CoordinadorNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + " ' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}
		try {
			CoordinadorNew = coordinadorService.save(coordinador);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al registrar nuevo usuario");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El usuario ha sido creado con èxito!");
		response.put("registro", CoordinadorNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}


	/**
	 * ACTUALIZAR
	 */
	@PutMapping("/coodinador/{id}")
	@Secured("ROLE_ADMIN")
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@Valid @RequestBody Coordinador coordinador, @PathVariable Long id,
			BindingResult result) {

		Coordinador coordinadorActual = coordinadorService.finById(id);
		Coordinador coordinadorUpdated = null;

		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + " ' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}
		if (coordinadorActual == null) {
			response.put("mensaje", "error : no se pudo editar el usuario ID: "
					.concat(id.toString().concat(" no Existe en la Base de Datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			
			coordinadorActual.setNombre(coordinador.getNombre());
			coordinadorActual.setApellido(coordinador.getApellido());
			coordinadorActual.setEmail(coordinador.getEmail());
			coordinadorUpdated = coordinadorService.save(coordinadorActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar  el usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario ha sido actualizado con èxito!");
		response.put("registro", coordinadorUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
	
	/**
	 * ELIMINAR
	 */

	@DeleteMapping("/coodinador/{id}")
	@Secured("ROLE_ADMIN")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {
			// Coordinador coordinadorServiceImp = coordinadorService.finById(id);

			coordinadorService.delete(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar  el usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "el usuario fue eliminado con èxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}


	
}
