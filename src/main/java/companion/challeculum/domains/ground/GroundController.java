package companion.challeculum.domains.ground;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroundController {
    @Autowired
    @Qualifier("groundservice")
    GroundService service;

    @GetMapping("/api/v1/ground")
    List<GroundDTO> getGrounds(@RequestParam(required = true)int page,
                               @RequestParam(required = false) Integer categoryId,
                               @RequestParam(required = false) Integer level){
        return service.getGrounds(page, categoryId, level);
    }

    @GetMapping("/api/v1/ground/{groundId}")
    GroundDTO showGroundDetail(@PathVariable long groundId){
        return service.showGroundDetail(groundId);
    }

    @DeleteMapping("/api/v1/ground/{groundId}")
    void deleteGround(@PathVariable Long groundId) {
        service.deleteGround(groundId);
    }
}
