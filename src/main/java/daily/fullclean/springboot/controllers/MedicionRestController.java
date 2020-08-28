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

import daily.fullclean.springboot.models.Imp.IMedicionServiceImp;
import daily.fullclean.springboot.models.entity.Medicion;

@CrossOrigin(origins = { "*" })
//@CrossOrigin(origins = { "http://localhost:4200", "*" })
@RestController
@RequestMapping("/api")
public class MedicionRestController {
	
	@Autowired
	private IMedicionServiceImp medicionService;


	/**
	 * LISTAR
	 */
	@GetMapping("/medicion/listar")
	public List<Medicion> index() {
		return medicionService.findall();
	}


	/**
	 * LISTAR PAGINACION
	 */
	@GetMapping("/medicion/page/{page}")
	public Page<Medicion> index(@PathVariable Integer page) {
		return medicionService.findall(PageRequest.of(page, 4));
	}
	
	
	/**
	 * LISTAR POR ID
	 */

	@GetMapping("/medicion/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> show(@PathVariable Long id) {

		Medicion medicion = null;
		Map<String, Object> response = new HashMap<>();
		try {

			medicion = medicionService.finById(id);

		} catch (DataAccessException e) {

			response.put("mensaje", "Error al realizar la consulta en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (medicion == null) {
			response.put("mensaje", "el registro ID: ".concat(id.toString().concat(" no Existe en la Base de Datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Medicion>(medicion, HttpStatus.OK);
	}
	/**
	 * CREAR
	 */
	// @RequestBody para recibir un json
	@PostMapping("/medicion/registrar")
	@Secured("ROLE_ADMIN")
	public ResponseEntity<?> create(@Valid @RequestBody Medicion medicion, BindingResult result) {
		// registro.setCreateAt(new Date());
		// return registroService.save(registro);

		Medicion medicionNew = null;
		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + " ' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}
		try {
			medicionNew = medicionService.save(medicion);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al registrar nuevo usuario");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "El usuario ha sido creado con èxito!");
		response.put("registro", medicionNew);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	
	/**
	 * ACTUALIZAR
	 */
	@PutMapping("/medicion/{id}")
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> update(@Valid @RequestBody Medicion medicion, @PathVariable Long id,
			BindingResult result) {

		Medicion medicionActual = medicionService.finById(id);
		Medicion medicionUpdated = null;

		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + " ' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}
		if (medicionActual == null) {
			response.put("mensaje", "error : no se pudo editar el usuario ID: "
					.concat(id.toString().concat(" no Existe en la Base de Datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			
			medicionActual.setNombre(medicion.getNombre());
			medicionUpdated = medicionService.save(medicionActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar  el usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario ha sido actualizado con èxito!");
		response.put("registro", medicionUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
	
	
	/**
	 * ACTUALIZAR
	 */
	@PutMapping("/medicion/completar/{id}")
//	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<?> completar(@Valid @RequestBody Medicion medicion, @PathVariable Long id,
			BindingResult result) {

		Medicion medicionActual = medicionService.finById(id);
		Medicion medicionUpdated = null;

		Map<String, Object> response = new HashMap<>();
		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + " ' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}
		if (medicionActual == null) {
			response.put("mensaje", "error : no se pudo editar el usuario ID: "
					.concat(id.toString().concat(" no Existe en la Base de Datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}

		try {
			
		
			medicionActual.setNombre(medicion.getNombre());
		
			medicionUpdated = medicionService.save(medicionActual);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al actualizar  el usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("mensaje", "El usuario ha sido actualizado con èxito!");
		response.put("registro", medicionUpdated);

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}
	
	
	/**
	 * ELIMINAR
	 */

	@DeleteMapping("/medicion/{id}")
	@Secured("ROLE_ADMIN")
//	@ResponseStatus(HttpStatus.NO_CONTENT)
	public ResponseEntity<?> delete(@PathVariable Long id) {

		Map<String, Object> response = new HashMap<>();

		try {
			// Medicion medicion = medicionService.finById(id);
			medicionService.findByDelete(id);

		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar  el usuario en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("mensaje", "el usuario fue eliminado con èxito!");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
