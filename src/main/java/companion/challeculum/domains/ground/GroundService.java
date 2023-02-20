package companion.challeculum.domains.ground;

import companion.challeculum.domains.ground.dtos.Ground;
import companion.challeculum.domains.ground.dtos.GroundCreateDto;
import companion.challeculum.domains.ground.dtos.GroundJoined;
import companion.challeculum.domains.ground.dtos.GroundUpdateDto;

import java.util.List;
import java.util.Map;

public interface GroundService {
    int getDepositById(long groundId);
    void deleteGround(long groundId);

    Ground getGround(long groundId);

    List<GroundJoined> getGroundList(Integer page, String filter, String sortBy, String orderBy, String keyword);

    List<Ground> getGroundsByMe(long userId);

    void createGround(GroundCreateDto groundCreateDTO);

    List<Map<String,Object>> getMyGroundList(long userId, Integer page, String status);

    int updateGround(long groundId, GroundUpdateDto groundUpdateDto);

    Long getGroundCreator(long groundId);

    List<Map<String, Object>> getMyGrounds(long userId);
}
