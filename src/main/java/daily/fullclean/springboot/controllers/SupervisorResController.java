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

import daily.fullclean.springboot.models.Imp.ISupervisorServiceImp;
import daily.fullclean.springboot.models.entity.Supervisor;

@CrossOrigin(origins = { "*" })
//@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class SupervisorResController {
	@Autowired
	private ISupervisorServiceImp supervisorService;
	// private final Logger log = LoggerFactory.getLogger(SupervisorResController.class);

	/*
	 * LISTAR
	 */
	@GetMapping("/supervisor")
	public List<Supervisor> index() {
		return supervisorService.findall();
	}

	/**
	 * LISTAR PAGINACION
	 */
	@GetMapping("/supervisor/page/{page}")
	public Page<Supervisor> index(@PathVariable Integer page) {
		return supervisorService.findall(PageRequest.of(page, 4));
	}

	/**
	 * LISTAR POR ID
	 */
	@Secured({ "ROLE_ADMIN", "ROLE_USER" })
	@GetMapping("/supervisor/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> show(@PathVariable Long id) {

		Supervisor supervisor = null;
		Map<String, Object> response = new HashMap<>();
		try {

			supervisor = supervisorService.finById(id);

		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (supervisor == null) {
			response.put("mensaje", "el registro ID: ".concat(id.toString().concat(" no Existe en la Base de Datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Supervisor>(supervisor, HttpStatus.OK);
	}

	/**
	 * CREAR
	 */
	// @RequestBody para recibir un json
	@PostMapping("/supervisor")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> create(@Valid @RequestBody Supervisor supervisor, BindingResult result) {
		// registro.setCreateAt(new Date());
		// return registroService.save(registro);

		Supervisor supervisorNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + " ' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}
		try {
			supervisorNew = supervisorService.save(supervisor);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al registrar nuevo usuario");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El usuario ha sido creado con èxito!");
		response.put("registro", supervisorNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	/**
	 * ACTUALIZAR
	 */
	@PutMapping("/supervisor/{id}")
	@Secured("ROLE_ADMIN")
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@Valid @RequestBody Supervisor supervisor, @PathVariable Long id,
			BindingResult result) {

		Supervisor supervisorActual = supervisorService.finById(id);
		Supervisor supervisorUpdated = null;

		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + " ' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}
		if (supervisorActual == null) {
			response.put("mensaje", "error : no se pudo editar el usuario ID: "
					.concat(id.toString().concat(" no Existe en la Base de Datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			supervisorActual.setNombre(supervisor.getNombre());
			supervisorActual.setApellido(supervisor.getApellido());
			supervisorActual.setEmail(supervisor.getEmail());

			supervisorUpdated = supervisorService.save(supervisorActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar  el usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario ha sido actualizado con èxito!");
		response.put("registro", supervisorUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	/**
	 * ELIMINAR
	 */

	@DeleteMapping("/supervisor/{id}")
	@Secured("ROLE_ADMIN")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {
			// Supervisor supervisor = supervisorService.finById(id);

			supervisorService.delete(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar  el usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "el usuario fue eliminado con èxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
